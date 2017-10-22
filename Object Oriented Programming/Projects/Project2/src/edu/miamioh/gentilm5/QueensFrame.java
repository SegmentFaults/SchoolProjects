/**
 * 
 */
package edu.miamioh.gentilm5;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * @author Michael
 *
 */
@SuppressWarnings("serial")
public class QueensFrame extends JFrame {
	private JPanel big, bottom;
	private QueensPanel queensPanel;
	private JTextArea dialogueArea;
	private JButton tipButton;
	QueensFrame(){
		initalizeFrame();//constructs the outer frame itself.
		createAndInitalizePanels();//makes all the panels operable.
		createBottom();//constructs the panel that is on the bottom of the screen
		setVisible(true);
	}

	private void createBottom() {
		JButton check=new JButton("Check");
		class tipListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Block b=findBlock();
				//if there is no queen that can be found throw a null pointer. 
				try{
					if (Queen.getQueenCount()>0 && Queen.getQueenCount()<8 && !b.equals(null)){
						b.setC(Block.BoardColor.YELLOW);
						repaint();
				}
				}
				catch(NullPointerException e){
					JOptionPane.showMessageDialog(QueensFrame.this, "NO MORE VALID SOLUTIONS");//Oracle documentation
				}

				
				
			}
			/**
			 * 
			 * @return a safe block where you can place a queen.
			 */
			public Block findBlock(){
				for (Queen q: Queen.getQueens()){
					for (int y=0; y<Block.getBlocks().size(); y++){
						if(q.attacksBlock(Block.getBlocks().get(y))){
							Block.getBlocks().get(y).setSafe(false);
						}
						
					}
				}
				for (Block x: Block.getBlocks()){	
					if (x.isSafe()){
						return x;
					}
				}
				return null;
			}
		}
		class checkSolutions implements ActionListener{
			String errors="";
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogueArea.setText("");
				boolean solved=solve();
				if (solved){
					dialogueArea.append("This solution works.\n");
					repaint();
				}
				if (!solved){
					dialogueArea.append("The following queens are in danger: "+errors+"\n");
					errors="";
				}
			}
			/**
			 * 
			 * @return whether or not there is an error in the queens.  
			 */
			public boolean solve(){
				boolean safe=true;
				for (int x=0; x<Queen.getQueenCount(); x++)//for every queen
				{
					for(int y=0; y<Queen.getQueenCount(); y++){//attacking every other queen
						Queen.getQueens().get(x).setSafe(true);
						if(Queen.getQueens().get(x).attacks(Queen.getQueens().get(y))){
							Queen.getQueens().get(x).setSafe(false);
							Queen.getQueens().get(y).setSafe(false);
							safe=false;
							repaint();
							break;
						}
					}
				}
				for(Queen x: Queen.getQueens()){
					if(!x.isSafe()){
						errors=errors+x.toString();
					}
				}
				return safe;
				
		}
			
			
		}
		//constructs all the buttons and the text area. 
		ActionListener checkListener=new checkSolutions();
		ActionListener tipListener=new tipListener();
		check.addActionListener(checkListener);
		tipButton=new JButton("Tip");
		tipButton.addActionListener(tipListener);
		dialogueArea=new JTextArea(10,40);
		dialogueArea.setEditable(false);
		check.setSize(200,200);
		bottom.add(dialogueArea);
		bottom.add(check);
		bottom.add(tipButton);
		
	}
	/**
	 * Sets the frame properties.
	 */
	private void initalizeFrame() {
		setResizable(false);
		setSize(800,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("8 Queens");
		
	}
	/**
	 * Simply creates all the panels.
	 */
	private void createAndInitalizePanels(){
		big=new JPanel();
		queensPanel=new QueensPanel();
		bottom=new JPanel();
		bottom.setSize(200,1000);
		add(big);
		big.setLayout(new BorderLayout());
		big.add(bottom,BorderLayout.SOUTH);
		big.add(queensPanel, BorderLayout.CENTER);
	}
}
