import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	public JPanel contentPane;
	public JLayeredPane scoresPanel, aboutMenuPanel, playPanel, mainJPanel, settingsPanel;
	private int AIDifficulty;
	private boolean isRed;
	public	MainFrame() {
		Score.checkSaveFileExists();
		playPanel=new PlayPanel(this);
		scoresPanel=new ScorePanel(this);
		aboutMenuPanel=new AboutMenu(this);
		mainJPanel=new MainJPanel(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(mainJPanel);
		setBounds(100, 100, 825, 850);
		this.setResizable(false);
	}
	public void changeContentPane(JLayeredPane newPanel){
		System.out.println(newPanel instanceof MainJPanel);
		if (newPanel instanceof MainJPanel){
			newPanel=new MainJPanel(this);
			System.out.println("mainpanel");
		}
		
		else if(newPanel instanceof ScorePanel){
			newPanel=new ScorePanel(this);
			System.out.println("score");
		}
		else if(newPanel instanceof PlayPanel){
			newPanel=new PlayPanel(this);
			System.out.println("playtime's over kiddo");
		}
		else if(newPanel instanceof AboutMenu){
			newPanel=new AboutMenu(this);
			System.out.println("aboot");
		}
		System.out.println("This ran");
		this.getContentPane().removeAll();
		this.setContentPane(newPanel);
		newPanel.revalidate();
		this.repaint();
		setVisible(true);
	}
	public int getAIDifficulty() {
		return AIDifficulty;
	}
	public void setAIDifficulty(int aiDifficulty) {
		AIDifficulty = aiDifficulty;
	}
	public boolean isRed() {
		return isRed;
	}
	public void setRed(boolean isRed) {
		this.isRed = isRed;
	}
}
