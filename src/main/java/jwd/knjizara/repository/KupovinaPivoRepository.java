package jwd.knjizara.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import jwd.knjizara.model.KupovinaPivo;

@Repository
public interface KupovinaPivoRepository extends JpaRepository<KupovinaPivo, Long>{

}
