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

public class LoadPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5804528487582382868L;
	private ResourceBundle Language;
	private ArrayList<storableInDataBase> list;
	private JList lista = new JList();
    private BotoneraH botonera; 
    private JLayeredPane layer = new JLayeredPane();
    private JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/img/madera.jpg")));
    
    public LoadPanel(ResourceBundle language){
    	this.setSize(650,500);
    	this.setLayout(null);
    	
    	Language = language;

    	botonera = new BotoneraH(Language.getString("label_loadGame"),"",Language.getString("label_exit"));  
    	JuegoOldWarriorTales partida = new JuegoOldWarriorTales();
    	list = partida.takeOutFromDataBase();
    	lista.setListData(list.toArray());

    	this.add(layer);
    	layer.add(lista, new Integer(1));
    	lista.setBounds(10,10,570,300);
    	layer.setBounds(0,0,this.getWidth(),this.getHeight());
    	layer.add(fondo,new Integer(0));
    	fondo.setBounds(0,0,this.getWidth(),this.getHeight());
    	layer.add(botonera,new Integer(1));
    	botonera.setBounds(0,340,600,200);
    }

    public BotoneraH getBotonera(){
    	return botonera;
    }
    public JuegoOldWarriorTales getSelectedGame ()
    {
    	return (JuegoOldWarriorTales) list.get(lista.getSelectedIndex());
    }

}
