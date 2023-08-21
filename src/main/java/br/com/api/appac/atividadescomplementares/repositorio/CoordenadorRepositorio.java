package br.com.api.appac.atividadescomplementares.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.api.appac.atividadescomplementares.coordenador.Coordenador;

@Repository
public interface CoordenadorRepositorio extends CrudRepository<Coordenador, String> {
    Coordenador findByCpf(String cpf);
    
    // Esta interface "CoordenadorRepositorio" estende a interface "CrudRepository" do Spring Data JPA.
    // Isso fornece métodos básicos de CRUD (Create, Read, Update, Delete) para a entidade "Coordenador".
    // A anotação "@Repository" indica que esta interface é um repositório Spring gerenciado.
    // A interface define o método "findByCpf" para buscar um coordenador por CPF.
}
