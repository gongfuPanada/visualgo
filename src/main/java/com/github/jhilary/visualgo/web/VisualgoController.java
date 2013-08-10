package com.github.jhilary.visualgo.web;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.github.jhilary.visualgo.graph.dao.GraphDao;
import com.github.jhilary.visualgo.graph.exception.GraphException;

@Controller
public final class VisualgoController {
    private static final Logger log = Logger.getLogger(VisualgoController.class);
    
    @Autowired
    private ServletContext servletContext;
    
    private String line = "{ \"nodes\":{\"foo\":{\"color\":\"red\", \"mass\":2}, \"bar\":{\"color\":\"green\"}} }";
    private String line2 = "{ \"edges\":{\"a\":{\"c\":{},\"d\":{}}, \"b\":{\"c\":{},\"f\":{}},\"c\":{\"d\":{},\"f\":{}}} }";
    private String line3 ="";
    public VisualgoController(){};
    
    @RequestMapping(
            value="algos.do", 
            method = RequestMethod.GET)
    public void getAlgos(Model model) {
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
    
    @RequestMapping(
            value="graph.do", 
            method = RequestMethod.GET,
            produces="application/text")
    @ResponseBody
    public String getGraph(Model model) {
        WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
        GraphDao graphDao = (GraphDao) ctx.getBean("graphDao");
        try {
            line3 = graphDao.readGraph().getEdges().toString();
            log.info("Read graph: " + line3);
            return line3;
        } catch (GraphException e) {
            log.error(e.getMessage());
        }
        return "";
    }
  }
