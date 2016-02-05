package br.edu.ifpi.forca.modelo;

public class Jogador implements Comparable<Jogador>{
	
	private String nome;
	private int pontos = 0;
	
	public Jogador(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void addPontos(int pontos) {
		this.pontos += pontos;
	}

	 public int compareTo(Jogador jogador) {
	        if (this.pontos > jogador.pontos) {
	            return -1;
	        }
	        if (this.pontos < jogador.pontos) {
	            return 1;
	        }
	        return 0;
	    }
	@Override
	public String toString() {
		return "Jogador " + nome + ", " + pontos + " pontos\n";
	}
	
	

}
