package com.example.demo.entity;

import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 1500, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String price;

    @Column(length = 50, nullable = false)
    private int count;


    public void changeName(String name){
        this.name = name;
    }

    public void changeContent(String content){
        this.content = content;
    }

    public void changePrice(String price){
        this.price = price;
    }

    public void changeCount(int count){ this.count = count; }

}
