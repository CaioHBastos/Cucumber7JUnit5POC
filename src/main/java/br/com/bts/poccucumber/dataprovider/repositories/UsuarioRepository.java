package br.com.bts.poccucumber.dataprovider.repositories;

import br.com.bts.poccucumber.dataprovider.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
}
