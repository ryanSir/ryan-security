package com.ryan.security.browser;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * WebSecurityConfigurerAdapter 安全应用适配器
 *
 * @author ryan
 * @version Id: BrwoserSecurityConfig, v 0.1 2022/4/12 4:33 PM ryan Exp $
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

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

        // 认证方式 - 表单登录
//        http.httpBasic() 不通过表单登录方式登录，最初始的方式
        http.formLogin().and()
                // 授权配置 - 任何配置都要认证
                .authorizeRequests().anyRequest().authenticated();
    }
}
