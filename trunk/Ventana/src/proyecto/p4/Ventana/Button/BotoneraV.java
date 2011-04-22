package proyecto.p4.Ventana.Button;

import javax.swing.JPanel;

public class BotoneraV extends JPanel{
	OldWarriorButton boton1;
	OldWarriorButton boton2;
	OldWarriorButton boton3;
	OldWarriorButton boton4;
	OldWarriorButton boton5;

	public BotoneraV(String x1, String x2, String x3, String x4, String x5){
		this.setSize(300,600);
		boton1 = new OldWarriorButton(x1);
		boton2 = new OldWarriorButton(x2);
		boton3 = new OldWarriorButton(x3);
		boton4 = new OldWarriorButton(x4);
		boton5 = new OldWarriorButton(x5);
		
		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		this.add(boton4);
		this.add(boton5);

		
	}

	
}
