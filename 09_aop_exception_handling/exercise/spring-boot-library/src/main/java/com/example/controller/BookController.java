package com.example.controller;

import com.example.model.Book;
import com.example.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {

    @Autowired
    private IBookService iBookService;

    @GetMapping("/library")
    public String showLibrary(@PageableDefault(value = 5) Pageable pageable, Model model){
        Page<Book> bookPage = iBookService.findAll(pageable);
        model.addAttribute("bookPage",bookPage);
        return "/book/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) throws Exception {
       Book book= iBookService.findById(id);

       if(book.getAmount() == 0){
           throw new Exception();
       }else{
           model.addAttribute("book",book);
           return "/book/edit";
       }
    }

    @PostMapping("/update")
    public String updateBorrow(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        book.setAmount(book.getAmount() -1);
        iBookService.update(book);

        redirectAttributes.addFlashAttribute("messUpdate", "Code book borrow for You is : "
                + book.getId()+ " Please put your code After pay book !!");
        return "redirect:/library";
    }

    @GetMapping("/{id}/check")
    public String checkId(@PathVariable int id,Model model){
        model.addAttribute("book",iBookService.findById(id));
        return "/book/check";
    }

    @PostMapping("/pay")
    public String updatePay(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        if(book.getAmount() == book.getSumBook()){
            redirectAttributes.addFlashAttribute("messPayFull", "Book Is FULL");
            return "redirect:/library";
        }else {
            book.setAmount(book.getAmount() +1);
            iBookService.update(book);
            redirectAttributes.addFlashAttribute("messPay", "Successfull!!");
            return "redirect:/library";
        }
    }

}
