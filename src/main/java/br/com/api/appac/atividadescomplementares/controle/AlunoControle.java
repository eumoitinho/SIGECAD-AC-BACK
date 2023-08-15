package br.com.api.appac.atividadescomplementares.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.appac.atividadescomplementares.aluno.Aluno;
import br.com.api.appac.atividadescomplementares.repositorio.AlunoRepositorio;

@RestController
@CrossOrigin(origins = "*")
public class AlunoControle {
    
    private final AlunoRepositorio alunoRepositorio;

    @Autowired
    public AlunoControle(AlunoRepositorio alunoRepositorio) {
        this.alunoRepositorio = alunoRepositorio;
    }

    @GetMapping("/aluno/{cpf}")
    public Aluno buscarPorCpf(@PathVariable String cpf) {
        return alunoRepositorio.findByCpf(cpf);
    }
}