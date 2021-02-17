package com.example.jeong.service;

import com.example.jeong.DTO.PageDTO;
import com.example.jeong.DTO.PagingDTO;
import com.example.jeong.DTO.ShopDTO;
import com.example.jeong.entity.Shop;

public interface ShopService {
    Long register(ShopDTO dto);

    ShopDTO read(Long s_productID);

    PagingDTO<ShopDTO, Shop> getList(PageDTO pageDTO);

    void modify(ShopDTO dto);

    void remove(Long s_productID);

    default Shop dtoToEntity(ShopDTO dto) {
        Shop entity = Shop.builder()
                .s_productID(dto.getS_productID())
                .s_product(dto.getS_product())
                .s_image(dto.getS_image())
                .s_content(dto.getS_content())
                .s_price(dto.getS_price())
                .s_count(dto.getS_count())
                .build();
        return entity;
    }

    default ShopDTO entityToDto(Shop entity) {
        ShopDTO dto = ShopDTO.builder()

                .s_productID(entity.getS_productID())
                .s_product(entity.getS_product())
                .s_image(entity.getS_image())
                .s_content(entity.getS_content())
                .s_price(entity.getS_price())
                .s_count(entity.getS_count())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }


}
