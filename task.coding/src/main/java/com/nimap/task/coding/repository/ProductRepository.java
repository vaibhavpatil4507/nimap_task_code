package com.nimap.task.coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.task.coding.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long>{

}
