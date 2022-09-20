package com.example.controller;

import com.example.model.Blog;
import com.example.model.Category;
import com.example.service.IBlogService;
import com.example.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;


@Controller
@RequestMapping("/category")
public class CategoryController  {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String showList(Model model) {
        List<Category> categoryList = iCategoryService.findByAll();
        model.addAttribute("categoryList", categoryList);
        return "list_category";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categorys",new Category());
        return "create_category";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Category category) {
//        blog.setId((int)(Math.random() * 200));
        iCategoryService.save(category);
        return "redirect:/category";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "edit_category";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.update(category);
        redirectAttributes.addFlashAttribute("mess", "Update successful!");
        return "redirect:/category";
    }
    @GetMapping("/delete/{id}")
    private String delete(@PathVariable int id, Model model) {
        model.addAttribute("category", iCategoryService.findById(id));
        return "delete_category";
    }

    @PostMapping("/delete")
    public String delete(Category category, RedirectAttributes redirectAttributes) {
        iCategoryService.remove(category.getId());
        redirectAttributes.addFlashAttribute("mess", "Remove successful!");
        return "redirect:/category";
    }
}
