package com.stylist.rest.webservices.restfulwebservices.service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.stylist.rest.webservices.restfulwebservices.model.Apparel;
import com.stylist.rest.webservices.restfulwebservices.model.BasicColour;
import com.stylist.rest.webservices.restfulwebservices.model.FileDB;
import com.stylist.rest.webservices.restfulwebservices.model.User;
import com.stylist.rest.webservices.restfulwebservices.repo.ApparelRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ApparelService {

    @Autowired
    private final ApparelRepo apparelRepo;

    @Autowired
    private final SessionUtilsService sessionUtils;

    public ApparelService(ApparelRepo apparelRepo, SessionUtilsService sessionUtils) {
        this.apparelRepo = apparelRepo;
        this.sessionUtils = sessionUtils;
    }

    @Transactional
    public Apparel addApparel(MultipartFile file, String type, BasicColour colour) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        FileDB image = new FileDB(fileName, file.getContentType(), file.getBytes());
        User currentUser = this.sessionUtils.getCurrentUserId();
        Apparel newApparel = new Apparel(currentUser, type, colour, image);
        System.out.println(newApparel);

        return apparelRepo.save(newApparel);
    }

    public Apparel saveApparel(int id, MultipartFile file, String type, BasicColour colour) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileDB image = new FileDB(fileName, file.getContentType(), file.getBytes());
        User currentUser = this.sessionUtils.getCurrentUserId();
        Apparel newApparel = new Apparel(currentUser, id, type, colour, image);

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

    public List<Apparel> getAllApparelsByUserId() {
        User currentUserId = this.sessionUtils.getCurrentUserId();
        return apparelRepo.findAllByUser(currentUserId);
    }
}
