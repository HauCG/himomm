package com.example.customerman.controller;

import com.example.customerman.model.Account;
import org.opencv.core.Core;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @ModelAttribute("img")
    public Account setUpAccountForm() {
        return new Account();
    }

    @RequestMapping("/version")
    public ModelAndView getVersion() {
        ModelAndView modelAndView = new ModelAndView("/img/versionView");
        modelAndView.addObject("version", Core.VERSION);
        return modelAndView;
    }
}
