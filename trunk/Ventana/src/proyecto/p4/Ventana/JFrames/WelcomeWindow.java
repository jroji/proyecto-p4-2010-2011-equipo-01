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

public class WelcomeWindow extends JFrame{
	
	NickPanel nicks = new NickPanel();
	BotoneraH botonera = new BotoneraH());
	SelectGamePane game = new SelectGamePane();
	JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/img/fondowelcome.jpg")));
	
	public WelcomeWindow(String Language,boolean Sound){
		if(Language.equals("Spanish")){
			botonera= new BotoneraH(ResourceBundle.getBundle("MyResource_Es").getString("label_accept"),ResourceBundle.getBundle("MyResource_Es").getString("label_exit"),ResourceBundle.getBundle("MyResource_Es").getString("label_newPlayer"));
		}else if(Language.equals("English")){
			botonera= new BotoneraH(ResourceBundle.getBundle("MyResource_En").getString("label_accept"),ResourceBundle.getBundle("MyResource_En").getString("label_exit"),ResourceBundle.getBundle("MyResource_En").getString("label_newPlayer"));
		}else if(Language.equals("French")){
			botonera= new BotoneraH(ResourceBundle.getBundle("MyResource_Fr").getString("label_accept"),ResourceBundle.getBundle("MyResource_Fr").getString("label_exit"),ResourceBundle.getBundle("MyResource_Fr").getString("label_newPlayer"));
		}
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

	public static void main(String args[]){
		WelcomeWindow z = new WelcomeWindow();
	}
}
