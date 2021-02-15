package com.swcordingschool.Ex5.repository;

import com.swcordingschool.Ex5.entity.Shop;
import com.swcordingschool.Ex5.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ShopRepository extends JpaRepository<Shop, Long>, QuerydslPredicateExecutor<Shop> {
}