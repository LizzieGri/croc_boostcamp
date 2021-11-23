package com.elections.croc.elections_mysql;

import com.elections.croc.elections_mysql.security.MySimpleUrlAuthenticationSuccessHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class ElectionsMysqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElectionsMysqlApplication.class, args);
    }


}
