package com.sai.springsecurity.controller;

import com.alibaba.fastjson2.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SAI
 * @create 2023-05-30
 */
@RequestMapping("/hello")
@Controller
public class HelloController {

    @RequestMapping("/1")
    @ResponseBody
    public String hello() throws JsonProcessingException {
        Map<String, String> result = new HashMap<>();
        result.put("555", "张搜覅还叫我死而后");

        return JSON.toJSONString(result);
    }

}
