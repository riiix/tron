package JavaTron;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Partie extends JPanel implements ActionListener, KeyListener{

	public void keyPressed(KeyEvent e) {
		
		/**
		 * Définit les touches du joueur 1 et 2 
		 */
		
		// joueur 1 
		if(e.getKeyCode() == KeyEvent.VK_DOWN){
			if(logic.getP1().getDirection() != Moto.UP)
				logic.setP1Direction(Moto.DOWN);
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP){
			if(logic.getP1().getDirection() != Moto.DOWN)
				logic.setP1Direction(Moto.UP);
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT){
			if(logic.getP1().getDirection() != Moto.RIGHT)
				logic.setP1Direction(Moto.LEFT);
		}
		else if(e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(logic.getP1().getDirection() != Moto.LEFT)
				logic.setP1Direction(Moto.RIGHT);
		}

		// joueur2
		if(e.getKeyCode() == KeyEvent.VK_S){
			if(logic.getP2().getDirection() != Moto.UP)
				logic.setP2Direction(Moto.DOWN);
		}
		else if(e.getKeyCode() == KeyEvent.VK_Z){
			if(logic.getP2().getDirection() != Moto.DOWN)
				logic.setP2Direction(Moto.UP);
		}
		else if(e.getKeyCode() == KeyEvent.VK_Q){
			if(logic.getP2().getDirection() != Moto.RIGHT)
				logic.setP2Direction(Moto.LEFT);
		}
		else if(e.getKeyCode() == KeyEvent.VK_D){
			if(logic.getP2().getDirection() != Moto.LEFT)
				logic.setP2Direction(Moto.RIGHT);
		}
		
		
	}
	
	
	
	/**
	 * définit la taille de la fenêtre
	 */
	private static final long serialVersionUID = 1L;

	private Logique logic;
	
	public static final int W = 1200, H = 800;


	


	Timer timerGeneral;
	

	public Partie() {
		
		// definit le fond
		
		setBackground(Color.BLACK);
		setLayout(new BorderLayout());
		setSize(W, H);
	
		
		
		logic = new Logique(W, H);
		timerGeneral = new Timer(30, this);

	}

	

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		logic.draw(g);
	}


	
	public void start(){
		
		logic.restart();
		timerGeneral.start();
	}
	
	

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==timerGeneral)
		{
			
			if(logic.stepAndOk())
				repaint();
			else
			{
				timerGeneral.stop();	
			}
			repaint();
		}

		

		

	}

	

	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}



}
