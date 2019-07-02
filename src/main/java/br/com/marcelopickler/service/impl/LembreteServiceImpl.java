package br.com.marcelopickler.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.marcelopickler.model.Lembrete;
import br.com.marcelopickler.repository.LembreteRepository;
import br.com.marcelopickler.service.LembreteService;

@Service
public class LembreteServiceImpl implements LembreteService{

	@Autowired
	private LembreteRepository lembreteRepository;
	
	@Override
	public List<Lembrete> getAll() {
		return lembreteRepository.findAll();
	}

	@Override
	public void save(Lembrete lembrete) {
		lembreteRepository.save(lembrete);
	}

	@Override
	public void delete(Lembrete lembrete) {
		lembreteRepository.delete(lembrete);
	}

	@Override
	public Lembrete findById(long id) {
		Optional<Lembrete> retorno = lembreteRepository.findById(id);
		if(retorno.isPresent())
			return retorno.get();
		return null;
	}
	
}