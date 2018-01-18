package jwd.knjizara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd.knjizara.model.TakmicenjaGodina;

@Repository
public interface TakmicenjaGodinaRepository extends JpaRepository<TakmicenjaGodina, Long> {

}