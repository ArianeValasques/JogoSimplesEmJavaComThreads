package threads;

import visao.Cenario;

public class DisparoInimigo {

	public DisparoInimigo() {
		// DISPAROS DO INIMIGO
		
		if (Cenario.getYouWin().isVisible() || Cenario.getGameOver().isVisible()) {
			Cenario.getDisparoInimigo().setVisible(false);
		}
		else {
			Cenario.getDisparoInimigo().setVisible(true);
			fogo();
		}
	}

	public static void fogo() {
		new Thread() {
			public void run() {

				int disparoInimigoX = 480;

				while (Vida.getSaudeInimigo() > 0) {

					if (disparoInimigoX <= 10) {
						disparoInimigoX = 480;
					}

					Cenario.getDisparoInimigo().setBounds(disparoInimigoX, 245, 50, 20);

					if (disparoInimigoX <= Cenario.getJogador().getX() && Cenario.getJogador().getY() >= 240
							&& Cenario.getDisparoInimigo().getX() > Cenario.getJogador().getX() - 30) {
						// Localiza a imagem e seta a imagem da explosão em cima do personagem atingido
						Cenario.getExplosao().setBounds(Cenario.getJogador().getX(), 240, 35, 50);

						// Para de exibir a imagem quando o jogo acabou
						if (Cenario.getGameOver().isVisible() || Cenario.getYouWin().isVisible()) {
							Cenario.getExplosao().setVisible(false);
						} else {
							Cenario.getExplosao().setVisible(true);
						}
					}

					try {
						sleep(7);
					} catch (Exception e) {
						e.printStackTrace();
					}

					disparoInimigoX -= 5;
					Cenario.getExplosao().setVisible(false);
				}
			}
		}.start();
	}

}