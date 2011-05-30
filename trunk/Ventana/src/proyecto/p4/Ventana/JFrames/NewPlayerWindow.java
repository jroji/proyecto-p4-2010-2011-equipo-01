package proyecto.p4.Ventana.JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import Languages.MyResources_En;

import proyecto.p4.Ventana.JPanels.PlayerCreationPanel;
import proyecto.p4.piezaOldWarriorTales.Unidades.Killer;

public class NewPlayerWindow extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2962497854265702665L;
	PlayerCreationPanel panel;
	
	public NewPlayerWindow(){
		this.setSize(355,330);
		panel = new PlayerCreationPanel(new MyResources_En());
		this.add(panel);
		this.setVisible(true);
		this.setResizable(false);
		panel.getAcceptButton().getOldWarriorButton().addActionListener(this);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		  while(true){
//          	if(x.getAcceptButton().isPulsed()){
//          		x.getAcceptButton().setBP(false);
//          		this.dispose();
//          	}
//          }

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==panel.getAcceptButton().getOldWarriorButton()){
			panel.getAcceptButton().setBP(false);
			this.dispose();
		}
		
	}
	
	public static void main(String[] args){
		new NewPlayerWindow();
	}
}
