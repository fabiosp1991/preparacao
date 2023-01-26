package br.com.fabiosp1991.preparacao.repositories;

import br.com.fabiosp1991.preparacao.entities.ArmarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface ArmarioRepository extends CrudRepository<ArmarioEntity, Integer> {
}