package br.edu.ifpi.forca.modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Rodada {
	
	private Tema tema;
	private List<String> letrasErradas;
	private Set<String> letrasCertas;
	private int vazios;
	private String palavraCerta;
	private String[] palavras;
	
	
	public Rodada() {
		sorteio();
		this.palavras = this.palavraCerta.split("");
		this.letrasErradas = new ArrayList<>(); 
		this.letrasCertas = new HashSet<>();
		this.vazios = this.palavras.length;
		
	}
	public void verificarLetra(String l){
		for (String s : palavras) {
			if(s.equals(l)){
				this.letrasCertas.add(l);
				return;
			}
		}
		this.letrasErradas.add(l);
	}
	
	public void sorteio(){
		BancoDeDados bd = new BancoDeDados();
		Random r = new Random();
		int num = r.nextInt(bd.getTemas().size());
		this.tema = bd.getTemas().get(num);
		bd.setTema(this.tema);
		num = r.nextInt(tema.getPalavras().size());
		palavraCerta = tema.getPalavras().get(num).toLowerCase();
		
	}

	public String vizualizacao(){
		this.vazios = this.palavras.length;
		String str = "\n\nDICA: "+ tema.getDescricao()+ "\n\n";
		for (String l : palavras) {
			boolean vazio = true;
			for (String c : letrasCertas) {
				if (l.equals(c)){
					str += (l + " ");
					vazio = false;
					vazios--;
					break;
				}
			}if (vazio){
				str += ("_ ");
			}
		}
		str += ("\n\n\nLETRAS ERRADAS: \n");
		for (String e : letrasErradas) {
			str += (e + " ");
		}
		str += ("\n-------------------\n");
		
		return str;
	}
	

	

public List<String> getLetrasErradas() {
	return letrasErradas;
}

public Set<String> getLetrasCertas() {
	return this.letrasCertas;
}

public String[] getPalavras() {
	return this.palavras;
}

public int getVazios() {
	// TODO Auto-generated method stub
	return this.vazios;
}

public String getPalavraCerta() {
	return palavraCerta;
}






	
}
	
	
	
	
	
	

