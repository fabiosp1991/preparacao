package br.com.fabiosp1991.preparacao.services.impl;

import br.com.fabiosp1991.preparacao.dtos.ImovelDto;
import br.com.fabiosp1991.preparacao.entities.ImovelEntity;
import br.com.fabiosp1991.preparacao.mappers.ImovelMapper;
import br.com.fabiosp1991.preparacao.repositories.ImovelRepository;
import br.com.fabiosp1991.preparacao.services.ImovelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ImovelServiceImpl implements ImovelService {

    @Autowired
    ImovelRepository imovelRepository;
    @Autowired
    private ImovelMapper imovelMapper;

    @Override
    public ImovelDto getImovelApelido(String apelido) {
        Optional<ImovelEntity> imovelEntity = imovelRepository.findByApelido(apelido);
        return imovelMapper.toDto(imovelEntity.get());

    }

    @Override
    public ImovelDto saveImovel(ImovelDto imovelDto) {
        ImovelEntity imovelEntity = imovelMapper.toEntity(imovelDto);
        return imovelMapper.toDto(imovelRepository.save(imovelEntity));
    }
}
