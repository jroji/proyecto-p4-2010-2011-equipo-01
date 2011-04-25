package proyecto.p4.Ventana.Button;



import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.SpringLayout;

public class BotoneraV extends JPanel implements MouseListener{

	private static final long serialVersionUID = -321863009831594419L;
	private OldWarriorButton boton1;
	private OldWarriorButton boton2;
	private OldWarriorButton boton3;
	private OldWarriorButton boton4;
	private OldWarriorButton boton5;
	private int ButtonP;
	

	public BotoneraV(String x1, String x2, String x3, String x4, String x5){
		this.setLayout(new SpringLayout());
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
		
		SpringUtilities.makeCompactGrid(this,5,1,6,6,6,6);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getComponent()==boton1){
			ButtonP=1;
		}
		if(e.getComponent()==boton2){
			ButtonP=2;
		}
		if(e.getComponent()==boton3){
			ButtonP=3;
		}
		if(e.getComponent()==boton4){
			ButtonP=4;
		}
		if(e.getComponent()==boton5){
			ButtonP=5;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public int getButtonP(){
		return ButtonP;
	}

	
}
