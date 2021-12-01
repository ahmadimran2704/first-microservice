package com.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {
    @Autowired
    private Environment environment;

    @Bean("dataSource")
    public DataSource dataSource() {
        HikariConfig hikariConfig =new HikariConfig();
        hikariConfig.setPoolName(environment.getProperty("hikari.poolname"));
        hikariConfig.setMaximumPoolSize(Integer.valueOf(environment.getProperty("hikari.maxpoolsize")));
        hikariConfig.setJdbcUrl(environment.getProperty("spring.datasource.url"));
        hikariConfig.setPassword(environment.getProperty("spring.datasource.password"));
        hikariConfig.setUsername(environment.getProperty("spring.datasource.username"));
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setConnectionTimeout(Integer.valueOf(environment.getProperty("hikari.timeout")));
        return new HikariDataSource(hikariConfig);

    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource dataSource){
        return new JdbcTemplate(dataSource);

    }
}
