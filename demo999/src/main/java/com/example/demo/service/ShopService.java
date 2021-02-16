package com.example.demo.service;

import com.example.demo.DTO.ShopDTO;
import com.example.demo.entity.Shop;

public interface ShopService {
    Long register(ShopDTO dto);
    ShopDTO read(Long gno);
    PageResultDTO<ShopDTO, Shop> getList(ShopDTO requestDTO);

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

                .gno(entity.getGno())
                .name(dto.getName())
                .content(entity.getContent())
                .price(dto.getPrice())
                .count(dto.getCount())
                .build();
        return dto;
    }

}
