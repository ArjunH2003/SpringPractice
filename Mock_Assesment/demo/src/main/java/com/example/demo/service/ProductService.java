package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.bean.Products;
import com.example.demo.dao.Productdao;

@Service
public class ProductService {

    @Autowired
    private Productdao productdao;

    public ResponseEntity<Products> addProducts(Products product){

        if(product!=null){

            productdao.save(product);
            return ResponseEntity.ok().body(product);
        }
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Products> displayPrice(Products product){

        int sum=0;
        Products pd = null;
        Optional<Products> op = productdao.findById(product.getId());
        if(op.isPresent()){
            pd=op.get();
            return ResponseEntity.ok(pd);
            
        }

        
    }
    
}
