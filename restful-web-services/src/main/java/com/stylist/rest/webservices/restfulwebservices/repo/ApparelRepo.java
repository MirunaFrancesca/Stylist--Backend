package com.stylist.rest.webservices.restfulwebservices.repo;

import com.stylist.rest.webservices.restfulwebservices.model.Apparel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApparelRepo extends JpaRepository<Apparel, Integer> {
}
