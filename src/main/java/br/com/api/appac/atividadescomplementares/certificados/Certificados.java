package br.com.api.appac.atividadescomplementares.certificados;

import java.math.BigDecimal;

import br.com.api.appac.atividadescomplementares.aluno.Aluno;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Esta classe representa um certificado de atividades complementares.
 * A anotação @Entity indica que essa classe é uma entidade JPA.
 * Ela é anotada com @Table para especificar o nome da tabela no banco de dados.
 * As anotações Lombok @Getter e @Setter geram automaticamente os métodos getter e setter para os atributos.
 */
@Entity
@Table(name = "certificados")
@Getter
@Setter
public class Certificados {

    // Chave primária gerada automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Informações do certificado
    private String codigo;
    private String atividade;
    private BigDecimal pontuacao;  
    private String caminhoArquivo;

    // Flags para status de correção e aprovação
    private Boolean statusCorrecao = false;
    private Boolean statusAprovado;
    private String correcaoCoordenador;

    // Relação com a entidade Aluno
    @ManyToOne
    @JoinColumn(name = "Alunos_cpf") // Coluna que representa o ID do aluno na tabela de certificados
    private Aluno aluno;
}
