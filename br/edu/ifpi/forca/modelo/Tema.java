package br.edu.ifpi.forca.modelo;

import java.util.ArrayList;
import java.util.List;

public class Tema {
	
	private String descricao;
	private List<String> palavras;

	
	
	public Tema(String descricao) {
		this.descricao = descricao;
		palavras = new ArrayList<>();
	}

	public List<String> getPalavras() {
		return palavras;
	}

	public void setPalavras(List<String> palavras) {
		this.palavras = palavras;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
		
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public String toString() {
		return "Tema " + descricao;
	}
	
	

}
