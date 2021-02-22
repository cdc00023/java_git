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
    private Long productID;

    @Column(length = 100, nullable = false)
    private String product;

    @Column(length = 200, nullable = false)
    private String image;

    @Column(length = 1500, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String price;

    @Column(length = 50, nullable = false)
    private int count;


    public void changeproductID(long productID){
        this.productID = productID;
    }

    public void changeproduct(String product){
        this.product = product;
    }

    public void changeimage(String image){
        this.image = image;
    }

    public void changecontent(String content){
        this.content = content;
    }

    public void changeprice(String price){
        this.price = price;
    }

    public void changecount(int count){ this.count = count; }
}
