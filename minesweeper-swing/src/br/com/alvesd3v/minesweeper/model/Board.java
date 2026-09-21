package br.com.alvesd3v.minesweeper.model;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Board implements ObserverField{

	private final int lines;
	private final int columns;
	private final int mines;

	private final List<Field> fields = new ArrayList<>();
	private final List<Consumer<EventResult>> observers = new ArrayList<>();

	public Board(int lines, int columns, int mines) {
		this.lines = lines;
		this.columns = columns;
		this.mines = mines;

		generateFields();
		associateNeighbors();
		drawMines();
	}
	
	public void forEach(Consumer<Field> function) {
		fields.forEach(function);
	}
	
	public void registerObserver(Consumer<EventResult> observer) {
		observers.add(observer);
	}
	
	private void notifyObservers(boolean result) {
		observers.stream().forEach(observer -> observer.accept(new EventResult(result)));
	}

	public void toOpen(int line, int column) {
			fields.parallelStream().filter(c -> c.getLine() == line && c.getColumn() == column).findFirst()
					.ifPresent(c -> c.toOpen());
	}
	
	public void toggleSelection(int line, int column) {
		fields.parallelStream().filter(c -> c.getLine() == line && c.getColumn() == column).findFirst()
				.ifPresent(c -> c.toggleSelection());
	}

	private void generateFields() {
		for (int line = 0; line < lines; line++) {
			for (int column = 0; column < columns; column++) {
				Field field = new Field(line, column);
				field.registerObservers(this);
				fields.add(field);
			}
		}
	}

	private void associateNeighbors() {
		for (Field c1 : fields) {
			for (Field c2 : fields) {
				c1.addNeighbors(c2);
			}
		}
	}

	private void drawMines() {
		long armedMines = 0;
		Predicate<Field> undermined = c -> c.isUndermined();

		do {
			int random = (int) (Math.random() * fields.size());
			fields.get(random).mine();
			armedMines = fields.stream().filter(undermined).count();
		} while (armedMines < mines);
	}

	public boolean goalAchieved() {
		return fields.stream().allMatch(c -> c.goalAchieved());
	}

	public void restart() {
		fields.stream().forEach(c -> c.restart());
		drawMines();
	}

	public int getLines() {
		return lines;
	}

	public int getColumns() {
		return columns;
	}

	@Override
	public void eventOcurred(Field field, EventField event) {
		if(event == EventField.TOEXPLODE) {
			showMines();
			notifyObservers(false);
		} else if (goalAchieved()) {
			notifyObservers(true);
		}
	}
	
	private void showMines() {
		fields.stream().filter(c -> c.isUndermined()).forEach(c -> c.setOpen(true));
	}
}