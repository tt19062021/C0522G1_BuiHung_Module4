package com.example.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {

            Integer currentValue = productMap.get(productDto);
            productMap.put(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public void dropProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            if (productMap.get(productDto) > 1) {
                Integer currentValue = productMap.get(productDto);
                productMap.put(productDto, currentValue - 1);
            } else {
                productMap.put(productDto, 0);
            }
        }
    }

    public double countTotalPayment() {
        double payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }
}
