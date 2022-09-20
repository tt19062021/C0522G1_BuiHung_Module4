package com.example.controller;

import com.example.dto.MusicDto;
import com.example.model.Music;
import com.example.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MusicController {

    @Autowired
    private IMusicService iMusicService;

    @GetMapping("/")
    public String showList(Model model) {
        List<Music> musicList = iMusicService.findByAll();
        model.addAttribute("musicList", musicList);
        return "/music/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "/music/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("musicDto") @Validated MusicDto musicDto,
                       BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasFieldErrors()) {
            return "/music/create";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);

            iMusicService.save(music);
            redirectAttributes.addFlashAttribute("success", "Create Success!!");
            return "redirect:/";
        }
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        MusicDto musicDto = new MusicDto();
        Music music = iMusicService.findById(id);
        
        BeanUtils.copyProperties(music, musicDto);

        model.addAttribute("musicDto", musicDto);
        return "/music/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("musicDto") @Validated MusicDto musicDto,
            BindingResult bindingResult,Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasFieldErrors()) {
            return "/music/edit";
        } else {
            Music music = new Music();
            BeanUtils.copyProperties(musicDto, music);

            iMusicService.save(music);
            redirectAttributes.addFlashAttribute("updateMess", "Update Success!!");
            return "redirect:/";
        }
    }
}
