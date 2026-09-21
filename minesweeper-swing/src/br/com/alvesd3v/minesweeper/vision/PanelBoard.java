package br.com.alvesd3v.minesweeper.vision;

import java.awt.GridLayout;

import javax.swing.JPanel;

import br.com.alvesd3v.minesweeper.model.Board;

@SuppressWarnings("serial")
public class PanelBoard extends JPanel{

	public PanelBoard(Board board) {
		
		setLayout(new GridLayout(board.getLines(), board.getColumns()));
		
		board.forEach(c -> add(new FieldButton(c)));
		
		board.registerObserver(e -> {
			
		});
	}
}
