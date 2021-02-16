package com.swcordingschool.Ex5.repositiory;


import com.swcordingschool.Ex5.dto.ShopDTO;
import com.swcordingschool.Ex5.entity.Shop;
import com.swcordingschool.Ex5.repository.ShopRepository;
import com.swcordingschool.Ex5.service.ShopService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;
import java.util.stream.IntStream;



@SpringBootTest
public class ShopRepositoryTests {
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ShopService service;




    @Test
    public void insertDummies(){
        IntStream.rangeClosed(1,10).forEach(i -> {
            Shop shop = Shop.builder()

                    .name("name...." + i)
                    .content("Content...." +i)
                    .price("price...." + (i % 10))
                    .count(+i)
                    .build();
            System.out.println(shopRepository.save(shop));
        });
    }

    @Test
    public void updateTest() {
        Optional<Shop> result = shopRepository.findById(1L);

        if(result.isPresent()){
            Shop shop = result.get();

            shop.changeName("Changed Name...");
            shop.changeContent("Changed Content...");
            shop.changePrice("Changed Price...");
            shop.changeCount(Integer.parseInt("Changed Count..."));

            shopRepository.save(shop);
        }
    }

}