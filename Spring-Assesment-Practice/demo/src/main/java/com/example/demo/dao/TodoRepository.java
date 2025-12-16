package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    // TODO: Add custom query methods if needed (e.g., findByCompleted)

    List<Todo> findByTitleStartingWithIgnoreCase(String prefix);
}