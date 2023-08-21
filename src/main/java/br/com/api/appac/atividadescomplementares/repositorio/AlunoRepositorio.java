package br.com.api.appac.atividadescomplementares.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.appac.atividadescomplementares.aluno.Aluno;

@Repository
public interface AlunoRepositorio extends CrudRepository<Aluno, String> {
    Aluno findByCpf(String cpf);
    List<Aluno> findByCursoCodigo(Long cursoCodigo);
    
    // Esta interface "AlunoRepositorio" estende a interface "CrudRepository" do Spring Data JPA.
    // Isso fornece métodos básicos de CRUD (Create, Read, Update, Delete) para a entidade "Aluno".
    // A anotação "@Repository" indica que esta interface é um repositório Spring gerenciado.
    // A interface define dois métodos adicionais: "findByCpf" para buscar um aluno por CPF
    // e "findByCursoCodigo" para buscar uma lista de alunos por código de curso.
}
