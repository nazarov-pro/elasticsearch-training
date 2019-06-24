package com.example.elastic.elasticsearch.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;

/**
 * Copyright Shahin Nazarov<me@shahinnazarov.com>
 */
@Document(indexName = "main2", type = "sales", shards = 3, replicas = 1)
@Data
public class Sales {
    @Id
    private String id;
    private String region;
    private String newParam;
    private String country;
    private String itemType;
    private String salesChannel;
    private char orderPriority;
    @Field(type = FieldType.Date, store = true,
            format = DateFormat.custom, pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
    private LocalDate orderDate;
    private BigInteger orderId;
    @Field(type = FieldType.Date, index = true, store = true,
            format = DateFormat.custom, pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd")
    private LocalDate shipDate;
    private int unitSold;
    private BigDecimal unitPrice;
    private BigDecimal unitCost;
    private BigDecimal totalRevenue;
    private BigDecimal totalCost;
    private BigDecimal totalProfit;

}
