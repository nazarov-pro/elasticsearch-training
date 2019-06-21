package com.example.elastic.elasticsearch.service.impl;

import com.example.elastic.elasticsearch.model.Sales;
import com.example.elastic.elasticsearch.repository.SalesRepository;
import com.example.elastic.elasticsearch.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright Shahin Nazarov<me@shahinnazarov.com>
 */
@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    private SalesRepository salesRepository;

    @Override
    public void save(Sales sales) {
        salesRepository.save(sales);
    }
}
