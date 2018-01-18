package jwd.knjizara.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jwd.knjizara.model.Pivara;
import jwd.knjizara.repository.PivaraRepository;
import jwd.knjizara.service.PivaraService;

@Service
@Transactional
public class JpaPivaraServiceImpl implements PivaraService {
	@Autowired
	private PivaraRepository pivaraRepository;

	@Override
	public List<Pivara> findAll() {
		return pivaraRepository.findAll();
	}

	@Override
	public Pivara findOne(Long id) {
		return pivaraRepository.findOne(id);
	}

	@Override
	public void save(Pivara pivara) {
		pivaraRepository.save(pivara);
	}

	@Override
	public void remove(Long id) {
		pivaraRepository.delete(id);
	}

	
	
}
