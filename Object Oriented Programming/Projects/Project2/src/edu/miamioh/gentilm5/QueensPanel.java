/**
 * 
 */
package edu.miamioh.gentilm5;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import edu.miamioh.gentilm5.Block.BoardColor;

/**
 * @author Michael
 *
 */
@SuppressWarnings("serial")
public class QueensPanel extends JPanel implements MouseListener {
	//images that we need
	private BufferedImage goodQueen = null, badQueen=null;
	//List of blocks so that we can manipulate them.
	private ArrayList<Block> blocks=new ArrayList<Block>();

	QueensPanel(){
	initalizeBlocks();
	processImage();
	setSize(800,800);
	this.addMouseListener(this);
	}
	/*
	 * Processes the image into the program so that they can be used. I used MSPaint to draw the badqueen.
	 */
	private void processImage() {	
		try {
		    goodQueen = ImageIO.read(new File("queen.png"));//Recieved from oracle documentation.
		    badQueen = ImageIO.read(new File("badqueen.png"));
		    //image was found at http://icons.mysitemyway.com/legacy-icon/116164-magic-marker-icon-sports-hobbies-chess-queen1-sc51/
		} catch (IOException e) {
		}
	}
	/**
	 * Gives the blocks their special coordinates and their color. 
	 */
	private void initalizeBlocks(){
		int z=1;
		//configure all the coordinates of the blocks.
		for(int y=0; y<8;y++)//all of the rows, 8 rows
		{
			if(y%2==0)//if this is the 0,2,4,6 row then black starts.
			{
				for(int x=0; x<800;x+=100){//this iterates through each 
					if (z==1){//this if alternates white and black.
						blocks.add(new Block(x,y*100,100,100,x/100,y, BoardColor.BLACK));
						z++;
					}
					else{
						blocks.add(new Block(x,y*100,100,100,x/100,y, BoardColor.RED));
						z=1;
					}
					
				}
			}
			else{
				for (int x=0;x<800; x+=100){
					if (z==1){
						blocks.add(new Block(x,y*100,100,100,x/100,y, BoardColor.RED));
						z++;
					}
					else{
						blocks.add(new Block(x,y*100,100,100,x/100,y, BoardColor.BLACK));
						z=1;
					}
				}
			}	
		}
	}
	/**
	 * Draws the blocks with their proper color. 
	 */
	@Override
	public void paintComponent(Graphics g){
		//simpy draw their components in the correct color. 
		for(Block x:blocks){
			if (x.getC()==BoardColor.BLACK){
				g.setColor(Color.black);
			}
			else if(x.getC()==BoardColor.RED){
				g.setColor(Color.red);
			}
			else{
				g.setColor(Color.yellow);
			}
			g.fillRect((int)x.getX(), (int)x.getY(), 100,100);			
			if (x.isFilled() && x.getQ().isSafe()){
				g.drawImage(goodQueen, (int)x.getX(), (int)x.getY(), this);//oracle documentation
			}
			else if(x.isFilled() && !x.getQ().isSafe()){
				g.drawImage(badQueen, (int)x.getX(), (int)x.getY(), this);
			}
		}
		//adjusts for odd colored blocks. Needs a special case because the "yellow" color is odd and needs to disappear eventually.
		for (int x=0; x<Block.getBlocks().size(); x++){
			if (Block.getBlocks().get(x).getC()==Block.BoardColor.YELLOW){
				Block.getBlocks().get(x).setC(Block.getBlocks().get(x).getOldC());
			}
		}
	}
	/**
	 * Sets the blocks to have a queen or not have a queen. 
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		for(Block b:blocks)
		{
			if (b.contains(e.getPoint())){
				if (b.isFilled())
				{
					b.setFilled(false);
				}
				else
				{
					b.setFilled(true);
				}
				repaint();
				break;
			}
		}
		
	}
	//useless because they are not implemented. 
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
