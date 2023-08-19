package br.com.api.appac.atividadescomplementares.serviços;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.appac.atividadescomplementares.certificados.Certificados;
import br.com.api.appac.atividadescomplementares.certificados.CorrecaoCertificadoRequest;
import br.com.api.appac.atividadescomplementares.repositorio.CertificadoRepositorio;
import br.com.api.appac.atividadescomplementares.repositorio.AlunoRepositorio;
import br.com.api.appac.atividadescomplementares.aluno.Aluno;

@Service
public class CorrecaoCertificadosService {

    @Autowired
    private CertificadoRepositorio certificadoRepositorio;

    @Autowired
    private AlunoRepositorio alunoRepositorio;


    public void corrigirCertificado(CorrecaoCertificadoRequest request) {
        Certificados certificado = certificadoRepositorio.findById(request.getCertificadoId()).orElse(null);
        if (certificado != null) {
            certificado.setStatusCorrecao(true);
            certificado.setCorrecaoCoordenador(request.getCorrecao());
            certificado.setStatusAprovado(request.isAprovado());

            Aluno aluno = certificado.getAluno();
            if (aluno.getPontuacaoAcumulada() == null) {
                aluno.setPontuacaoAcumulada(BigDecimal.ZERO);
            }
            BigDecimal novaPontuacao = aluno.getPontuacaoAcumulada().add(certificado.getPontuacao());
            if (certificado.getStatusAprovado() == true){
            aluno.setPontuacaoAcumulada(novaPontuacao);
            }
            if (aluno.getMateriaMatricula() != null && aluno.getMateriaMatricula().getId() == 1) {
                // Defina a pontuação mínima para aprovação na matéria de atividades complementares
                BigDecimal pontuacaoMinimaAprovacao = new BigDecimal("8");
                
                if (novaPontuacao.compareTo(pontuacaoMinimaAprovacao) >= 0) {
                    // Marque o aluno como aprovado na matéria de atividades complementares
                    aluno.setAprovadoAtividadesComplementares(true);
                }
            }
            alunoRepositorio.save(aluno); // Atualiza o aluno com a aprovação na matéria de atividades complementares
            certificadoRepositorio.save(certificado);
        }
    }
}
