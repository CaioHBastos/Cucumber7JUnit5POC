package br.com.bts.poccucumber.entrypoint.controller;

import br.com.bts.poccucumber.entrypoint.mapper.response.UsuarioEntrypointMapperResponse;
import br.com.bts.poccucumber.entrypoint.model.response.UsuarioResumoModelResponse;
import br.com.bts.poccucumber.usecase.domain.UsuarioDomain;
import br.com.bts.poccucumber.usecase.service.UsuarioUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/v1/usuarios")
@RestController
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResumoModelResponse>> getAll() {
        List<UsuarioDomain> usuariosDomain = usuarioUseCase.buscarTodosUsuarios();

        if (usuariosDomain.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        List<UsuarioResumoModelResponse> usuariosModelResponse = UsuarioEntrypointMapperResponse.toModel(usuariosDomain);

        return ResponseEntity.ok(usuariosModelResponse);
    }
}
