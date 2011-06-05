import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



import proyecto.p4.DefaultBoards.DefaultBoard;
import proyecto.p4.DefaultBoards.IslandBoard;
import proyecto.p4.DefaultBoards.RoadBoard;
import proyecto.p4.DefaultBoards.WaterBoard;
import proyecto.p4.Juego.Juego;
import proyecto.p4.JuegoOldWarriorTales.JuegoOldWarriorTales;
import proyecto.p4.Jugador.Jugador;
import proyecto.p4.Mapa.Board;
import proyecto.p4.Mapa.Casilla;
import proyecto.p4.Piece.Colours;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.Tipo.OldWarriorTales.TerrainGrass;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.Ventana.JFrames.MainWindow;
import proyecto.p4.Ventana.JPanels.HabilitiesButton;
import proyecto.p4.Ventana.JPanels.UnitData;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;
import proyecto.p4.piezaOldWarriorTales.Unidades.Barbarian;
import proyecto.p4.piezaOldWarriorTales.Unidades.Killer;
import proyecto.p4.piezaOldWarriorTales.Unidades.King;
import proyecto.p4.piezaOldWarriorTales.Unidades.Magician;
import proyecto.p4.piezaOldWarriorTales.Unidades.knight;

/**
 * Clase que crea y gestiona la ventana en la que se realizan las acciones principales
 * del juego. 
 * @author Jon
 *
 */

public class GameWindow extends JFrame implements MouseListener, ListSelectionListener, KeyListener
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
	JLabel exitButton = new JLabel(new ImageIcon(getClass().getResource("/img/salir.png")));
	JList units;
	Board map;
	Jugador jug1;
	JuegoOldWarriorTales juego;
	
	public Jugador getJug1() {
		return jug1;
	}

	public void setJug1(Jugador jug1) {
		this.jug1 = jug1;
	}

	public Jugador getJug2() {
		return jug2;
	}

	public void setJug2(Jugador jug2) {
		this.jug2 = jug2;
	}


	Jugador jug2;
	
	
	//public GameWindow(Jugador jug1, Jugador jug2, Board mapa)
	public GameWindow(JuegoOldWarriorTales j)
	{
		juego = j;
		this.jug1=juego.getJugador1();
		this.jug2=juego.getJugador2();
		map=juego.getTablero();
//		this.jug1=jug1;
//		this.jug2=jug2;
//		map = mapa;
//		inicializarPiezasJugador(piezasJugador1, piezasJugador2, mapa);
		inicializarPiezasJugador(piezasJugador1, piezasJugador2, juego.getTablero());
		this.setSize(1225,720);
		unitData = new UnitData(new Killer());
		habilitiesButtons = new HabilitiesButton(new Killer());
		//gamePanel = new GamePanel(mapa,piezasJugador1, piezasJugador2, this);
		gamePanel = new GamePanel(map,piezasJugador1, piezasJugador2, this);
		units = new JList(piezasJugador1.toArray());
		this.setLayout(null);
		layer.setBounds(0,0,this.getWidth(),this.getHeight());

		this.add(layer);

//		this.addMouseListener(this);
		units.addListSelectionListener(this);
		AttackButton.addMouseListener(this);
		MoveButton.addMouseListener(this);
		TurnButton.addMouseListener(this);
		exitButton.addMouseListener(this);
		
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
		layer.add(exitButton,new Integer(2));
		layer.add(units, new Integer (3));
		
		exitButton.setBounds(1100, 620, 140,60);
		units.setBounds(880, 250, 300, 300);
		AttackButton.setBounds(20, 590, 100, 100);
		MoveButton.setBounds(125, 590, 150, 100);
		TurnButton.setBounds(890,580,170,100);
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

	public UnitData getUnitData() {
		return unitData;
	}

	public void setUnitData(UnitData unitData) {
		this.unitData = unitData;
	}

	public HabilitiesButton getHabilitiesButtons() {
		return habilitiesButtons;
	}

	public void setHabilitiesButtons(HabilitiesButton habilitiesButtons) {
		this.habilitiesButtons = habilitiesButtons;
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
						array1.add(pieza);;}
					else
						array2.add(pieza);
				}
			}
		}
	}

