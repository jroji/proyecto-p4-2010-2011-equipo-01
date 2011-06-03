package proyecto.p4.Ventana.JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Languages.*;

import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.Ventana.JPanels.ListAndImage;
import proyecto.p4.Juego.*;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;
import proyecto.p4.piezaOldWarriorTales.Unidades.Killer;
import proyecto.p4.piezaOldWarriorTales.Unidades.Magician;
import proyecto.p4.piezaOldWarriorTales.Unidades.Monk;
import proyecto.p4.piezaOldWarriorTales.Unidades.Soldier;
import proyecto.p4.piezaOldWarriorTales.Unidades.knight;


public class SelectArmy extends JFrame implements ActionListener{

     /**
	 * 
	 */
	private static final long serialVersionUID = -710066457784512920L;
	ListAndImage  x ;
	
     JTable table = new JTable();
     private ResourceBundle language;
     private Juego J;
     private ArrayList<Object> jugador1;
     private ArrayList<Object> jugador2;
     private boolean selected;
     private DefaultTableModel modelo;
     private boolean sound;
     private int gold;
	
	public SelectArmy(ResourceBundle Language,boolean Sound,Juego j,ArrayList<Object> j1,ArrayList<Object> j2,boolean j1Selected,int gold)
	{
		language = Language;
		this.gold=gold;
		jugador1 = j1;
		jugador2 = j2;
		sound = Sound;
		selected = j1Selected;
		modelo = new DefaultTableModel();
		modelo.setColumnCount(3);
		Object [] l= {Language.getString("Name"),Language.getString("Health"),Language.getString("Mana")};
		modelo.setColumnIdentifiers(l);
		table= new JTable(modelo);
		J=j;
		//x.addMouseListener(this);
		this.setSize(1024,720);
		this.setLayout(null);
		x = new ListAndImage(Language);
		this.add(x);
		this.add(table);
		((OldWarriorButton)x.getButtons().getComponent(0)).getOldWarriorButton().addActionListener(this);
		((OldWarriorButton)x.getButtons().getComponent(2)).getOldWarriorButton().addActionListener(this);	  
		table.setBounds(280, 320, 650,300 );
		x.setBounds(0, 0, 280, 720);
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==((OldWarriorButton)x.getButtons().getComponent(0)).getOldWarriorButton()){
			if(x.getP()!=null){
				Object[]fila=new String[3];
				fila[0] = x.getP().getType();
				fila[1] = x.getP().getLife();
				fila[2] = x.getP().getEnergy();
				modelo.addRow(fila);
				if(selected = true)
					jugador1.add(x.getP());
				else
					jugador2.add(x.getP());
			}
		}else if(e.getSource()==((OldWarriorButton)x.getButtons().getComponent(2)).getOldWarriorButton()){
			if(selected){
			this.dispose();
			new SelectArmy(language,sound,J,jugador1,jugador2,false,gold);
			}else{
				this.dispose();
				//cargar Partida con el mapa y las unidades.
			}
		}
	}
}
