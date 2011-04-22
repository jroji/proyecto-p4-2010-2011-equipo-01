package proyecto.p4.Ventana.JFrames;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.Ventana.JPanels.NickPanel;
import proyecto.p4.Ventana.JPanels.SelectGamePane;

public class WelcomeWindow extends JFrame{
	
	NickPanel nicks = new NickPanel();
	BotoneraH botonera = new BotoneraH("  Aceptar","     Salir", "Nuevo Jugador");
	SelectGamePane game = new SelectGamePane();
	
	public WelcomeWindow(){
		this.setSize(1024, 728);
		JLayeredPane layer = new JLayeredPane();
		this.setLayout(null);
		this.add(layer);
		
		layer.setBounds(0, 0, 1024, 728);
		
		layer.add(game, new Integer (0));
		layer.add(nicks, new Integer (1));
		layer.add(botonera, new Integer (2));
		
		game.setBounds(550,0,400,400);
		nicks.setBounds(500, 380, 500, 500);
		botonera.setBounds(50, 550, 600, 200);
		this.setVisible(true);
		}

	public static void main(String args[]){
		WelcomeWindow z = new WelcomeWindow();
	}
}
