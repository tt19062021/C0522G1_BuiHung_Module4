package com.codegym.service.impl;

import com.codegym.service.ICaculatorService;
import org.springframework.stereotype.Service;


@Service
public class CaculatorService implements ICaculatorService {
    public String result(float firstOperand, float secondOperand, String operator) {
        try {
            switch (operator) {
                case "Addition":
                    return String.valueOf(firstOperand + secondOperand);
                case "Subtraction":
                    return String.valueOf(firstOperand - secondOperand);
                case "Multiplication":
                    return String.valueOf(firstOperand * secondOperand);
                case "Division":
                    if (secondOperand != 0) {
                        return String.valueOf(firstOperand / secondOperand);
                    } else {
                        return "Not divisible by 0";
                    }
            }
        } catch (NumberFormatException e) {
            return "Please input number";
        }
        return "";
    }
}
