package net.elyland.cloud.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by Igor on 09-Jun-16.
 */
@Configuration
//@EnableWebSecurity
@EnableWebMvcSecurity
//@EnableAutoConfiguration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@ComponentScan(basePackages = {
        "net.elyland.cloud",
        "net.elyland.cloud.controllers",
        "net.elyland.cloud.domain",
        "net.elyland.cloud.repositories",
        "net.elyland.cloud.services",
        "net.elyland.cloud.validator" })

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    //@Autowired
    //private DataSource datasource;
    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/admin/**").access("hasAuthority('ADMIN')")
                .antMatchers("/**", "/admin/**", "/registration**", "/resourses**", "/resourses/**", "/images**", "/images/**", "/css/**")
                .permitAll()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();
        http.formLogin()
                .failureUrl("/login?error")
                .defaultSuccessUrl("/")
                .loginPage("/login")
                .usernameParameter("username").passwordParameter("password")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(encoder);

    }


}