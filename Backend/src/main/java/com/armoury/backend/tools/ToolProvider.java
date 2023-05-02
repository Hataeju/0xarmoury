package com.armoury.backend.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ToolProvider {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String getToolByIdx(int toolIdx){
        return "Success";
    }
}
