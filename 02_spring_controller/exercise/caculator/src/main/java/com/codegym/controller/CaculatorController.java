package com.codegym.controller;

import com.codegym.service.ICaculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CaculatorController {

    @Autowired
    private ICaculatorService iCaculatorService;

    @GetMapping("/")
    public String showCaculator(){
        return ("list");
    }

    @RequestMapping("/operator")
    public String operator(@RequestParam(value = "firstOperand" ,required = false) float firstOperand,
                           @RequestParam(value = "secondOperand",required = false) float secondOperand,
                           @RequestParam(value = "operator" ,required = false) String operator,
                                       ModelMap modelMap){

        String result = iCaculatorService.result(firstOperand,secondOperand,operator);

        modelMap.addAttribute("firstOperand",firstOperand);
        modelMap.addAttribute("secondOperand",secondOperand);
        modelMap.addAttribute("operator",operator);
        modelMap.addAttribute("result",result);
        return "list";
    }
}
