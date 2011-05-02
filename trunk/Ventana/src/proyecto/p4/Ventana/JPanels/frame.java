package proyecto.p4.Ventana.JPanels;

import javax.swing.JFrame;

import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;

public class frame extends JFrame{
	
	public frame(){
		this.setSize(250,250);
		Arquero arq = new Arquero();
		UnitData x = new UnitData(arq);
		this.add(x);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		new frame();
	}

}
