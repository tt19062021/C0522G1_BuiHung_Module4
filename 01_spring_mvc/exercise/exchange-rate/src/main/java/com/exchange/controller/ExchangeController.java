package com.exchange.controller;


import com.exchange.service.IExchangeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ExchangeController {

    @Autowired
    private IExchangeService iExchangeService;

    @GetMapping("/")
    public String convent() {
        return "list";
    }

    @GetMapping("/convert")
    public String result(@RequestParam double usd, Model model) {
        Double exchange = iExchangeService.getMoney(usd);
        model.addAttribute("exchange", exchange);
        return "list";

    }
}
