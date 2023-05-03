package com.armoury.backend.gallery;

import com.armoury.backend.config.BaseException;
import com.armoury.backend.config.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gallery")
public class GalleryController {
    final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private final GalleryProvider galleryProvider;

    @Autowired
    private final GalleryService galleryService;

    public GalleryController(GalleryProvider galleryProvider, GalleryService galleryService) {
        this.galleryProvider = galleryProvider;
        this.galleryService = galleryService;
    }


    @ResponseBody
    @GetMapping("/posts")
    public BaseResponse<String> getPostsInfo(){
        try {

        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }
}
