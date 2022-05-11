package com.stylist.rest.webservices.restfulwebservices.controller;

import com.stylist.rest.webservices.restfulwebservices.dto.ResponseMessage;
import com.stylist.rest.webservices.restfulwebservices.model.Apparel;

import com.stylist.rest.webservices.restfulwebservices.model.FileDB;
import com.stylist.rest.webservices.restfulwebservices.service.ApparelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/apparel")
public class ApparelController {

    @Autowired
    private ApparelService apparelService;

    @PostMapping("/save")
    public ResponseEntity<ResponseMessage> saveApparel(@RequestParam("file") MultipartFile file, @RequestParam("type") String type, @RequestParam("colour") String colour) {
        String message = "";
        try {
            this.apparelService.addApparel(file, type, colour);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
        }
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/delete/{id}")
    public boolean deleteApparel(@PathVariable("id") int id){
        return this.apparelService.deleteApparel(id);
    }

    @GetMapping(path="/get/{id}")
    public Optional<Apparel> getApparelById(@PathVariable("id") int id){
        return this.apparelService.getApparelById(id);
    }

    @GetMapping(path="/get-all")
    public List<Apparel> getAllApparels(){
        return this.apparelService.getAllApparels();
    }

    @GetMapping(path="/get-file/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable int id) {
        FileDB fileDB = this.apparelService.getFileById(id).orElseThrow();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }

}