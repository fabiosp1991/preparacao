package br.com.fabiosp1991.preparacao.Repositories;

import br.com.fabiosp1991.preparacao.Entities.ImovelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImovelRepository extends JpaRepository<ImovelEntity, Integer> {
}