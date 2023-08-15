package br.com.api.appac.atividadescomplementares.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.appac.atividadescomplementares.aluno.Aluno;
import br.com.api.appac.atividadescomplementares.certificados.Certificados;

@Repository
public interface CertificadoRepositorio extends CrudRepository<Certificados, Long> {
    Certificados findByAluno(Aluno aluno);
    List<Certificados> findByAlunoCpf(String cpf); // Implemente esse método para buscar certificados por CPF do aluno
}
