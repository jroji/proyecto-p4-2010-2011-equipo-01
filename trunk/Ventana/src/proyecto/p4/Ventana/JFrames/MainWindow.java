package proyecto.p4.Ventana.JFrames;


import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import Languages.*;

import proyecto.p4.Juego.Juego;
import proyecto.p4.JuegoOldWarriorTales.JuegoOldWarriorTales;
import proyecto.p4.Jugador.Jugador;
import proyecto.p4.Mapa.Board;
import proyecto.p4.Piece.Colours;
import proyecto.p4.Ventana.Button.BotoneraV;
import proyecto.p4.VentanaJuego.GameWindow;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;
import proyecto.p4.piezaOldWarriorTales.Unidades.Barbarian;
import proyecto.p4.piezaOldWarriorTales.Unidades.Magician;
import proyecto.p4.piezaOldWarriorTales.Unidades.knight;

public class MainWindow extends JFrame implements ActionListener, MouseListener{
	private static final long serialVersionUID = 1L;
	BotoneraV Buttons;
	private ResourceBundle Language;
	boolean Sound;
	private Juego selectedGame;
	static Clip sonido = null;
	boolean sonando;
	JLabel helpButton;
	BotoneraV botoneraV;
	
	public MainWindow(ResourceBundle language,boolean Sound, Juego ju){
		selectedGame=ju;
		Language=language;
		this.Sound=Sound;
		Buttons=new BotoneraV(Language.getString("label_quickGame"),Language.getString("label_customGame"),
		Language.getString("label_loadGame"), Language.getString("label_options"),
	    Language.getString("label_exit"));
		this.setSize(1024,720);
		this.setLayout(null);
		helpButton = new JLabel(new ImageIcon(getClass().getResource("/img/botontutorial.png")));
		ImageIcon img = new ImageIcon(getClass().getResource("/img/fondojpg.jpg"));
		JLabel fondo = new JLabel(img);
		JLayeredPane layer = new JLayeredPane();
		layer.setBounds(0, 0, 1024, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(layer, new Integer(0));
		layer.add(fondo);
		fondo.setBounds(0, 0, 1024, 720);
		layer.add(Buttons, new Integer (1));
		layer.add(helpButton, new Integer (2));
		
		helpButton.setBounds(900, 600, 100, 100);
		Buttons.setBounds(750, 150,500,500);
		this.setVisible(true);
		this.setResizable(false);
		//ActionListeners
		Buttons.getBoton1().getOldWarriorButton().addActionListener(this);
		Buttons.getBoton2().getOldWarriorButton().addActionListener(this);
		Buttons.getBoton3().getOldWarriorButton().addActionListener(this);
		Buttons.getBoton4().getOldWarriorButton().addActionListener(this);
		Buttons.getBoton5().getOldWarriorButton().addActionListener(this);
		helpButton.addMouseListener(this);

		if(Sound&&!sonando){
			StartMusic("epicarojilarga.wav");
			sonando = true ;
		}
		else{
			//sonido.stop();
		}
			
	}

	/** Reproduce el archivo de sonido .wav que se encuentra en la ruta que 
	 * recibe como atributo.
	 */

	public static void StartMusic(String ruta){
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==Buttons.getBoton1().getOldWarriorButton()){
			Buttons.setButtonP1(false);

			Board z = new Board();

			Arquero arq = new Arquero();
			arq.setBoard(z);
			arq.setPosition(10, 5);
			arq.setColor(Colours.blanco);
			arq.setLife(5);
			arq.setEnergy(34);
			arq.setExperience(67);
			
			Arquero arq2 = new Arquero();
			arq2.setBoard(z);
			arq2.setPosition(10, 10);
			arq2.setColor(Colours.blanco);
			arq2.setLife(77);

			Magician mag = new Magician();
			mag.setPosition(11,12);
			mag.setColor(Colours.blanco);
			mag.setBoard(z);
			z.getBoard()[11][12].setPiece(mag);

			knight kill = new knight();
			kill.setBoard(z);
			kill.setPosition(2,2);
			kill.setColor(Colours.negro);
			z.getBoard()[2][2].setPiece(kill);
			
			Barbarian bar = new Barbarian();
			bar.setBoard(z);
			bar.setColor(Colours.negro);
			bar.setPosition(5, 5);
			
			z.getBoard()[5][5].setPiece(bar);
			z.getBoard()[10][10].setPiece(arq2);
			z.getBoard()[10][5].setPiece(arq);
			selectedGame.setTablero(z);
			
			new GameWindow((JuegoOldWarriorTales) selectedGame);
			this.dispose();
		}
		else{
			if(e.getSource()==Buttons.getBoton2().getOldWarriorButton()){
				this.dispose();
				System.out.println(selectedGame);
				new MapGoldSelectionWindows(Language,Sound,selectedGame);
			}else{
				if(e.getSource()==Buttons.getBoton3().getOldWarriorButton()){
				}else{
					if(e.getSource()==Buttons.getBoton4().getOldWarriorButton()){
							Buttons.setButtonP3(false);
			   				this.dispose();
			   				new OptionWindow(Language,Sound,selectedGame);
					}else{
						if(e.getSource()==Buttons.getBoton5().getOldWarriorButton()){
							Buttons.setButtonP5(false);
							this.dispose();
							new WelcomeWindow(Language,Sound);
						}
					}
				}
			}
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==helpButton)
		{
			helpButton.setIcon(new ImageIcon(getClass().getResource("/img/botontutorialpulsado.png")));
			try {
				Desktop.getDesktop().open(new File ("src/TUTORIAL.pdf"));
			} catch (IOException e1) {
				JOptionPane.showMessageDialog(null, "Archivo de ayuda no disponible", "Warning", JOptionPane.ERROR_MESSAGE, null);
			} 
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==helpButton)
			helpButton.setIcon(new ImageIcon(getClass().getResource("/img/botontutorial.png")));
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
