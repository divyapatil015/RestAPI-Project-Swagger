package com.express.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.express.entities.Category;
import com.express.entities.User;

public interface CategoryRepository extends JpaRepository< Category, Long> {

}
