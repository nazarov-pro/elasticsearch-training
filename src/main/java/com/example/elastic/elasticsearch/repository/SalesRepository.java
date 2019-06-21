package com.example.elastic.elasticsearch.repository;

import com.example.elastic.elasticsearch.model.Sales;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Copyright Shahin Nazarov<me@shahinnazarov.com>
 */
public interface SalesRepository extends ElasticsearchRepository<Sales, String> {


}
