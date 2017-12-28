package com.example.ppb.config;

import com.example.ppb.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.sql.DataSource;

@Configuration
// http://docs.spring.io/spring-boot/docs/current/reference/html/howto-security.html
// Switch off the Spring Boot security configuration
//@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    //Version - 2: Pointing to database
    @Autowired
    private DataSource datasource;

    //Version 3: For UserDetailsService
    @Autowired
    MyUserDetailsService myUserDetailsService;

    // roles admin allow to access /admin/**
    // roles user allow to access /user/**
    // roles super_admin allow to access /super_admin/**
    // custom 403 access denied handler
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                    .antMatchers("/", "/home", "/about").permitAll()
                    .antMatchers("/admin/**").hasAuthority("ADMIN")
                    .antMatchers("/user/**").hasAuthority("USER")
                    .antMatchers("/super_user/**").hasAuthority("SUPER_USER")
                        .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .permitAll()
                .and()
                    .logout()
                    .permitAll()
                .and()
                    .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        //Spring Security - Version 1 : Using In-memory database
//        auth.inMemoryAuthentication()
//                .withUser("user").password("password").authorities("USER")
//                .and()
//                .withUser("admin").password("password").authorities("ADMIN")
//                .and()
//                .withUser("super_admin").password("password").authorities("SUPER_ADMIN");

        //Spring Security - Version 2 : Adding Datasource from database
//        auth.jdbcAuthentication()
//                .dataSource(datasource)
//                .usersByUsernameQuery("select username,password, enabled from users where username=?")
//                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");

        //Version 3: Using UserDetailsService
        auth.userDetailsService(myUserDetailsService);
    }

    /*
    //Spring Boot configured this already.
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
    }*/
}
