package JavaTron;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Fenêtre extends JFrame implements ActionListener{

	/**
	 * taille de la fenêtre
	 */
	private static final long serialVersionUID = 1L;


	public static final int FRAME_WIDTH = 1200, FRAME_HEIGHT = 800;

	
	public Partie gamePanel;
	
	/**
	 * constructeur avec toute les méthodes de la fenêtre
	 */

	public Fenêtre()
	{
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Tron Java");
		setResizable(false);
		
		//fermeture de la fenêtre
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
		gamePanel = new Partie();
		
		// initialisation du game panel + ajout à la fenêtre
		
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
