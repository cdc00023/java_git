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

                    .product("product...." +i)
                    .image("image...." + (i % 10))
                    .content("Content...." +i)
                    .price("price...." +i)
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

            shop.changeproduct("Tomato");
            shop.changeimage("img/featured/tomato.jpg");
            shop.changecontent("맛있는 토마토 입니다");
            shop.changeprice("20000");
            shop.changecount(Integer.parseInt("50"));

            shopRepository.save(shop);
        }
    }

}