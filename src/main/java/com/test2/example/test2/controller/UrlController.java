package com.test2.example.test2.controller;
import java.util.List;

import com.test2.example.test2.model.Url;
import com.test2.example.test2.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/url")
public class UrlController {
    private final UrlService urlService;

    @Autowired
    public UrlController(UrlService urlService) {
        this.urlService=urlService;
    }
   /*@GetMapping("/get/Id")
    public String getAllObject(){
        return urlService.saveAllObject();
    }*/

    @GetMapping("/getAll")
    public List<Url> getAllObjects(){
        return urlService.saveAllObjects();
    }
}
