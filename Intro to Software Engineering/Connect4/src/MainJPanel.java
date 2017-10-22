import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainJPanel extends JLayeredPane {
	private MainJPanel panel;
	private MainFrame frame;
	MainJPanel(MainFrame frame){
	panel=this;
	this.frame=frame;
	setBackground(Color.GRAY);
	setBorder(new EmptyBorder(5, 5, 5, 5));
	setLayout(null);
	
	JLabel backgroundImage = new JLabel("");
	backgroundImage.setVerticalAlignment(SwingConstants.TOP);
	backgroundImage.setIcon(new ImageIcon("Main Menu Mock-up 1.png"));
	backgroundImage.setBounds(0, 0, 825, 850);
	add(backgroundImage);
	
	JButton playButton = new JButton("");
	playButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			SettingsFrame frame2=new SettingsFrame(frame);
			frame2.setVisible(true);
			System.out.println("The button lives!");
		}
	});
	playButton.setOpaque(false);
	playButton.setBounds(290, 334, 225, 99);
	add(playButton);
	
	JButton exitButton = new JButton("");
	exitButton.setBounds(301, 642, 200, 77);
	exitButton.setOpaque(false);
	exitButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	});
	add(exitButton);
	
	
	JButton aboutButton= new JButton("");
	aboutButton.setOpaque(false);
	aboutButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg){
			System.out.println("shit");
			frame.changeContentPane(frame.aboutMenuPanel);
		}
	});
	aboutButton.setBounds(250,540,300,80);
	add(aboutButton);
	
	JButton scoreButton=new JButton("");
	scoreButton.setBounds(235,440,330,80);
	scoreButton.setOpaque(false);
	scoreButton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent arg){
			frame.changeContentPane(frame.scoresPanel);
		}
	});
	add(scoreButton);
	}
}
