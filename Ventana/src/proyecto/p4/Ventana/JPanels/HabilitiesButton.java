package proyecto.p4.Ventana.JPanels;


import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;


public class HabilitiesButton extends JPanel{

	private ResourceBundle Language;
	private Hability[] Habilities;
	private OldWarriorButton[] Buttons;
	private int habilityPulsed;
	
	//public HabilitiesButton(ResourceBundle language,PiezaOldWarriorTales p){
	public HabilitiesButton(PiezaOldWarriorTales p){

//		Language=language;
		this.setOpaque(false);
		
		Buttons=new OldWarriorButton[4];
		Habilities=p.getHabilities();
		Buttons[0] = new OldWarriorButton("");
		Buttons[1] = new OldWarriorButton("");
		Buttons[2] = new OldWarriorButton("");
		Buttons[3] = new OldWarriorButton("");		
		this.setLayout(new FlowLayout());
		for(int i = 0; i<Habilities.length;i++){
	//		Buttons[i].setText(Language.getString(Habilities[i].getName()));	
			Buttons[i].setText(Habilities[i].getName());
		}
		catch(Exception e){			
			System.out.println("No me cargo");
		}

			this.add(Buttons[i]);
			if(Buttons[i].getText().equals(""))
				Buttons[i].setVisible(false);
			}
		
	 while(true){
	   		if(Buttons[0].isPulsed()){
	   		habilityPulsed=0;	
			}else if(Buttons[1].isPulsed()){
			habilityPulsed=1;	
	        }else if(Buttons[2].isPulsed()){
	        habilityPulsed=2;	
			}else if(Buttons[3].isPulsed()){
			habilityPulsed=3;	
			}	
	/**
	 * Realiza una operaci�n de actualizaci�n sobre los botones a partir de una pieza
	 * 
	 */
	public void update(PiezaOldWarriorTales piece){
		this.Habilities=piece.getHabilities();
		for(int i = 0; i<Buttons.length;i++){
			//		Buttons[i].setText(Language.getString(Habilities[i].getName()));	
				try{
					Buttons[i].setText(Habilities[i].getName());
				}	catch(Exception e){	
					Buttons[i].setText("");
					}	
					if(Buttons[i].getText().equals(""))
						Buttons[i].setVisible(false);
					else
						Buttons[i].setVisible(true);

		}
		this.repaint();
		
	}
		
	public Hability  getSelectedHability(Hability h){
		return Hability[habilityPulsed];
	}
