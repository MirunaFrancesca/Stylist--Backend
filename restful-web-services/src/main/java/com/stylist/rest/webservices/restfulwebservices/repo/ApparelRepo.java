package com.stylist.rest.webservices.restfulwebservices.repo;

import com.stylist.rest.webservices.restfulwebservices.model.Apparel;
import com.stylist.rest.webservices.restfulwebservices.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApparelRepo extends JpaRepository<Apparel, Integer> {
    List<Apparel> findAllByUser(User user);
}
