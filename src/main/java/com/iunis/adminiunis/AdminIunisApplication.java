package com.iunis.adminiunis;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.iunis"})
@EnableJpaRepositories("com.iunis.adminiunis.repository")
@EntityScan(basePackages = "com.iunis.adminiunis.domain")
public class AdminIunisApplication {

    /**
     * Configurando el modelMapper
     * @return nueva instancia de modelMapper
     */
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    public static void main(String[] args) {
        SpringApplication.run(AdminIunisApplication.class, args);
    }

}
