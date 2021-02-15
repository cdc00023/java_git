package com.swcordingschool.Ex5.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;

import com.swcordingschool.Ex5.dto.PageRequestDTO;
import com.swcordingschool.Ex5.dto.PageResultDTO;
import com.swcordingschool.Ex5.dto.ShopDTO;
import com.swcordingschool.Ex5.entity.QShop;
import com.swcordingschool.Ex5.entity.Shop;
import com.swcordingschool.Ex5.repository.ShopRepository;
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
public abstract class ShopServiceImpl implements ShopService {

    private final ShopRepository repository;

    @Override
    public Long register(ShopDTO dto) {

        log.info("DTO------------------------");
        log.info(dto);
        Shop entity = dtoToEntity(dto);
        log.info(entity);

        repository.save(entity);

        return entity.getNumber();
    }

    @Override
    public PageResultDTO<ShopDTO, Shop> getList(PageRequestDTO requestDTO) {

        Pageable pageable = requestDTO.getPageable(Sort.by("number").descending());

        BooleanBuilder booleanBuilder = getSearch(requestDTO); //검색 조건 처리

        Page<Shop> result = repository.findAll(booleanBuilder, pageable); //Querydsl 사용

        Function<Shop, ShopDTO> fn = (entity -> entityToDto(entity));

        return new PageResultDTO<>(result, fn );
    }

    @Override
    public ShopDTO read(Long number) {
        Optional<Shop> result = repository.findById(number);
        return result.isPresent()? entityToDto(result.get()): null;
    }

    @Override
    public void remove(Long number) {

        repository.deleteById(number);

    }

    @Override
    public void modify(ShopDTO dto) {

        //업데이트 하는 항목은 '제목', '내용', '가격'

        Optional<Shop> result = repository.findById(dto.getNumber());

        if(result.isPresent()){

            Shop entity = result.get();

            entity.changeName(dto.getName());
            entity.changeContent(dto.getContent());
            entity.changePrice(dto.getPrice());
            entity.changeCount(dto.getCount());

            repository.save(entity);

        }
    }


    private BooleanBuilder getSearch(PageRequestDTO requestDTO){

        String type = requestDTO.getType();

        BooleanBuilder booleanBuilder = new BooleanBuilder();

        QShop qshop = QShop.shop;

        String keyword = requestDTO.getKeyword();

        BooleanExpression expression = qshop.number.gt(0L); // number > 0 조건만 생성

        booleanBuilder.and(expression);

        if(type == null || type.trim().length() == 0){ //검색 조건이 없는 경우
            return booleanBuilder;
        }


        //검색 조건을 작성하기
        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if(type.contains("n")){
            conditionBuilder.or(qshop.name.contains(keyword));
        }
        if(type.contains("c")){
            conditionBuilder.or(qshop.content.contains(keyword));
        }
        if(type.contains("p")){
            conditionBuilder.or(qshop.price.contains(keyword));
        }

        //모든 조건 통합
        booleanBuilder.and(conditionBuilder);

        return booleanBuilder;
    }

}