package proyecto.p4.Ventana.JFrames;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import Languages.*;

import proyecto.p4.Ventana.Button.BotoneraV;

public class MainWindow extends JFrame implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BotoneraV Buttons;
	private ResourceBundle Language;
	


	BotoneraV botoneraV;
	
	public MainWindow(ResourceBundle language,boolean Sound){
		Language=language;
		Buttons=new BotoneraV(Language.getString("label_quickGame"),Language.getString("label_customGame"),
		Language.getString("label_options"), "",
	    Language.getString("label_exit"));
		this.setSize(1024,720);
		this.setLayout(null);
		ImageIcon img = new ImageIcon(getClass().getResource("/img/fondojpg.jpg"));
		JLabel fondo = new JLabel(img);
		JLayeredPane layer = new JLayeredPane();
		layer.setBounds(0, 0, 1024, 720);
		
		this.add(layer, new Integer(0));
		layer.add(fondo);
		fondo.setBounds(0, 0, 1024, 720);
		botoneraV = new BotoneraV("Partida Rápida", "P. Personalizada", "Opciones", "Editor de mapas", "   Salir");
		layer.add(botoneraV, new Integer (1));

		layer.add(Buttons, new Integer (1));

		
		Buttons.setBounds(750, 150,500,500);
		this.setVisible(true);
		this.setResizable(false);
	       while(true){
		   		if(Buttons.getButtonP3()){
					Buttons.setButtonP3(false);
		   			this.dispose();
					new OptionWindow(Language,Sound);
				}else if(Buttons.getButtonP5()){
					Buttons.setButtonP5(false);
					this.dispose();
					new WelcomeWindow(Language,Sound);
		       }
				else if(Buttons.getButtonP1()){
					Buttons.setButtonP1(false);
					this.dispose();
					
					
		       }
		   }
		
	}

	public static void main(String[] args)
	{
		MainWindow x = new MainWindow(new MyResources_En(),true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		if(botoneraV.getButtonP3()){
			this.dispose();
		}else if(botoneraV.getButtonP4()){
			this.dispose();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
