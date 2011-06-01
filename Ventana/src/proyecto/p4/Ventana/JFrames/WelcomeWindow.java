package proyecto.p4.Ventana.JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import proyecto.p4.Juego.Juego;
import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.Ventana.JPanels.NickPanel;
import proyecto.p4.Ventana.JPanels.SelectGamePane;
import Languages.*;

public class WelcomeWindow extends JFrame implements ActionListener{
	
	private NickPanel nicks = new NickPanel();
	private BotoneraH botonera;
	private SelectGamePane game = new SelectGamePane(this);
	private JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/img/fondowelcome.jpg")));
	private ResourceBundle language;
	private boolean sound;
	public Juego selectedGame;
	
	public WelcomeWindow(ResourceBundle language,boolean Sound){

		botonera= new BotoneraH(language.getString("label_accept"),language.getString("label_exit"),language.getString("label_newPlayer"));
		this.setResizable(false);
		this.language=language;
		sound=Sound;
		this.setSize(1024, 728);
		JLayeredPane layer = new JLayeredPane();
		this.setLayout(null);
		this.add(layer);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		((OldWarriorButton)botonera.getComponent(0)).getOldWarriorButton().addActionListener(this);
		((OldWarriorButton)botonera.getComponent(1)).getOldWarriorButton().addActionListener(this);
		((OldWarriorButton)botonera.getComponent(2)).getOldWarriorButton().addActionListener(this);
		//�?�?�?�?�? action listener �?�?�?�?�?
//		    while(true){
//		   		if(botonera.getButtonP1()){
//		   			botonera.setButtonP1(false);
//		   			this.dispose();
//					new MainWindow(language,Sound);
//				}else if(botonera.getButtonP2()){
//					botonera.setButtonP2(false);
//					//this.dispose();
//					System.exit(0);
//		       }
//				else if(botonera.getButtonP3()){
//					botonera.setButtonP3(false);
//					new NewPlayerWindow();
//
//		}
//		}
		    
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==((OldWarriorButton) botonera.getComponent(0)).getOldWarriorButton())
		{
			botonera.setButtonP1(false);
			new MainWindow(language,sound,selectedGame);
			this.dispose();
		}else{
			if(e.getSource()==((OldWarriorButton) botonera.getComponent(1)).getOldWarriorButton()){
				botonera.setButtonP2(false);
				this.dispose();
				System.exit(0);
			}else{
				if(e.getSource()==((OldWarriorButton) botonera.getComponent(2)).getOldWarriorButton()) {
					botonera.setButtonP3(false);
					new NewPlayerWindow();
				}
			}
		}
		
	}
	public static void main(String [] args){
		ResourceBundle language = new MyResources_En();
		WelcomeWindow x = new WelcomeWindow(language,false);
	}
}
