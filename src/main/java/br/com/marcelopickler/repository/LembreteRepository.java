package br.com.marcelopickler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcelopickler.model.Lembrete;

public interface LembreteRepository extends JpaRepository<Lembrete,Long>{
	Lembrete findByMateria(String materia);
}
