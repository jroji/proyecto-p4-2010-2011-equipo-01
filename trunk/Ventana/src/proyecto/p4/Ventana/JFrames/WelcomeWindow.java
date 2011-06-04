package proyecto.p4.Ventana.JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import proyecto.p4.Juego.Juego;
import proyecto.p4.Jugador.Jugador;
import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.Ventana.JPanels.NickPanel;
import proyecto.p4.Ventana.JPanels.SelectGamePane;
import ConnectionInterface.storableInDataBase;
import Languages.*;

public class WelcomeWindow extends JFrame implements ActionListener,KeyListener{
	
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

		//StartMusic("epicarojilarga.wav");
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
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==((OldWarriorButton) botonera.getComponent(0)).getOldWarriorButton())
		{
			botonera.setButtonP1(false);
			//new MainWindow(language,sound,selectedGame);

			Jugador j = new Jugador();
			boolean enc1 = false;
			boolean enc2 = false;
			ArrayList<storableInDataBase> array=j.takeOutFromDataBase();
			Jugador j2= new Jugador();
			Jugador j1= new Jugador();
			//Metodo buscar jugador
			for(int i = 0;i<array.size()&& (!enc1 || !enc2); i++){
				j=(Jugador) array.get(i);
				if(nicks.getNicktext().equals(j.getNick())){
					j1=j;
					enc1=true;
				}else if(nicks.getNicktext2().equals(j.getNick())){
					j2=j;
					enc2 = true;
				}
			}
			if(enc1&& enc2){
				botonera.setButtonP1(false);
				selectedGame.setJugador1(j1);
				selectedGame.setJugador2(j2);
				selectedGame.throwWindow(language,sound);
				this.dispose();
				System.out.println("fuera");
			}else if(!enc1 && !enc2){
				JOptionPane.showMessageDialog(this,language.getString("noPlayer12"),"",JOptionPane.ERROR_MESSAGE);
			}else if(!enc1){
				JOptionPane.showMessageDialog(this,language.getString("noPlayer1"),"",JOptionPane.ERROR_MESSAGE);
			}else{
				JOptionPane.showMessageDialog(this,language.getString("noPlayer2"),"",JOptionPane.ERROR_MESSAGE);
			}
			
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

	/** Reproduce el archivo de sonido .wav que se encuentra en la ruta que 
	 * recibe como atributo.
	 */
	public static void StartMusic(String ruta){
		Clip sonido = null;
		try
		{
		  sonido=AudioSystem.getClip();
		  sonido.open(AudioSystem.getAudioInputStream(new File(ruta)));
		}catch(Exception e)
		  {
			e.printStackTrace();}
		sonido.loop(Clip.LOOP_CONTINUOUSLY); //Para que se reproduzca indefinidamente
		sonido.start();
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
}
