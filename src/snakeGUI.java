import javax.swing.JFrame;

public class snakeGUI extends JFrame {
	JFrame frame;

	public snakeGUI() {
		frame = new JFrame("Snake");
		frame.add(new GamePanel());
		frame.setResizable(false);
		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}

}
