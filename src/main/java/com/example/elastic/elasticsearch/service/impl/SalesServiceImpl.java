package com.example.elastic.elasticsearch.service.impl;

import com.example.elastic.elasticsearch.model.Sales;
import com.example.elastic.elasticsearch.repository.SalesRepository;
import com.example.elastic.elasticsearch.service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Sales> findSalesByCountry(String country) {
        return new ArrayList<>(salesRepository.findSalesByCountry(country));
    }

    @Override
    public Page<Sales> findSalesByRegion(String region, PageRequest pageRequest) {
        return salesRepository.findAllByRegion(region, pageRequest);
    }
}
