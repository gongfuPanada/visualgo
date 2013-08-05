package com.github.jhilary.visualgo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public final class VisualgoController {
    public VisualgoController(){};
    @RequestMapping
    public void zero(Model model) {
      model.addAttribute(0);
    }
  }
