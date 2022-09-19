package com.example.controller;


import com.example.model.Blog;
import com.example.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.print.Pageable;
import java.util.List;

@Controller
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @GetMapping({"/blog","/"})
    public String showBlogList(Model model){
        List<Blog> blogList = iBlogService.findByAll();
        model.addAttribute("blogList",blogList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blogList", new Blog());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog) {
//        blog.setId((int)(Math.random() * 200));
        iBlogService.save(blog);
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blogList", iBlogService.findById(id));
        return "view";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("blogList", iBlogService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.update(blog);
        redirectAttributes.addFlashAttribute("messegerUpdate","UPDATE SUCCESS!!");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("blogList", iBlogService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Blog blog, RedirectAttributes redirect) {
        iBlogService.remove(blog.getId());
        redirect.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/blog";
    }

//    @GetMapping("/search")
//    public String search(@RequestParam String name, Model model){
//        model.addAttribute("blogList", iBlogService.searchByName(name));
//        return "list";
//    }
}
