package com.exchange.service;


import org.springframework.stereotype.Service;

@Service
public class ExchangeService {

    public Double showRate(double money){
        Double result = money * 23000;

        return result;
    }
}
