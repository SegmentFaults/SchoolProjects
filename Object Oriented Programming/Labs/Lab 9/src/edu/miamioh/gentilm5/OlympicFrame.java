/**
 * 
 */
package edu.miamioh.gentilm5;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * Creates the Frame and Panel to draw the Olympic program. 
 * @author Michael
 *
 */
@SuppressWarnings("serial")
public class OlympicFrame extends JFrame {
	OlympicFrame(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(600,600);
		setVisible(true);
		OlympicPanel panel=new OlympicPanel();
		add(panel);
	}

}
class OlympicPanel extends JPanel{
	private Graphics2D g;//delcare it globally so we may modify it throughout the class
	/**
	 * Actually draws all of the rings for the program
	 */
	@Override
	public void paintComponent(Graphics gTemp){
		g = (Graphics2D) gTemp;
		g.setStroke(new BasicStroke(5));
		this.drawRing(Color.BLUE, 120, 250);
		this.drawRing(Color.YELLOW, 185, 290);
		this.drawRing(Color.BLACK, 250, 250);
		this.drawRing(Color.GREEN, 315, 290);
		this.drawRing(Color.RED, 375, 250);
	}
	/**
	 * Draws a ring with the size of 80 by 80 at a specified coordinate
	 * @param c, the color of the desired ring
	 * @param x, x cordinate of the ring
	 * @param y, y cordinate of the ring
	 */
	private void drawRing(Color c, int x , int y){
		g.setColor(c);
		g.drawOval(x,y,80,80);
	}
}