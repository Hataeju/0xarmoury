package com.armoury.backend.gallery;

import com.armoury.backend.config.BaseException;
import com.armoury.backend.config.BaseResponse;
import com.armoury.backend.gallery.model.PostInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/posts/{pageNumber}")
    public BaseResponse<List<PostInfo>> getPostsInfo(@PathVariable("pageNumber") int pageNum){
        try {
            List<PostInfo> infoList = galleryProvider.getPostInfo(pageNum*5 - 5);
            return new BaseResponse<>(infoList);
        } catch(BaseException exception){
            return new BaseResponse<>((exception.getStatus()));
        }
    }


}
