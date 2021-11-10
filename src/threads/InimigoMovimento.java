
package threads;

import visao.Cenario;

public class InimigoMovimento {

	public InimigoMovimento() {
		andar();
	}

	private void andar() {
		new Thread() {
			public void run() {
				int x = Cenario.getInimigo().getX();
				while (true) {
					while (x > 500) {

						x--;
						// Cenario.setInimigo(img[z]);
						Cenario.getInimigo().setBounds(x, 210, 70, 90);
						Cenario.getInimigo().repaint();
						try {
							sleep(100);
						} catch (Exception e) {
							// TODO: handle exception
						}
					}
					while (x < 510) {
						x++;
						// Cenario.getInimigo().add(label[z]);
						Cenario.getInimigo().setBounds(x, 210, 70, 90);

						try {
							sleep(100);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}

				}
			}
		}.start();
	}

}
