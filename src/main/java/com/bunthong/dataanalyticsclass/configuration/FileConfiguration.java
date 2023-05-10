package com.bunthong.dataanalyticsclass.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class FileConfiguration implements WebMvcConfigurer {
    @Value("${server-path}")
    String serverPath;
    @Value("${client-path}")
    String clientPath;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addResourceHandler(clientPath)
                .addResourceLocations("file:"+ serverPath);

    }
}
