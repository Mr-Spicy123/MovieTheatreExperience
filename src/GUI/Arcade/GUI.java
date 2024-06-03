package GUI.Arcade;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI extends JFrame {
	
	JFrame frame;
	
	
	public GUI() {
		
		
		
		frame = new JFrame("Snake");
		frame.add(new GamePanel());
		

		frame.setResizable(false);
		frame.pack();
		frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		
		
	}

}
