package br.com.levi.coimbra.pw3detran.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.levi.coimbra.pw3detran.entity.Pessoa;
import br.com.levi.coimbra.pw3detran.repository.PessoaRepository;

@RestController
@RequestMapping("/pessoa")

public class pessoa_controller {

	@Autowired
	private PessoaRepository repository;
	
	private List<Pessoa> dados = new ArrayList<Pessoa>();
	
	@GetMapping
	public List<Pessoa> ListarTodos(){
		dados = repository.findAll();
		return dados;
	}

	@GetMapping("/(id)")
	public Pessoa BuscarPorId(@PathVariable Integer id) {
		Pessoa tipo = new Pessoa();
		tipo= repository.findById(id).get();
		return tipo;
	}
}