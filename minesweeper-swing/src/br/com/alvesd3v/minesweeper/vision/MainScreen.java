package br.com.alvesd3v.minesweeper.vision;

import javax.swing.JFrame;

import br.com.alvesd3v.minesweeper.model.Board;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {

	public MainScreen() {
		
		Board board = new Board(16, 30, 50);
		
		add(new PanelBoard(board));
		
		setTitle("MinesWeeper");
		setSize(690, 438);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MainScreen();
	}
}
