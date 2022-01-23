package br.com.bts.poccucumber.entrypoint.mapper.response;

import br.com.bts.poccucumber.entrypoint.model.response.UsuarioResumoModelResponse;
import br.com.bts.poccucumber.usecase.domain.UsuarioDomain;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioEntrypointMapperResponse {

    private UsuarioEntrypointMapperResponse() {}

    public static List<UsuarioResumoModelResponse> toModel(List<UsuarioDomain> usuariosDomain) {
        return usuariosDomain.stream()
                .map(UsuarioEntrypointMapperResponse::toModelResumo)
                .collect(Collectors.toList());
    }

    private static UsuarioResumoModelResponse toModelResumo(UsuarioDomain usuarioDomain) {
        UsuarioResumoModelResponse usuarioResumoModelResponse = new UsuarioResumoModelResponse();
        usuarioResumoModelResponse.setId(usuarioDomain.getId());
        usuarioResumoModelResponse.setNome(usuarioDomain.getNome());
        usuarioResumoModelResponse.setSobrenome(usuarioDomain.getSobrenome());

        return usuarioResumoModelResponse;
    }
}
