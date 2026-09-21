package br.com.alvesd3v.minesweeper.model;

@FunctionalInterface
public interface ObserverField {
	
	public void eventOcurred(Field c, EventField event);

}
