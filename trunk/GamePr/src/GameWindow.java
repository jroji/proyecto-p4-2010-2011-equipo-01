
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



import proyecto.p4.Jugador.Jugador;
import proyecto.p4.Mapa.Board;
import proyecto.p4.Mapa.Casilla;
import proyecto.p4.Piece.Colours;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.Tipo.OldWarriorTales.TerrainGrass;
import proyecto.p4.Ventana.JPanels.HabilitiesButton;
import proyecto.p4.Ventana.JPanels.UnitData;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;
import proyecto.p4.piezaOldWarriorTales.Unidades.Barbarian;
import proyecto.p4.piezaOldWarriorTales.Unidades.Killer;
import proyecto.p4.piezaOldWarriorTales.Unidades.Magician;

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
	JLabel AttackButton = new JLabel(new ImageIcon(getClass().getResource("/img/botonatacar.png")));
	JLabel TurnButton = new JLabel(new ImageIcon(getClass().getResource("/img/botonturno.jpg")));
	JLabel MoveButton = new JLabel(new ImageIcon(getClass().getResource("/img/botonmover.png")));
	JList units;
	Board map;
	
	
	public GameWindow(Jugador jug1, Jugador jug2, Board mapa)
//	public GameWindow()
	{
		map = mapa;
		inicializarPiezasJugador(piezasJugador1, piezasJugador2, mapa);
		this.setSize(1225,720);
		unitData = new UnitData(new Killer());
		habilitiesButtons = new HabilitiesButton(new Killer());
		gamePanel = new GamePanel(mapa,piezasJugador1, piezasJugador2, this);
		units = new JList(piezasJugador1.toArray());
		this.setLayout(null);
		layer.setBounds(0,0,this.getWidth(),this.getHeight());

		this.add(layer);

//		this.addMouseListener(this);
		units.addListSelectionListener(this);
		AttackButton.addMouseListener(this);
		MoveButton.addMouseListener(this);
		TurnButton.addMouseListener(this);
		
		gamePanel.setBounds(10,10,gamePanel.getWidth(),gamePanel.getHeight());
		unitData.setBounds(875,50,250,125);
		habilitiesButtons.setBounds(200,600, 750, 200);		

		gamePanel.addMouseListener(this);
		layer.add(gamePanel, new Integer (1));
		layer.add(unitData, new Integer(2));
		layer.add(habilitiesButtons, new Integer(2));
		layer.add(imgFondo, new Integer(0));
		layer.add(imgEXP, new Integer(3));
		layer.add(imgLIFE, new Integer(3));
		layer.add(imgMANA, new Integer(3));
		layer.add(imgPerg, new Integer(2));
		layer.add(AttackButton, new Integer(2));
		layer.add(TurnButton, new Integer(2));
		layer.add(MoveButton, new Integer(2));
		layer.add(units, new Integer (3));
		
		units.setBounds(880, 250, 300, 300);
		
		AttackButton.setBounds(20, 590, 100, 100);
		MoveButton.setBounds(125, 590, 150, 100);
		TurnButton.setBounds(940,570,170,100);
		imgEXP.setBounds(1100, 112, 80, 80);
		imgMANA.setBounds(1100, 65, 80, 80);
		imgLIFE.setBounds(1100, 28, 80, 80);
		imgPerg.setBounds(820, 20, 400, 200);

		imgFondo.setBounds(0, 0, this.getWidth(), this.getHeight());
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JList getUnits() {
		return units;
	}

	public void setUnits(JList units) {
		this.units = units;
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
//		for (int i=0;i<z.getBoard().length;i++)
//		{
//			for (int j=0;j<z.getBoard()[1].length;j++)
//			{
//				z.getBoard()[i][j]= new Casilla();
//			}
//		}
		Arquero arq = new Arquero();
		arq.setBoard(z);
		arq.setPosition(10, 5);
		arq.setColor(Colours.blanco);
		arq.setLife(5);
		arq.setEnergy(34);
		arq.setExperience(67);
		
		Arquero arq2 = new Arquero();
		arq2.setBoard(z);
		arq2.setPosition(10, 10);
		arq2.setColor(Colours.blanco);
		arq2.setLife(77);
//
//		Magician mag = new Magician();
//		mag.setPosition(10, 5);
//		mag.setColor(Colours.blanco);
//
//		Killer kill = new Killer();
//		kill.setPosition(10, 5);
//		kill.setColor(Colours.blanco);
//		
		Barbarian bar = new Barbarian();
		bar.setBoard(z);
		bar.setColor(Colours.blanco);
		bar.setPosition(5, 5);
		z.getBoard()[5][5].setPiece(bar);
		z.getBoard()[10][10].setPiece(arq2);
		z.getBoard()[10][5].setPiece(arq);
		new GameWindow(new Jugador(), new Jugador(), z);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==this.gamePanel){
			unitData.update(gamePanel.getMapPanel().getUnidad());
			habilitiesButtons.update(gamePanel.getMapPanel().getUnidad());
			
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
		Object x =  e.getSource();
		if(x==AttackButton){
			((JLabel) x).setIcon(new ImageIcon(getClass().getResource("/img/botonatacarpulsado.png")));
		if(gamePanel.getMapPanel().getUnidad()!=null&&gamePanel.getMapPanel().isSeleccionado()){
			gamePanel.getMapPanel().setAtacar(true);
			boolean[][] array = gamePanel.getMapPanel().getUnidad().getAttackAble();
			for(int i = 0; i<array.length;i++){
				for(int j = 0; j<array[i].length;j++){
					if(array[i][j]){
						gamePanel.getMapPanel().getMapa()[i][j].setIcon(gamePanel.getMapPanel().getAtacable());
				}
	}
		}
	}
		}
		if(x==MoveButton){
			units.repaint();
			((JLabel) x).setIcon(new ImageIcon(getClass().getResource("/img/botonmoverpulsado.png")));
			if(gamePanel.getMapPanel().getUnidad()!=null&&gamePanel.getMapPanel().isSeleccionado()){
				gamePanel.getMapPanel().setMover(true);
				boolean[][] array = gamePanel.getMapPanel().getUnidad().getAble_to_move();
				for(int i = 0; i<array.length;i++){
					for(int j = 0; j<array[i].length;j++){
						if(array[i][j]){
							gamePanel.getMapPanel().getMapa()[i][j].setIcon(gamePanel.getMapPanel().getSelected());
					}
		}
			}
		}
		}
		if(x==TurnButton){
			for(int i = 0; i < piezasJugador1.size();i++){
				piezasJugador1.get(i).finalizarTurno();
			}
			gamePanel.getMapPanel().getFlecha().setVisible(false);
			((JLabel) x).setIcon(new ImageIcon(getClass().getResource("/img/botonturnopulsado.jpg")));
		}
		}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		Object x = e.getSource();
		if(x==AttackButton)
			((JLabel) x).setIcon(new ImageIcon(getClass().getResource("/img/botonatacar.png")));
		if(x==MoveButton)
			((JLabel) x).setIcon(new ImageIcon(getClass().getResource("/img/botonmover.png")));
		if(x==TurnButton)
			((JLabel) x).setIcon(new ImageIcon(getClass().getResource("/img/botonturno.jpg")));
		}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("prueba"+units.getSelectedIndex());
		gamePanel.getMapPanel().setUnidad(piezasJugador1.get(units.getSelectedIndex()));
		gamePanel.getMapPanel().setSelectedUnit(gamePanel.getMapPanel().getUnitsimg01().get(units.getSelectedIndex()));
		gamePanel.getMapPanel().getFlecha().setBounds(gamePanel.getMapPanel().getUnitsimg01().get(units.getSelectedIndex()).getX()+15, gamePanel.getMapPanel().getUnitsimg01().get(units.getSelectedIndex()).getY()-25, 36, 57);
		gamePanel.getMapPanel().setSeleccionado(true);
		unitData.update((PiezaOldWarriorTales)  units.getSelectedValue());
		habilitiesButtons.update((PiezaOldWarriorTales) units.getSelectedValue());
	}
}
