package JavaTron;

import java.awt.Color;
import java.awt.Graphics;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Moto {

	private String name;
	private int direction;
	private ModuleLong head;
	private Color color;
	
	/**
	 *Connexion à la bdd ,calculer du temps total d'excécution et ouvre le pop up de victoire
	 * @param uptime
	 * 
	 */
	public void isWinner(long uptime) {
		
		float Uptime = uptime;
		Uptime = Uptime/1000;
		String Time = Float.toString(Uptime);
		
		try {
			String url="jdbc:mysql://localhost/tron?useSSL=false&serverTimezone=UTC";
		    String user="root";
		    String password="";
		   
		    Connection conn = null;
		    conn = DriverManager.getConnection(url, user, password);
		    
		    
		    CallableStatement cStmt = conn.prepareCall("{call _enr (?, ?)}");
		    cStmt.setString(1, this.getName());
		    cStmt.setString(2, Time);
		    cStmt.execute();
		    System.out.println(" BDD enregistré");


		} catch (SQLException ex) {
		    
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		
		
		System.out.println(" Le joueur " + this.getName() + " vous a vaincu");
		System.out.println(" Durée de la partie: " + Uptime + "s");
		
		JOptionPane.showMessageDialog(null, "Victoire du joueur " + this.getName() +" !", "Fin de la partie", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Paramètre de la moto
	 * @param name
	 * @param direction
	 * @param color
	 * @param x
	 * @param y
	 */
	
	//taille module
	
	public static int UP = 1, DOWN = 2, LEFT = 3, RIGHT = 4;


	public static int PIX_PER_STEP = 2, THIKNES = 2;
	
	

	public Moto(String name, int direction, Color color, int x, int y)
	{
		this.name = name;
		this.direction = direction;
		this.color = color;
		// commence à ce module
		head = new ModuleLong(x, y, null);
	}

	public String getName() {
		return name;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}



	public int getDirection() {
		return direction;
	}



	public ModuleLong getHead() {
		return head;
	}

	// en fonction de la direction on regarde si le module ne se touche pas 
	public void step()
	{
		switch(direction)
		{
		case 1: 		//haut
			head = new ModuleLong(head.getX(), head.getY() - PIX_PER_STEP, head);
			break;
		case 2: 		//bas
			head = new ModuleLong(head.getX(), head.getY() + PIX_PER_STEP, head);
			break;
		case 3: 		//gauche
			head = new ModuleLong(head.getX() - PIX_PER_STEP, head.getY(), head);
			break;
		case 4: 		//droite
			head = new ModuleLong(head.getX() + PIX_PER_STEP, head.getY(), head);
			break;
		}

	}

/**
 * défini les cas ou le joueur perd
 * @param other
 * @param maxWidth
 * @param maxHeight
 * @return
 */

	public boolean loosed(Moto other, int maxWidth, int maxHeight)
	{
		//si le joueur se percute lui-même
		for(ModuleLong p = head.getNext(); p.getNext() != null ; p = p.getNext())
			if(head.sameValues(p))
				return true;
		//si il percute un autre joueur
		for(ModuleLong p = other.getHead(); p.getNext() != null ; p = p.getNext())
			if(head.sameValues(p))
				return true;
		//si il touche  les murs de la map 
		if(head.getX() < 0 || head.getY() < 0 || head.getX() > maxWidth + THIKNES || head.getY() > maxHeight + THIKNES)
			return true;

		return false;
	}
	

	public void draw(Graphics g)
	{
		g.setColor(color);
		ModuleLong p = head;
		for(;p != null; p=p.getNext()) {
			g.fillRect(p.getX(), p.getY(), THIKNES, THIKNES);	//tous les joueurs
		}
	}
	
	
}




