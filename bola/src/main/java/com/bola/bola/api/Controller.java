package com.bola.bola.api;

import com.bola.bola.Entity.Resturant;
import com.bola.bola.Entity.Review;
import com.bola.bola.Repositores.ResturantRepositorie;
import com.bola.bola.Repositores.ReviewRepository;
import com.bola.bola.Services.MainService;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("/api/res/")
public class Controller {
    private final MainService mainService;
    private final EntityManager entityManager;
    private final ResturantRepositorie resturantRepositorie;
private final ReviewRepository reviewRepository;
    public Controller(MainService mainService, EntityManager entityManager, ResturantRepositorie resturantRepositorie, ReviewRepository reviewRepository) {
        this.mainService = mainService;
        this.entityManager = entityManager;
        this.resturantRepositorie = resturantRepositorie;
        this.reviewRepository = reviewRepository;
    }

    @PostMapping("/add")
    public void add(@RequestBody ResturantDTO resturantDTO) {
        mainService.add(resturantDTO);

    }

    @PostMapping("/addd")
    public void addd(@RequestBody ResturantDTO resturantDTO) {
        Resturant resturant = new Resturant();
        resturant.setId(resturantDTO.getId());
        resturant.setName(resturantDTO.getName());
        resturantRepositorie.save(resturant);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestParam int id) {
        resturantRepositorie.deleteById(id);

    }

    @PostMapping("/adreview")
    public void adreview(@RequestBody ReviewDTO reviewDTO) {
        mainService.adreview(reviewDTO);

    }

    @PostMapping("/updaterev")
    public void updaterev(@RequestBody ReviewDTO reviewDTO) {
        mainService.updaterev(reviewDTO);
    }

    @GetMapping("/findallreview")
    public List<ReviewDTO> findall() {
        return mainService.findAll();
    }

    @PostMapping("/updateResturant")
    public void updateResturant(@RequestBody ResturantDTO resturantDTO) {
        mainService.updateResturant(resturantDTO);
    }
    @DeleteMapping("deleteresturant")
    public void deleteresturant(@RequestParam int id){
         mainService.deleteresturant(id);
    }
    @GetMapping("/findAllrestorants")
    public List<ResturantDTO>findAllrestorants(){
        return mainService.findAllrestorants();
    }

    @GetMapping("/average")
    public double average(){

        return mainService.average();

    }
    @GetMapping("/low")
    public double low(){

        return mainService.low();

    }
    @GetMapping("/top")
    public double top(){

        return mainService.top();

    }

    @GetMapping("/last")
    public int last(){

        return mainService.last();

    }

}
