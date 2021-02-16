package com.example.demo.service;

import com.example.demo.DTO.ShopDTO;
import com.example.demo.entity.Shop;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public abstract class ShopServiceImpl implements ShopService {

    @Override
    public Long register(ShopDTO dto) {

        log.info("DTO------------------------");
        log.info(dto);
        Shop entity = dtoToEntity(dto);
        log.info(entity);

        repository.save(entity);

        return entity.getNumber();
    }

}
