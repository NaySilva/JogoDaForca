package br.edu.ifpi.forca.modelo;

import java.util.ArrayList;
import java.util.List;

public class BancoDeDados {
	private List<Tema> temas;
	private Tema tema;

	public BancoDeDados() {
		temas = new ArrayList<Tema>();
		tema = new Tema("Profissao");
		addTemas();
		addPalavras("Professor");
		addPalavras("Medico");
		addPalavras("Advogado");
		addPalavras("Analista");
		addPalavras("Mecanico");
		tema = new Tema("Animais");
		addTemas();
		addPalavras("Leao");
		addPalavras("Macaco");
		addPalavras("Elefante");
		addPalavras("Capivara");
		addPalavras("Urso");
	}

	public void addPalavras(String palavra) {
		tema.getPalavras().add(palavra);
	}

	public void addTemas() {
		temas.add(tema);
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	
}
