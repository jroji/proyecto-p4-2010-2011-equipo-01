import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


import proyecto.p4.Mapa.Casilla;
import proyecto.p4.Mapa.Board;
import proyecto.p4.Piece.Piece;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;


/**
 * Panel donde se crea y muestra el mapa del juego y las unidades de cada jugador en el mapa.
 * 
 */

public class MapPanel extends JPanel implements MouseListener{

	private static final long serialVersionUID = 1L;
	ImageIcon img = new ImageIcon(getClass().getResource("/img/hierba.png"));
	ImageIcon sold = new ImageIcon(getClass().getResource("/img/arquero.png"));
	ImageIcon Barbaro = new ImageIcon(getClass().getResource("/img/barbaro.gif"));
	ImageIcon piedra = new ImageIcon(getClass().getResource("/img/piedra.png"));
	JLabel suelo  = new JLabel(new ImageIcon(getClass().getResource("/img/suelo.png")));
	ImageIcon selected = new ImageIcon(getClass().getResource("/img/SELECCION.png"));
//	ImageIcon circrojo = new ImageIcon(getClass().getResource("/img/marcaroja.png"));
	ImageIcon castillo = new ImageIcon(getClass().getResource("/img/castillo.png"));
	ImageIcon villa = new ImageIcon(getClass().getResource("/img/villa.png"));
	Icon viejoimg;
//	Board tab = new Board();
	
//	JLabel fondo = new JLabel(fond);
	
	//	JLabel circrojo01 = new JLabel(circrojo);
	
	
	ArrayList<JLabel> unitsimg01 = new ArrayList<JLabel>();
	ArrayList<JLabel> unitsimg02 = new ArrayList<JLabel>();
	
	int SelectedX;
	int SelectedY;
	
	JLabel viejo = new JLabel(img);
	
	JLabel[][] mapa = new JLabel[14][13];
	
	
	JLayeredPane layer = new JLayeredPane();


//	public MapPanel(Board map){
	public MapPanel(Board map, ArrayList<PiezaOldWarriorTales> piezasJugador1,ArrayList<PiezaOldWarriorTales> piezasJugador2){	
	
		//tab = map;
		iniMap(map, mapa);
		this.setOpaque(false);
		
		//Inicializa el mapa de imagenes cogiendo las casillas del Board que recibimos
		iniMap(map, mapa);
		setSize(1500,1200);
		setLayout(null);
		
		//Añade el layerPane sobre el que irán las casillas
		layer.setBounds(0, 0, 1500, 1200);
		add(layer);
		
		//Añade al layerPane las casillas del mapa.
		anyadirArray(mapa);
		layer.add(suelo, new Integer(-1));
	

		anyadirUnidades(piezasJugador1, piezasJugador2, unitsimg01,unitsimg02);
		
		
		

	//	layer.add(circrojo01, new Integer(13));
		
		int x = 800;
		int y = 50;
		colocarMapa(mapa,x,y);
		suelo.setBounds(70, 450, 1500, 800);
//		unit01.setBounds(520, 150, sold.getIconWidth(), sold.getIconHeight());
//		unit02.setBounds(520, 150, sold.getIconWidth(), sold.getIconHeight());

	//	circrojo01.setBounds(unit01.getX()+3, unit01.getY()+30, sold.getIconWidth(), sold.getIconHeight());
	}

	/* 1 = norte, 2 = este, 3 = sur, 4 = oeste
	 * 
	 */
	public void iniMap(Board map, JLabel[][] array)
	{
		for(int i = 0;i<array.length;i++)
		{
			for(int j = 0; j<array[i].length;j++){
				array[i][j] = new JLabel(new ImageIcon(getClass().getResource(map.getCasilla(i, j).getSquare().getImage())));
			}
		}
	}
	
	/**Coloca cada label con su imagen en el sitio correspodiente
	 * Además añade los MouseListener a cada label.
	 */
	public void colocarMapa(JLabel[][] imag,int x, int y){
		int inix = x;
		int iniy = y;
		for(int j= 0;j<imag.length;j++){
			for(int i  = 0; i<imag[j].length;i++){
				imag[j][i].setBounds(x, y,img.getIconWidth(), img.getIconHeight());
				imag[j][i].addMouseListener(this);
				x = x+44;
				y = y+38;
			}
			x= inix -55;
			y= iniy +36;
			inix = x;
			iniy = y;}
	}
	
	public void anyadirUnidades(ArrayList<PiezaOldWarriorTales> unidadesjug1, ArrayList<PiezaOldWarriorTales> unidadesjug2, ArrayList<JLabel> labels, ArrayList<JLabel> labels2){
	
		for(int i = 0;i<unidadesjug1.size();i++){
			labels.add(new JLabel(unidadesjug1.get(i).getImagen()));
			int x = unidadesjug1.get(i).getPosition_x();
			int y = unidadesjug1.get(i).getPosition_y();
			System.out.println(mapa[x][y].getX());
			labels.get(i).setBounds(mapa[x][y].getX(), mapa[x][y].getY(), 70, 125);
			layer.add(labels.get(i), new Integer(layer.getLayer(mapa[x][y])));
		}
		for(int i = 0;i<unidadesjug2.size();i++){
			labels2.add(new JLabel(unidadesjug2.get(i).getImagen()));
			int x = unidadesjug2.get(i).getPosition_x();
			int y = unidadesjug2.get(i).getPosition_y();
			labels.get(i).setBounds(mapa[x][y].getX(), mapa[x][y].getY(), 70, 125);
			layer.add(labels2.get(i), new Integer(layer.getLayer(mapa[x][y])));

		}
	}
	/**Coloca los JLabel del array en el layerpane  
	 * Decide además en que capa del layer se introduciran los elementos
	 */
	public void anyadirArray(JLabel[][] arr){
		for(int j = 0; j<arr.length;j++){
		for(int i = 0; i<arr[j].length;i++){
			layer.add(arr[j][i], new Integer(arr[j].length-i));
			}
	}}
	
//	public Casilla buscarCasilla(String x){
//	int i = 0;
//	int j = 0;
//	boolean encontrado= false;
//		while(j<mapa.length&&!encontrado){
//			while(i<mapa[j].length&&!encontrado){
//				if(mapa[j][i].getName().equals(x))
//					encontrado = true;
//				else
//					i++;
//				}
//		if(!encontrado)
//			j++;
//		}
//		return tab.getMap()[j][i];
//	}
//	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel x = (JLabel) arg0.getSource();
		viejoimg = x.getIcon();
		x.setIcon(selected);
		String nombre = x.getName();
	//	buscarCasilla(nombre);
		viejo = x;
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		viejo.setIcon(viejoimg);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JLabel x = (JLabel) arg0.getSource();
		for(int i = 0; i<mapa.length;i++ ){
			for(int j = 0; j<mapa[i].length;j++){
				if(mapa[i][j].equals(x)){
					System.out.println(i+","+j);
					System.out.println("CAPA : "+ layer.getLayer(x));				
			}
		}
		}
//		layer.setLayer(unit01, layer.getLayer(x)+2);
//		unit01.setLocation(x.getX(), x.getY()-50);
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
