package br.com.bts.poccucumber.usecase.gateway;

import br.com.bts.poccucumber.usecase.domain.UsuarioDomain;

import java.util.List;

public interface UsuarioGateway {

    List<UsuarioDomain> buscarTodosUsuarios();
}
