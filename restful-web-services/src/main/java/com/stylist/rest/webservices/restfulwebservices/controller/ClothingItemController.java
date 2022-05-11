package com.stylist.rest.webservices.restfulwebservices.controller;

import com.stylist.rest.webservices.restfulwebservices.model.ClothingItem;
import com.stylist.rest.webservices.restfulwebservices.repo.ClothingItemRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outfits")
public class ClothingItemController {

    @Autowired
    private ClothingItemRepo clothingItemRepo;

    @GetMapping(path="/all-outfits")
    public List<ClothingItem> getAllOutfits(){
        List<ClothingItem> allItems = clothingItemRepo.findAll();
        return allItems;
    }

    @PostMapping("/update-outift")
    public ClothingItem saveClothingItem(@RequestBody ClothingItem newClothingItem) {
        return this.clothingItemRepo.save(newClothingItem);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete-outfit/{id}")
    public boolean deleteClothingItem(@PathVariable("id") int id){
        this.clothingItemRepo.deleteById(id);
        return this.clothingItemRepo.findById(id).isEmpty();
    }

}
