package com.nimap.task.coding.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.task.coding.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long>  {

}
