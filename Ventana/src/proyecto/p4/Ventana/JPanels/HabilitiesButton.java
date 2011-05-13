package proyecto.p4.Ventana.JPanels;


import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;


public class HabilitiesButton extends JPanel{

	private OldWarriorButton Hability1;
	private OldWarriorButton Hability2;
	private OldWarriorButton Hability3;
	private OldWarriorButton Hability4;
	private ResourceBundle Language;
	private Hability[] Habilities;
	private OldWarriorButton[] Buttons;
	
	//public HabilitiesButton(ResourceBundle language,PiezaOldWarriorTales p){
	public HabilitiesButton(PiezaOldWarriorTales p){

//		Language=language;
		this.setOpaque(false);
		
		Buttons=new OldWarriorButton[4];
		Habilities=p.getHabilities();
		Hability1 = new OldWarriorButton("");
		Hability2 = new OldWarriorButton("");
		Hability3 = new OldWarriorButton("");
		Hability4 = new OldWarriorButton("");
		Buttons[0] = Hability1;
		Buttons[1] = Hability2;
		Buttons[2] = Hability3;
		Buttons[3] = Hability4;		
		this.setLayout(new SpringLayout());
		for(int i = 0; i<Buttons.length;i++){
	//		Buttons[i].setText(Language.getString(Habilities[i]));	
		try{
			Buttons[i].setText(Habilities[i].getName());
		}
		catch(Exception e){
			
		}
			
			this.add(Buttons[i]);
			if(Buttons[i].getText().equals(""))
				Buttons[i].setVisible(false);
			}
		

		}	
	/**
	 * Realiza una operación de actualización sobre los botones a partir de una pieza
	 * 
	 */
	public void update(PiezaOldWarriorTales piece){
		this.Habilities=piece.getHabilities();
		for(int i = 0; i<Buttons.length;i++){
			//		Buttons[i].setText(Language.getString(Habilities[i]));	
				try{
					Buttons[i].setText(Habilities[i].getName());
				}
				catch(Exception e){	
				}	
		}
		
	}
		
		
	}
