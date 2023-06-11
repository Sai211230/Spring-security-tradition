package com.sai.springsecurity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SAI
 * @create 2023-05-31
 */
@RequestMapping("/index")
@RestController
public class IndexController {

    @RequestMapping("/1")
    public String hello() {
        return "1";
    }
}
