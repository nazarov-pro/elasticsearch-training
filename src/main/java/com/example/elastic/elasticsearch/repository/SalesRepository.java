package com.example.elastic.elasticsearch.repository;

import com.example.elastic.elasticsearch.model.Sales;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.Collection;

/**
 * Copyright Shahin Nazarov<me@shahinnazarov.com>
 */
public interface SalesRepository extends ElasticsearchRepository<Sales, String> {
    Collection<Sales> findSalesByCountry(String country);
    Page<Sales> findAllByRegion(String region, Pageable pageable);
}
