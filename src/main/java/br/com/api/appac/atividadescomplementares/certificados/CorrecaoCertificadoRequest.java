package br.com.api.appac.atividadescomplementares.certificados;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CorrecaoCertificadoRequest {
    private Long certificadoId;
    private boolean aprovado;
    private String correcao;
}