package com.armoury.backend.controller;

import com.armoury.backend.config.BaseException;
import com.armoury.backend.config.BaseResponse;
import com.armoury.backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {


    @Autowired
    private final MemberService memberService;

    public HomeController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/api/test")
    public String test() {
        System.out.println("===Test===");
        //System.out.println(restTemplateService.mitreTest());
        //return restTemplateService.mitreTest();
        return "test";
    }

    @GetMapping("/api/techniques")
    public String Techniques() {
        System.out.println("===Techniques===");
        //return restTemplateService.mitreTechniques();
        return "test";
    }

    @GetMapping("/test")
    public BaseResponse<String> userInfoTest() {
        System.out.println("===RDS-DB-Test===");
        String result = memberService.test();
        return new BaseResponse<>(result);
    }

}