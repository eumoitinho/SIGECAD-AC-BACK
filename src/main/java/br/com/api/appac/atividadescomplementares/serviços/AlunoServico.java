package br.com.api.appac.atividadescomplementares.serviços;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.appac.atividadescomplementares.aluno.Aluno;
import br.com.api.appac.atividadescomplementares.repositorio.AlunoRepositorio;

@Service
public class AlunoServico {

    @Autowired
    private AlunoRepositorio ar;


    public Aluno buscarAlunoPorId(String cpf) {
        return ar.findById(cpf).orElse(null);
    }
}
