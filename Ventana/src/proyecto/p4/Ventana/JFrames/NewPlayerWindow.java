package proyecto.p4.Ventana.JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import ConnectionInterface.PieceJDBC;
import ConnectionInterface.storableInDataBase;
import Languages.MyResources_En;

import proyecto.p4.Jugador.Jugador;
import proyecto.p4.Ventana.JPanels.PlayerCreationPanel;
import proyecto.p4.piezaOldWarriorTales.Unidades.Killer;

public class NewPlayerWindow extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2962497854265702665L;
	PlayerCreationPanel panel;
	private ResourceBundle idioma;
	private boolean sonido;
	private Jugador j;
	
	public NewPlayerWindow(ResourceBundle language,boolean sound){
		idioma=language;
		sonido=sound;
		this.setSize(355,330);
		panel = new PlayerCreationPanel(idioma);
		this.add(panel);
		this.setVisible(true);
		this.setResizable(false);
		panel.getAcceptButton().getOldWarriorButton().addActionListener(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==panel.getAcceptButton().getOldWarriorButton()){
			panel.getAcceptButton().setBP(false);
			this.dispose();
			j= new Jugador(panel.getNick(),panel.getAvatar());
			//Guardar j en la base de datos
			PieceJDBC p;
			try {
				p = new PieceJDBC();
				p.insert("Jugador", j);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public static void main(String[] args){
		//new NewPlayerWindow();
	}
}
