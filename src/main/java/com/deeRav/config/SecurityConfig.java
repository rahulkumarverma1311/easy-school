package com.deeRav.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/home").authenticated()
                        .requestMatchers("/holidays/**").permitAll()
                        .requestMatchers("/saveMsg").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/courses").permitAll()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                        .requestMatchers("/login").permitAll()
                ).formLogin().loginPage("/login").defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll()
                .and().logout().logoutSuccessUrl("/login?logout=true").invalidateHttpSession(true).permitAll().and()
                .httpBasic();
        return httpSecurity.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailService() {
        UserDetails user1 = User.withDefaultPasswordEncoder().username("user").password("1234").roles("USER").build();
        UserDetails admin = User.withDefaultPasswordEncoder().username("admin").password("1234").roles("USER", "ADMIN").build();
        return new InMemoryUserDetailsManager(user1, admin);
    }


    // for permitAll()
//    @Bean
//    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests((auth)->
//                 auth
//                .anyRequest()
//                .permitAll())
//                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//        return http.build();
//    }



    /*
    // for denyAll()
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((auth)->auth
                .anyRequest()
                .denyAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

     */
}

