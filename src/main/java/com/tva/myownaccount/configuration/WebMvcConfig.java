package com.tva.myownaccount.configuration;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.tva.myownaccount.interceptor.UrlLocaleInterceptor;
import com.tva.myownaccount.resolver.UrlLocaleResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

  @Bean(name = "messageSource")
  public MessageSource getMessageResource() {
    ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();

    messageResource.setBasename("classpath:i18n/messages");
    messageResource.setDefaultEncoding("UTF-8");
    return messageResource;
  }

  @Bean(name = "localeResolver")
  public LocaleResolver getLocaleResolver() {
    LocaleResolver resolver = new UrlLocaleResolver();
    return resolver;
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    UrlLocaleInterceptor localeInterceptor = new UrlLocaleInterceptor();
    registry.addInterceptor(localeInterceptor).addPathPatterns("/en/*", "/fr/*", "/pt/*");
  }

}
