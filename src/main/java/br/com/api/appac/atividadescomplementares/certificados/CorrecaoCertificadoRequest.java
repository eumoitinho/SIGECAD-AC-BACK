package br.com.api.appac.atividadescomplementares.certificados;

import lombok.Getter;
import lombok.Setter;

/**
 * Esta classe representa uma solicitação de correção de certificado.
 * As anotações Lombok @Getter e @Setter geram automaticamente os métodos getter e setter para os atributos.
 */
@Getter
@Setter
public class CorrecaoCertificadoRequest {
    
    // Identificador do certificado a ser corrigido
    private Long certificadoId;
    
    // Indica se o certificado foi aprovado ou rejeitado após a correção
    private boolean aprovado;
    
    // Comentários de correção
    private String correcao;
}
