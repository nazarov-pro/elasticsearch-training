package com.example.elastic.elasticsearch.service;

import com.example.elastic.elasticsearch.model.Sales;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * Copyright Shahin Nazarov<me@shahinnazarov.com>
 */
public interface SalesService {
    void save(Sales sales);
    List<Sales> findSalesByCountry(String country);
    Page<Sales> findSalesByRegion(String region, PageRequest pageRequest);
}
