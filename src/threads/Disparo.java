package threads;

import visao.Cenario;

public class Disparo {

	public Disparo() {

		if (Cenario.getYouWin().isVisible() || Cenario.getGameOver().isVisible()) {
			Cenario.getDisparo().setVisible(false);
		} else {
			Cenario.getDisparo().setVisible(true);
			fogo();
		}
	}

	public static void fogo() {
		new Thread() {
			public void run() {

				int disparoX = Cenario.getJogador().getX();
				int disparoY = Cenario.getJogador().getY() + 12;

				while (disparoX <= 650) {
					Cenario.getDisparo().setBounds(disparoX, disparoY, 50, 20);

					if (disparoX >= Cenario.getInimigo().getX()
							&& Cenario.getDisparo().getX() < Cenario.getInimigo().getX() + 40
							&& Cenario.getDisparo().getY() >= Cenario.getInimigo().getY()) {
						// Localiza a imagem e seta a imagem da explosão em cima do personagem atingido
						Cenario.getExplosao().setBounds(Cenario.getInimigo().getX() + 10, 240, 35, 50);

						// Para de exibir a imagem quando o jogo acabou
						if (Cenario.getGameOver().isVisible() || Cenario.getYouWin().isVisible()) {
							Cenario.getExplosao().setVisible(false);
						} else {
							Cenario.getExplosao().setVisible(true);
						}
					}

					try {
						sleep(10);
					} catch (Exception e) {
						e.printStackTrace();
					}
					disparoX += 5;
				}
			}
		}.start();
	}

}