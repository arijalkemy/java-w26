package com.mercadolibre.fresh_market.config;

import com.fury.api.FuryUtils;
import com.fury.api.exceptions.FuryDecryptException;
import com.fury.api.exceptions.FuryNotFoundAPPException;
import com.fury.api.exceptions.FuryUpdateException;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    @Bean(name = "datasource")
    @Profile("prod")
    public DataSource getDataSource(
            final @Value("${spring.datasource.driver-class-name}") String driver,
            final @Value("${spring.datasource.host}") String host,
            final @Value("${spring.datasource.db}") String db,
            final @Value("${spring.datasource.user}") String user,
            final @Value("${spring.datasource.password}") String password,
            final @Value("${spring.datasource.max-lifetime}") long maxLifeTime,
            final @Value("${spring.datasource.keepalive}") long keepAlive) throws FuryDecryptException, FuryNotFoundAPPException, FuryUpdateException {
        return buildDataSource(driver, FuryUtils.getEnv(host), db, user, FuryUtils.getEnv(password), maxLifeTime, keepAlive);
    }

    private DataSource buildDataSource(String driver, String url, String db, String user, String password, long maxLifeTime, long keepAlive) {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(driver);
        config.setJdbcUrl(String.format("jdbc:mysql://%s/%s?serverTimezone=UTC&characterEncoding=UTF-8", url, db));
        config.setUsername(user);
        config.setPassword(password);
        config.setKeepaliveTime(keepAlive);
        config.setMaxLifetime(maxLifeTime);
        return new HikariDataSource(config);
    }
}