package JavaTron;

import java.awt.Color;
import java.awt.Graphics;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

public class Logique {
	private Moto player1, player2;
	private int width, height;
	private Color colorP1, colorP2;
	
	/**
	 * coordonnées de départ des joueurs
	 */
	private int P1StartX = 900;
	private int P1StartY = 400;
	private int P2StartX = 300;
	private int P2StartY = 400;
	
	/**
	 * set la grille de la partie + noms joueurs et couleur 
	 * @param maxWidth
	 * @param maxHeight
	 */

	public Logique(int maxWidth, int maxHeight)
	{
		width = maxWidth;
		height = maxHeight;
		colorP1 = new Color(0,0,255);
		colorP2 = new Color(255, 0, 0 );
		
		// initialise les 2 joueurs

		player1 = new Moto("BLEU",Moto.LEFT, colorP1, P1StartX, P1StartY);  //commence de la droite
		player2 = new Moto("ROUGE", Moto.RIGHT, colorP2, P2StartX, P2StartY);  //commence de la gauche
	}


	// chaque touche rentrer donne une nouvelle direction aux joueurs
	
	public void setP1Direction(int direct)
	{
		player1.setDirection(direct);
	}

	public void setP2Direction(int direct)
	{
		player2.setDirection(direct);
	}

	public String getP1Name()
	{
		return player1.getName();
	}

	public String getP2Name()
	{
		return player2.getName();
	}

	public Moto getP1(){
		return player1;
	}

	public Moto getP2(){
		return player2;
	}


	public boolean stepAndOk()
	{

		player1.step();
		player2.step();
		/**
		 * temps d'execution du programme 
		 */
		
		RuntimeMXBean rb = ManagementFactory.getRuntimeMXBean();
		long uptime = rb.getUptime();
		
		if(player1.loosed(player2, width, height))
		{
			player2.isWinner(uptime);
			return false;
		}
		else if(player2.loosed(player1, width, height))
		{
			player1.isWinner(uptime);
			return false;
		}
		return true;
	}

/**
 * replacement des joueurs apres la fin de partie
 */
	public void  restart()
	{
		player1 = new Moto(player1.getName(), Moto.LEFT, colorP1,P1StartX, P1StartY);
		player2 = new Moto(player2.getName(), Moto.RIGHT, colorP2,P2StartX, P2StartY);
	}



	public void draw(Graphics g)
	{
		player1.draw(g);
		player2.draw(g);
	}

}
