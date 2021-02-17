package com.example.jeong.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shop extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long s_productID;

    @Column(length = 100, nullable = false)
    private String s_product;

    @Column(length = 200, nullable = false)
    private String s_image;

    @Column(length = 1500, nullable = false)
    private String s_content;

    @Column(length = 50, nullable = false)
    private String s_price;

    @Column(length = 50, nullable = false)
    private int s_count;


    public void changes_productID(long s_productID){
        this.s_productID = s_productID;
    }

    public void changes_product(String s_product){
        this.s_product = s_product;
    }

    public void changes_image(String s_image){
        this.s_image = s_image;
    }

    public void changes_content(String s_content){
        this.s_content = s_content;
    }

    public void changes_price(String s_price){
        this.s_price = s_price;
    }

    public void changes_count(int s_count){ this.s_count = s_count; }
}
