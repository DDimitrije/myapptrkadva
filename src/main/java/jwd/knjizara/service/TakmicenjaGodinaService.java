package jwd.knjizara.service;

import java.util.List;

import jwd.knjizara.model.TakmicenjaGodina;

public interface TakmicenjaGodinaService {
	
		List<TakmicenjaGodina> findAll();
		TakmicenjaGodina findOne(Long id);
		void save(TakmicenjaGodina takmicenjaGodina);
		void remove(Long id);

	
		

}
