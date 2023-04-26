package com.armoury.backend.controller;

import com.armoury.backend.config.BaseException;
import com.armoury.backend.config.BaseResponse;
import com.armoury.backend.service.RestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.armoury.backend.dao.userModel.*;
import com.armoury.backend.service.UserService;

@RestController
public class HomeController {
    private final RestTemplateService restTemplateService;

    @Autowired
    private final UserService userService;

    public HomeController(RestTemplateService restTemplateService, UserService userService) {
        this.restTemplateService = restTemplateService;
        this.userService = userService;
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

    @GetMapping("/db/user/{userIdx}")
    public BaseResponse<GetUserRes> userInfoTest(@PathVariable("userIdx")int userIdx) {
        System.out.println("===RDS-DB-Test===");
        try{
            GetUserRes getUsersRes = userService.getUsersByIdx(userIdx);
            return new BaseResponse<>(getUsersRes);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }

}