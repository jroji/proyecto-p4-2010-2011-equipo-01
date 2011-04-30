package proyecto.p4.Ventana.Button;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class BotoneraV extends JPanel{

	private static final long serialVersionUID = -321863009831594419L;
	private OldWarriorButton boton1;
	private OldWarriorButton boton2;
	private OldWarriorButton boton3;
	private OldWarriorButton boton4;
	private OldWarriorButton boton5;
	

	public BotoneraV(String x1, String x2, String x3, String x4, String x5){
		this.setLayout(new SpringLayout());
		this.setOpaque(false);
		boton1 = new OldWarriorButton(x1);
		boton2 = new OldWarriorButton(x2);
		boton3 = new OldWarriorButton(x3);
		boton4 = new OldWarriorButton(x4);
		boton5 = new OldWarriorButton(x5);
		
//		boton1.addMouseListener(this);
//		boton2.addMouseListener(this);
//		boton3.addMouseListener(this);
//		boton4.addMouseListener(this);
//		boton5.addMouseListener(this);
//		
		
		
		this.add(boton1);
		this.add(boton2);
		this.add(boton3);
		this.add(boton4);
		this.add(boton5);
		
		if(x1.equals("")){
			boton1.setVisible(false);
		}if(x2.equals("")){
			boton2.setVisible(false);
		}if(x3.equals("")){
			boton3.setVisible(false);
		}if(x4.equals("")){
			boton4.setVisible(false);
		}if(x5.equals("")){
			boton5.setVisible(false);
		}
		
		SpringUtilities.makeCompactGrid(this,5,1,6,6,6,6);
		
	}

	public boolean getButtonP1() {
		return boton1.isPulsed();
	}
	public boolean getButtonP2() {
		return boton2.isPulsed();
	}
	public boolean getButtonP3() {
		return boton3.isPulsed();
	}
	public boolean getButtonP4() {
		return boton4.isPulsed();
	}
	public boolean getButtonP5() {
		return boton5.isPulsed();
	}
	
}
