package com.rsqd.springbootwebrestfulcrud.config;


import com.rsqd.springbootwebrestfulcrud.component.LoginHandlerInterceptor;
import com.rsqd.springbootwebrestfulcrud.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SuppressWarnings("all")
//@EnableWebMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    //use autoconfig and extend other usage
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/rsqd").setViewName("success");
    }

    // all webmvcconfigureadapter will work
    @Bean//add to container
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // add interceptor
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                //static resources；  *.css , *.js
                //SpringBoot has down static resource mapping
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/main.html").excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

}
