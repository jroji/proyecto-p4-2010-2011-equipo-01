package proyecto.p4.Ventana.JFrames;


import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.Ventana.Button.BotoneraV;
import proyecto.p4.VentanaJuego.GameWindow;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;
import proyecto.p4.piezaOldWarriorTales.Unidades.Barbarian;
import proyecto.p4.piezaOldWarriorTales.Unidades.Killer;
import proyecto.p4.piezaOldWarriorTales.Unidades.King;
import proyecto.p4.piezaOldWarriorTales.Unidades.Magician;
import proyecto.p4.piezaOldWarriorTales.Unidades.Monk;
import proyecto.p4.piezaOldWarriorTales.Unidades.Soldier;
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
			sonido.stop();
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

			ArrayList<PiezaOldWarriorTales> array = new ArrayList<PiezaOldWarriorTales>() ;
			ArrayList<PiezaOldWarriorTales> array2 = new ArrayList<PiezaOldWarriorTales>() ;

			
			Board z = new Board();
		
			
			Killer ass = new Killer();
			ass.setBoard(z);
			ass.setColor(Colours.rojo);
//			ass.setPosition(0, 4);
//			z.getBoard()[0][4].setPiece(ass);
			
			Killer ass2 = new Killer();
			ass2.setBoard(z);
			ass2.setColor(Colours.azul);
//			ass2.setPosition(13, 4);
//			z.getBoard()[13][4].setPiece(ass2);

			Arquero arq = new Arquero();
			arq.setBoard(z);
//			arq.setPosition(0, 5);
			arq.setColor(Colours.rojo);
//			z.getBoard()[0][5].setPiece(arq);
			
			Arquero arq2 = new Arquero();
			arq2.setBoard(z);
//			arq2.setPosition(13, 5);
			arq2.setColor(Colours.azul);
//			z.getBoard()[13][5].setPiece(arq2);

			Magician mag = new Magician();
//			mag.setPosition(0,8);
			mag.setColor(Colours.rojo);
			mag.setBoard(z);
//			z.getBoard()[0][8].setPiece(mag);
			
			Magician mag2 = new Magician();
//			mag2.setPosition(13,8);
			mag2.setColor(Colours.azul);
			mag2.setBoard(z);
//			z.getBoard()[13][8].setPiece(mag2);

			knight kill = new knight();
			kill.setBoard(z);
//			kill.setPosition(0,7);
			kill.setColor(Colours.rojo);
//			z.getBoard()[0][7].setPiece(kill);
			
			knight kill2 = new knight();
			kill2.setBoard(z);
//			kill2.setPosition(13,7);
			kill2.setColor(Colours.azul);
//			z.getBoard()[13][7].setPiece(kill2);
			
			King king = new King();
			king.setBoard(z);
//			king.setPosition(0, 6);
			king.setColor(Colours.rojo);
//			z.getBoard()[0][6].setPiece(king);
			
			King king2 = new King();
			king2.setBoard(z);
//			king2.setPosition(13, 6);
			king2.setColor(Colours.azul);
//			z.getBoard()[13][6].setPiece(king2);
			
			Barbarian bar = new Barbarian();
			bar.setBoard(z);
			bar.setColor(Colours.rojo);
//			bar.setPosition(0, 9);
//			z.getBoard()[0][9].setPiece(bar);
			
			Barbarian bar2 = new Barbarian();
			bar2.setBoard(z);
			bar2.setColor(Colours.azul);
//			bar2.setPosition(13, 9);
//			z.getBoard()[13][9].setPiece(bar2);
			
			Monk monje = new Monk();
			monje.setBoard(z);
			monje.setColor(Colours.rojo);
//			monje.setPosition(0, 10);
//			z.getBoard()[0][10].setPiece(monje);
			
			Monk monje2 = new Monk();
			monje2.setBoard(z);
			monje2.setColor(Colours.azul);
//			monje2.setPosition(13, 10);
//			z.getBoard()[13][10].setPiece(monje2);
			
			Soldier sold = new Soldier();
			sold.setBoard(z);
			sold.setColor(Colours.rojo);
//			sold.setPosition(0, 11);
//			z.getBoard()[0][11].setPiece(sold);
			
			Soldier sold2 = new Soldier();
			sold2.setBoard(z);
			sold2.setColor(Colours.azul);
