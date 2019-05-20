package com.jack.jackdawson.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping(value = "/test")
    @ResponseBody
    public String test(@RequestParam long userId){
        return userId + " ok";
    }

}
