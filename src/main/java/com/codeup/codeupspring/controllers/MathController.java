package com.codeup.codeupspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/3/and/4")
    @ResponseBody
    public int add() {
        return 3+4;
    }

    @GetMapping("/subtract/3/from/10")
    @ResponseBody
    public int subtract() {
        return 10-3;
    }

    @GetMapping("/multiply/4/and/5")
    @ResponseBody
    public int multiply(){
        return 4*5;
    }

    @GetMapping("/divide/6/by/3")
    @ResponseBody
    public int divide(){
        return 6/3;
    }
}
