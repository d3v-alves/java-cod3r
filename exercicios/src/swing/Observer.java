package swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Observer {
	
	public static void main(String[] args) {
		
		JFrame windown = new JFrame("Observer");
		windown.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		windown.setSize(600, 200);
		windown.setLayout(new FlowLayout());
		windown.setLocationRelativeTo(null);
		
		JButton button = new JButton("ToClick");
		windown.add(button);
		
		button.addActionListener(e -> {
			System.out.println("Event occurred");
		});
		
		windown.setVisible(true);
	}
}
