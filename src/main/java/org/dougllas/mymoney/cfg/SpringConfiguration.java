package org.dougllas.mymoney.cfg;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by DOUGLLAS SOUSA on 20/09/2017.
 */

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("org.dougllas.mymoney.model")
@ComponentScan(basePackages = {"org.dougllas.*"})
@EnableJpaRepositories(basePackages = "org.dougllas.mymoney.repository")
public class SpringConfiguration extends SpringBootServletInitializer {


    @Bean(name = "messageSource")
    public MessageSource messageSource(){
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("windows-1252");
        return messageSource;
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {

            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                registry.addResourceHandler("/resources/**")
                        .addResourceLocations("classpath:/public/", "/public/");
            }

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
            }

            @Override
            public Validator getValidator() {
                LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
                validator.setValidationMessageSource(messageSource());
                return validator;
            }

        };
    }
}