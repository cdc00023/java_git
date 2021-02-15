package com.swcordingschool.Ex5.dto;

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

    private Long number;
    private String name;
    private String content;
    private String price;
    private int count;
    private LocalDateTime regDate, modDate;

}