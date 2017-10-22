/**
 * 
 */
package edu.miamioh.gentilm5;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 * @author Michael
 *
 */
public class ColorMenu extends JFrame implements MouseListener {
	JPanel panel;
	JMenuBar menuBar;
	JMenu menu;
	JMenuItem red, green, blue;
	int colorChange=0;//if color is 0 red, 1 green, 2 blue
	/**
	 * Initalizes the frame and panels with a standard size of 400, 400 so that the colors are easily visible. 
	 */
	ColorMenu(){
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new JPanel();
		panel.addMouseListener(this);
		add(panel);
		InitalizeJMenu();
		setVisible(true);
	}
	/**
	 * Initalizes the top level of the menus
	 */
	private void InitalizeJMenu() {

		menuBar=new JMenuBar();
		menuBar.add(createColorMenu());
		setJMenuBar(menuBar);
	}
	/**
	 * Begins construction of all the menu items
	 * @return the singlular menu that will be added to the JMenuBar. 
	 */
	private JMenu createColorMenu() {
		menu=new JMenu("Color");
		menu.add(createColorMenuItem(0, "Red"));
		menu.add(createColorMenuItem(1,"Green"));
		menu.add(createColorMenuItem(2,"Blue"));
		return menu;
	}
	/**
	 * 
	 * @param color, based off of the colors enumeration created up top regarding 0 being red, 1 being green and 2 being blue
	 * @param label, the text on the menuItem. 
	 * @return a JMenuItem with an actionListener attached to it
	 */
	private JMenuItem createColorMenuItem(int color, String label) {
		class ChangeColor implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				colorChange=color;
				changeColor();
			}
			
		}
		JMenuItem item=new JMenuItem(label);
		ActionListener listener=new ChangeColor();
		item.addActionListener(listener);
		return item;
	}
	/**
	 * Changes the colors based on the enumeration stated earlier. It cycles through while allowing for intervention by the JMenuItems
	 */
	private void changeColor(){
		if (colorChange==0){
			panel.setBackground(Color.RED);
			colorChange++;
		}
		else if(colorChange==1)
		{
			panel.setBackground(Color.GREEN);
			colorChange++;
		}
		else{
			panel.setBackground(Color.BLUE);
			colorChange=0;
		}
		repaint();
	}
	
	/**
	 * Changes the color in order if the mouse is clicked.
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		changeColor();
		
	}
	//the rest of the program is useless and only used to satisfy the interface
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