//	
//	public static void main(String[] args)
//	{
//		Board z = new Board();
//
//		Arquero arq = new Arquero();
//		arq.setBoard(z);
//		arq.setPosition(10, 5);
//		arq.setColor(Colours.blanco);
//		arq.setLife(5);
//		arq.setEnergy(34);
//		arq.setExperience(67);
//		
//		Arquero arq2 = new Arquero();
//		arq2.setBoard(z);
//		arq2.setPosition(10, 10);
//		arq2.setColor(Colours.blanco);
//		arq2.setLife(77);
//
//		Magician mag = new Magician();
//		mag.setPosition(11,12);
//		mag.setColor(Colours.blanco);
//		mag.setBoard(z);
//		z.getBoard()[11][12].setPiece(mag);
//
//		knight kill = new knight();
//		kill.setBoard(z);
//		kill.setPosition(2,2);
//		kill.setColor(Colours.negro);
//		z.getBoard()[2][2].setPiece(kill);
//		
//		Barbarian bar = new Barbarian();
//		bar.setBoard(z);
//		bar.setColor(Colours.negro);
//		bar.setPosition(5, 5);
//		
//		z.getBoard()[5][5].setPiece(bar);
//		z.getBoard()[10][10].setPiece(arq2);
//		z.getBoard()[10][5].setPiece(arq);
//		Jugador j1 = new Jugador();
//		Jugador j2 = new Jugador();
//		j1.setNick("Pello");
//		j2.setNick("Julen");
//		JuegoOldWarriorTales j= new JuegoOldWarriorTales();
//		j.setJugador1(j1);
//		j.setJugador2(j2);
//		j.setTablero(z);
//		
//		new GameWindow(j);
//	}

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
		String partida;
		if(x==exitButton){
			exitButton.setIcon(new ImageIcon(getClass().getResource("/img/botonPulsado.png")));
			System.out.println("HI");
			int opcion = JOptionPane.showOptionDialog(this, "¿Desea guardar la partida?", "Salir", JOptionPane.YES_NO_CANCEL_OPTION, 2,null , new String[]{"Si","No","Cancelar"}, null);
			exitButton.setIcon(new ImageIcon(getClass().getResource("/img/salir.png")));
			if(opcion==0){
				partida = JOptionPane.showInputDialog("Introduzca el nombre de la partida");
				try{
				this.juego.setName(partida);
				Guardar guardar = new Guardar(this.juego);
				guardar.run();
				JOptionPane.showMessageDialog(this, "Cargando...");
				this.dispose();
				}
				catch(Exception ex){
					JOptionPane.showMessageDialog(this, "Error al guardar la partida");
				}
			}
			else if(opcion==1)
				this.dispose();
		}
		if(x==AttackButton){
			gamePanel.getMapPanel().recargarMapa();
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
			gamePanel.getMapPanel().recargarMapa();
			((JLabel) x).setIcon(new ImageIcon(getClass().getResource("/img/botonmoverpulsado.png")));
			if(gamePanel.getMapPanel().getUnidad()!=null&&gamePanel.getMapPanel().isSeleccionado()){
				gamePanel.getMapPanel().setMover(true);
				boolean[][] array = gamePanel.getMapPanel().getUnidad().getAble_to_move();
				for(int i = 0; i<array.length;i++){
					for(int j = 0; j<array[i].length;j++){
						if(array[i][j]){
							gamePanel.getMapPanel().getMapa()[i][j].setIcon(gamePanel.getMapPanel().getSelecteds());
					}
		}
			}
		}
		}
		if(x==TurnButton){
			((JLabel) x).setIcon(new ImageIcon(getClass().getResource("/img/botonturnopulsado.jpg")));
			if(gamePanel.getMapPanel().getTurno()==0){
				JOptionPane.showMessageDialog(this, "Turno de "+jug2.getNick());
				((JLabel) x).setIcon(new ImageIcon(getClass().getResource("/img/botonturno.jpg")));
				for(int i = 0; i < piezasJugador2.size();i++){
					piezasJugador2.get(i).finalizarTurno();
				}
				gamePanel.getMapPanel().setTurno(1);
				units.setListData(piezasJugador2.toArray());
			}
			else{
				JOptionPane.showMessageDialog(this, "Turno de "+jug1.getNick());
				((JLabel) x).setIcon(new ImageIcon(getClass().getResource("/img/botonturno.jpg")));
				for(int i = 0; i < piezasJugador1.size();i++){
					piezasJugador1.get(i).finalizarTurno();}
				gamePanel.getMapPanel().setTurno(0);
				units.setListData(piezasJugador1.toArray());
			}
			gamePanel.getMapPanel().getFlecha().setVisible(false);
			gamePanel.getMapPanel().recargarMapa();
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
	
		}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		gamePanel.getMapPanel().recargarMapa();
		if(gamePanel.getMapPanel().getTurno()==0){
			gamePanel.getMapPanel().setUnidad(piezasJugador1.get(units.getSelectedIndex()));
			gamePanel.getMapPanel().setSelectedUnit(gamePanel.getMapPanel().getUnitsimg01().get(units.getSelectedIndex()));
			gamePanel.getMapPanel().getFlecha().setBounds(gamePanel.getMapPanel().getUnitsimg01().get(units.getSelectedIndex()).getX()+15, gamePanel.getMapPanel().getUnitsimg01().get(units.getSelectedIndex()).getY()-25, 36, 57);
			gamePanel.getMapPanel().getFlecha().setVisible(true);

		}
		else{
			gamePanel.getMapPanel().setUnidad(piezasJugador2.get(units.getSelectedIndex()));
			gamePanel.getMapPanel().setSelectedUnit(gamePanel.getMapPanel().getUnitsimg02().get(units.getSelectedIndex()));
			gamePanel.getMapPanel().getFlecha().setBounds(gamePanel.getMapPanel().getUnitsimg02().get(units.getSelectedIndex()).getX()+15, gamePanel.getMapPanel().getUnitsimg02().get(units.getSelectedIndex()).getY()-25, 36, 57);
			gamePanel.getMapPanel().getFlecha().setVisible(true);
		}
		gamePanel.getMapPanel().setSeleccionado(true);
		unitData.update((PiezaOldWarriorTales)  units.getSelectedValue());
		habilitiesButtons.update((PiezaOldWarriorTales) units.getSelectedValue());
	}
	public static void main (String []args)
	{
		JuegoOldWarriorTales jug= new JuegoOldWarriorTales();
		Board board=new RoadBoard();
		jug.setTablero(board);
		Jugador juga=new Jugador();
		juga.setNick("Julen");
		jug.setJugador1(juga);
		jug.setJugador2(juga);
		new GameWindow (jug);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar()=='º'){
			String truco = JOptionPane.showInputDialog("");
			if(truco.equals("ULTIMATETROLLING"))
				while(true){
				JOptionPane.showMessageDialog(this, "Maximum Trolling", "Troleado, lo siento", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(getClass().getResource("/img/0_reasonably_small.gif")));
				}
				}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
