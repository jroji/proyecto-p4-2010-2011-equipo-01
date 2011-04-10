import javax.swing.JFrame;
import javax.swing.JLabel;


public class Test extends JFrame{
	

	private static final long serialVersionUID = 1L;

	static MapPanel mapPanel = new MapPanel();
	
	
	public Test(){
		setSize(800,700);
		setLayout(null);
		
		add(mapPanel);
		
		setVisible(true);
		int i = -200;
		mapPanel.setBounds(i, 0, 1000, 700);
		}

public static void main(String[] args){
	Test x = new Test();
}
}
