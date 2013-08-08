package com.github.jhilary.visualgo.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public final class VisualgoController {
    private static final Logger log = Logger.getLogger(VisualgoController.class);
    private String line = "{ nodes:{foo:{color:\"red\", mass:2}, bar:{color:\"green\"}} }";
    public VisualgoController(){};
    
    @RequestMapping(method = RequestMethod.GET)
    public void getGraph(Model model) {
      log.info("Passed line to page: " + line);
      model.addAttribute("line", line);
    }
  }
