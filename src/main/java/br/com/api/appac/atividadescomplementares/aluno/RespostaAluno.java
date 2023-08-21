package br.com.api.appac.atividadescomplementares.aluno;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * Esta classe representa uma resposta a ser enviada ao aluno.
 * Ela é anotada como @Component para indicar que é um componente gerenciado pelo Spring.
 * Possui um atributo 'mensagem' que armazena a mensagem a ser exibida na resposta.
 * As anotações Lombok @Getter e @Setter geram automaticamente os métodos getter e setter para o atributo.
 */
@Component
@Getter
@Setter
public class RespostaAluno {
    
    // Mensagem a ser exibida na resposta ao aluno
    private String mensagem;
}
