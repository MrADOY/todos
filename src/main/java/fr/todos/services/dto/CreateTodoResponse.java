package fr.todos.services.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateTodoResponse {
    private Long id;
    private String libelle;
    private Long idAuteur;
    private String prenomAuteur;
}
