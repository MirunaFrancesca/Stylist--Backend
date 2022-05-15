package com.stylist.rest.webservices.restfulwebservices.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.stylist.rest.webservices.restfulwebservices.model.Apparel;
import com.stylist.rest.webservices.restfulwebservices.model.BasicColour;
import com.stylist.rest.webservices.restfulwebservices.model.FileDB;
import com.stylist.rest.webservices.restfulwebservices.repo.ApparelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ApparelService {

    @Autowired
    private ApparelRepo apparelRepo;

    public Apparel addApparel(MultipartFile file, String type, BasicColour colour) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB image = new FileDB(fileName, file.getContentType(), file.getBytes());
        Apparel newApparel = new Apparel(type, colour, image);

        return apparelRepo.save(newApparel);
    }

    public boolean deleteApparel(int id) {
        this.apparelRepo.deleteById(id);
        return this.apparelRepo.findById(id).isEmpty();
    }

    public Optional<Apparel> getApparelById(int id) {
        return apparelRepo.findById(id);
    }

    public Optional<FileDB> getFileById(int id) {
        return apparelRepo.findById(id).map(Apparel::getImage);
    }

    public List<Apparel> getAllApparels() {
        return apparelRepo.findAll();
    }
}
