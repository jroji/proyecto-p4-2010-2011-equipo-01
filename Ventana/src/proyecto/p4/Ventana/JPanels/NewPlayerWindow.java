package proyecto.p4.Ventana.JPanels;

import Languages.MyResources_En;
import proyecto.p4.Ventana.JFrames.JFrameFondo;

public class NewPlayerWindow extends JFrameFondo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2962497854265702665L;

	public NewPlayerWindow(){
		this.setSize(400,400);
		PlayerCreationPanel x = new PlayerCreationPanel(new MyResources_En());
		x.setOpaque(false);
		this.add(x);
		this.setVisible(true);
		setImagen("/img/madera.jpg");

	}
	
	public static void main(String[] args){
		new NewPlayerWindow();
	}

}
