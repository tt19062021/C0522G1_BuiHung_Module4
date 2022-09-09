package com.exchange.controller;


import com.exchange.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ExchangeController {

    @Autowired
    private ExchangeService service;

    @GetMapping("/")
    public String convent() {

        return "list";
    }

    @GetMapping("/convert")
    public String result(@RequestParam double money, Model model) {

        model.addAttribute("kq", service.showRate(money));
        return "list";

    }
}
