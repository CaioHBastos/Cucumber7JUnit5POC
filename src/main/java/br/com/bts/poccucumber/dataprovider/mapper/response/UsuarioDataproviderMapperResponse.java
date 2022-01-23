package br.com.bts.poccucumber.dataprovider.mapper.response;

import br.com.bts.poccucumber.dataprovider.entities.UsuarioEntity;
import br.com.bts.poccucumber.usecase.domain.UsuarioDomain;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioDataproviderMapperResponse {

    private UsuarioDataproviderMapperResponse() {}

    public static List<UsuarioDomain> toDomain(List<UsuarioEntity> usuariosEntity) {

        return usuariosEntity.stream()
                .map(UsuarioDataproviderMapperResponse::toDomain)
                .collect(Collectors.toList());
    }

    public static UsuarioDomain toDomain(UsuarioEntity usuarioEntity) {
        UsuarioDomain usuarioDomain = new UsuarioDomain();
        usuarioDomain.setId(usuarioEntity.getId());
        usuarioDomain.setNome(usuarioEntity.getNome());
        usuarioDomain.setSobrenome(usuarioEntity.getSobrenome());

        return usuarioDomain;
    }
}
