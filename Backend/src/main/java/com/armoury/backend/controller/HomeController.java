package com.armoury.backend.controller;

import com.armoury.backend.service.RestTemplateService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
    private final RestTemplateService restTemplateService;

    public HomeController(RestTemplateService restTemplateService) {
        this.restTemplateService = restTemplateService;
    }

    @GetMapping("/api/test")
    public String test() {
        System.out.println("===Test===");
        //System.out.println(restTemplateService.mitreTest());
        return restTemplateService.mitreTest();
    }

    @GetMapping("/api/techniques")
    public String Techniques() {
        System.out.println("===Techniques===");
        return restTemplateService.mitreTechniques();
    }

}