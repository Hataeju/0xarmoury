package com.armoury.backend.service.impl;


import java.net.URI;

import com.armoury.backend.service.RestTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {

    private final Logger LOGGER = LoggerFactory.getLogger(RestTemplateServiceImpl.class);

    @Override
    public String mitreTest() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:5000")
                .path("/mitre/test")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());
        System.out.println("==========Test============");
        System.out.println(responseEntity.getBody());
        return responseEntity.getBody();
    }

    @Override
    public String mitreTechniques() {
        URI uri = UriComponentsBuilder
                .fromUriString("http://localhost:5000")
                .path("/mitre/techniques")
                .encode()
                .build()
                .toUri();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(uri, String.class);

        LOGGER.info("status code : {}", responseEntity.getStatusCode());
        LOGGER.info("body : {}", responseEntity.getBody());
        System.out.println("==========Test============");
        System.out.println(responseEntity.getBody());
        return responseEntity.getBody();
    }
}