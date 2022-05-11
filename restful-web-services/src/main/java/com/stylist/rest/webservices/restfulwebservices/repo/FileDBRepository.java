package com.stylist.rest.webservices.restfulwebservices.repo;

import com.stylist.rest.webservices.restfulwebservices.model.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {

}
