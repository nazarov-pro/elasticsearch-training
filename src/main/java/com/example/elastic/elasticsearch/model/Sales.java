package com.example.elastic.elasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

/**
 * Copyright Shahin Nazarov<me@shahinnazarov.com>
 */
@Document(indexName = "main", type = "sales", shards = 3, replicas = 1)
@Data
public class Sales {
    @Id
    private String id;
    private String region;
    private String country;
    private String itemType;
    private String salesChannel;
    private char orderPriority;
    private LocalDate orderDate;
    private BigInteger orderId;
    private LocalDate shipDate;
    private int unitSold;
    private BigDecimal unitPrice;
    private BigDecimal unitCost;
    private BigDecimal totalRevenue;
    private BigDecimal totalCost;
    private BigDecimal totalProfit;

}
