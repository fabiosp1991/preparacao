package br.com.fabiosp1991.preparacao.repositories;

import br.com.fabiosp1991.preparacao.entities.ProdutoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<ProdutoEntity, Integer> {
}