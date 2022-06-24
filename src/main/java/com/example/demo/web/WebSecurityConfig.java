package com.example.demo.web;

import com.example.demo.user.User;
import com.example.demo.user.UserRepository;
import com.example.demo.user.UserService;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserService userService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder.bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/training").hasRole("USER")
                .and()
                .formLogin()
                .permitAll()
                .and()
                .csrf().disable();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void get(){
        User user = new User(
                "User",
                passwordEncoder.bCryptPasswordEncoder().encode("user"),
                "USER");
        userRepository.save(user);
    }
}
