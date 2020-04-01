package com.jack.jackdawson.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import com.jack.jackdawson.interceptor.DefaultInterceptor;

@Configuration
public class WebAppRootContext implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getDefaultInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/setting/**");
    }

    @Bean
    public DefaultInterceptor getDefaultInterceptor() {
        return new DefaultInterceptor();
    }

}
