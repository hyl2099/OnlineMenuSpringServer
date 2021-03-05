package com.lisa.onlineMenu.businessController;

import com.lisa.onlineMenu.documents.menu.Picture;
import com.lisa.onlineMenu.repository.menu.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PictureUploadBusinessController {

    PictureRepository pictureRepository;

    @Autowired
    public PictureUploadBusinessController(PictureRepository pictureRepository) {
        this.pictureRepository = pictureRepository;
    }

    public Picture add(String src, Picture p){
        p.setPath(src);
        return this.pictureRepository.save(p);
    }
}
