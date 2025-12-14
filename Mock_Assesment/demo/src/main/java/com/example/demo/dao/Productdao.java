package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Products;

@Repository
public interface Productdao extends JpaRepository<Products,Long> {

}
