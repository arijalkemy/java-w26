package com.meli.elastic.config;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.meli.elastic.repository")
public class Config {

    @Bean
    public RestClient getRestClient() {
        return RestClient.builder(HttpHost.create("https://localhost:9200"))
                .build();
    }

    // Create the transport with a Jackson mapper
    ElasticsearchTransport getTransport() {
        return new RestClientTransport(
                getRestClient(), new JacksonJsonpMapper());
    }

    // And create the API client
    ElasticsearchClient getEsClient() {
        return new ElasticsearchClient(getTransport());
    }

}
