package com.example.controller;

import com.example.dto.CartDto;
import com.example.dto.ProductDto;
import com.example.model.Product;
import com.example.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import java.util.Optional;

@SessionAttributes("cart")
@Controller
@RequestMapping("/shop")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto initCart(){
        return new CartDto();
    }

    @GetMapping()
    public ModelAndView showProduct(Model model,
    @CookieValue(value ="idProduct",
    defaultValue = "-1") Long idProduct) {

        if(idProduct != -1){
            model.addAttribute("historyProduct",
                    iProductService.findAll());
        }
        return new ModelAndView("shop/list" ,"productList",
                iProductService.findAll());
    }

    @GetMapping("/view/{id}")
    public ModelAndView showViewProduct(@PathVariable long id, HttpServletResponse response) {

        Cookie cookie = new Cookie("idProduct",id + "");
        cookie.setMaxAge(60*60*24*1);
//        cookie.setPath("/");
        response.addCookie(cookie);
       return new ModelAndView("shop/view","product", iProductService.findById(id).get());

    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cart ) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);
            cart.addProduct(productDto);
        }
        return "redirect:/cart";
    }
    @GetMapping("/drop/{id}")
    public String dropToCart(@PathVariable Long id,
                            @SessionAttribute("cart") CartDto cart ) {
        Optional<Product> productOptional = iProductService.findById(id);
        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(),productDto);
            cart.dropProduct(productDto);
        }
        return "redirect:/cart";
    }
}
