package proyecto.p4.Juego;


import java.util.ResourceBundle;

import proyecto.p4.Mapa.Board;
import proyecto.p4.Jugador.Jugador;

public abstract class Juego {
	
	protected Board tablero;
	protected Jugador jugador1;
	protected Jugador jugador2;
	protected String name;
	protected String playing;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	protected String rutaImagen;
	
	
	public Board getTablero() {
		return tablero;
	}
	public void setTablero(Board tablero) {
		this.tablero = tablero;
	}
	public Jugador getJugador1() {
		return jugador1;
	}
	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}
	public Jugador getJugador2() {
		return jugador2;
	}
	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}
	public String toString(){
		return name;
	}
	public String getRuta(){
		return this.rutaImagen;
	}
	public abstract void throwWindow(ResourceBundle rb, boolean bool);

}
