package com.swcordingschool.Ex5.service;

import com.swcordingschool.Ex5.dto.PageRequestDTO;
import com.swcordingschool.Ex5.dto.PageResultDTO;
import com.swcordingschool.Ex5.dto.ShopDTO;

import com.swcordingschool.Ex5.entity.Shop;

import java.time.LocalDateTime;

public interface ShopService {
    Long register(ShopDTO dto);
    ShopDTO read(Long gno);
    PageResultDTO<ShopDTO, Shop> getList(PageRequestDTO requestDTO);
    void modify(ShopDTO dto);
    void remove(Long gno);


    default Shop dtoToEntity(ShopDTO dto) {
        Shop entity = Shop.builder()

                .number(dto.getNumber())
                .name(dto.getName())
                .content(dto.getContent())
                .price(dto.getPrice())
                .count(dto.getCount())
                .build();
        return entity;
    }

    default ShopDTO entityToDto(Shop entity) {
        ShopDTO dto = ShopDTO.builder()

                .number(entity.getNumber())
                .name(entity.getName())
                .content(entity.getContent())
                .price(entity.getPrice())
                .count(entity.getCount())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }


}