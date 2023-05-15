package com.istad.securitydemo.configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration {
    //set up user credentail
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails user = User.withUsername("jame")
                .password("12345")
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("nana")
                .password("1111")
                .roles("ADMIN")
                .build();
        ;
        return new InMemoryUserDetailsManager(user, user2);
    }

    // configuration for the security
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity)throws  Exception{
        httpSecurity.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("//admin/**")
                .hasRole("ADMIN")
                .requestMatchers("//user/**")
                .hasRole("USER")
                .requestMatchers("/home/**")
                .anonymous()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin();
        return httpSecurity.build();
    }


    //password encoder
    @Bean
//    public PasswordEncoder passwordEncoder (){
//        return new BCryptPasswordEncoder();
//    }
    @SuppressWarnings("deprecation")
    public NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}