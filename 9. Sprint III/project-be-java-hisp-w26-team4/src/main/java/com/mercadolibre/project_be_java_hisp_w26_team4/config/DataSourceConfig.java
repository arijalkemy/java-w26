package com.mercadolibre.project_be_java_hisp_w26_team4.config;

import com.fury.api.FuryUtils;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.util.Objects;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DataSourceConfig {
    private final Environment env;

    DataSourceConfig(Environment env) {
        this.env = env;
    }

    @Bean
    @Primary
    @Profile({"remote"})
    public DataSource localDataSource() {
        final String host = env.getProperty("db.host");
        final String port = env.getProperty("db.port");
        final String db = env.getProperty("db.name");
        final String username = env.getProperty("db.username");
        final String password = env.getProperty("db.password");
        final String driverName = env.getProperty("db.driver.name");
        final String url = String.format(
                Objects.requireNonNull(env.getProperty("db.url")), host, port, db
        );

        return getDatasourceConfig(username, password, url, driverName);
    }

    @Bean
    @Primary
    @Profile("prod")
    public DataSource furyDataSource() {
        try {
            final String host = FuryUtils.getEnv(env.getProperty("db.host"));
            final String db = env.getProperty("db.name");
            final String username = env.getProperty("db.username");
            final String password = FuryUtils.getEnv(env.getProperty("db.password"));
            final String driverName = env.getProperty("db.driver.name");
            final String url = String.format(Objects.requireNonNull(env.getProperty("db.url")), host, db);

            return getDatasourceConfig(username, password, url, driverName);
        } catch (Exception e) {
            throw new Error(e.getMessage(), e);
        }
    }

    private static HikariDataSource getDatasourceConfig(String username, String password, String url, String driverName) {
        HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(20);
        config.setMinimumIdle(2);
        config.setUsername(username);
        config.setPassword(password);
        config.setJdbcUrl(url);
        config.setDriverClassName(driverName);
        // 30 seconds idle timeout
        config.setIdleTimeout(30000L);
        // Keep alive connections every 30 seconds
        config.setKeepaliveTime(30000L);
        // Query executed by keep alive
        config.setConnectionTestQuery("SELECT 1");
        // A connection can live at max one minute before recycling.
        config.setMaxLifetime(60000L);

        return new HikariDataSource(config);
    }
}

