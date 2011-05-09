import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import proyecto.p4.Ventana.JPanels.HabilitiesButton;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;


public class GameWindow extends JFrame
{
	private static final long serialVersionUID = 6973735437802698696L;
	GamePanel gamePanel;
//	UnitData unitData;
	JLayeredPane layer = new JLayeredPane();
//	HabilitiesButton habilitiesButtons;
	
	public GameWindow()
	{
		this.setSize(1024,720);
//		HabilitiesButton habilitiesButtons = new HabilitiesButton(new Arquero());
		gamePanel = new GamePanel();
	//	unitData = new UnitData(new Arquero());
		this.setLayout(null);
		// FALTA METODO DE CARGAR MAPA DESDE BD
		layer.setBounds(0,0,this.getWidth(),this.getHeight());

		this.add(layer);


		gamePanel.setBounds(0,0,gamePanel.getWidth(),gamePanel.getHeight());
//		unitData.setBounds(gamePanel.getWidth(),0,unitData.getWidth(),unitData.getHeight());
//		habilitiesButtons.setBounds(0,gamePanel.getHeight(), habilitiesButtons.getWidth(), habilitiesButtons.getHeight());		

		layer.add(gamePanel, new Integer (0));
	//	layer.add(unitData, new Integer(1));
//		layer.add(	habilitiesButtons, new Integer(1));

//		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new GameWindow();
	}
}
