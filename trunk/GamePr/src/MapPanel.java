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
	public JLabel getSelectedUnit() {
		return selectedUnit;
	}

	public void setSelectedUnit(JLabel selectedUnit) {
		this.selectedUnit = selectedUnit;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}

	ImageIcon piedra = new ImageIcon(getClass().getResource("/img/piedra.png"));
	JLabel suelo  = new JLabel(new ImageIcon(getClass().getResource("/img/suelo.png")));
	ImageIcon selected = new ImageIcon(getClass().getResource("/img/SELECCION.png"));
//	ImageIcon circrojo = new ImageIcon(getClass().getResource("/img/marcaroja.png"));
	ImageIcon castillo = new ImageIcon(getClass().getResource("/img/castillo.png"));
	ImageIcon villa = new ImageIcon(getClass().getResource("/img/villa.png"));
	Icon viejoimg;
	boolean seleccionado = false;
	JLabel selectedUnit;
	Board tab;
	
	boolean need_to_update;
	
	PiezaOldWarriorTales unidad;
	
	public PiezaOldWarriorTales getUnidad() {
		return unidad;
	}

	public void setUnidad(PiezaOldWarriorTales unidad) {
		this.unidad = unidad;
	}

	ArrayList<PiezaOldWarriorTales> piezasJugador1;
	ArrayList<PiezaOldWarriorTales> piezasJugador2;
	
	ArrayList<JLabel> unitsimg01 = new ArrayList<JLabel>();
	ArrayList<JLabel> unitsimg02 = new ArrayList<JLabel>();
	
	int SelectedX;
	int SelectedY;
	
	JLabel viejo = new JLabel(img);
	
	JLabel[][] mapa = new JLabel[14][13];
	
	
	JLayeredPane layer = new JLayeredPane();


//	public MapPanel(Board map){
	public MapPanel(Board map, ArrayList<PiezaOldWarriorTales> piezasJugador1,ArrayList<PiezaOldWarriorTales> piezasJugador2){	
	
		this.piezasJugador2 = piezasJugador2;
		this.piezasJugador1 = piezasJugador1;
		tab = map;
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

	//	layer.add(circrojo01, new Integer(13));
		
		int x = 800;
		int y = 50;
		colocarMapa(mapa,x,y);
		anyadirUnidades(piezasJugador1, piezasJugador2, this.unitsimg01,this.unitsimg02);
		suelo.setBounds(70, 450, 1500, 800);

	}

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
			layer.add(labels.get(i), new Integer(layer.getLayer(this.mapa[x][y])+2));
			labels.get(i).addMouseListener(this);
			labels.get(i).setBounds(this.mapa[x][y].getLocation().x+10, mapa[x][y].getLocation().y-55, 70, 125);
		}
		for(int i = 0;i<unidadesjug2.size();i++){
			labels2.add(new JLabel(unidadesjug2.get(i).getImagen()));
			int x = unidadesjug2.get(i).getPosition_x();
			int y = unidadesjug2.get(i).getPosition_y();
			layer.add(labels2.get(i), new Integer(layer.getLayer(mapa[x][y])+2));
			labels2.get(i).setBounds(mapa[x][y].getX(), mapa[x][y].getY(), 70, 125);
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

	public boolean esUnidad(JLabel x){
		int i =0;
		boolean enc = false;
		while(i<unitsimg01.size()&&!enc){
			if(unitsimg01.get(i).equals(x))
				enc = true;
			i++;
		}
		if(!enc){
			return false;}
		else
			return true;
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if(!(esUnidad((JLabel)arg0.getSource()))){
		JLabel x = (JLabel) arg0.getSource();
		viejoimg = x.getIcon();
		x.setIcon(selected);
		String nombre = x.getName();
	//	buscarCasilla(nombre);
		viejo = x;
	}
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		viejo.setIcon(viejoimg);
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	if(seleccionado){
		JLabel x = (JLabel) arg0.getSource();
		for(int i = 0; i<mapa.length;i++ ){
			for(int j = 0; j<mapa[i].length;j++){
				if(mapa[i][j].equals(x)){
					int z = 0;
					if(tab.getBoard()[i][j].getPiece()==null){
					boolean enc = false;
					while(z<=unitsimg01.size()&&!enc){
						if(unitsimg01.get(z).equals(selectedUnit)){
							unitsimg01.get(z).setBounds(this.mapa[i][j].getLocation().x+10,this.mapa[i][j].getLocation().y-50,80,90);
							layer.setLayer(unitsimg01.get(z), layer.getLayer(x)+2);
							seleccionado=false;
							this.repaint();
							enc =true;
							System.out.println(tab.getBoard()[unidad.getPosition_x()][unidad.getPosition_y()].getPiece());
							tab.getBoard()[unidad.getPosition_x()][unidad.getPosition_y()].setPiece(null);
							tab.getBoard()[i][j].setPiece(unidad);
							System.out.println(tab.getBoard()[unidad.getPosition_x()][unidad.getPosition_y()].getPiece());
							try {
								unidad.move(i, j);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
							z++;
					}			
			}}
		}
		need_to_update = false;
		}
	}
	else{
		for(int y = 0;y<unitsimg01.size();y++){
			if(unitsimg01.get(y).equals(arg0.getSource())){
				selectedUnit = (JLabel) arg0.getSource();
				need_to_update = true;
				int i = 0;
				boolean en = false;
				while(i<unitsimg01.size()&&!en){
					if(selectedUnit == unitsimg01.get(i)){
						en = true;
						unidad = piezasJugador1.get(i);
				}
					i++;
				}
					
				seleccionado = true;
		}
		}
	}
//		layer.setLayer(unit01, layer.getLayer(x)+2);
//		unit01.setLocation(x.getX(), x.getY()-50);
	}
	
	public boolean isNeed_to_update() {
		return need_to_update;
	}

	public void setNeed_to_update(boolean need_to_update) {
		this.need_to_update = need_to_update;
	}

	public ArrayList<JLabel> getUnitsimg01() {
		return unitsimg01;
	}

	public void setUnitsimg01(ArrayList<JLabel> unitsimg01) {
		this.unitsimg01 = unitsimg01;
	}

	public ArrayList<JLabel> getUnitsimg02() {
		return unitsimg02;
	}

	public void setUnitsimg02(ArrayList<JLabel> unitsimg02) {
		this.unitsimg02 = unitsimg02;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
