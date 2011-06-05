package proyecto.p4.VentanaJuego;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import proyecto.p4.JuegoOldWarriorTales.JuegoOldWarriorTales;


public class Guardar extends Thread{
		private JuegoOldWarriorTales juego;
	
	public Guardar(JuegoOldWarriorTales juego){
		this.juego=juego;
	}
	public void run(){
		
		//JOptionPane.showMessageDialog(null, "Guardando");
		new SavingWindow();
		System.out.println("a");
	}

}
