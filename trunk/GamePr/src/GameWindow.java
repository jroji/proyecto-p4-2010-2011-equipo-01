import javax.swing.JFrame;

import Proyecto.p4.casilla.Casilla;


public class GameWindow extends JFrame{
	
	GamePanel x;
	public GameWindow()
	{
		this.setSize(500,500);
		//x = new GamePanel()   -   FALTA METODO DE CARGAR MAPA DESDE BD
		this.add(x);
		
	}

}
