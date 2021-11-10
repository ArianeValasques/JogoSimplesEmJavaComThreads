package visao;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Cenario extends JFrame {
	/**
	 * JFrame carregando o cenário e personagens
	 */
	private static final long serialVersionUID = 1L;
	private static JLabel image;
	private static JLabel inimigo;
	private static JLabel disparoInimigo;
	private static JLabel disparo;
	private static JLabel jogador;
	private static JLabel explosao;
	private static JLabel gameOver;
	private static JLabel youWin;
	private static JLabel coracao[] = new JLabel[5];
	private static JLabel coracaoInimigo[] = new JLabel[5];

	static int x = 20;

	public Cenario() {
		this.getContentPane().setLayout(null);
		this.setTitle("Jogo Com Threads");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(655, 346);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		// Explosão durante colisão
		explosao = new JLabel(new ImageIcon("Imagens\\explosao.png"));
		explosao.setHorizontalAlignment(SwingConstants.LEADING);
		explosao.setBounds(0, 210, 98, 94);
		explosao.setVisible(false);
		getContentPane().add(explosao);

		// Disparo do jogador (Cor Azul - Acontecerá quando o usuário pressionar a tecla
		// Z)
		disparo = new JLabel(new ImageIcon("Imagens\\leiser.png"));
		disparo.setHorizontalAlignment(SwingConstants.LEADING);
		disparo.setBounds(30, 253, 50, 20);
		disparo.setVisible(false);
		getContentPane().add(disparo);

		// Chefão da fase (Posição fixada)
		ImageIcon img = new ImageIcon("Imagens\\sprite.png");
		setInimigo(img);
		getContentPane().add(inimigo);

		// Disparo do chefão (Cor Vermelha - Acontecerá em loop, por tempo determinado
		// na classe DisparoInimigo, pacote objetos)
		disparoInimigo = new JLabel(new ImageIcon("Imagens\\leiserInimigo.png"));
		disparoInimigo.setHorizontalAlignment(SwingConstants.LEADING);
		disparoInimigo.setBounds(480, 245, 50, 20);
		disparoInimigo.setVisible(false);
		getContentPane().add(disparoInimigo);

		// Jogador (Pode se movimentar por espaço pré-definido na classe Personagem,
		// pacote objetos, pressionadas as setas)
		jogador = new JLabel(new ImageIcon("Imagens\\sprite_1.png"));
		jogador.setHorizontalAlignment(SwingConstants.LEADING);
		jogador.setBounds(60, 240, 35, 50);
		jogador.setVisible(true);
		getContentPane().add(jogador);

		// corações de vida do personagem
		coracao[0] = new JLabel(new ImageIcon("Imagens\\coração_1.png"));
		coracao[0].setHorizontalAlignment(SwingConstants.LEADING);
		coracao[0].setBounds(10, 10, 35, 35);
		coracao[0].setVisible(true);
		getContentPane().add(coracao[0]);

		coracao[1] = new JLabel(new ImageIcon("Imagens\\coração_2.png"));
		coracao[1].setHorizontalAlignment(SwingConstants.LEADING);
		coracao[1].setBounds(35, 10, 35, 35);
		coracao[1].setVisible(true);
		getContentPane().add(coracao[1]);

		coracao[2] = new JLabel(new ImageIcon("Imagens\\coração_3.png"));
		coracao[2].setHorizontalAlignment(SwingConstants.LEADING);
		coracao[2].setBounds(60, 10, 35, 35);
		coracao[2].setVisible(true);
		getContentPane().add(coracao[2]);

		coracao[3] = new JLabel(new ImageIcon("Imagens\\coração_4.png"));
		coracao[3].setHorizontalAlignment(SwingConstants.LEADING);
		coracao[3].setBounds(85, 10, 35, 35);
		coracao[3].setVisible(true);
		getContentPane().add(coracao[3]);

		coracao[4] = new JLabel(new ImageIcon("Imagens\\coração_5.png"));
		coracao[4].setHorizontalAlignment(SwingConstants.LEADING);
		coracao[4].setBounds(110, 10, 35, 35);
		coracao[4].setVisible(true);
		getContentPane().add(coracao[4]);

		// corações de vida do inimigo
		coracaoInimigo[0] = new JLabel(new ImageIcon("Imagens\\coração_1.png"));
		coracaoInimigo[0].setHorizontalAlignment(SwingConstants.LEADING);
		coracaoInimigo[0].setBounds	(500, 10, 35, 35);
		coracaoInimigo[0].setVisible(true);
		getContentPane().add(coracaoInimigo[0]);
		
		coracaoInimigo[1] = new JLabel(new ImageIcon("Imagens\\coração_2.png"));
		coracaoInimigo[1].setHorizontalAlignment(SwingConstants.LEADING);
		coracaoInimigo[1].setBounds(525, 10, 35, 35);
		coracaoInimigo[1].setVisible(true);
		getContentPane().add(coracaoInimigo[1]);
		
		coracaoInimigo[2] = new JLabel(new ImageIcon("Imagens\\coração_3.png"));
		coracaoInimigo[2].setHorizontalAlignment(SwingConstants.LEADING);
		coracaoInimigo[2].setBounds(550, 10, 35, 35);
		coracaoInimigo[2].setVisible(true);
		getContentPane().add(coracaoInimigo[2]);
		
		coracaoInimigo[3] = new JLabel(new ImageIcon("Imagens\\coração_4.png"));
		coracaoInimigo[3].setHorizontalAlignment(SwingConstants.LEADING);
		coracaoInimigo[3].setBounds(575, 10, 35, 35);
		coracaoInimigo[3].setVisible(true);
		getContentPane().add(coracaoInimigo[3]);
		
		coracaoInimigo[4] = new JLabel(new ImageIcon("Imagens\\coração_5.png"));
		coracaoInimigo[4].setHorizontalAlignment(SwingConstants.LEADING);
		coracaoInimigo[4].setBounds(600, 10, 35, 35);
		coracaoInimigo[4].setVisible(true);
		getContentPane().add(coracaoInimigo[4]);

		// Cenário (Imagem fixa no fundo do frame)
		image = new JLabel(new ImageIcon("Imagens\\2.gif"));
		image.setHorizontalAlignment(SwingConstants.LEADING);
		image.setBounds(0, 0, 640, 307);
		image.setVisible(true);
		getContentPane().add(image);

		// Imagem de GameOver
		gameOver = new JLabel(new ImageIcon("Imagens\\gameOverMaior.png"));
		gameOver.setHorizontalAlignment(SwingConstants.LEADING);
		gameOver.setBounds(0, 0, 640, 307);
		gameOver.setVisible(false);
		getContentPane().add(gameOver);

		// Imagem de You Win
		youWin = new JLabel(new ImageIcon("Imagens\\win.png"));
		youWin.setHorizontalAlignment(SwingConstants.LEADING);
		youWin.setBounds(0, 0, 640, 307);
		youWin.setVisible(false);
		getContentPane().add(youWin);

		this.repaint();
		this.validate();

	}

	// Funçoes para obtenção de informações do personagem, inimigo e disparos
	public static JLabel getImagemCenario() {
		return image;
	}

	public static JLabel getDisparo() {
		return disparo;
	}

	public static JLabel getDisparoInimigo() {
		return disparoInimigo;
	}

	public static JLabel getJogador() {
		return jogador;
	}

	public static JLabel getInimigo() {
		return inimigo;
	}

	public static JLabel getCoracaoPersoangem(int i) {
		return coracao[i];
	}

	public static JLabel getCoracaoInimigo(int i) {
		return coracaoInimigo[i];
	}

	public static void setInimigo(ImageIcon image) {
		inimigo = new JLabel(image);
		inimigo.setHorizontalAlignment(SwingConstants.LEADING);
		inimigo.setBounds(510, 210, 70, 90);
		inimigo.setVisible(true);
	}

	public static JLabel getExplosao() {
		return explosao;
	}

	public static JLabel getYouWin() {
		return youWin;
	}

	public static JLabel getGameOver() {
		return gameOver;
	}
}