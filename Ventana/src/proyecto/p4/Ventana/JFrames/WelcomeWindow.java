package proyecto.p4.Ventana.JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import proyecto.p4.Juego.Juego;
import proyecto.p4.Jugador.Jugador;
import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.Ventana.JPanels.NickPanel;
import proyecto.p4.Ventana.JPanels.SelectGamePane;
import ConnectionInterface.storableInDataBase;
import Languages.*;

public class WelcomeWindow extends JFrame implements ActionListener,KeyListener,FocusListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5305552228910252163L;
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
		this.sound=Sound;
		this.setSize(1024, 728);
		JLayeredPane layer = new JLayeredPane();
		this.setLayout(null);
		this.add(layer);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.addKeyListener(this);
		this.setFocusable(true);
		
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
		
		nicks.getNick1TF().addFocusListener(this);
		nicks.getNick2TF().addFocusListener(this);
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
					new NewPlayerWindow(language,sound);
				}
			}
		}
		
	}
	public static void main(String [] args){
		ResourceBundle language = new MyResources_En();
		WelcomeWindow x = new WelcomeWindow(language,false);
	}



	@Override
	public void keyPressed(KeyEvent e) {
	
		if(e.getKeyCode()==116){
			Jugador j= new Jugador();
			ArrayList<storableInDataBase> jug= j.takeOutFromDataBase();
			ArrayList<Jugador> jugadores= new ArrayList<Jugador>();
			for(int i=0; i<jug.size();i++){
				jugadores.add((Jugador) jug.get(i));
			}
			new ListaJugadores(jugadores);
		}
		
	}



	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==nicks.getNick1TF()){
			//metodo para comprobar que existe
		}else if(e.getSource()==nicks.getNick2TF()){
			//metodo para comprobar que existe
		}
	}
}
