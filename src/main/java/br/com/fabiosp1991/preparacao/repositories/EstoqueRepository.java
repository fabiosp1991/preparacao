package br.com.fabiosp1991.preparacao.repositories;

import br.com.fabiosp1991.preparacao.entities.EstoqueEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.List;

public interface EstoqueRepository extends CrudRepository<EstoqueEntity, Integer> {
    List<EstoqueEntity> findByIdProduto_NomeProduto(@NonNull String nomeProduto);
}