package br.com.marcelopickler.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.marcelopickler.model.Lembrete;
import br.com.marcelopickler.service.LembreteService;

@Controller
@RequestMapping("/lembrete")
public class LembreteController {

	/*@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "eu não acredito";
	}


	@ResponseBody
	@RequestMapping(value ="/api/hello",method = RequestMethod.GET,produces="application/json")
	public String hello() {
		return "{  \r\n" +
				"   \"hello\":\"world\"\r\n" +
				"}";

	}
	@ResponseBody
	@RequestMapping(value ="/api/hello/{name}",method = RequestMethod.GET,produces="application/json")
	public String hello(@PathVariable("name") String name) {
		return String.format("{  \r\n" +
				"   \"hello\":\"%s\"\r\n" +
				"}",name);
	}
	@ResponseBody
	@RequestMapping(value ="/api/hello/{name}",method = RequestMethod.DELETE,produces="application/json")
	public String deletar(@PathVariable("name") String name) {
		return "{  \r\n" +
				"   \"resultado\":\"ok\"\r\n" +
				"}";

	}*/
	@Autowired
	private LembreteService service;
	
	@GetMapping()
	public ModelAndView index() {
		return new ModelAndView("lembrete/index","lembretes",service.getAll());
	}

	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Lembrete lembrete) {
		return new ModelAndView("lembrete/form");
	}

	@PostMapping(params="form")
	public ModelAndView save(@Valid Lembrete lembrete)
	{
		service.save(lembrete);
		return new ModelAndView("redirect:/lembrete");
	}
	@GetMapping(value="/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Lembrete lembrete) {
		return new ModelAndView("lembrete/form","lembrete",lembrete);
	}

	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Lembrete lembrete) {
		service.delete(lembrete);
		return new ModelAndView("redirect:/lembrete");
	}
}