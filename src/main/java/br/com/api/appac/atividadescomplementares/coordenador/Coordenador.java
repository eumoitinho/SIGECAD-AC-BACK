package br.com.api.appac.atividadescomplementares.coordenador;

import br.com.api.appac.atividadescomplementares.cursos.Curso;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coordenador")
@Getter
@Setter
public class Coordenador {
    @Id
    private String cpf;
    private String nome;
    private String email;
    private String password;
    
    @OneToOne
    @JoinColumn(name = "Curso_codigo") // Coluna que representa o ID do curso na tabela de coordenador
    private Curso curso;
    // Esta classe representa a entidade "Coordenador" no banco de dados.
    // Ela contém os campos correspondentes às informações de um coordenador, como CPF, nome, email e senha.
    // Além disso, possui uma associação com a entidade "Curso" através da anotação @OneToOne e @JoinColumn,
    // o que permite relacionar um coordenador a um curso específico.
}
