package com.codeseek.dbindices.conf;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
@ConfigurationProperties(prefix = "application.db")
@Getter
@Setter
public class DBConfiguration {
    private String url;
    private String user;
    private String password;

    @Bean
    public Connection connection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
