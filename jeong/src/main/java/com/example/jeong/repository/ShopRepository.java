package com.example.jeong.repository;


import com.example.jeong.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface ShopRepository extends JpaRepository<Shop, Long>, QuerydslPredicateExecutor<Shop> {
}