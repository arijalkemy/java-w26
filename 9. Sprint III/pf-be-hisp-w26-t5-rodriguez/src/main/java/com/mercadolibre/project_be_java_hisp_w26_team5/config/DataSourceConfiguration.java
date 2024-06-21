package com.mercadolibre.project_be_java_hisp_w26_team5.config;

import com.fury.api.FuryUtils;
import com.fury.api.exceptions.FuryDecryptException;
import com.fury.api.exceptions.FuryNotFoundAPPException;
import com.fury.api.exceptions.FuryUpdateException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    Environment env;

    public DataSourceConfiguration(Environment env) {
        this.env = env;
    }

    @Bean
    @Qualifier("datasource")
    @Profile({"prod"})
    public DataSource getDataSource(
            final @Value("${spring.datasource.host}") String host, final @Value("${spring.datasource.db}") String db,
            final @Value("${spring.datasource.username}") String user,
            final @Value("${spring.datasource.password}") String password
    ) throws FuryDecryptException, FuryUpdateException, FuryNotFoundAPPException {
        return DataSourceBuilder
                .create()
                .url(String.format("jdbc:mysql://%s/%s?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8",
                        FuryUtils.getEnv(host),
                        db
                ))
                .username(user)
                .password(FuryUtils.getEnv(password))
                .build();
    }
}
