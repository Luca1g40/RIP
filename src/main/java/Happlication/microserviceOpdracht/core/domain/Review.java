package Happlication.microserviceOpdracht.core.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private Long id;
    private String foodReview;
    private int foodScore;
    private String foodDeliveryReview;
    private int foodDeliveryScore;
    @OneToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Order order;

    public Review() {
    }

    public Review(String foodReview, int foodScore, String foodDeliveryReview, int foodDeliveryScore, Order order) {
        this.foodReview = foodReview;
        this.foodScore = foodScore;
        this.foodDeliveryReview = foodDeliveryReview;
        this.foodDeliveryScore = foodDeliveryScore;
        this.order = order;
    }

    public Long getId() {
        return id;
    }

    public String getFoodReview() {
        return foodReview;
    }

    public int getFoodScore() {
        return foodScore;
    }

    public String getFoodDeliveryReview() {
        return foodDeliveryReview;
    }

    public int getFoodDeliveryScore() {
        return foodDeliveryScore;
    }

    public Order getOrder(){
        return order;
    }
}
