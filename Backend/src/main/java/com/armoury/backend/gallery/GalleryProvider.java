package com.armoury.backend.gallery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryProvider {
    final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private final GalleryDao galleryDao;

    public GalleryProvider(GalleryDao galleryDao) {
        this.galleryDao = galleryDao;
    }
}
