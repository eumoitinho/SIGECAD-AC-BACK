package br.com.api.appac.atividadescomplementares.serviços;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.api.appac.atividadescomplementares.aluno.Aluno;
import br.com.api.appac.atividadescomplementares.certificados.Certificados;
import br.com.api.appac.atividadescomplementares.coordenador.Coordenador;
import br.com.api.appac.atividadescomplementares.coordenador.RespostaCoordenador;
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

    public Coordenador listarcoord(String coordCpf) {
        return cor.findByCpf(coordCpf);
    }

    public List<Aluno> listarAlunosDoCurso(Long cursoCodigo) {
        return ar.findByCursoCodigo(cursoCodigo);
    }

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

