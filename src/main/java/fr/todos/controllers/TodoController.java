package fr.todos.controllers;

import fr.todos.controllers.communs.HttpErreurFonctionnelle;
import fr.todos.services.TodoService;
import fr.todos.services.dto.CreateTodoRequest;
import fr.todos.services.dto.CreateTodoResponse;
import fr.todos.services.dto.GetTodosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    private ResponseEntity getTodos(@RequestParam("idAuteur") Long idAuteur) {
        if(idAuteur == null || idAuteur == 0) {
            return ResponseEntity
                    .badRequest()
                    .body(HttpErreurFonctionnelle.builder().message("idAuteur est obligatoire").build());
        }
        return ResponseEntity.ok().body(this.todoService.getAllTodos(idAuteur));
    }

    @PostMapping
    private ResponseEntity<CreateTodoResponse> createTodo(@RequestBody CreateTodoRequest request) {
        return ResponseEntity.created(null).body(this.todoService.createTodo(request));
    }

}
