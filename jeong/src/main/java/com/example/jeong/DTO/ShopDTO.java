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

    private Long s_productID;
    private String s_product;
    private String s_image;
    private String s_content;
    private String s_price;
    private int s_count;
    private LocalDateTime regDate, modDate;

}