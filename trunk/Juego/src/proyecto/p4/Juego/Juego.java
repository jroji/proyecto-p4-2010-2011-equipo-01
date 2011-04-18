package proyecto.p4.Juego;


import Proyecto.p4.mapa.Board;
import proyecto.p4.Jugador.Jugador;
import proyecto.p4.pieza.Piece;

public abstract class Juego {
	private int identificador;
	public int getIdentificador() {
		return identificador;
	}
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
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
	private Board tablero;
	private Jugador jugador1;
	private Jugador jugador2;

}
