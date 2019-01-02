package com.jack.jackdawson.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(@RequestParam long userId){
        return userId + " ok";
    }

}
