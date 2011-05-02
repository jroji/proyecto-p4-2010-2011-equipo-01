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
	

	public MainWindow(String Language,boolean Sound){
		if(Language.equals("Spanish")){
			Buttons=new BotoneraV(ResourceBundle.getBundle("MyResource_Es").getString("label_quickGame"),ResourceBundle.getBundle("MyResource_Es").getString("label_customGame"),
							  ResourceBundle.getBundle("MyResource_Es").getString("label_options"), ResourceBundle.getBundle("MyResource_Es").getString("label_mapEditor"),
							  ResourceBundle.getBundle("MyResource_Es").getString("label_exit"));
		}else if(Language.equals("English")){
			Buttons=new BotoneraV(ResourceBundle.getBundle("MyResource_En").getString("label_quickGame"),ResourceBundle.getBundle("MyResource_En").getString("label_customGame"),
					  ResourceBundle.getBundle("MyResource_En").getString("label_options"), ResourceBundle.getBundle("MyResource_En").getString("label_mapEditor"),
					  ResourceBundle.getBundle("MyResource_En").getString("label_exit"));	
		}else if(Language.equals("French")){
			Buttons=new BotoneraV(ResourceBundle.getBundle("MyResource_Fr").getString("label_quickGame"),ResourceBundle.getBundle("MyResource_Fr").getString("label_customGame"),
					  ResourceBundle.getBundle("MyResource_Fr").getString("label_options"), ResourceBundle.getBundle("MyResource_Fr").getString("label_mapEditor"),
					  ResourceBundle.getBundle("MyResource_Fr").getString("label_exit"));
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
