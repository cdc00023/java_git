package com.example.jeong.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ShopDTO {

    private Long productID;
    private String product;
    private String image;
    private String content;
    private String price;
    private int count;

}