package com.iunis.adminiunis.config;

import com.iunis.adminiunis.service.UsuarioDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //necesario para evitar qe se aplique seguridad a los recursos
    String[] resourses = new String[]{
            "/build/**", "/dist/**", "/docs/**", "/pages/**", "/plugins/**"
    };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .authorizeRequests()
                .antMatchers(resourses).permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/usuarios*","/loadUpdate*").access("hasRole('ADMIN')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .defaultSuccessUrl("/dashboard/display")
                .failureUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .csrf().disable()
                .rememberMe().key("uniqueAndSecret")
                .and()
                .logout()
                .permitAll()
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/login");
    }

    BCryptPasswordEncoder passwordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        passwordEncoder = new BCryptPasswordEncoder(4);
        return passwordEncoder;
    }

    @Autowired
    UsuarioDetailsServiceImpl usuarioDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception{
        managerBuilder.userDetailsService(usuarioDetailsService).passwordEncoder(passwordEncoder());
    }
}
