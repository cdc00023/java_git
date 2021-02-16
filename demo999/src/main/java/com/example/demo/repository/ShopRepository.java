package com.example.demo.repository;



public interface ShopRepository extends JpaRepository<Shop, Long>, QuerydslPredicateExecutor<Shop> {
}