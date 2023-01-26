package br.com.fabiosp1991.preparacao.services;

import br.com.fabiosp1991.preparacao.dtos.ImovelDto;

public interface ImovelService {
    ImovelDto getImovelApelido(String apelido);

    ImovelDto saveImovel(ImovelDto imovelDto);
}
