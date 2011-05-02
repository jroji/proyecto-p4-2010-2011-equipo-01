package proyecto.p4.Ventana.JFrames;

import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import proyecto.p4.Ventana.Button.BotoneraV;

public class MainWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BotoneraV Buttons = new BotoneraV();
	private ResourceBundle Language;
	

	public MainWindow(ResourceBundle language,boolean Sound){
		Language=language;
		Buttons=new BotoneraV(Language.getBundle("MyResource_Fr").getString("label_quickGame"),Language.getBundle("MyResource_Fr").getString("label_customGame"),
					  Language.getBundle("MyResource_Fr").getString("label_options"), Language.getBundle("MyResource_Fr").getString("label_mapEditor"),
					  Language.getBundle("MyResource_Fr").getString("label_exit"));
		}
		this.setSize(1024,720);
		this.setLayout(null);
		ImageIcon img = new ImageIcon(getClass().getResource("/img/fondojpg.jpg"));
		JLabel fondo = new JLabel(img);
		JLayeredPane layer = new JLayeredPane();
		layer.setBounds(0, 0, 1024, 720);
		
		this.add(layer, new Integer(0));
		layer.add(fondo);
		fondo.setBounds(0, 0, 1024, 720);
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

//	public static void main(String[] args)
//	{
//		MainWindow x = new MainWindow();
//		       while(true){
//		   		if(Buttons.getButtonP3()){
//					x.dispose();
//					new OptionWindow();
//					Buttons.setButtonP3(false);
//				}else if(Buttons.getButtonP5()){
//					x.dispose();
//					Buttons.setButtonP5(false);
//					
//		       }
//		   }
//	}
}
