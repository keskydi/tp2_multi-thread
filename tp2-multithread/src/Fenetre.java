
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;


//CTRL + SHIFT + O pour générer les imports 
public class Fenetre extends JFrame {

	private DrawPanel drawPanel = new DrawPanel();

	public Fenetre() {
		this.setSize(Constants.WINDOWS_WITDH, Constants.WINDOW_HEIGHT);
		//this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawPanel.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.gray));
		this.getContentPane().add(drawPanel, BorderLayout.CENTER);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		Fenetre fen = new Fenetre();
	}
}