package br.com.api.appac.atividadescomplementares.semestre;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "semestre")
@Getter
@Setter
public class Semestre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int ano;
    private int numeroSemestre;
    
    // Esta classe "Semestre" é uma entidade JPA que representa um semestre acadêmico.
    // A anotação "@Entity" indica que essa classe é uma entidade mapeada no banco de dados.
    // A anotação "@Table(name = "semestre")" especifica o nome da tabela no banco de dados.
    // Os atributos "ano" e "numeroSemestre" representam o ano e o número do semestre, respectivamente.
    // A anotação "@Id" marca o atributo "id" como a chave primária da entidade.
    // A anotação "@GeneratedValue(strategy = GenerationType.IDENTITY)" indica que a geração do ID será automática.
    // As anotações "@Getter" e "@Setter" do Lombok geram automaticamente os getters e setters para os atributos.
    // Outros atributos e relacionamentos podem ser adicionados, se necessário.
}
