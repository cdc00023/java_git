package com.example.jeong.service;

import com.example.jeong.DTO.PageDTO;
import com.example.jeong.DTO.PagingDTO;
import com.example.jeong.DTO.ShopDTO;
import com.example.jeong.entity.Shop;

public interface ShopService {
    Long register(ShopDTO dto);

    ShopDTO read(Long productID);

    PagingDTO<ShopDTO, Shop> getList(PageDTO pageDTO);

    void modify(ShopDTO dto);

    void remove(Long productID);

    default Shop dtoToEntity(ShopDTO dto) {
        Shop entity = Shop.builder()
                .productID(dto.getProductID())
                .product(dto.getProduct())
                .image(dto.getImage())
                .content(dto.getContent())
                .price(dto.getPrice())
                .count(dto.getCount())
                .build();
        return entity;
    }

    /*
     private Long productID;
    private String product;
    private String image;
    private String content;
    private String price;
    private int count;
    private LocalDateTime regDate, modDate;

*/

    default ShopDTO entityToDto(Shop entity) {
        ShopDTO dto = ShopDTO.builder()
                .productID(entity.getProductID())
                .product(entity.getProduct())
                .image(entity.getImage())
                .content(entity.getContent())
                .price(entity.getPrice())
                .count(entity.getCount())
                .regDate(entity.getRegDate())
                .modDate(entity.getModDate())
                .build();
        return dto;
    }


}
