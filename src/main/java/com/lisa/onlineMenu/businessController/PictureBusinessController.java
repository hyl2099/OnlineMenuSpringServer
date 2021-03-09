package com.lisa.onlineMenu.businessController;

import com.lisa.onlineMenu.businessService.PhotoService;
import com.lisa.onlineMenu.documents.menu.Picture;
import com.lisa.onlineMenu.repository.menu.PictureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Controller
public class PictureBusinessController {
    PictureRepository pictureRepository;
    private PhotoService photoService;

    //自动装入pictureRepository
    @Autowired
    public PictureBusinessController(PictureRepository pictureRepository, PhotoService photoService) {
        this.pictureRepository = pictureRepository;
        this.photoService = photoService;
    }

    //因为涉及到图片，没有用到
    public Iterable<Picture> readAll(){
        return this.pictureRepository.findAll();
    }

    //post一个picture，因为涉及到图片，没有用到
    public Picture savePicture(Picture picture){
        return this.pictureRepository.save(picture);
    }


    public Optional<Picture> findPictureById(Long id){
        return this.pictureRepository.findById(id);
    }


    public void deletePicture(Long id) {
        this.pictureRepository.deleteById(id);
    }
}
