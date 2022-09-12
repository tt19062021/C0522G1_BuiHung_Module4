package com.exchange.service.impl;


import com.exchange.service.IExchangeService;
import org.springframework.stereotype.Service;

@Service
public class ExchangeService implements IExchangeService {


    @Override
    public Double getMoney(Double usd) {
        return usd * 23000;
    }
}
