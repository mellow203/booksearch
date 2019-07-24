package com.pyj.booksearch.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.pyj.booksearch.util.AuthenticationSuccessHandler;
/*
@EnableWebSecurity
*/

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    public AuthenticationSuccessHandler authenticationSuccessHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/**").authenticated()
                .and()
                .formLogin()
                .loginPage("/user/login")
                .usernameParameter("uid")
                .passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}
