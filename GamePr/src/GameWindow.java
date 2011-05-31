import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import proyecto.p4.Mapa.Board;

import proyecto.p4.Jugador.Jugador;
import proyecto.p4.Piece.Colours;
import proyecto.p4.Piece.Piece;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.Ventana.JPanels.HabilitiesButton;
import proyecto.p4.Ventana.JPanels.UnitData;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;
import proyecto.p4.piezaOldWarriorTales.Unidades.Barbarian;
import proyecto.p4.piezaOldWarriorTales.Unidades.Killer;

/**
 * Clase que crea y gestiona la ventana en la que se realizan las acciones principales
 * del juego. 
 * @author Jon
 *
 */

public class GameWindow extends JFrame implements MouseListener, ListSelectionListener
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
	ArrayList<PiezaOldWarriorTales> piezasJugador1 = new ArrayList<PiezaOldWarriorTales>();
	ArrayList<PiezaOldWarriorTales> piezasJugador2 = new ArrayList<PiezaOldWarriorTales>();
	JLabel AttackBotton = new JLabel(new ImageIcon(getClass().getResource("/img/botonatacar.png")));
	JList units;
	
	
	public GameWindow(Jugador jug1, Jugador jug2, Board mapa)
//	public GameWindow()
	{
		inicializarPiezasJugador(piezasJugador1, piezasJugador2, mapa);
		this.setSize(1225,720);
		unitData = new UnitData(new Killer());
		habilitiesButtons = new HabilitiesButton(new Arquero());
		gamePanel = new GamePanel(mapa,piezasJugador1, piezasJugador2);
		units = new JList(piezasJugador1.toArray());
		this.setLayout(null);
		layer.setBounds(0,0,this.getWidth(),this.getHeight());

		this.add(layer);

		units.addListSelectionListener(this);
		AttackBotton.addMouseListener(this);
		
		gamePanel.setBounds(10,10,gamePanel.getWidth(),gamePanel.getHeight());
		unitData.setBounds(875,50,250,125);
		habilitiesButtons.setBounds(200,600, 500, 200);		

		layer.add(gamePanel, new Integer (1));
		layer.add(unitData, new Integer(2));
		layer.add(habilitiesButtons, new Integer(2));
		layer.add(imgFondo, new Integer(0));
		layer.add(imgEXP, new Integer(3));
		layer.add(imgLIFE, new Integer(3));
		layer.add(imgMANA, new Integer(3));
		layer.add(imgPerg, new Integer(2));
		layer.add(AttackBotton, new Integer(2));
		layer.add(units, new Integer (3));
		
		units.setBounds(900, 250, 300, 300);
		
		AttackBotton.setBounds(1000, 580, 100, 100);
		imgEXP.setBounds(1100, 112, 80, 80);
		imgMANA.setBounds(1100, 65, 80, 80);
		imgLIFE.setBounds(1100, 28, 80, 80);
		imgPerg.setBounds(820, 20, 400, 200);

		imgFondo.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.setResizable(false);
		this.setVisible(true);
	}

	/**Inicializa un arraylist introduciendo las piezas que existen en el mapa en los arrays de las piezas de los jugadores
	 * 
	 */
	public void inicializarPiezasJugador(ArrayList<PiezaOldWarriorTales> array1, ArrayList<PiezaOldWarriorTales> array2, Board mapa){
		PiezaOldWarriorTales pieza;
		for(int i = 0; i<mapa.getBoard().length;i++){
			for(int j = 0;j<mapa.getBoard()[i].length;j++){
				pieza = (PiezaOldWarriorTales) mapa.getCasilla(i, j).getPiece();
				if(pieza!=null){
					if(pieza.getColor()==Colours.blanco){
						array1.add(pieza);
					System.out.println(pieza);}
					else
						array2.add(pieza);
				}
			}
		}
	}

	
	public static void main(String[] args)
	{
		Board z = new Board();
		Arquero arq = new Arquero();
	//	arq.setPosition(10, 5);
		arq.setColor(Colours.blanco);
		z.getBoard()[10][5].setPiece(arq);
		new GameWindow(new Jugador(), new Jugador(), z);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
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
		JLabel x = (JLabel) e.getSource();
		x.setIcon(new ImageIcon(getClass().getResource("/img/botonatacarpulsado.png")));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel x = (JLabel) e.getSource();
		x.setIcon(new ImageIcon(getClass().getResource("/img/botonatacar.png")));
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		unitData.update((PiezaOldWarriorTales)  units.getSelectedValue());
		habilitiesButtons.update((PiezaOldWarriorTales) units.getSelectedValue());
	}
}