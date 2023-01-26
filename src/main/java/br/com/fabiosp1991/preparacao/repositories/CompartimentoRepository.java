package br.com.fabiosp1991.preparacao.repositories;

import br.com.fabiosp1991.preparacao.entities.CompartimentoEntity;
import org.springframework.data.repository.CrudRepository;

public interface CompartimentoRepository extends CrudRepository<CompartimentoEntity, Integer> {
}