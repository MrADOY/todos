package fr.todos.services.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GetTodosResponse {
    private Long id;
    private String libelle;
}
