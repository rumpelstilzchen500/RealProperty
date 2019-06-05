package com.api.RealProperty.config;

import com.api.RealProperty.service.TokenRememberMeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private PersistentTokenRepository persistentTokenRepository;

    @Autowired
    private TokenRememberMeService tokenRememberMeService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/api/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS)
                .and()
                .rememberMe()
                .key("secret-key")
                .alwaysRemember(true)
                .tokenValiditySeconds(999999999)
                .tokenRepository(persistentTokenRepository)
                .useSecureCookie(true)
                .rememberMeServices(tokenRememberMeService)
                .rememberMeParameter("remember");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .debug(true)
                .ignoring()
                .antMatchers("/css/**", "/img/**");
    }
}
