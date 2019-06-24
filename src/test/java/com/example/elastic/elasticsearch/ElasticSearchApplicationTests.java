package com.example.elastic.elasticsearch;

import com.example.elastic.elasticsearch.model.Sales;
import com.example.elastic.elasticsearch.service.SalesService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticSearchApplicationTests {

    @Autowired
    private SalesService salesService;

    //TODO: change "sales_records.csv" file name after extracting "1500000_Sales_Records.7z"
    @Test
    public void feedElastic() throws IOException {
        Path path = Paths.get("src/test/resources/sales_records.csv");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");

        Files.readAllLines(path).stream().skip(1).forEach((row) -> {
            String[] elements = row.split(",");
            if (elements.length == 14) {
                Sales sales = new Sales();
                sales.setId(UUID.randomUUID().toString());
                sales.setRegion(elements[0]);
                sales.setCountry(elements[1]);
                sales.setItemType(elements[2]);
                sales.setSalesChannel(elements[3]);
                sales.setOrderPriority(elements[4].charAt(0));
                sales.setOrderDate(LocalDate.parse(elements[5], formatter));
                sales.setOrderId(new BigInteger(elements[6]));
                sales.setShipDate(LocalDate.parse(elements[7], formatter));
                sales.setUnitSold(Integer.parseInt(elements[8]));
                sales.setUnitPrice(new BigDecimal(elements[9]));
                sales.setUnitCost(new BigDecimal(elements[10]));
                sales.setTotalRevenue(new BigDecimal(elements[11]));
                sales.setTotalCost(new BigDecimal(elements[12]));
                sales.setTotalProfit(new BigDecimal(elements[13]));
                salesService.save(sales);
            } else {
                System.out.println("Not Parseable " + row);
            }

        });
    }

    @Test
    public void testWithNewField() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        String[] elements = "Central America and the Caribbean,Dominica,Meat,Online,L,8/6/2016,476103961,8/7/2016,8597,421.89,364.69,3626988.33,3135239.93,491748.40".split(",");
        Sales sales = new Sales();
        sales.setId(UUID.randomUUID().toString());
        sales.setRegion(elements[0]);
        sales.setNewParam("Test Param");
        sales.setCountry(elements[1]);
        sales.setItemType(elements[2]);
        sales.setSalesChannel(elements[3]);

        sales.setOrderPriority(elements[4].charAt(0));
        sales.setOrderDate(LocalDate.parse(elements[5], formatter));
        sales.setOrderId(new BigInteger(elements[6]));
        sales.setShipDate(LocalDate.parse(elements[7], formatter));
        sales.setUnitSold(Integer.parseInt(elements[8]));
        sales.setUnitPrice(new BigDecimal(elements[9]));
        sales.setUnitCost(new BigDecimal(elements[10]));
        sales.setTotalRevenue(new BigDecimal(elements[11]));
        sales.setTotalCost(new BigDecimal(elements[12]));
        sales.setTotalProfit(new BigDecimal(elements[13]));
        salesService.save(sales);
    }


    @Test
    public void findByCountryName() {
        List<Sales> south = salesService.findSalesByCountry("Singapore");
        Assert.assertTrue(south.size() > 0);
    }


    @Test
    public void findByRegionName() {
        Page<Sales> page = salesService.findSalesByRegion("Asia", PageRequest.of(1, 10));
        Assert.assertTrue(page.getTotalElements() == 10);
    }


}
