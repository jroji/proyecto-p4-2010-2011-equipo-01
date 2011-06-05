package proyecto.p4.Ventana.JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;

import Languages.MyResources_Es;
import proyecto.p4.Juego.Juego;
import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.Ventana.JPanels.LoadPanel;

public class LoadFrame extends JFrame implements ActionListener {

	LoadPanel loadPanel;
	BotoneraH botonera;
	ResourceBundle language;
	Juego j;
	boolean sound;
	
	public LoadFrame(ResourceBundle language,boolean Sound,Juego j){
		
		this.sound=Sound;
		this.language=language;
		this.j=j;
		botonera= loadPanel.getBotonera();
		this.setResizable(false);
		loadPanel = new LoadPanel(language);
		
		((OldWarriorButton)botonera.getComponent(0)).getOldWarriorButton().addActionListener(this);
		((OldWarriorButton)botonera.getComponent(1)).getOldWarriorButton().addActionListener(this);
		((OldWarriorButton)botonera.getComponent(2)).getOldWarriorButton().addActionListener(this);	 
		
		this.setVisible(true);
		this.add(loadPanel);
		this.setSize(loadPanel.getWidth(),loadPanel.getHeight());
		}
	
//	public static void main(String[] args){
//		new LoadFrame(new MyResources_Es());
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==((OldWarriorButton)botonera.getComponent(0)).getOldWarriorButton()){
			
		}else if(e.getSource()==((OldWarriorButton)botonera.getComponent(1)).getOldWarriorButton()){
			
		}else if(e.getSource()==((OldWarriorButton)botonera.getComponent(2)).getOldWarriorButton()){
			this.dispose();
			new MainWindow(language, sound, j);
		}
	}
}
