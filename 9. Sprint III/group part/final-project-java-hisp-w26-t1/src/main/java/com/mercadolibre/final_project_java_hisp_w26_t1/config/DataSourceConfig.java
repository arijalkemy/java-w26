package com.mercadolibre.final_project_java_hisp_w26_t1.config;

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
public class DataSourceConfig {

    Environment environment;

    public DataSourceConfig(Environment environment){
        this.environment = environment;
    }

    @Bean
    @Qualifier("datasource")
    @Profile({"test","prod"})
    public DataSource getDataSource(final @Value("${spring.datasource.host}") String host,
                                    final @Value("${spring.datasource.db}") String db,
                                    final @Value("${spring.datasource.username}") String userName,
                                    final @Value("${spring.datasource.password}") String password) throws FuryDecryptException, FuryUpdateException, FuryNotFoundAPPException, FuryDecryptException, FuryUpdateException, FuryNotFoundAPPException {

        return DataSourceBuilder.create()
                .url(String.format("jdbc:mysql://%s/%s?useSSL=false&serverTimezone=UTC&characterEncoding=UTF-8",
                        FuryUtils.getEnv(host), db))
                .username(userName)
                .password(FuryUtils.getEnv(password))
                .build();


    }
}
