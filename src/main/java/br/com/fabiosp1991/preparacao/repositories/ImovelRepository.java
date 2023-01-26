package br.com.fabiosp1991.preparacao.repositories;

import br.com.fabiosp1991.preparacao.entities.ImovelEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;
import java.util.Set;

public interface ImovelRepository extends CrudRepository<ImovelEntity, Integer> {
    Optional<ImovelEntity> findByApelido(@NonNull String apelido);

    Optional<ImovelEntity> findByApelidoIgnoreCase(@NonNull String apelido);

    Optional<ImovelEntity> findByCep(@NonNull String cep);
}