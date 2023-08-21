package br.com.api.appac.atividadescomplementares.materia;

import br.com.api.appac.atividadescomplementares.semestre.Semestre;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "materia")
@Getter
@Setter
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "semestre_id")
    private Semestre semestre;
    
    // Esta classe "Materia" representa uma entidade no banco de dados que armazena informações sobre matérias.
    // Ela possui campos como "id" (identificador único da matéria) e "nome" (nome da matéria).
    // Além disso, ela tem um relacionamento "ManyToOne" com a entidade "Semestre".
    // Isso significa que uma matéria pertence a um semestre específico.
    // A anotação "@Entity" indica que esta classe é uma entidade JPA, mapeada para uma tabela no banco de dados.
    // A anotação "@Table" especifica o nome da tabela no banco de dados correspondente a esta entidade.
    // Os métodos getters e setters são gerados automaticamente para os campos.
}
