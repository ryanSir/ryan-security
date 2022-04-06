package com.ryan.web.config;

import com.ryan.web.filter.TimeFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ryan
 * @version Id: WebConfig, v 0.1 2022/4/6 4:07 PM ryan Exp $
 */
@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean timeFilter(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        TimeFilter timeFilter = new TimeFilter();
        registrationBean.setFilter(timeFilter);

        List<String> urls = new ArrayList<>();
        urls.add("/*");
        // 指定路径下生效过滤器
        registrationBean.setUrlPatterns(urls);

        return registrationBean;
    }
}
