package com.example.demo.DTO;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShopDTO {

    private Long number;
    private String name;
    private String content;
    private String price;
    private int count;



}
