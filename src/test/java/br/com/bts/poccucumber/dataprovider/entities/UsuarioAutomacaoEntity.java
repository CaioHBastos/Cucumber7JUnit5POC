package br.com.bts.poccucumber.dataprovider.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "usuario")
public class UsuarioAutomacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String sobrenome;

    public UsuarioAutomacaoEntity() {}

    public UsuarioAutomacaoEntity(Long id, String nome, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioAutomacaoEntity that = (UsuarioAutomacaoEntity) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
