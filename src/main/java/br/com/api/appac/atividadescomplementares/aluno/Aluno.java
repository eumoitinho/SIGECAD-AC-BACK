package br.com.api.appac.atividadescomplementares.aluno;

import br.com.api.appac.atividadescomplementares.cursos.Curso;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "alunos")
@Getter
@Setter

public class Aluno {
    
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String password;
    private Integer horascomplementares;
    
    @ManyToOne
    @JoinColumn(name = "Curso_codigo") // Coluna que representa o ID do curso na tabela de alunos
    private Curso curso;
}

