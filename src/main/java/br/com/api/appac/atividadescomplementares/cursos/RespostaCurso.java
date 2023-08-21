package br.com.api.appac.atividadescomplementares.cursos;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter

public class RespostaCurso {
    private String mensagem;
    
    // Esta classe "RespostaCurso" é um componente que possui o campo "mensagem" para armazenar mensagens de resposta.
    // Ela é usada para retornar mensagens relacionadas às operações envolvendo cursos, como cadastrar, alterar ou remover cursos.
    // A anotação "@Component" indica que esta classe é um componente gerenciado pelo Spring.
    // Os métodos getters e setters são gerados automaticamente para o campo "mensagem".
}
