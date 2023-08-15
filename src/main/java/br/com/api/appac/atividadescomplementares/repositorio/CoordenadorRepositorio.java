package br.com.api.appac.atividadescomplementares.repositorio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.api.appac.atividadescomplementares.coordenador.Coordenador;

@Repository
public interface CoordenadorRepositorio extends CrudRepository<Coordenador, String> {
    Coordenador findByCpf(String cpf);
}
