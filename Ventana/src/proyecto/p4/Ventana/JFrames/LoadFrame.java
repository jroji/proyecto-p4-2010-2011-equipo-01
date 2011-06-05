package proyecto.p4.Ventana.JFrames;

import java.util.ResourceBundle;

import javax.swing.JFrame;

import Languages.MyResources_Es;

import proyecto.p4.Ventana.JPanels.LoadPanel;

public class LoadFrame extends JFrame{

	LoadPanel loadPanel;
	
	public LoadFrame(ResourceBundle language){
		loadPanel = new LoadPanel(language);
		this.setVisible(true);
		this.add(loadPanel);
		this.setSize(loadPanel.getWidth(),loadPanel.getHeight());
		}
	
	public static void main(String[] args){
		new LoadFrame(new MyResources_Es());
	}
}
