package com.code2go.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;

import javax.sql.DataSource;
import java.sql.JDBCType;

@Configuration
public class DemoSecurityConfig {


   //Adding support for JDBC

    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource){

        return new JdbcUserDetailsManager(datasource);

    }



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/employees/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN")
        );

        // HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }

//    Following method is for the time you want to hard code the users and respective roles
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//
//        UserDetails john= User.builder()
//                .username("john")
//                .password("{noop}1234")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary= User.builder()
//                .username("mary")
//                .password("{noop}1234")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//
//        UserDetails raha= User.builder()
//                .username("raha")
//                .password("{noop}1234")
//                .roles("EMPLOYEE","MANAGER" , "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john,mary,raha);
//    }
}
