package org.generation.SpringBootAssessment.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("").setViewName("item-list");
        registry.addViewController("/item-list").setViewName("item-list");
        registry.addViewController("/item-form").setViewName("item-form");
    }

}
