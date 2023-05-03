package com.armoury.backend.test;

import com.armoury.backend.config.BaseResponseStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/success")
    public String success(){
        return BaseResponseStatus.SUCCESS.getMessage();
    }

}
