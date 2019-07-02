package br.com.marcelopickler.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.marcelopickler.model.Lembrete;
import br.com.marcelopickler.service.LembreteService;

@RestController
@RequestMapping("/api/clientes")
public class LembreteControllerAPI {
	@Autowired
	private LembreteService service;
	
	@GetMapping
	public ResponseEntity<List<Lembrete>> listarLembretes(){
		List<Lembrete> lista = new ArrayList<Lembrete>();
		try {
			lista = service.getAll();
		}catch (Exception e) {
			System.err.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
		return new ResponseEntity<List<Lembrete>>(lista,HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Lembrete lembrete){
		service.save(lembrete);
		return ResponseEntity.ok().build();
	}
	@PutMapping(path="/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, 
									@RequestBody Lembrete lembrete){
		Lembrete lembreteAtual = service.findById(id);
		if(lembreteAtual != null) {
			lembreteAtual.setMateria(lembrete.getMateria());
			lembreteAtual.setConteudo(lembrete.getConteudo());
			lembreteAtual.setData_prova(lembrete.getData_prova());
			service.save(lembreteAtual);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@DeleteMapping(path="/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id){
		Lembrete lembreteAtual = service.findById(id);
		if(lembreteAtual != null) {
			service.delete(lembreteAtual);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
	
	
	
	
	
	
}
