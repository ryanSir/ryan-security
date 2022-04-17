package com.ryan.security.browser;

import com.ryan.security.core.auth.mobile.SmsCodeAuthenticationFilter;
import com.ryan.security.core.auth.mobile.SmsCodeAuthenticationSecurityConfig;
import com.ryan.security.core.properties.SecurityProperties;
import com.ryan.security.core.validate.code.SmsCodeFilter;
import com.ryan.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * WebSecurityConfigurerAdapter 安全应用适配器
 *
 * @author ryan
 * @version Id: BrwoserSecurityConfig, v 0.1 2022/4/12 4:33 PM ryan Exp $
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Resource(name = "browserAuthenticationSuccessHandler")
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Resource(name = "browserAuthenticationFailHandler")
    private AuthenticationFailureHandler browserAuthenticationFailHandler;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

    @Autowired
    private SpringSocialConfigurer springSocialConfigurer;

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 对输入的密码加密
        return new BCryptPasswordEncoder();
        // 自定义实现方式
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence) {
//                return charSequence.toString().concat("1");
//            }
//
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                if (rawPassword.toString().concat("1").equals(encodedPassword)) {
//                    return true;
//                }
//                return false;
//            }
//        };
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository(){
        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
        tokenRepository.setDataSource(dataSource);
//        tokenRepository.setCreateTableOnStartup(true);
        return tokenRepository;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(browserAuthenticationFailHandler);
        validateCodeFilter.setSecurityProperties(securityProperties);
        validateCodeFilter.afterPropertiesSet();

        SmsCodeFilter smsCodeFilter = new SmsCodeFilter();
        smsCodeFilter.setAuthenticationFailureHandler(browserAuthenticationFailHandler);
        smsCodeFilter.setSecurityProperties(securityProperties);
        smsCodeFilter.afterPropertiesSet();

        // 认证方式 - 表单登录
//        http.httpBasic() 不通过表单登录方式登录，最初始的方式
        http.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                // 定义登录页面 注意，下面配置任何请求都要进行验证，所以要去除login.html请求校验
                    .loginPage("/authentication/require")
                    // 默认处理 /login 请求才会进入UsernamePasswordAuthenticationFilter
                    .loginProcessingUrl("/authentication/form")
                    .successHandler(authenticationSuccessHandler)
                    .failureHandler(browserAuthenticationFailHandler)
                    .and()
                .rememberMe()
                    .tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                    .userDetailsService(userDetailsService)
                    .and()
                // 授权配置 - 任何配置都要认证,除login.html不需要认证
                .authorizeRequests()
                .antMatchers("/authentication/require",securityProperties.getBrowser().getLoginPage(),"/authentication/mobile","/code/*").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                // 暂时关闭csrf跨站请求防护功能
                .csrf().disable()
                .apply(smsCodeAuthenticationSecurityConfig).and().apply(springSocialConfigurer);
    }
}
