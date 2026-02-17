package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin(origins = "*")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // Create todo
    @PostMapping
    public Todo createTodo(@Valid @RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    // Get all todos (optional filter)
    @GetMapping
    public List<Todo> getTodos(
            @RequestParam(required = false) Boolean completed
    ) {
        return todoService.getAllTodos(completed);
    }

    // Update todo
    @PutMapping("/{id}")
    public Todo updateTodo(
            @PathVariable Long id,
            @RequestBody Todo todo
    ) {
        return todoService.updateTodo(id, todo);
    }

    // Delete todo
    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
