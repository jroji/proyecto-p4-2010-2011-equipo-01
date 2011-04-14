import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Proyecto.p4.mapa.Board;


public class GamePanel extends JPanel{
	

	private static final long serialVersionUID = 1L;

	 static MapPanel mapPanel;
	 static TranslationPanel translatePanelI = new TranslationPanel();
	 static TranslationPanel translatePanelD = new TranslationPanel();
	 TranslationPanel translatePanelAr = new TranslationPanel();
	 TranslationPanel translatePanelAb = new TranslationPanel();
	
	public GamePanel(Board map){
		setSize(800,700);
		mapPanel = new MapPanel(map);
		setLayout(null);
		add(translatePanelI);
		add(translatePanelD);
		translatePanelI.setSize(40, 700);
		
		add(mapPanel);
		
		setVisible(true);
		int i = -200;
		mapPanel.setBounds(i, 0, 1000, 700);
		translatePanelD.setBounds(this.getWidth()-60, 0, 50, 700);
		while(true){
			Move();
		}
		}
	
	public static void Move(){
		while(mapPanel.getX()<0){
			if(translatePanelI.isMover()){
				mapPanel.setLocation(mapPanel.getX()+1, mapPanel.getY());
			}
		}
		while(mapPanel.getX()>-200){
			if(translatePanelD.isMover()){
				System.out.println();
				mapPanel.setLocation(mapPanel.getX()-1, mapPanel.getY());
			}
		}
		
	}

//public static void main(String[] args){
//	Test x = new Test();
//	while(true){
//		Move();
//}
//}
}
