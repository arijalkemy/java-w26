package bootcamp.bendezujonathan.elastichsearch.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

// @Configuration
// @EnableElasticsearchRepositories(basePackages = " bootcamp.bendezujonathan.elastichsearch.repository.interfaces")
// public class ElasticSearchConfig  extends ElasticsearchConfiguration {
    

//     @Value("${elasticsearch.user}")
//     private String userName;

//     @Value("${elasticsearch.pass}")
//     private String pass;

//     @Override
//     public ClientConfiguration clientConfiguration() {
//         return ClientConfiguration.builder()           
// 			.connectedTo("localhost:9200")
//             .withBasicAuth(userName, pass)
// 			.build();
//     }

// }
