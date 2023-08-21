// Importações das classes e bibliotecas necessárias
package br.com.api.appac.atividadescomplementares.aluno;

import java.math.BigDecimal;

import br.com.api.appac.atividadescomplementares.cursos.Curso;
import br.com.api.appac.atividadescomplementares.materia.Materia;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

// Anotação indicando que a classe representa uma entidade no banco de dados
@Entity
// Nome da tabela no banco de dados
@Table(name = "alunos")
// Anotações Lombok para gerar automaticamente os métodos getter e setter
@Getter
@Setter
public class Aluno {
    
    // Identificador único do aluno
    @Id
    private String cpf;

    // Nome do aluno
    private String nome;

    // Endereço de e-mail do aluno
    private String email;

    // Senha do aluno
    private String password;

    // Pontuação total acumulada pelo aluno nas atividades complementares
    private BigDecimal pontuacaoAcumulada;

    // Indica se o aluno foi aprovado nas atividades complementares
    private boolean aprovadoAtividadesComplementares;
    
    // Relacionamento muitos-para-um com a entidade Curso
    @ManyToOne
    @JoinColumn(name = "Curso_codigo") // Coluna que representa o ID do curso na tabela de alunos
    private Curso curso;

    // Relacionamento muitos-para-um com a entidade Materia
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materiaMatricula;
}

// Esta classe representa a entidade Aluno no sistema. Ela é mapeada para a tabela "alunos" no banco de dados
// através das anotações @Entity e @Table. Os atributos da classe correspondem às colunas da tabela.
// A classe possui relacionamentos muitos-para-um com as entidades Curso e Materia, estabelecidos através
// das anotações @ManyToOne e @JoinColumn. Esses relacionamentos indicam que um aluno pode pertencer a um curso
// e estar matriculado em uma matéria específica.
// As anotações Lombok @Getter e @Setter geram automaticamente os métodos getter e setter para os atributos da classe.
