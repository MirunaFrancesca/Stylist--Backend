package com.stylist.rest.webservices.restfulwebservices.repo;

import com.stylist.rest.webservices.restfulwebservices.model.ClothingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClothingItemRepo extends JpaRepository<ClothingItem, Integer> {
}
