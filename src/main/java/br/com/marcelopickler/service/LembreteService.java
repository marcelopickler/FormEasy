package br.com.marcelopickler.service;

import java.util.List;

import br.com.marcelopickler.model.Lembrete;

public interface LembreteService {

	List<Lembrete> getAll();

	void save(Lembrete lembrete);
	
	void delete(Lembrete Lembrete);
	
	Lembrete findById(long id);
}
