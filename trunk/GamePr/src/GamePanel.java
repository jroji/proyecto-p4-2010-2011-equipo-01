import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class GamePanel extends JFrame{
//public class GamePanel extends JPanel{
	

	private static final long serialVersionUID = 1L;

	 MapPanel mapPanel;
	 TranslationPanel translatePanelI = new TranslationPanel();
	 TranslationPanel translatePanelD = new TranslationPanel();
	 TranslationPanel translatePanelAr = new TranslationPanel();
	 TranslationPanel translatePanelAb = new TranslationPanel();
	 JLayeredPane layer = new JLayeredPane();
	
//	public GamePanel(Board map){
	 public GamePanel(){
		setSize(850,700);
		//mapPanel = new MapPanel(map);
		mapPanel = new MapPanel();
		setLayout(null);
		this.add(layer);
		
		layer.setBounds(0,0,this.getWidth(), this.getHeight());
		
		layer.add(translatePanelI, new Integer(1));
		layer.add(translatePanelD, new Integer(1));
		layer.add(translatePanelAr, new Integer(2));
		layer.add(translatePanelAb, new Integer(2));
		
		
		setVisible(true);
		int i = -200;
		
		mapPanel.setBounds(i, 0, 1500, 1000);
		translatePanelI.setBounds(0, 0, 60, this.getWidth());
		translatePanelD.setBounds(this.getWidth()-60, 0, 60, this.getHeight());
		translatePanelAr.setBounds(0, 0, this.getWidth(), 60);
		translatePanelAb.setBounds(0, this.getHeight()-90, this.getWidth(), 60);
		
		layer.add(mapPanel, new Integer(0));
		
		while(true){
			Move();
		}
		}

	 /**M�todo para el movimiento de la pantalla de juego a traves de los m�todos de 
	  * la clase TranslatePanel. 
	  */
	public void Move(){
			while(translatePanelI.isMover()&&mapPanel.getX()<0){
				mapPanel.setLocation(mapPanel.getX()+1, mapPanel.getY());
			}
			while(translatePanelD.isMover()&&mapPanel.getX()>-600){
				mapPanel.setLocation(mapPanel.getX()-1, mapPanel.getY());
			}
			while(translatePanelAr.isMover()&&mapPanel.getY()<0){
				mapPanel.setLocation(mapPanel.getX(), mapPanel.getY()+1);
			}		
			while(translatePanelAb.isMover()&&mapPanel.getY()>-350){
				mapPanel.setLocation(mapPanel.getX(), mapPanel.getY()-1);
			}
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
			System.out.println("Error: "+e);}
		sonido.loop(Clip.LOOP_CONTINUOUSLY); //Para que se reproduzca indefinidamente
		sonido.start();
	}

public static void main(String[] args){

	StartMusic("C:/Users/Jon/workspace/GamePr/epicarojilarga.wav");
	GamePanel x = new GamePanel();
	MapPanel mapa = new MapPanel();
	x.add(mapa);
}
}
