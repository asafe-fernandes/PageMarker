package com.PageMarkerSite.PageMarker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**") // Apply to all endpoints
        .allowedOrigins("http://localhost:5173") // Allow your frontend's origin
        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allow these methods
        .allowedHeaders("Content-Type", "Authorization", "Access-Control-Allow-Origin", "Access-Control-Allow-Headers")
        .allowCredentials(false) // Optional: if you need to allow cookies/credentials
        .maxAge(3600); // Cache preflight response for 1 hour
  }
}
