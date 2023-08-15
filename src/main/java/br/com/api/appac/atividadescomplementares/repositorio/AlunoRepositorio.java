package br.com.api.appac.atividadescomplementares.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.appac.atividadescomplementares.aluno.Aluno;

@Repository

public interface AlunoRepositorio extends CrudRepository<Aluno, String> {
    Aluno findByCpf(String cpf);
    List<Aluno> findByCursoCodigo(Long cursoCodigo); // Implemente esse método para buscar alunos por curso
}
