package proyecto.p4.Ventana.JFrames;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Languages.*;

import proyecto.p4.Ventana.JPanels.ListAndImage;
import proyecto.p4.Juego.*;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;
import proyecto.p4.piezaOldWarriorTales.Unidades.Killer;
import proyecto.p4.piezaOldWarriorTales.Unidades.Magician;
import proyecto.p4.piezaOldWarriorTales.Unidades.Monk;
import proyecto.p4.piezaOldWarriorTales.Unidades.Soldier;
import proyecto.p4.piezaOldWarriorTales.Unidades.knight;


public class SelectArmy extends JFrame implements MouseListener{

     /**
	 * 
	 */
	private static final long serialVersionUID = -710066457784512920L;
	ListAndImage  x ;
     JTable table = new JTable();
     private Juego J;
	
	public SelectArmy(ResourceBundle Language,boolean Sound,Juego j)
	{
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnCount(3);
		Object [] l= {"Nombre","Vida","Mana"};
		modelo.setColumnIdentifiers(l);
		table= new JTable(modelo);
		J=j;
		x.addMouseListener(this);
		this.setSize(1024,720);
		this.setLayout(null);
		x = new ListAndImage(Language);
		this.add(x);
		this.add(table);
		
		table.setBounds(280, 320, 650,300 );
		x.setBounds(0, 0, 280, 720);
		this.setVisible(true);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==x){
			if(x.getP()==null){
			}else{
				Object[]fila=new String[3];
				fila[0] = x.getP().getType();
				fila[1] = x.getP().getLife();
				fila[2] = x.getP().getEnergy();
				modelo.addRow(fila);
			}
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
