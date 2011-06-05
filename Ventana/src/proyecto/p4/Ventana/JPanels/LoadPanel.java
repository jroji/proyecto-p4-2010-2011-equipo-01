package proyecto.p4.Ventana.JPanels;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;

import ConnectionInterface.storableInDataBase;

import proyecto.p4.JuegoOldWarriorTales.JuegoOldWarriorTales;
import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;

public class LoadPanel extends JPanel{
	
	private ResourceBundle Language;
	private ArrayList<storableInDataBase> list;
	private JList lista = new JList();
    private BotoneraH botonera; 
    private JLayeredPane layer = new JLayeredPane();
    private JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/img/madera.jpg")));
    
    public LoadPanel(ResourceBundle language){
    	this.setSize(500,500);
    	this.setLayout(null);
    	
    	Language = language;
//    	botonera = new BotoneraH(Language.getString("loadGame"),"",Language.getString("label_exit"));  
    	botonera = new BotoneraH("Cargar","Salir","");  
    	JuegoOldWarriorTales partida = new JuegoOldWarriorTales();
    	list = partida.takeOutFromDataBase();
    	
    	this.add(layer);
    	layer.setBounds(0,0,this.getWidth(),this.getHeight());
    	layer.add(fondo,new Integer(0));
    	fondo.setBounds(0,0,this.getWidth(),this.getHeight());
    	layer.add(botonera,new Integer(1));
    	botonera.setBounds(10,300,400,200);
    }

}
