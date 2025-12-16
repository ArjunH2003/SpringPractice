package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.bean.Todo;
import com.example.demo.service.TodoService;

import java.util.List;



@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @PostMapping("/add")
    public ResponseEntity<Todo> create(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Todo> getById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    @GetMapping("/getall")
    public List<Todo> getAll() {
        return todoService.getAllTodos();
    }

    @GetMapping("/getbyprefix/{prefix}")
    public ResponseEntity<List<Todo>> getByPrefix(@PathVariable String prefix) {
        List<Todo> todos = todoService.findByPrefix(prefix);
        return ResponseEntity.ok().body(todos);
    }

    

    @PutMapping("update/{id}")
    public ResponseEntity<Todo> update(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }


}