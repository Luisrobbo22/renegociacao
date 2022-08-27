package br.com.robbo.renegociacao.mapper;


import br.com.robbo.renegociacao.DTO.DebitoDTO;
import br.com.robbo.renegociacao.entity.Debito;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MapStructMapper {

    MapStructMapper INSTANCE = Mappers.getMapper(MapStructMapper.class);

    @Mapping(source = "descricaoDebito", target = "descricaoDebito")
    DebitoDTO dtoToDebito(Debito debito);

    @Mapping(source = "descricaoDebito", target = "descricaoDebito")
    List<DebitoDTO> dtosToDebitos(List<Debito> debitos);




}
