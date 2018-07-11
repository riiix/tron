package JavaTron;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Fen�tre extends JFrame implements ActionListener{

	/**
	 * taille de la fen�tre
	 */
	private static final long serialVersionUID = 1L;


	public static final int FRAME_WIDTH = 1200, FRAME_HEIGHT = 800;

	
	public Partie gamePanel;
	
	/**
	 * constructeur avec toute les m�thodes de la fen�tre
	 */

	public Fen�tre()
	{
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Tron Java");
		setResizable(false);
		
		//fermeture de la fen�tre
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		gamePanel = new Partie();
		
		// initialisation du game panel + ajout � la fen�tre
		
		gamePanel.setVisible(true);
		add(gamePanel);
		gamePanel.start();
		
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent e) {
		
			gamePanel.setVisible(true);
			add(gamePanel);
			gamePanel.start();
		
	}

}
