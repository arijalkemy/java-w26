package com.mercadolibre.pf_be_hisp_w26_t07_torres.config;

import com.mercadolibre.routing.RoutingFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.FixedLocaleResolver;

import java.time.Clock;
import java.util.Locale;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  /**
   * Gets the router filter.
   *
   * @return the router filter
   */
  @Bean
  public FilterRegistrationBean<RoutingFilter> routingFilter() {
    FilterRegistrationBean<RoutingFilter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setName("routingFilter");
    registrationBean.setFilter(new RoutingFilter());
    registrationBean.setOrder(1);
    return registrationBean;
  }

  @Bean
  public LocaleResolver localeResolver() {
    return new FixedLocaleResolver(Locale.US);
  }

  @Bean
  public Clock clock() {
    return Clock.systemDefaultZone();
  }

  @Bean
  public WebMvcConfigurer corsConfigurer() {
    return new WebMvcConfigurer() {
      @Override
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("http://localhost:5173");
        WebMvcConfigurer.super.addCorsMappings(registry);
      }
    };
  }
}
