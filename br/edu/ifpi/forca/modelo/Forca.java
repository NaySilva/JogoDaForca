package br.edu.ifpi.forca.modelo;

import java.util.ArrayList;
import java.util.List;

public class Forca {
	
	public final static String GANHOU = "Ganhou";
	public final static String PERDEU = "Perdeu";
	public final static String JOGANDO = "Jogando";
	
	private static Forca unico;
	private Rodada rodada;
	private List<Jogador> jogadores;
	private BancoDeDados bd;
	private String status;
	
	private Forca() {
		jogadores =  new ArrayList<Jogador>();
		bd = new BancoDeDados();
	}
	public String Vizualizacao(){
		String str = "";
		str += "===\n      |\n";
		int num = rodada.getLetrasErradas().size();
		switch (num) {
		case 1: str += ("     O"); break;
		case 2: str += ("     O\n      |"); break;
		case 3: str += ("     O\n     /|"); break;
		case 4: str += ("     O\n     /|\\"); break;
		case 5: str += ("     O\n     /|\\\n     /"); break;
		case 6: str += ("     O\n     /|\\\n     / \\"); break;
		default:
			break;
		}
		str += rodada.vizualizacao();
		return str;
	}

	public static Forca getInstance(){
		if (unico == null)
			unico = new Forca();
		return unico;
	}
	
	public void novaRodada(){
		rodada = new Rodada();
		this.status = Forca.JOGANDO;
	}

	public void addJogador(String nome){
		jogadores.add(new Jogador(nome));
	}

	public boolean situacao(int index) {
		if (this.rodada.getVazios() == 0){
			this.status = Forca.GANHOU;
			jogadores.get(index).addPontos(100);
			return false;
		}else if (this.rodada.getLetrasErradas().size() == 6){
			this.status = Forca.PERDEU;
			return false;
		}return true;
	}
	public boolean jaSei(String chute, int index){
		if (chute.equals(rodada.getPalavraCerta())){
			jogadores.get(index).addPontos(100);
			jogadores.get(index).addPontos(rodada.getVazios()*15);
			this.status = Forca.GANHOU;
			return true;
		}else{
			this.status = Forca.PERDEU;
			return false;
		}
			
	}
	
	public Rodada getRodada() {
		return rodada;
	}

	public void setRodada(Rodada rodada) {
		this.rodada = rodada;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}



	public BancoDeDados getBd() {
		return bd;
	}

	public void setBd(BancoDeDados bd) {
		this.bd = bd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
		
	}

	
}