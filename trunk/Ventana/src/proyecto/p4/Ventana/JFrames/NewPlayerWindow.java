package proyecto.p4.Ventana.JFrames;

import javax.swing.JFrame;

import proyecto.p4.piezaOldWarriorTales.Unidades.Killer;

public class NewPlayerWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2962497854265702665L;

	public NewPlayerWindow(){
		this.setSize(400,400);
		PlayerCreationPanel x = new PlayerCreationPanel();
		this.add(x);
		this.setVisible(true);
		
		  while(true){
          	if(x.getAcceptButton().isPulsed()){
          		x.getAcceptButton().setBP(false);
          		this.dispose();
          	}
          }

	}
	
	public static void main(String[] args){
		new NewPlayerWindow();
	}

}
