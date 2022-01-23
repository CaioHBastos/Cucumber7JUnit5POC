package br.com.bts.poccucumber.steps;

import br.com.bts.poccucumber.dataprovider.entities.UsuarioAutomacaoEntity;
import br.com.bts.poccucumber.dataprovider.repositories.UsuarioAutomacaoRepository;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ValidatableResponse;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioSteps {

    private String url;
    private ValidatableResponse responseApi;
    private JsonPath jsonPath;
    private UsuarioAutomacaoEntity usuarioEntity;

    @Autowired
    UsuarioAutomacaoRepository usuarioAutomacaoRepository;

    @Before
    public void tearDown() {
        usuarioAutomacaoRepository.deleteAll();
    }
    
    @Dado("que quero consultar os dados dos usuarios")
    public void queQueroConsultarOsDadosDosUsuarios() {
        this.url = "http://localhost:8080/v1/usuarios";
    }

    @Quando("informo que quero visualizar os usuarios na base sem cadastro")
    public void informoQueQueroVisualizarOsUsuariosNaBaseSemCadastro() {
        this.responseApi = RestAssured.given().get(this.url).then().log().body();
    }

    @Entao("devera ser exibido o corpo da resposta vazio")
    public void deveraSerExibidoOCorpoDaRespostaVazio() {
        this.responseApi.assertThat().statusCode(204);
        assertTrue(this.responseApi.extract().body().asString().isEmpty());
    }

    @Quando("informo que quero visualizar os usuarios na base com cadastro")
    public void informoQueQueroVisualizarOsUsuariosNaBaseComCadastro() {
        UsuarioAutomacaoEntity usuarioAutomacaoEntity = new UsuarioAutomacaoEntity();
        usuarioAutomacaoEntity.setNome("Caio");
        usuarioAutomacaoEntity.setSobrenome("Bastos");

        this.usuarioEntity = usuarioAutomacaoRepository.save(usuarioAutomacaoEntity);

        this.responseApi = RestAssured.given().get(this.url).then().log().body();
    }

    @Entao("devera ser exibido os dados de todos os usuarios")
    public void deveraSerExibidoOsDadosDeTodosOsUsuarios() {
        this.responseApi.assertThat().statusCode(200);
        this.jsonPath = new JsonPath(this.responseApi.extract().body().asString());

        assertAll(
                () -> assertEquals(this.usuarioEntity.getId(), this.jsonPath.getLong("[0].id")),
                () -> assertEquals("Caio", this.jsonPath.getString("[0].nome")),
                () -> assertEquals("Bastos", this.jsonPath.getString("[0].sobrenome"))
        );
    }
}
