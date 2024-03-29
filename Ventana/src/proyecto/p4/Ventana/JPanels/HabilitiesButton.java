package proyecto.p4.Ventana.JPanels;


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import proyecto.p4.PiezasOldWarriorTales.Habilidades.Hability;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.Ventana.Button.OldWarriorButton;


public class HabilitiesButton extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8645064945784497631L;
	private Hability[] Habilities;
	private OldWarriorButton[] Buttons;
	private int habilityPulsed;
	
	public HabilitiesButton(PiezaOldWarriorTales p){
		this.setOpaque(false);
		
		Buttons=new OldWarriorButton[4];
		Habilities=p.getHabilities();
		Buttons[0] = new OldWarriorButton("");
		Buttons[1] = new OldWarriorButton("");
		Buttons[2] = new OldWarriorButton("");
		Buttons[3] = new OldWarriorButton("");		
		this.setLayout(new FlowLayout());
		for(int i = 0; i<Habilities.length;i++){
			//Buttons[i].setText(Language.getString(Habilities[i].getName()));	
			Buttons[i].setText(Habilities[i].getName());
			this.add(Buttons[i]);
			if(Buttons[i].getText().equals(""))
				Buttons[i].setVisible(false);
			}
		
	Buttons[0].getOldWarriorButton().addActionListener(this);
	Buttons[1].getOldWarriorButton().addActionListener(this);
	Buttons[2].getOldWarriorButton().addActionListener(this);
	Buttons[3].getOldWarriorButton().addActionListener(this);
	}
	/**
	 * Realiza una operaci�n de actualizaci�n sobre los botones a partir de una pieza
	 * 
	 */
	public void update(PiezaOldWarriorTales piece){
		this.Habilities=piece.getHabilities();
		for(int i = 0; i<Buttons.length;i++){
					//Buttons[i].setText(Habilities[i].getName());	
				try{
					Buttons[i].setText(Habilities[i].getName());
				}	catch(Exception e){	
					Buttons[i].setText("");
					}	
		for(int j = 0;j<Buttons.length;j++){
					if(Buttons[j].getText().equals(""))
						Buttons[j].setVisible(false);
					else
						Buttons[j].setVisible(true);
		}
		}
		this.repaint();
		
	}	

	public Hability getSelectedHability(){
		return Habilities[habilityPulsed];
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Buttons[0])
			habilityPulsed=0;
		else if(e.getSource()==Buttons[1])
			habilityPulsed=1;
		else if(e.getSource()==Buttons[2]) 
			habilityPulsed=2;
		else if(e.getSource()==Buttons[3]) 
			habilityPulsed=3;
	}
}