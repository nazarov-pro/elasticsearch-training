package com.example.elastic.elasticsearch.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Copyright Shahin Nazarov<me@shahinnazarov.com>
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.elastic.elasticsearch.repository")
public class ElasticSearchConfiguration {
    @Value("${elasticsearch.port:9200}")
    private int port;
    @Value("${elasticsearch.host:localhost}")
    private String host;
    @Value("${elasticsearch.clustername:elasticsearch}")
    private String clusterName;

    @Bean
    Client client() throws UnknownHostException {
        Settings settings = Settings.builder().put("cluster.name", clusterName).build();
        return new PreBuiltTransportClient(settings)
                .addTransportAddress(new TransportAddress(new InetSocketAddress((host), port)));
    }

    @Bean
    ElasticsearchTemplate elasticsearchTemplate() throws UnknownHostException {
        return new ElasticsearchTemplate(client());
    }
}