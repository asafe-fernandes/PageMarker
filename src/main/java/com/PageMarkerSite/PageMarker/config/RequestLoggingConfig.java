package com.PageMarkerSite.PageMarker.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class RequestLoggingConfig {

  @Bean
  public CommonsRequestLoggingFilter requestLoggingFilter() {
    CommonsRequestLoggingFilter loggingFilter = new CommonsRequestLoggingFilter();
    loggingFilter.setIncludeClientInfo(true); // Log client information (e.g., IP)
    loggingFilter.setIncludeQueryString(true); // Log query parameters
    loggingFilter.setIncludePayload(true); // Log the request body (be cautious with large bodies)
    loggingFilter.setMaxPayloadLength(10000); // Maximum length of the request body to log
    loggingFilter.setIncludeHeaders(true); // Log headers
    loggingFilter.setAfterMessagePrefix("REQUEST DATA : "); // Custom prefix
    return loggingFilter;
  }
}
