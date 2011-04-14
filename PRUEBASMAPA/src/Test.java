import javax.swing.JFrame;
import javax.swing.JLabel;


public class Test extends JFrame{
	

	private static final long serialVersionUID = 1L;

	static MapPanel mapPanel = new MapPanel();
	static TranslationPanel translatePanelI = new TranslationPanel();
	static TranslationPanel translatePanelD = new TranslationPanel();
	static TranslationPanel translatePanelAr = new TranslationPanel();
	static TranslationPanel translatePanelAb = new TranslationPanel();
	
	public Test(){
		setSize(800,700);
		setLayout(null);
		add(translatePanelI);
		add(translatePanelD);
		translatePanelI.setSize(50, 700);
		
		add(mapPanel);
		
		setVisible(true);
		int i = -200;
		mapPanel.setBounds(i, 0, 1000, 700);
		translatePanelD.setBounds(this.getWidth()-50, 0, 50, 700);
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

public static void main(String[] args){
	Test x = new Test();
	while(true){
		Move();
}
}
}
