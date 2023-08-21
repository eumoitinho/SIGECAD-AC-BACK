package br.com.api.appac.atividadescomplementares.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.appac.atividadescomplementares.aluno.Aluno;
import br.com.api.appac.atividadescomplementares.certificados.Certificados;

@Repository
public interface CertificadoRepositorio extends CrudRepository<Certificados, Long> {
    Certificados findByAluno(Aluno aluno);
    List<Certificados> findByAlunoCpf(String cpf);
    
    // Esta interface "CertificadoRepositorio" estende a interface "CrudRepository" do Spring Data JPA.
    // Isso fornece métodos básicos de CRUD (Create, Read, Update, Delete) para a entidade "Certificados".
    // A anotação "@Repository" indica que esta interface é um repositório Spring gerenciado.
    // A interface define dois métodos adicionais: "findByAluno" para buscar um certificado por aluno
    // e "findByAlunoCpf" para buscar uma lista de certificados por CPF do aluno.
}
