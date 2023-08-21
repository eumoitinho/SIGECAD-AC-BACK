package br.com.api.appac.atividadescomplementares.serviços;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.appac.atividadescomplementares.aluno.Aluno;
import br.com.api.appac.atividadescomplementares.certificados.Certificados;
import br.com.api.appac.atividadescomplementares.coordenador.Coordenador;
import br.com.api.appac.atividadescomplementares.repositorio.AlunoRepositorio;
import br.com.api.appac.atividadescomplementares.repositorio.CertificadoRepositorio;
import br.com.api.appac.atividadescomplementares.repositorio.CoordenadorRepositorio;

@Service
public class CoordenadorServico {

    @Autowired
    CoordenadorRepositorio cor;

    @Autowired
    CertificadoRepositorio cp;

    @Autowired
    AlunoRepositorio ar;

    /**
     * Lista as informações de um coordenador pelo CPF.
     * 
     * @param coordCpf CPF do coordenador.
     * @return Coordenador encontrado.
     */
    public Coordenador listarcoord(String coordCpf) {
        return cor.findByCpf(coordCpf);
    }

    /**
     * Lista os alunos associados a um curso.
     * 
     * @param cursoCodigo Código do curso.
     * @return Lista de alunos associados ao curso.
     */
    public List<Aluno> listarAlunosDoCurso(Long cursoCodigo) {
        return ar.findByCursoCodigo(cursoCodigo);
    }

    /**
     * Lista os certificados associados a um aluno.
     * 
     * @param alunoCpf CPF do aluno.
     * @return Lista de certificados associados ao aluno.
     */
    public List<Certificados> listarCertificadosDoAluno(String alunoCpf) {
        Aluno aluno = ar.findByCpf(alunoCpf);
        if (aluno != null) {
            Certificados certificados = cp.findByAluno(aluno);
            List<Certificados> listaCertificados = new ArrayList<>();
            listaCertificados.add(certificados);
            return listaCertificados;
        } else {
            return new ArrayList<>(); // Retorna uma lista vazia se o aluno não for encontrado
        }
    }
}
