package org.Java.Project.School.app.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

import static org.springframework.security.config.Customizer.withDefaults;

@Component
public class ProjectSecurityConfig {


    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf->csrf.ignoringRequestMatchers("/saveMsg").ignoringRequestMatchers(PathRequest.toH2Console()))
                .authorizeHttpRequests(
                        authorize->authorize
                                .requestMatchers("/dashboard").authenticated()
                                .requestMatchers("/","/home").permitAll()
                                .requestMatchers("/courses").permitAll()
                                .requestMatchers("/contact").permitAll()
                                .requestMatchers("/holidays/**").permitAll()
                                .requestMatchers("/saveMsg").permitAll()
                                .requestMatchers("/about").permitAll()
                                .requestMatchers("/assets/**").permitAll()
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/logout").permitAll()
                                .requestMatchers(PathRequest.toH2Console()).permitAll()
                                .requestMatchers("/displayMessages").hasRole("ADMIN")
                )
                .formLogin(login->login.loginPage("/login").defaultSuccessUrl("/dashboard").failureUrl("/login?error=true").permitAll())

                .httpBasic(withDefaults());
        http.headers(fram->fram.frameOptions(withDefaults()).disable());

        return  http.build();

    }

    @Bean
   public InMemoryUserDetailsManager userDetails(){

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("user")
                .password("123")
                .roles("USER")
                .build();
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("123@Rg")
                .roles("USER","ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
}
