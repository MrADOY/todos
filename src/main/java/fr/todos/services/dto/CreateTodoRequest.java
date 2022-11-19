package fr.todos.services.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTodoRequest {
    private Long idAuteur;
    private String prenomAuteur;
    private String libelleTodo;

}
