package br.com.bts.poccucumber.dataprovider.implementation;

import br.com.bts.poccucumber.dataprovider.entities.UsuarioEntity;
import br.com.bts.poccucumber.dataprovider.mapper.response.UsuarioDataproviderMapperResponse;
import br.com.bts.poccucumber.dataprovider.repositories.UsuarioRepository;
import br.com.bts.poccucumber.usecase.domain.UsuarioDomain;
import br.com.bts.poccucumber.usecase.gateway.UsuarioGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UsuarioImpl implements UsuarioGateway {

    private final UsuarioRepository usuarioRepository;

    public UsuarioImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDomain> buscarTodosUsuarios() {
        List<UsuarioEntity> usuariosEntity = usuarioRepository.findAll();
        return UsuarioDataproviderMapperResponse.toDomain(usuariosEntity);
    }
}
