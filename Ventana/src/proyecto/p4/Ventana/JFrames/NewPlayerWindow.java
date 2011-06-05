package proyecto.p4.Ventana.JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;


import proyecto.p4.Jugador.Jugador;
import proyecto.p4.Ventana.JPanels.PlayerCreationPanel;

public class NewPlayerWindow extends JFrameFondo implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2962497854265702665L;
	PlayerCreationPanel panel;
	private ResourceBundle idioma;
	private Jugador j;
	
	public NewPlayerWindow(ResourceBundle language,boolean sound){
		idioma=language;
		this.setSize(355,330);
		panel = new PlayerCreationPanel(idioma);
		panel.setOpaque(false);
		this.add(panel);
		this.setVisible(true);
		this.setResizable(false);
		panel.getAcceptButton().getOldWarriorButton().addActionListener(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setImagen("/img/madera.jpg");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==panel.getAcceptButton().getOldWarriorButton()){
			panel.getAcceptButton().setBP(false);
			this.dispose();
			j= new Jugador(panel.getNick(),panel.getAvatar());
			j.insertIntoDataBase();
			//Guardar j en la base de datos		
		}
		
	}
	
	public static void main(String[] args){
		//new NewPlayerWindow();
	}
}
