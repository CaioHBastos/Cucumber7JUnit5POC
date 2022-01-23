package br.com.bts.poccucumber.dataprovider.repositories;

import br.com.bts.poccucumber.dataprovider.entities.UsuarioAutomacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioAutomacaoRepository extends JpaRepository<UsuarioAutomacaoEntity, Long> {
}
