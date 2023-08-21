package br.com.api.appac.atividadescomplementares.cursos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "curso")
@Getter
@Setter
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nome;
    private String horas;

    // Esta classe representa a entidade "Curso", que é mapeada para a tabela "curso" no banco de dados.
    // Ela possui campos como "codigo", "nome" e "horas" para armazenar informações sobre os cursos.
    // A anotação "@Entity" indica que essa classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.
    // A anotação "@Table" especifica o nome da tabela no banco de dados correspondente a esta entidade.
    // Os campos "codigo", "nome" e "horas" representam as colunas da tabela, com seus respectivos tipos de dados.
    // A anotação "@Id" indica que o campo "codigo" é a chave primária da tabela.
    // A anotação "@GeneratedValue" com a estratégia "GenerationType.IDENTITY" indica que o valor da chave primária é gerado automaticamente.
    // As anotações "@Getter" e "@Setter" geram automaticamente os métodos getters e setters para os campos.
}
