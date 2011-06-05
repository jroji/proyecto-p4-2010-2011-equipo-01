package proyecto.p4.VentanaJuego;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import proyecto.p4.JuegoOldWarriorTales.JuegoOldWarriorTales;


public class Guardar extends Thread{
		private JuegoOldWarriorTales juego;
		private GameWindow game;
	public Guardar(JuegoOldWarriorTales juego, GameWindow game){
		this.juego=juego;
		this.game=game;
	}
	public void run(){
		
		//JOptionPane.showMessageDialog(null, "Guardando");
		SavingWindow sav=new SavingWindow();
		sav.setVisible(true);
		sav.repaint();
		juego.insertIntoDataBase();
		sav.dispose();
		JOptionPane.showMessageDialog(null, "Partida guardada con éxito");
		game.dispose();
	}

}
