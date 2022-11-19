package fr.todos.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Todo {
    @Id
    @GeneratedValue
    private Long id;
    private String libelle;

    @ManyToOne
    private Auteur auteur;
}
