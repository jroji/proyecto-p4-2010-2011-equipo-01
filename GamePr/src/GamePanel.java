import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


//public class GamePanel extends JFrame{
public class GamePanel extends JPanel implements MouseListener{
	

	 boolean mover = false;
	 MapPanel mapPanel;
	 TranslationPanel translatePanelI = new TranslationPanel();
	 TranslationPanel translatePanelD = new TranslationPanel();
	 TranslationPanel translatePanelAr = new TranslationPanel();
	 TranslationPanel translatePanelAb = new TranslationPanel();
	 JLayeredPane layer = new JLayeredPane();
	
//	public GamePanel(Board map){
	 public GamePanel(){
		setSize(800,550);
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
		
		translatePanelI.addMouseListener(this);
		translatePanelD.addMouseListener(this);
		translatePanelAr.addMouseListener(this);
		translatePanelAb.addMouseListener(this);
		
		layer.add(mapPanel, new Integer(0));
		

		}

	 /**Método para el movimiento de la pantalla de juego a traves de los métodos de 
	  * la clase TranslatePanel. 
	  */
	public void Move(){
			while(translatePanelI.isMover()&&mapPanel.getX()<0){
				mapPanel.setLocation(mapPanel.getX()+1, mapPanel.getY());
			}
			while(translatePanelD.isMover()&&mapPanel.getX()>-600){
				mapPanel.setLocation(mapPanel.getX()-1, mapPanel.getY());
			}
			while(translatePanelAr.isMover()&&mapPanel.getY()<60){
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mover=true;
		while(mover)
		this.Move();	
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mover=false;
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

//public static void main(String[] args){
//
//	StartMusic("C:/Users/Jon/workspace/GamePr/epicarojilarga.wav");
//	GamePanel x = new GamePanel();
//	MapPanel mapa = new MapPanel();
//	x.add(mapa);
//}
}
