import java.util.ResourceBundle;

import javax.swing.JPanel;
import javax.swing.SpringLayout;
import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.Ventana.Button.OldWarriorButton;


public class HabilitiesButton extends JPanel{

	private OldWarriorButton Hability1;
	private OldWarriorButton Hability2;
	private OldWarriorButton Hability3;
	private OldWarriorButton Hability4;
	private BotoneraH ButtonDown;
	private ResourceBundle Language;
	private habilities[] Habilities;
	private OldWarriorButton[] Buttons;
	
	public HabilitiesButton(ResourceBundle language,PiezaOldWarriorTales p){
		Language=language;
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
		for(int i = 0; i<Habilities.length();i++){
			Buttons[i].setText(Language.getString(Habilities[i]));	
			this.add(Buttons[i]);
			}
		}	
		
		SpringUtilities.makeCompactGrid(this,2,2,6,6,6,6);
		
	}
}
