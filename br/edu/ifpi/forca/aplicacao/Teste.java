package br.edu.ifpi.forca.aplicacao;

import java.util.Collections;

import javax.swing.JOptionPane;

import br.edu.ifpi.forca.modelo.Forca;
import br.edu.ifpi.forca.modelo.Tema;

public class Teste {
	
	public static void main(String[] args) {

		Forca forca = Forca.getInstance();
		
		String mesa =  "###### Jogo Da Forca #####\n\n";
		mesa += "1 - Nova Rodada\n"
				+ "2 - Adicionar Palavras\n"
				+ "3 - Ranking\n"
				+ "4 - Trocar De Jogador\n"
				+ "0 - Sair\n";
		
		trocarJogador(forca);
		
		while(true){
			
			int op = Integer.parseInt(JOptionPane.showInputDialog(mesa));
			
			switch (op) {
			case 1:
				novaRodada(forca);
				break;
			case 2:
				addPalavra(forca);
				break;
			case 3:
				ranking(forca);
				break;
			case 4:
				trocarJogador(forca);
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Volte Sempre!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção Invalida!");
				break;
			}
			
			if (op == 0)
				break;
		
		}
	}
	
		


	private static void ranking(Forca forca) {
		String str = "Ranking\n\n";
		Collections.sort(forca.getJogadores());
		for (int i = 0; i < forca.getJogadores().size(); i++)
			str += (i+1) + " - " + forca.getJogadores().get(i) + "\n";
		JOptionPane.showMessageDialog(null, str);
		
	}

	private static void addPalavra(Forca forca) {
		String conjuntoDeTemas = "TEMAS\n\n";
		
		for (int i = 0; i < forca.getBd().getTemas().size(); i++){
			conjuntoDeTemas += (i+1) + " - " + forca.getBd().getTemas().get(i).getDescricao() + "\n";
		}
		conjuntoDeTemas += "\nDigite o nome do tema ou Novo tema: ";
		String tema = JOptionPane.showInputDialog(conjuntoDeTemas);
		boolean novo = true;
		for (int i = 0; i < forca.getBd().getTemas().size(); i++){
			if (forca.getBd().getTemas().get(i).getDescricao().equals(tema)){
				novo = false;
				break;
			}
		}
		forca.getBd().setTema(new Tema(tema));
		if (novo)
			forca.getBd().addTemas();
		String palavra = JOptionPane.showInputDialog("Digite a palavra nova:");
		forca.getBd().addPalavras(palavra);
		
	}


	private static void novaRodada(Forca forca) {
		forca.novaRodada();
		String res = JOptionPane.showInputDialog(forca.Vizualizacao()+"\nJa sabe? s / n");
		while (forca.getStatus() == Forca.JOGANDO){
			if (res.equals("s")){
				String chute = JOptionPane.showInputDialog("Digite a palavra: ");
				if(forca.jaSei(chute, forca.getJogadores().size()-1)){
					String str = "Parabens!\n" + forca.getJogadores().get(forca.getJogadores().size()-1);
					JOptionPane.showMessageDialog(null, str);
				}else{
					String str = "Voce errou!\n Palavra certa é " + forca.getRodada().getPalavraCerta() + "\n" + forca.getJogadores().get(forca.getJogadores().size()-1);
					JOptionPane.showMessageDialog(null, str);
				}
			}else{
			String l = JOptionPane.showInputDialog(forca.Vizualizacao()+"\nDigite um nova letra: ");
			forca.getRodada().verificarLetra(l);
			forca.Vizualizacao();
			if(forca.situacao(forca.getJogadores().size()-1)){
				res = JOptionPane.showInputDialog(forca.Vizualizacao()+"\nJa sabe? s / n");
			}else{
				if (forca.getStatus() == Forca.GANHOU){
					String str = "Parabens!\n" + forca.getJogadores().get(forca.getJogadores().size()-1);
					JOptionPane.showMessageDialog(null, str);
				}else if (forca.getStatus() == Forca.PERDEU){
					String str = "Game Over!\n Palavra certa é " + forca.getRodada().getPalavraCerta() + "\n" + forca.getJogadores().get(forca.getJogadores().size()-1);
					JOptionPane.showMessageDialog(null, str);
				}
			}
				
		}
		
		}
	}

	

	private static void trocarJogador(Forca forca) {
		String nome = JOptionPane.showInputDialog("Digite o nome do Jogador: ");
		forca.addJogador(nome);
	}
}

