package com.ryan.security.browser;

import com.ryan.security.core.properties.SecurityProperties;
import com.ryan.security.core.validate.code.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

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

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(browserAuthenticationFailHandler);

        // 认证方式 - 表单登录
//        http.httpBasic() 不通过表单登录方式登录，最初始的方式
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .formLogin()
                // 定义登录页面 注意，下面配置任何请求都要进行验证，所以要去除login.html请求校验
                .loginPage("/authentication/require")
                // 默认处理 /login 请求才会进入UsernamePasswordAuthenticationFilter
                .loginProcessingUrl("/authentication/form")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(browserAuthenticationFailHandler)
                .and()
                // 授权配置 - 任何配置都要认证,除login.html不需要认证
                .authorizeRequests()
                .antMatchers("/authentication/require",securityProperties.getBrowser().getLoginPage(),"/code/image").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                // 暂时关闭csrf跨站请求防护功能
                .csrf().disable();
    }
}
