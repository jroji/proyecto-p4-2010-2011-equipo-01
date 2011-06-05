import javax.swing.JOptionPane;

import proyecto.p4.JuegoOldWarriorTales.JuegoOldWarriorTales;


public class Guardar extends Thread{
	private JuegoOldWarriorTales juego;
	
	public Guardar(JuegoOldWarriorTales juego){
		this.juego=juego;
	}
	public void run(){
		juego.insertIntoDataBase();
		JOptionPane.showMessageDialog(this, "Partida guardada con éxito");
	}

}
