package com.mxjlife.admin.web.controller;

import org.springframework.web.bind.annotation.*;

/**
 * 测试接口
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String get(@RequestParam("id") Long id) {
        return "success";
    }


}
