package br.com.api.appac.atividadescomplementares.serviços;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.appac.atividadescomplementares.aluno.Aluno;
import br.com.api.appac.atividadescomplementares.repositorio.AlunoRepositorio;

@Service
public class AlunoServico {

    @Autowired
    private AlunoRepositorio ar;

    // Esta classe "AlunoServico" é um serviço que lida com operações relacionadas aos alunos.
    // A anotação "@Service" indica que essa classe é um componente de serviço gerenciado pelo Spring.
    // O atributo "ar" é injetado automaticamente pelo Spring com base na anotação "@Autowired".
    // Ele se conecta ao repositório "AlunoRepositorio" para realizar operações no banco de dados.

    public Aluno buscarAlunoPorId(String cpf) {
        // O método "buscarAlunoPorId" recebe o CPF de um aluno como parâmetro.
        // Ele utiliza o repositório "AlunoRepositorio" para buscar um aluno por CPF.
        // A chamada "ar.findById(cpf)" busca um aluno pelo ID (CPF) no banco de dados.
        // O método "orElse(null)" retorna o aluno encontrado ou null se não for encontrado.
        return ar.findById(cpf).orElse(null);
    }
}
