package com.bola.bola.Repositores;

import com.bola.bola.Entity.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review,Integer> {
//    List<Review> findLastRow();
//    List<Review> findallByResturantId(int id);

}
