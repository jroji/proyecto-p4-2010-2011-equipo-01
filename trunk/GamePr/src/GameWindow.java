import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;

import proyecto.p4.Ventana.JPanels.HabilitiesButton;
import proyecto.p4.Ventana.JPanels.UnitData;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;
import proyecto.p4.piezaOldWarriorTales.Unidades.Killer;


public class GameWindow extends JFrame
{
	private static final long serialVersionUID = 6973735437802698696L;
	GamePanel gamePanel;
	UnitData unitData;
	JLayeredPane layer = new JLayeredPane();
	HabilitiesButton habilitiesButtons;
	JLabel imgFondo = new JLabel(new ImageIcon(getClass().getResource("/img/madera.jpg"))) ;
	JLabel imgEXP = new JLabel(new ImageIcon(getClass().getResource("/img/exp.png"))) ;
	JLabel imgLIFE = new JLabel(new ImageIcon(getClass().getResource("/img/vida.png"))) ;
	JLabel imgMANA = new JLabel(new ImageIcon(getClass().getResource("/img/energia.png"))) ;
	JLabel imgPerg = new JLabel(new ImageIcon(getClass().getResource("/img/PERGAMINO.png"))) ;
	
	public GameWindow()
	{
		this.setSize(1225,720);
		unitData = new UnitData(new Killer());
		habilitiesButtons = new HabilitiesButton(new Arquero());
		gamePanel = new GamePanel();
		JList units = new JList();
		this.setLayout(null);
		// FALTA METODO DE CARGAR MAPA DESDE BD
		layer.setBounds(0,0,this.getWidth(),this.getHeight());

		this.add(layer);


		gamePanel.setBounds(10,10,gamePanel.getWidth(),gamePanel.getHeight());
		unitData.setBounds(875,50,250,125);
		habilitiesButtons.setBounds(20,600, 500, 200);		

		layer.add(gamePanel, new Integer (1));
		layer.add(unitData, new Integer(2));
		layer.add(habilitiesButtons, new Integer(2));
		layer.add(imgFondo, new Integer(0));
		layer.add(imgEXP, new Integer(3));
		layer.add(imgLIFE, new Integer(3));
		layer.add(imgMANA, new Integer(3));
		layer.add(imgPerg, new Integer(2));
		layer.add(units, new Integer (3));
		
		units.setBounds(900, 250, 300, 300);
		
		imgEXP.setBounds(1100, 112, 80, 80);
		imgMANA.setBounds(1100, 65, 80, 80);
		imgLIFE.setBounds(1100, 28, 80, 80);
		imgPerg.setBounds(820, 20, 400, 200);

		imgFondo.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new GameWindow();
	}
}
