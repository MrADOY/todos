package fr.todos.services;

import fr.todos.entities.Auteur;
import fr.todos.entities.Todo;
import fr.todos.repositories.AuteurRepository;
import fr.todos.repositories.TodoRepository;
import fr.todos.services.dto.CreateTodoRequest;
import fr.todos.services.dto.CreateTodoResponse;
import fr.todos.services.dto.GetTodosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private AuteurRepository auteurRepository;

    public List<GetTodosResponse> getAllTodos(Long idAuteur) {
        return this.todoRepository
                .findByAuteurId(idAuteur)
                .stream()
                .map(this::buildGetTodosResponse)
                .collect(Collectors.toList());
    }

    public CreateTodoResponse createTodo(CreateTodoRequest todoToCreate) {
        //Save met à jour une entité si l'id existe deja en base de données.
        Auteur auteurSaved = this.auteurRepository.save(Auteur.builder()
                .id(todoToCreate.getIdAuteur())
                .prenom(todoToCreate.getPrenomAuteur())
                .build());

        Todo todoToSave =
                Todo.builder().auteur(auteurSaved)
                        .libelle(todoToCreate.getLibelleTodo()).build();
        return buildCreateTodoResponse(this.todoRepository.save(todoToSave));
    }

    private GetTodosResponse buildGetTodosResponse(Todo todo) {
        return GetTodosResponse.builder().id(todo.getId()).libelle(todo.getLibelle()).build();
    }

    private CreateTodoResponse buildCreateTodoResponse(Todo todo) {
        return CreateTodoResponse.builder()
                .id(todo.getId())
                .libelle(todo.getLibelle())
                .idAuteur(todo.getAuteur().getId())
                .prenomAuteur(todo.getAuteur().getPrenom())
                .build();
    }
}
