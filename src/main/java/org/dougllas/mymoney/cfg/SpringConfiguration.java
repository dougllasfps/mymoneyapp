package org.dougllas.mymoney.cfg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by DOUGLLAS SOUSA on 20/09/2017.
 */

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("org.dougllas.mymoney.model")
@ComponentScan(basePackages = {"org.dougllas.*"})
@EnableJpaRepositories(basePackages = "org.dougllas.mymoney.repository")
public class SpringConfiguration extends SpringBootServletInitializer {
//
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurerAdapter() {
//
//            @Override
//            public void addResourceHandlers(ResourceHandlerRegistry registry) {
//                registry.addResourceHandler("/resources/**")
//                        .addResourceLocations("classpath:/public/");
//            }
//
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "HEAD");
//            }
//        };
//    }

    public static void main(String[] args) {
        SpringApplication.run(SpringConfiguration.class, args);
    }

}