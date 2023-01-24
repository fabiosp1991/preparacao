package br.com.fabiosp1991.preparacao.Repositories;

import br.com.fabiosp1991.preparacao.Entities.ArmarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmarioRepository extends JpaRepository<ArmarioEntity, Integer> {
}