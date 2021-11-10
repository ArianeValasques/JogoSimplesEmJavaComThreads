package controle;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import threads.Disparo;
import threads.DisparoInimigo;
import threads.InimigoMovimento;
import threads.Pulo;
import threads.Som;
import threads.Vida;
import visao.Cenario;

public class ControladorJogo {
	static Cenario cenario;
	static int x = 60;

	public ControladorJogo() {
		cenario = new Cenario();
		cenario.repaint();
		cenario.validate();
		addEventos();
	}

	private void addEventos() {
		new Vida();// controle de vida dos personagens
		new DisparoInimigo(); // Disparos seguidos do inimigo
		new InimigoMovimento(); // Movimento do Inimigo
		controleJogador(); // controle para movimentação do personagem
		new Som();
	}

	public void controleJogador() {
		cenario.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {// para direita 39
					if (x < 430) {
						x += 15;
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {// para esquerda 37
					if (x > 60) {
						x -= 15;
					}
				}

				if (e.getKeyCode() == KeyEvent.VK_ENTER && (Cenario.getGameOver().isVisible()
						|| Cenario.getYouWin().isVisible())) {

					System.exit(0);
				}

				Cenario.getJogador().setBounds(x, 240, 35, 50);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_UP) {// para cima 38
					new Pulo();
				}
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {// para cima 38
					new Disparo();
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}
		});
	}

	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null,
				"Utilize as setas para movimentar o personagem\n"
						+ "e a pressione a BARRA DE ESPAÇO para atirar");
		new ControladorJogo();
	}
}
