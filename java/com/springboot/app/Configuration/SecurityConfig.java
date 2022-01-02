package com.springboot.app.Configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder pe = new BCryptPasswordEncoder();

        String userByMailQuery = "SELECT email FROM User WHERE email = ?;";
        String roleByMailQuery = "SELECT role FROM User WHERE email =?;";

        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(pe);
              //  .usersByUsernameQuery(userByMailQuery)
             //   .authoritiesByUsernameQuery(roleByMailQuery);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/student/*").hasAnyRole("STUDENT", "ADMIN")
                .antMatchers("/teacher/*").hasAnyRole("TEACHER", "ADMIN")
                .antMatchers("/admin/*").hasRole("ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll().and().exceptionHandling().accessDeniedPage("/403");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }


}