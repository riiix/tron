package JavaTron;

/**
 * Initialisation de la fen�tre 
 * Initialisation du controller (keylistener) 
 * 
 * @author Goutorbe
 *
 */
public class Main {

	public static void main(String[] args) {
		 Fen�tre f = new Fen�tre();
		 f.addKeyListener(f.gamePanel);

	}
}

