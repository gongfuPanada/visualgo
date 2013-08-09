package com.github.jhilary.visualgo.web;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public final class VisualgoController {
    private static final Logger log = Logger.getLogger(VisualgoController.class);
    private String line = "{ \"nodes\":{\"foo\":{\"color\":\"red\", \"mass\":2}, \"bar\":{\"color\":\"green\"}} }";
    private String line2 = "{ \"edges\":{\"a\":{\"c\":{},\"d\":{}}, \"b\":{\"c\":{},\"f\":{}},\"c\":{\"d\":{},\"f\":{}}} }";
    public VisualgoController(){};
    
    @RequestMapping(
            value="algos.do", 
            method = RequestMethod.GET)
    public void getGraph(Model model) {
      log.info("Initialized algos.do");
    }
    @RequestMapping(
            value="rest.do",
            method=RequestMethod.GET,
            produces="application/json"
            )
        @ResponseBody
        public String getLineAsJson() {
            log.info("Passed graph to REST: " + line2);
            return line2;
        }
  }
