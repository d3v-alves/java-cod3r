package br.com.alvesd3v.minesweeper.vision;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import br.com.alvesd3v.minesweeper.model.EventField;
import br.com.alvesd3v.minesweeper.model.Field;
import br.com.alvesd3v.minesweeper.model.ObserverField;

@SuppressWarnings("serial")
public class FieldButton extends JButton implements ObserverField{

	private Field field;
	
	private final Color BG_DEFAULT = new Color(184, 184, 184);
	private final Color BG_TOMARK = new Color(8, 179, 247);
	private final Color BG_TOEXPLODE = new Color(189, 66, 68);
	private final Color TEXT_GREEN = new Color(0, 100, 0);
	
	public FieldButton(Field field) {
		this.field = field;
		setBackground(BG_DEFAULT);
		setBorder(BorderFactory.createBevelBorder(0));
		
		field.registerObservers(this);
	}
	
	@Override
	public void eventOcurred(Field field, EventField event)	{
		switch(event) {
		case TOOPEN:
			applyToOpenStyle();
			break;
		case TOMARK:
			applyToMarkStyle();
			break;
		case TOEXPLODE:
			applyToExplodeStyle();
			break;
		default:
			applyDefaultStyle();
		}
	}

	private void applyDefaultStyle() {
	}
	private void applyToExplodeStyle() {
	}
	private void applyToMarkStyle() {
	}
	private void applyToOpenStyle() {
	}
}
