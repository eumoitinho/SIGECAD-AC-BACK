package br.com.api.appac.atividadescomplementares.certificados;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

/**
 * Esta classe representa uma resposta relacionada a operações com certificados.
 * As anotações Lombok @Getter e @Setter geram automaticamente os métodos getter e setter para os atributos.
 */
@Component
@Getter
@Setter
public class RespostaCertificados {
    
    // Mensagem relacionada à operação realizada com certificados
    private String mensagem;
}
