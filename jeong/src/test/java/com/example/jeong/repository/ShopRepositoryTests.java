package com.example.jeong.repository;



import com.example.jeong.entity.Shop;
import com.example.jeong.service.ShopService;
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

                    .s_product("product...." +i)
                    .s_image("image...." + (i % 10))
                    .s_content("Content...." +i)
                    .s_price("price...." +i)
                    .s_count(+i)

                    .build();
            System.out.println(shopRepository.save(shop));
        });
    }

    @Test
    public void updateTest() {
        Optional<Shop> result = shopRepository.findById(1L);

        if(result.isPresent()){
            Shop shop = result.get();

            shop.changes_product("Changed product...");
            shop.changes_image("Changed image...");
            shop.changes_content("Changed Content...");
            shop.changes_price("Changed Price...");
           // shop.changes_count(Integer.parseInt("Changed Count..."));

            shopRepository.save(shop);
        }
    }

}