package cn.schoolo2o.schoolo2o.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping(value = "/index.html")
    public String test(Model model){
        model.addAttribute("name","赵雅娟");
        return "index";
    }
}
