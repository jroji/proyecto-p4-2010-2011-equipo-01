package proyecto.p4.Ventana.JFrames;

import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JTable;

import proyecto.p4.Ventana.JPanels.ListAndImage;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;
import proyecto.p4.piezaOldWarriorTales.Unidades.Killer;
import proyecto.p4.piezaOldWarriorTales.Unidades.Magician;
import proyecto.p4.piezaOldWarriorTales.Unidades.Monk;
import proyecto.p4.piezaOldWarriorTales.Unidades.Soldier;
import proyecto.p4.piezaOldWarriorTales.Unidades.knight;


public class SelectArmy extends JFrame{

     /**
	 * 
	 */
	private static final long serialVersionUID = -710066457784512920L;
	ListAndImage  x ;
     JTable table = new JTable();
	
	public SelectArmy(ResourceBundle Language,boolean Sound)
	{
		this.setSize(1024,720);
		this.setLayout(null);
		x = new ListAndImage(Language);
		this.add(x);
		this.add(table);
		
		table.setBounds(280, 320, 650,300 );
		x.setBounds(0, 0, 280, 720);
		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		SelectArmy x = new SelectArmy(null, false);
	}
}
