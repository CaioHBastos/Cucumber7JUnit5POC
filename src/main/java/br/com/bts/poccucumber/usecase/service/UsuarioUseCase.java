package br.com.bts.poccucumber.usecase.service;

import br.com.bts.poccucumber.usecase.domain.UsuarioDomain;
import br.com.bts.poccucumber.usecase.gateway.UsuarioGateway;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUseCase {

    private final UsuarioGateway usuarioGateway;

    public UsuarioUseCase(UsuarioGateway usuarioGateway) {
        this.usuarioGateway = usuarioGateway;
    }

    public List<UsuarioDomain> buscarTodosUsuarios() {
        return usuarioGateway.buscarTodosUsuarios();
    }
}
