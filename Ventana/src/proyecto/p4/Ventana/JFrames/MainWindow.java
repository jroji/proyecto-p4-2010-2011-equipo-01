package proyecto.p4.Ventana.JFrames;

import javax.swing.JFrame;

import proyecto.p4.Ventana.Button.BotoneraV;

public class MainWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindow(){
		this.setSize(1024,720);
		BotoneraV botoneraV = new BotoneraV("Partida Rápida", "P. Personalizada", "Opciones", "Editor de mapas", "   Salir");
		this.add(botoneraV);
		this.setVisible(true);
	}

	public static void main(String[] args)
	{
		new MainWindow();
	}
}