//			sold2.setPosition(13, 11);
//			z.getBoard()[13][10].setPiece(sold2);
			
			array.add(king);
			array.add(arq);
			array.add(kill);
			array.add(ass);
			array.add(sold);
			array.add(monje);
			array.add(mag);
			array.add(bar);
			
			array2.add(king2);
			array2.add(arq2);
			array2.add(kill2);
			array2.add(ass2);
			array2.add(sold2);
			array2.add(monje2);
			array2.add(mag2);
			array2.add(bar2);
			
			
			colocarUnidades(array, z);
			colocarUnidades(array2, z);
			
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
					this.dispose();
					new LoadFrame(Language,Sound,selectedGame);
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
	
	public void colocarUnidades(ArrayList<PiezaOldWarriorTales> array, Board z){
		int indice = 1;
	try{
		if(array.get(0).getColor().equals(Colours.rojo)){
			array.get(0).setPosition(0, 6);
			z.getBoard()[0][6].setPiece(array.get(0));
			for(int i = 1;i<=2;i++){
				for(int j = 0;j<i+1;j++){
					array.get(indice).setPosition(array.get(0).getPosition_x()+j, array.get(0).getPosition_y()-i);
					z.getBoard()[array.get(0).getPosition_x()+j][array.get(0).getPosition_y()-i].setPiece(array.get(indice));
					indice++;
				}
				if(i==2){
					array.get(indice).setPosition(array.get(0).getPosition_x()+i, array.get(0).getPosition_y()-1);
					z.getBoard()[array.get(0).getPosition_x()+i][array.get(0).getPosition_y()-1].setPiece(array.get(indice));
					indice++;
				}
				array.get(indice).setPosition(array.get(0).getPosition_x()+i, array.get(0).getPosition_y());
				z.getBoard()[array.get(0).getPosition_x()+i][array.get(0).getPosition_y()].setPiece(array.get(indice));
				indice++;
				if(i==2){
					array.get(indice).setPosition(array.get(0).getPosition_x()+i, array.get(0).getPosition_y()+1);
					z.getBoard()[array.get(0).getPosition_x()+i][array.get(0).getPosition_y()+1].setPiece(array.get(indice));
					indice++;
				}
				for(int j = i;j>=0;j--){
					array.get(indice).setPosition(array.get(0).getPosition_x()+j, array.get(0).getPosition_y()+i);
					z.getBoard()[array.get(0).getPosition_x()+j][array.get(0).getPosition_y()+i].setPiece(array.get(indice));
					indice++;
				}
			}	
		
		}
		else{
			array.get(0).setPosition(13, 6);
			z.getBoard()[13][6].setPiece(array.get(0));
			for(int i = 1;i<=2;i++){
				for(int j = 0;j<i+1;j++){
					array.get(indice).setPosition(array.get(0).getPosition_x()-j, array.get(0).getPosition_y()+i);
					z.getBoard()[array.get(0).getPosition_x()-j][array.get(0).getPosition_y()+i].setPiece(array.get(indice));
					indice++;
				}
				if(i==2){
					array.get(indice).setPosition(array.get(0).getPosition_x()-i, array.get(0).getPosition_y()+1);
					z.getBoard()[array.get(0).getPosition_x()-i][array.get(0).getPosition_y()+1].setPiece(array.get(indice));
					indice++;
				}
				array.get(indice).setPosition(array.get(0).getPosition_x()-i, array.get(0).getPosition_y());
				z.getBoard()[array.get(0).getPosition_x()-i][array.get(0).getPosition_y()].setPiece(array.get(indice));
				indice++;
				if(i==2){
					array.get(indice).setPosition(array.get(0).getPosition_x()-i, array.get(0).getPosition_y()-1);
					z.getBoard()[array.get(0).getPosition_x()-i][array.get(0).getPosition_y()-1].setPiece(array.get(indice));
					indice++;
				}
				for(int j = i;j>=0;j--){
					array.get(indice).setPosition(array.get(0).getPosition_x()-j, array.get(0).getPosition_y()-i);
					z.getBoard()[array.get(0).getPosition_x()-j][array.get(0).getPosition_y()-i].setPiece(array.get(indice));
					indice++;
				}
			}
		}
			
		
	}
	catch(Exception ex){
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
