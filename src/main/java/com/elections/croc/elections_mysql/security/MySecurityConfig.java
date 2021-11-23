package com.elections.croc.elections_mysql.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {


    final DataSource dataSource;

    public MySecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean("authenticationManager")
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
              auth.jdbcAuthentication().dataSource(dataSource);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/home").hasAnyRole("dobavCand", "smotr", "tv", "uik1383", "uik1386", "uik1390", "uik1460", "uik1461", "uik1462", "uik1463", "uik1464",
                        "uik2914", "uik2915", "uik2916", "uik2917", "uik2918", "uik1549", "uik1550", "uik1551", "uik1552", "uik1553",
                        "uik2964", "uik2965", "uik2966", "uik2967", "uik2968", "dobavCand")
                .antMatchers("/login").hasAnyRole("dobavCand", "smotr", "tv", "uik1383", "uik1386", "uik1390", "uik1460", "uik1461", "uik1462", "uik1463", "uik1464",
                                "uik2914", "uik2915", "uik2916", "uik2917", "uik2918", "uik1549", "uik1550", "uik1551", "uik1552", "uik1553",
                                "uik2964", "uik2965", "uik2966", "uik2967", "uik2968", "dobavCand")
                .antMatchers("/tiks").hasRole("smotr")
                .antMatchers("/votes-info").hasRole("tv")
                .antMatchers("/update-information-station/1383").hasRole("uik1383")
                .antMatchers("/update-information-station/1386").hasRole("uik1386")
                .antMatchers("/update-information-station/1388").hasRole("uik1388")
                .antMatchers("/update-information-station/1390").hasRole("uik1390")
                .antMatchers("/update-information-station/1392").hasRole("uik1392")
                .antMatchers("/update-information-station/1460").hasRole("uik1460")
                .antMatchers("/update-information-station/1461").hasRole("uik1461")
                .antMatchers("/update-information-station/1462").hasRole("uik1462")
                .antMatchers("/update-information-station/1463").hasRole("uik1463")
                .antMatchers("/update-information-station/1464").hasRole("uik1464")
                .antMatchers("/update-information-station/2914").hasRole("uik2914")
                .antMatchers("/update-information-station/2915").hasRole("uik2915")
                .antMatchers("/update-information-station/2916").hasRole("uik2916")
                .antMatchers("/update-information-station/2917").hasRole("uik2917")
                .antMatchers("/update-information-station/2918").hasRole("uik2918")
                .antMatchers("/update-information-station/1549").hasRole("uik1549")
                .antMatchers("/update-information-station/1550").hasRole("uik1550")
                .antMatchers("/update-information-station/1551").hasRole("uik1551")
                .antMatchers("/update-information-station/1552").hasRole("uik1552")
                .antMatchers("/update-information-station/1553").hasRole("uik1553")
                .antMatchers("/update-information-station/2964").hasRole("uik2964")
                .antMatchers("/update-information-station/2965").hasRole("uik2965")
                .antMatchers("/update-information-station/2966").hasRole("uik2966")
                .antMatchers("/update-information-station/2967").hasRole("uik2967")
                .antMatchers("/update-information-station/2968").hasRole("uik2968")
                .antMatchers("/votes_for_candidates").hasRole("dobavCand")
                .and()
                .formLogin()
                .successHandler(myAuthenticationSuccessHandler());

    }

    @Bean
    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
        return new MySimpleUrlAuthenticationSuccessHandler();
    }
}
