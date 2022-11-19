package fr.todos.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Auteur {
    @Id
    @GeneratedValue
    private Long id;

    private String prenom;

    @OneToMany(mappedBy = "auteur")
    private List<Todo> todos;
}
