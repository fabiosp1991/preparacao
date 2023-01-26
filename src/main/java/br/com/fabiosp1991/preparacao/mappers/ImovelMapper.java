package br.com.fabiosp1991.preparacao.mappers;

import br.com.fabiosp1991.preparacao.dtos.ImovelDto;
import br.com.fabiosp1991.preparacao.entities.ImovelEntity;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ImovelMapper {
    ImovelEntity toEntity(ImovelDto imovelDto);

    ImovelDto toDto(ImovelEntity imovelEntity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ImovelEntity partialUpdate(ImovelDto imovelDto, @MappingTarget ImovelEntity imovelEntity);
}