/**
 * 
 */
package edu.miamioh.gentilm5;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Creates the whole gui including frame and all panels with all of their interworkings. Incorporates subclasses for custom actions.
 * @author gentilm5
 *
 */
@SuppressWarnings("serial")
public class ResturantFrame extends JFrame implements ActionListener {
	private JButton[] buttons= new JButton[10];
	private JPanel panelTop, wholeFramePanel, bottomPanel, sidePanel;
	private JTextArea tabBar;
	private ArrayList<ResturantItem> items= new ArrayList<ResturantItem>();
	private JTextField foodNameField,foodPriceField;
	private final double TAXRATE=.065;
	private JScrollPane scroller;
	private JLabel priceLabel,foodLabel;
	private JButton addRareItemButton,calculateButton;
	
	/**
	 * 
	 * @param width, width of frame
	 * @param height, the height of the frame
	 * 
	 * Initalizes all items
	 * This handles all the submethods as well as initalizes all the panels and the frame
	 */
	public ResturantFrame(int width, int height){
		setSize(width,height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		initiatePanels();
		initalizeBottom();
		initalizeTabBar();
		initalizeButtons();
		setVisible(true);
		//pack();
	}
	/**
	 * initiates all the panels within the frame and adds them to the correct spot within the layout
	 */
	private void initiatePanels() {
		
		this.wholeFramePanel=new JPanel();
		wholeFramePanel.setLayout(new GridLayout(2,2));
		add(wholeFramePanel);
			
		this.panelTop=new JPanel();
		GridLayout layout=new GridLayout(5,2);
		panelTop.setLayout(layout);
		wholeFramePanel.add(panelTop);
		
		sidePanel=new JPanel();
		sidePanel.setLayout(new BorderLayout());
		wholeFramePanel.add(sidePanel);
		
		bottomPanel=new JPanel();
		this.wholeFramePanel.add(this.bottomPanel);
		
	}
	/**
	 * creates the bar that holds all of the items the customer purchased.
	 */
	private void initalizeTabBar() {
		tabBar=new JTextArea(20,30);
		tabBar.setEditable(false);
		scroller=new JScrollPane(tabBar);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.sidePanel.add(scroller, BorderLayout.CENTER);
	}
	/**
	 * Creates the text field and buttons for the bottom half of the program.
	 * This includes the button that totals your items and the custom items. 
	 */
	private void initalizeBottom() {
		foodNameField=new JTextField(30);
		foodPriceField=new JTextField(6);
		addRareItemButton=new JButton("Add Item");
		foodLabel=new JLabel("Food Name");
		priceLabel=new JLabel("Food Price");
		bottomPanel.add(foodLabel);
		bottomPanel.add(foodNameField);
		bottomPanel.add(priceLabel);
		bottomPanel.add(foodPriceField);
		bottomPanel.add(addRareItemButton);
		addRareItemButton.addActionListener(this);
		calculateButton=new JButton("Calculate Tax and Total");
		ActionListener listener=new AddCalculateListener();
		calculateButton.addActionListener(listener);
		bottomPanel.add(calculateButton);
	}
	/**
	 * Creates all the buttons needed for the top left corner of the program. 
	 */
	private void initalizeButtons() {
		ResturantButton mcChickenButton=new ResturantButton("McChicken", .99);
		buttons[0]=mcChickenButton;
		ResturantButton mcDoubleButton=new ResturantButton("McDouble", 1.99);
		buttons[1]=mcDoubleButton;
		ResturantButton BigMacButton=new ResturantButton("Big Mac", 3.99);
		buttons[2]=BigMacButton;
		ResturantButton mcNuggetButton=new ResturantButton("McNugget", .29);
		buttons[3]=mcNuggetButton;
		ResturantButton mcTerribleButton=new ResturantButton("McBad", .99);
		buttons[4]=mcTerribleButton;
		ResturantButton mcConeButton=new ResturantButton("McCone", .99);
		buttons[5]=mcConeButton;
		ResturantButton mcHotDogButton=new ResturantButton("McHotDog", .99);
		buttons[6]=mcHotDogButton;
		ResturantButton mcShakeButton=new ResturantButton("McShake", .99);
		buttons[7]=mcShakeButton;
		ResturantButton mcCafeButton=new ResturantButton("McCafe", .99);
		buttons[8]=mcCafeButton;
		ResturantButton mcAppleButton=new ResturantButton("McApple", .99);
		buttons[9]=mcAppleButton;
		for (int x=0; x<10; x++){
			buttons[x].setFont(new Font("Arial", Font.BOLD, 25));
			panelTop.add(buttons[x]);
			((ResturantButton) buttons[x]).setActionListener();
		}
	}
	/**
	 * This is the actionPerformed to add a custom food item.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
			items.add(new ResturantItem(foodNameField.getText(), Double.parseDouble(foodPriceField.getText())));
			int x=items.size()-1;
			tabBar.append(items.get(x).toString());
	}
	private class AddCalculateListener implements ActionListener{
		/**
		 * Tabs the total and the tax of the items that need to be totaled. 
		 */
		public void actionPerformed(ActionEvent e){
			double ttl=0;
			for(ResturantItem x:items){
				ttl+=x.getPrice();
			}
			double taxDouble=TAXRATE*ttl;
			ttl+=taxDouble;
			tabBar.setText("\n\n\n\n\n"+taxDouble+"\n"+ttl+"\n\n");
			items=new ArrayList<ResturantItem>();//resets for a new customer. 
		}
	}
	/**
	 * Represents a button specific to the need of having identifying variables such as the price of the item and the name of item. 
	 * @author Michael
	 *
	 */
	private class ResturantButton extends JButton implements ActionListener{
		private String text;
		private ResturantItem item;
		public ResturantButton(String text, double price){
			this.setText(text);
			this.text=text;
			item=new ResturantItem(text, price);
			setVisible(true);
		}
		
		/**
		 * @return text, the text of the button
		 */
		public String getText() {
			return text;
		}
		/**
		 * @param text, sets the description of the item.
		 */
		public void setText(String text) {
			this.text = text;
		}
		/**
		 * 
		 * @return the resturant Item that allows for the retrieval of information.
		 */
		public ResturantItem getItem() {
			return item;
		}
		/**
		 * sets the actionListener of the object to the actionPerformed defined by the class. 
		 */
		public void setActionListener(){
			this.addActionListener(this);
		}
		/**
		 * made specifically for the current resturant frame.
		 * This adds an item to the resturant text area where your bill is tabulated. 
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			items.add(((ResturantButton) e.getSource()).getItem());
			int x=items.size()-1;
			tabBar.append(items.get(x).toString());
			
		}//end method
	}//end subclass
}//end class
