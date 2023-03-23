package com.tech.shop.TechShop.repository;

import com.tech.shop.TechShop.entity.StoreData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreDataRepository extends JpaRepository<StoreData, String> {
}
