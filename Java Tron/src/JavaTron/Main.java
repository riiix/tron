package JavaTron;

/**
 * Initialisation de la fenêtre 
 * Initialisation du controller (keylistener) 
 * 
 * @author Goutorbe
 *
 */
public class Main {

	public static void main(String[] args) {
		 Fenêtre f = new Fenêtre();
		 f.addKeyListener(f.gamePanel);

	}
}

