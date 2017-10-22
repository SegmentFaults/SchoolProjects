/**
 * 
 */
package edu.miamioh.gentilm5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author gentilm5
 *
 */
@SuppressWarnings("serial")
public class CurrencyConverter extends JFrame implements ActionListener{
	private JPanel mainPanel,topPanel, centerPanel,bottomPanel;
	private JComboBox<String> currencyFromSelectorCombo, currencyToConverToCombo;
	private JTextField conversionAmount;
	private JButton convertButton;
	private JLabel resultLabel, comboFromLabel, comboToLabel;
	public final double EURtoUSD=1.42, GBPtoUSD=1.64,GBPtoEUR=1.13; 
	private ArrayList<String> currencies=new ArrayList<String>();
	private double result=0;
	/**
	 * Initalizes all the helper methods and the frame.
	 */
	CurrencyConverter(){
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initalizePanels();
		initalizeTopPanel();
		initalizeBottomPanel();
		initalizeCenterPanel();
		pack();
		setVisible(true);
	}
	/**
	 * Creates all the panels and allocates them to the proper section
	 */
	private void initalizePanels(){
		mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		add(mainPanel);
		topPanel=new JPanel();
		centerPanel=new JPanel();
		bottomPanel=new JPanel();
		mainPanel.add(topPanel, BorderLayout.NORTH);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.SOUTH);
	}
	/**
	 * Creates all the parts to the panel that holds the amount that needs converted as well as the button,
	 */
	private void initalizeCenterPanel() {
		JLabel convetAmountLabel=new JLabel("Amount to convert");
		centerPanel.add(convetAmountLabel);
		conversionAmount=new JTextField(15);
		centerPanel.add(conversionAmount);
		convertButton=new JButton("Convert");
		centerPanel.add(convertButton);
		convertButton.addActionListener(this);
		
	}
	/**
	 * Initalizes the panel that holds the results. 
	 */
	private void initalizeBottomPanel() {
		resultLabel=new JLabel("Converted quanitity is: "+ result);
		bottomPanel.add(resultLabel);
		
	}
	/**
	 * initalizes the choices for currencies selection as well as the array list that holds them.
	 */
	private void initalizeTopPanel() {
		currencies.add("USD");
		currencies.add("GBP");
		currencies.add("EUR");
		currencyFromSelectorCombo=new JComboBox(currencies.toArray());
		currencyToConverToCombo=new JComboBox(currencies.toArray());
		Font f=new Font("Serif",Font.BOLD,10);
		comboFromLabel=new JLabel("Currency You Have:");
		comboFromLabel.setFont(f);
		comboToLabel=new JLabel("Currency You Want:");
		comboToLabel.setFont(f);
		topPanel.add(comboFromLabel);
		topPanel.add(currencyFromSelectorCombo);
		topPanel.add(comboToLabel);
		topPanel.add(currencyToConverToCombo);
	}
	/**
	 * the action listener checks which currencies are in the combo boxes then does the conversion based on nested if statements. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		double amtToConvert;
		try {
			amtToConvert = Double.parseDouble(conversionAmount.getText());
		} catch (NumberFormatException e1) {
			amtToConvert=0;
		}
		if(currencyFromSelectorCombo.getSelectedItem()=="USD"){
			if (currencyToConverToCombo.getSelectedItem()=="EUR"){
				result=EURtoUSD*amtToConvert;
			}
			else if(currencyToConverToCombo.getSelectedItem()=="GBP"){
				result=GBPtoUSD*amtToConvert;
			}
			else{
				showError();
			}
		}
		else if(currencyFromSelectorCombo.getSelectedItem()=="GBP"){
			if (currencyToConverToCombo.getSelectedItem()=="EUR"){
				result=GBPtoEUR*amtToConvert;
			}
			else if(currencyToConverToCombo.getSelectedItem()=="USD"){
				result=amtToConvert/GBPtoUSD;
			}
			else{
				showError();
			}
		}
		//the item is EUR
		else{
			if (currencyToConverToCombo.getSelectedItem()=="USD"){
				result=amtToConvert/EURtoUSD;
			}
			else if(currencyToConverToCombo.getSelectedItem()=="GBP"){
				result=amtToConvert/1.13;
			}
			else{
				showError();
			}
			
		}
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		resultLabel.setText("Converted Quantity is: "+formatter.format(result));
	}
	/**
	 * Displays an error if the currencies are the same that need covnerted. 
	 */
	private void showError(){
		JOptionPane.showMessageDialog(this,
			    "Please select a valid conversion.");
	}

}
