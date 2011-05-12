package proyecto.p4.Ventana.JFrames;

import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.Ventana.JPanels.NickPanel;
import proyecto.p4.Ventana.JPanels.SelectGamePane;
import Languages.*;

public class WelcomeWindow extends JFrame{
	
	NickPanel nicks = new NickPanel();
	BotoneraH botonera;
	SelectGamePane game = new SelectGamePane();
	JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/img/fondowelcome.jpg")));
	
	public WelcomeWindow(ResourceBundle language,boolean Sound){

		botonera= new BotoneraH(language.getString("label_accept"),language.getString("label_exit"),language.getBundle("MyResource_Fr").getString("label_newPlayer"));


		this.setSize(1024, 728);
		JLayeredPane layer = new JLayeredPane();
		this.setLayout(null);
		this.add(layer);
		
		layer.setBounds(0, 0, 1024, 728);
		
		layer.add(fondo, new Integer (0));
		layer.add(game, new Integer (1));
		layer.add(nicks, new Integer (2));
		layer.add(botonera, new Integer (3));
		
		fondo.setBounds(0, 0, 1024, 720);
		game.setBounds(580,0,400,400);
		nicks.setBounds(500, 380, 500, 500);
		botonera.setBounds(50, 550, 600, 200);
		this.setVisible(true);
		}
	
	public static void main(String [] args){
		ResourceBundle language = new MyResources_Es();
		WelcomeWindow x = new WelcomeWindow(language,true);
		x.setVisible(true);
		
	}
}
