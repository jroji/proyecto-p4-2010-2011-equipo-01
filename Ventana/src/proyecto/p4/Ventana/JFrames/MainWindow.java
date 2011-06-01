package proyecto.p4.Ventana.JFrames;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import Languages.*;

import proyecto.p4.Ventana.Button.BotoneraV;

public class MainWindow extends JFrame implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BotoneraV Buttons;
	private ResourceBundle Language;
	boolean Sound;


	BotoneraV botoneraV;
	
	public MainWindow(ResourceBundle language,boolean Sound){
		Language=language;
		this.Sound=Sound;
		Buttons=new BotoneraV(Language.getString("label_quickGame"),Language.getString("label_customGame"),
		Language.getString("label_loadGame"), Language.getString("label_options"),
	    Language.getString("label_exit"));
		this.setSize(1024,720);
		this.setLayout(null);
		ImageIcon img = new ImageIcon(getClass().getResource("/img/fondojpg.jpg"));
		JLabel fondo = new JLabel(img);
		JLayeredPane layer = new JLayeredPane();
		layer.setBounds(0, 0, 1024, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(layer, new Integer(0));
		layer.add(fondo);
		fondo.setBounds(0, 0, 1024, 720);
		layer.add(Buttons, new Integer (1));

		Buttons.setBounds(750, 150,500,500);
		this.setVisible(true);
		this.setResizable(false);
		//ActionListeners
		Buttons.getBoton1().getOldWarriorButton().addActionListener(this);
		Buttons.getBoton2().getOldWarriorButton().addActionListener(this);
		Buttons.getBoton3().getOldWarriorButton().addActionListener(this);
		Buttons.getBoton4().getOldWarriorButton().addActionListener(this);
		Buttons.getBoton5().getOldWarriorButton().addActionListener(this);
//	       while(true){
//		   		if(Buttons.getButtonP3()){
//					Buttons.setButtonP3(false);
//		   			this.dispose();
//					new OptionWindow(Language,Sound);
//				}else if(Buttons.getButtonP5()){
//					Buttons.setButtonP5(false);
//					this.dispose();
//					new WelcomeWindow(Language,Sound);
//		       }
//				else if(Buttons.getButtonP1()){
//					Buttons.setButtonP1(false);
//					this.dispose();
//		       }
//		   }
		
	}
	
	public static void main(String[] args)
	{
		MainWindow x = new MainWindow(new MyResources_En(),true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==Buttons.getBoton1().getOldWarriorButton()){
			Buttons.setButtonP1(false);
			this.dispose();
		}
		else{
			if(e.getSource()==Buttons.getBoton2().getOldWarriorButton()){
				System.out.println("boton2");
			}else{
				if(e.getSource()==Buttons.getBoton3().getOldWarriorButton()){
				}else{
					if(e.getSource()==Buttons.getBoton4().getOldWarriorButton()){
							Buttons.setButtonP3(false);
			   				this.dispose();
			   				new OptionWindow(Language,Sound);
					}else{
						if(e.getSource()==Buttons.getBoton5().getOldWarriorButton()){
							Buttons.setButtonP5(false);
							this.dispose();
							new WelcomeWindow(Language,Sound);
						}
					}
				}
			}
		}
		
	}
}
