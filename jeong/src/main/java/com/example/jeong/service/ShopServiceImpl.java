package com.example.jeong.service;

import com.example.jeong.entity.QShop;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import com.example.jeong.DTO.PageDTO;
import com.example.jeong.DTO.PagingDTO;
import com.example.jeong.DTO.ShopDTO;
import com.example.jeong.entity.Shop;


import com.example.jeong.repository.ShopRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService {
    private final ShopRepository repository;


    @Override
    public Long register(ShopDTO dto) {
        log.info("DTO------------------------");
        log.info(dto);
        Shop entity = dtoToEntity(dto);
        log.info(entity);

        repository.save(entity);

        return entity.getProductID();
    }

    @Override
    public PagingDTO<ShopDTO, Shop> getList(PageDTO pageDTO) {

        Pageable pageable = pageDTO.getPageable(Sort.by("productID").descending());

        BooleanBuilder booleanBuilder = getSearch(pageDTO); //검색 조건 처리

        Page<Shop> result = repository.findAll(pageable); //Querydsl 사용
        //Page<Shop> result = repository.findAll(booleanBuilder, pageable); //Querydsl 사용

        Function<Shop, ShopDTO> fn = (entity->entityToDto(entity));

        return new PagingDTO<>(result, fn );
    }

    @Override
    public ShopDTO read(Long productID) {
        Optional<Shop> result = repository.findById(productID);
        return result.isPresent()? entityToDto(result.get()): null;
    }


    @Override
    public void remove(Long productID) {

        repository.deleteById(productID);

    }


    @Override
    public void modify(ShopDTO dto) {

        //업데이트 하는 항목은 '제목', '내용'

        Optional<Shop> result = repository.findById(dto.getProductID());

        if(result.isPresent()){

            Shop entity = result.get();

            entity.changeproduct(dto.getProduct());
            entity.changeimage(dto.getImage());
            entity.changecontent(dto.getContent());
            entity.changeprice(dto.getPrice());
            entity.changecount(dto.getCount());

            repository.save(entity);

        }
    }

    private BooleanBuilder getSearch(PageDTO pageDTO){

        String type = pageDTO.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QShop qShop = QShop.shop;

        String keyword = pageDTO.getKeyword();

        BooleanExpression expression = qShop.productID.gt(0L); // productID > 0 조건만 생성

        booleanBuilder.and(expression);

        if(type == null || type.trim().length() == 0){ //검색 조건이 없는 경우
            return booleanBuilder;
        }


        //검색 조건을 작성하기
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(type.contains("p")){
            conditionBuilder.or(qShop.product.contains(keyword));
        }
        if(type.contains("c")){
            conditionBuilder.or(qShop.content.contains(keyword));
        }

        //모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }

}