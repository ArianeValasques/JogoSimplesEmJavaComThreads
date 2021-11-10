package threads;

import java.awt.Component;
import visao.Cenario;

public class Vida {

	public int saudePersonagem = 300;
	int auxVidaPersonagem = getSaudePersonagem();
	public static int saudeInimigo = 300;
	int auxVidaInimigo = getSaudeInimigo();
	int indicePersonagem = 4;
	int indiceInimigo = 0;
	float indiceReducaoVidaInimigo = (float) 0.2;
	float indiceReducaoVidaPersonagem = (float) 0.2;

	public Vida() {
		verifica();
	}

	public void verifica() {

		new Thread() {
			public void run() {

				while (true) {

					// VERIFICAÇÃO DE COLISÃO NO INIMIGO E FIM DE JOGO
					if ((colisao(Cenario.getDisparo(), Cenario.getInimigo(), 0) == true)
							&& ((Cenario.getGameOver().isVisible() == false)
									|| (Cenario.getYouWin().isVisible() == false))) {

						// REDUZ A VIDA
						setSaudeInimigo(10);

						// VERIFICA SE A VIDA DO INIMIGO CHEGOU AO PONTO CERTO PARA A REDUÇÃO DOS
						// CORAÇÕES
						if (getSaudeInimigo() == auxVidaInimigo - (auxVidaInimigo * indiceReducaoVidaInimigo)) {

							Cenario.getCoracaoInimigo(indiceInimigo).setVisible(false);
							indiceReducaoVidaInimigo += 0.20;// AUMENTA O PERCENTUAL DE REDUÇÃO DE VIDA DO INIMIGO

							// VERIFICAÇÃO DE ÍNDICE - SE CHEGAR AO MÁXIMO TRAVA
							if (indiceInimigo >= 4) {
								indiceInimigo = 4;
							} else {
								indiceInimigo++;
							}
						}

						// VERIFICAÇÃO DE VIDA DO INIMIGO PARA FINALIZAR O JOGO
						if (getSaudeInimigo() == 0) {
							limpaTela(true);
						}
					}

					// VERIFICAÇÃO DE COLISÃO NO JOGADOR E FIM DE JOGO
					if ((colisao(Cenario.getJogador(), Cenario.getDisparoInimigo(), 1))
							&& ((Cenario.getGameOver().isVisible() == false)
									|| (Cenario.getYouWin().isVisible() == false))) {

						// REDUZ A VIDA
						setSaudePersonagem(10);

						// VERIFICA SE A VIDA DO PERSONAGEM CHEGOU AO PONTO CERTO PARA A REDUÇÃO DOS
						// CORAÇÕES
						if (getSaudePersonagem() == auxVidaPersonagem
								- (auxVidaPersonagem * indiceReducaoVidaPersonagem)) {

							Cenario.getCoracaoPersoangem(indicePersonagem).setVisible(false);
							indiceReducaoVidaPersonagem += 0.20;// AUMENTA O PERCENTUAL DE REDUÇÃO DE VIDA DO PERONAGEM

							// VERIFICAÇÃO DE ÍNDICE - SE CHEGAR AO MÁXIMO TRAVA
							if (indicePersonagem <= 0) {
								indicePersonagem = 0;
							} else {
								indicePersonagem--;
							}
						}
						// VERIFICAÇÃO DE VIDA DO JOGADOR PARA FINALIZAR O JOGO
						if (getSaudePersonagem() == 0) {
							limpaTela(false);
						}
					}
					try {
						sleep(200);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}.start();

	}

	public boolean colisao(Component disparo, Component personagem, int i) {

//		Recolhendo informações sobre a localização das sprites(Personagem e Disparo)
//		Para verificar se houve ou não colisão entre elas Informações armazenadas: Altura, Largura e posições X e Y
		int disparoPosiaoX = disparo.getX();
		int ladoDireitoDisparo = disparoPosiaoX + disparo.getWidth();
		int ladoEsquerdoDisparo = disparoPosiaoX;
		//int disparoPosiaoY = disparo.getY();
		//int ladoBaixoA = disparoPosiaoY + disparo.getHeight();
		//int ladoCimaA = disparoPosiaoY;

		int personagemPosicaoX = personagem.getX();
		int ladoDireitoPersonagem = personagemPosicaoX + personagem.getWidth();
		int ladoEsquerdoPersonagem = personagemPosicaoX;
		//int personagemPosicaoY = personagem.getY();
		//int ladoBaixoB = personagemPosicaoY + personagem.getHeight();
		//int ladoCimaB = personagemPosicaoY;

		boolean colisao = false;

		//verificadores de contato
		boolean colisaoNaDireita = false;
		boolean colisaoNaEsquerda = false;
		//boolean colisaoEmCima = false;
		//boolean colisaoEmBaixo = false;
		

		// Verificações referente a posição do sprite do personagem/inimigo e o sprite dos disparos
		// as colisões podem ser pela frente, ou por trás; ou mesmo por cima, ou por baixo
		
		if (ladoDireitoDisparo >= ladoEsquerdoPersonagem) {
			colisaoNaDireita = true;
		}

		if (ladoEsquerdoDisparo <= ladoDireitoPersonagem) {
			colisaoNaEsquerda = true;
		}
		/*
		if (ladoCimaA <= ladoBaixoB) {
			colisaoEmCima = true;
		}
		if (ladoBaixoA >= ladoCimaB) {
			colisaoEmBaixo = true;
		}
		if (ladoEsquerdoDisparo <= ladoDireitoPersonagem) {
			colisaoNaEsquerda = true;
		}
		if (colisaoNaDireita && colisaoNaEsquerda && colisaoEmBaixo && colisaoEmCima) {
			colisao = true;
		}*/
		
		// Se as posições para a colisão forem True, então houve colisão
		if (colisaoNaDireita && colisaoNaEsquerda) {
			colisao = true;
		}

		return colisao;
	}

	public void limpaTela(boolean verificador) {

		// Deixando os sprites desabiltados e mostrando apenas a mensagem de You Win, ou
		// Game Over.
		Cenario.getImagemCenario().setVisible(false);
		Cenario.getInimigo().setVisible(false);
		Cenario.getJogador().setVisible(false);
		Cenario.getExplosao().setVisible(false);
		Cenario.getDisparo().setVisible(false);
		Cenario.getDisparoInimigo().setVisible(false);
		Cenario.getCoracaoPersoangem(0).setVisible(false);
		Cenario.getCoracaoPersoangem(1).setVisible(false);
		Cenario.getCoracaoPersoangem(2).setVisible(false);
		Cenario.getCoracaoPersoangem(3).setVisible(false);
		Cenario.getCoracaoPersoangem(4).setVisible(false);
		Cenario.getCoracaoInimigo(0).setVisible(false);
		Cenario.getCoracaoInimigo(1).setVisible(false);
		Cenario.getCoracaoInimigo(2).setVisible(false);
		Cenario.getCoracaoInimigo(3).setVisible(false);
		Cenario.getCoracaoInimigo(4).setVisible(false);

		// Verifica quem ganhou e mostra a imagem correta
		if (verificador == true && Cenario.getGameOver().isVisible()) {
			Cenario.getYouWin().setVisible(false);
		} else if (verificador == true){
			Cenario.getYouWin().setVisible(true);
		} else if (verificador == false && Cenario.getYouWin().isVisible()){
			Cenario.getGameOver().setVisible(false);
		} else {
			Cenario.getGameOver().setVisible(true);
		}

	}

	public int getSaudePersonagem() {
		return saudePersonagem;
	}

	public void setSaudePersonagem(int reduzSaude) {
		this.saudePersonagem -= reduzSaude;
	}

	public static int getSaudeInimigo() {
		return saudeInimigo;
	}

	public void setSaudeInimigo(int reduzSaude) {
		Vida.saudeInimigo -= reduzSaude;
	}

}
