package com.bola.bola.Services;

import com.bola.bola.Entity.Resturant;
import com.bola.bola.Entity.Review;
import com.bola.bola.Repositores.ResturantRepositorie;
import com.bola.bola.Repositores.ReviewRepository;
import com.bola.bola.api.ResturantDTO;
import com.bola.bola.api.ReviewDTO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Collections.max;

@Component
public class MainService {
    private final EntityManager entityManager;
    private final ResturantRepositorie resturantRepositorie;
    private final ReviewRepository reviewRepository;
    private final JdbcTemplate jdbcTemplate;


    public MainService(EntityManager entityManager, ResturantRepositorie resturantRepositorie, ReviewRepository reviewRepository, JdbcTemplate jdbcTemplate) {
        this.entityManager = entityManager;
        this.resturantRepositorie = resturantRepositorie;
        this.reviewRepository = reviewRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public void add(ResturantDTO resturantDTO) {
        Resturant resturant = new Resturant();
        List<ReviewDTO> reviewDTOS = resturantDTO.getReviewDTOS();

        resturant.setId(resturantDTO.getId());
        resturant.setName(resturantDTO.getName());


        entityManager.persist(resturant);
        for (ReviewDTO reviewDTO : reviewDTOS) {
            Review reviewentity = new Review();
            reviewentity.setId(reviewDTO.getId());
            reviewentity.setDate(reviewDTO.getDate());
            reviewentity.setRateing(reviewDTO.getRateing());
            reviewentity.setResturant(resturant);
            entityManager.persist(reviewentity);
        }
    }

    @Transactional
    public void adreview(ReviewDTO reviewDTO) {
        Review review = new Review();

        review.setId(reviewDTO.getId());
        review.setRateing(reviewDTO.getRateing());
        review.setDate(reviewDTO.getDate());

        Resturant resturant = resturantRepositorie.findById(reviewDTO.getResturantId()).get();
        review.setResturant(resturant);

        reviewRepository.save(review);


    }

    @Transactional
    public void updaterev(ReviewDTO reviewDTO) {
        Review review;
        review = entityManager.find(Review.class, reviewDTO.getId());

        review.setDate(reviewDTO.getDate());
        review.setRateing(reviewDTO.getRateing());

        entityManager.persist(review);

    }

    @Transactional
    public List<ReviewDTO> findAll() {
        List<Review> reviews = entityManager.createQuery("SELECT l from Review l", Review.class).getResultList();

        return reviews.stream().map(review -> {
            ReviewDTO reviewDTO = new ReviewDTO();


            reviewDTO.setId(review.getId());
            reviewDTO.setDate(review.getDate());
            reviewDTO.setRateing(review.getRateing());


            return reviewDTO;
        }).collect(Collectors.toUnmodifiableList());
    }

    @Transactional
    public void updateResturant(ResturantDTO resturantDTO) {
        Resturant resturant;
        resturant = entityManager.find(Resturant.class, resturantDTO.getId());

        resturant.setName(resturantDTO.getName());
        resturantRepositorie.save(resturant);
    }

    @Transactional
    public void deleteresturant(int id) {
        Resturant resturant = entityManager.find(Resturant.class, id);
        entityManager.remove(resturant);

    }

    @Transactional
    public List<ResturantDTO> findAllrestorants() {
        List<Resturant> resturants = entityManager.createQuery("SELECT l from Resturant l", Resturant.class).getResultList();

        return resturants.stream().map(resturant -> {
            ResturantDTO resturantDTO = new ResturantDTO();


            resturantDTO.setId(resturant.getId());
            resturantDTO.setName(resturant.getName());


            return resturantDTO;
        }).collect(Collectors.toUnmodifiableList());
    }

    @Transactional
    public double average() {
        ArrayList<Integer> rate = new ArrayList();
        int y = 0;
        int count = 0;
        int a = 0;

        //TODO i could not write this
        Query query = entityManager.createNativeQuery("select * from review where resturant_id = 4", List.class);
        List<Review> reviewLis = query.getResultList();

        for (Review review : reviewLis) {
            int x = 0;
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setRateing(review.getRateing());
            x = reviewDTO.getRateing();
            rate.add(x);
        }

        while (a <= rate.size()) {
            count += rate.get(a);

            a++;
        }

        return count / a;


    }

    @Transactional
    public int top() {
        ArrayList<Integer> rate = new ArrayList();
        int a = 0;
        int max = 0;

        List<Review> reviewLis = entityManager.createNativeQuery("Select * from review where  = 4");

        for (Review review : reviewLis) {
            int x = 0;
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setRateing(review.getRateing());
            x = reviewDTO.getRateing();
            rate.add(x);
        }
        while (a <= rate.size()) {
            if (rate.get(a) > max) {
                max = rate.get(a);
            }
            a++;
        }
        return max;

    }

    @Transactional
    public int low() {
        ArrayList<Integer> rate = new ArrayList();
        int a = 0;
        int min = rate.get(0);

        //TODO i could not write this
        List<Review> reviewLis = entityManager.createNativeQuery("Select * from review where resturant_id = 4");

        for (Review review : reviewLis) {
            int x = 0;
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setRateing(review.getRateing());
            x = reviewDTO.getRateing();
            rate.add(x);
        }
        while (a <= rate.size()) {

            if (min > rate.get(a)) {
                min = rate.get(a);
            }
            a++;
        }
        return min;

    }

    @Transactional
    public int last() {


        int p = 0;

        //TODO i could not write this
        List<Review> reviewLis = entityManager.createNativeQuery("Select * from review where resturant_id = 4");

        for (Review review : reviewLis) {
            int x = 0;
            ReviewDTO reviewDTO = new ReviewDTO();
            reviewDTO.setRateing(review.getRateing());
            x = reviewDTO.getRateing();
            p=x;
        }

        return p;

    }


}









