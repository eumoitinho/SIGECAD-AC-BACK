package br.com.api.appac.atividadescomplementares.coordenador;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class RespostaCoordenador {
    private String mensagem;
    // Esta classe representa uma resposta padrão para operações relacionadas a coordenadores.
    // Ela possui um campo "mensagem" que pode ser utilizado para enviar mensagens de resposta
    // após a realização de operações envolvendo coordenadores, como cadastro, atualização, etc.
}
