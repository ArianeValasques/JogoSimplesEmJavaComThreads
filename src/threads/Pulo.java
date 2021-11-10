package threads;

import visao.Cenario;

public class Pulo {
	int x, y;

	public Pulo() {
		if (Cenario.getJogador().getY() == 240) {
			up();
		}
	}

	public void up() {

		new Thread() {
			public void run() {
				x = Cenario.getJogador().getX();
				y = 240;

				while (y >= 100) {
					y -= 5;
					Cenario.getJogador().setBounds(x, y, 35, 50);

					try {
						sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
					}

				}

				while (y < 240) {

					y += 5;
					Cenario.getJogador().setBounds(x, y, 35, 50);

					try {
						sleep(10);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}

				Cenario.getJogador().setBounds(x, 240, 35, 50);
			}
		}.start();
	}

}
