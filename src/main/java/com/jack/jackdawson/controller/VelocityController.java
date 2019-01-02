package com.jack.jackdawson.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("velocity")
public class VelocityController {

    @RequestMapping(value = "/testVM", method = RequestMethod.GET)
    public String testVM(Model model){
        model.addAttribute("name", "zhangys");
        return "index";
    }

}
