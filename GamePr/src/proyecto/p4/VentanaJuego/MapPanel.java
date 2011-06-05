package proyecto.p4.VentanaJuego;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import proyecto.p4.Mapa.Casilla;
import proyecto.p4.Mapa.Board;
import proyecto.p4.Piece.Piece;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.Ventana.JFrames.MainWindow;


/**
 * Panel donde se crea y muestra el mapa del juego y las unidades de cada jugador en el mapa.
 * 
 */

public class MapPanel extends JPanel implements MouseListener{
	
//	ImageIcon piedra = new ImageIcon(getClass().getResource("/img/piedra.png"));
	JLabel suelo  = new JLabel(new ImageIcon(getClass().getResource("/img/suelo.png")));
	ImageIcon selected = new ImageIcon(getClass().getResource("/img/SELECCION.png"));
	ImageIcon selecteds = new ImageIcon(getClass().getResource("/img/SELECCIONs.png"));
	ImageIcon atacable = new ImageIcon(getClass().getResource("/img/atacable.png"));
	ImageIcon circazul = new ImageIcon(getClass().getResource("/img/marcaazul.png"));
	ImageIcon circrojo = new ImageIcon(getClass().getResource("/img/marcaroja.png"));
	JLabel flecha = new JLabel(new ImageIcon(getClass().getResource("/img/flechaSeleccionado.gif")));
	PiezaOldWarriorTales unidad;
	PiezaOldWarriorTales unidadEnemiga;
	private static final long serialVersionUID = 1L;
	ImageIcon img = new ImageIcon(getClass().getResource("/img/hierba.png"));
	Icon viejoimg;
	boolean seleccionado = false;
	JLabel selectedUnit;
	JLabel objectiveUnit;
	Board tab;
	GameWindow gameWindow;
	int turno = 0;
	
	boolean mover = false;
	boolean atacar = false;
	
	ArrayList<PiezaOldWarriorTales> piezasJugador1;
	ArrayList<PiezaOldWarriorTales> piezasJugador2;
	ArrayList<JLabel> unitsimg01 = new ArrayList<JLabel>();
	ArrayList<JLabel> unitsimg02 = new ArrayList<JLabel>();
	ArrayList<JLabel> redunits = new ArrayList<JLabel>();
	ArrayList<JLabel> blueunits = new ArrayList<JLabel>();
	
	JLabel viejo = new JLabel(img);
	JLabel[][] mapa = new JLabel[14][13];
	JLayeredPane layer = new JLayeredPane();

	public ImageIcon getAtacable() {
		return atacable;
	}

	public void setAtacable(ImageIcon atacable) {
		this.atacable = atacable;
	}

	public boolean isAtacar() {
		return atacar;
	}

	public void setAtacar(boolean atacar) {
		this.atacar = atacar;
	}

	public boolean isMover() {
		return mover;
	}

	public void setMover(boolean mover) {
		this.mover = mover;
	}

	
	public ImageIcon getSelecteds() {
		return selecteds;
	}

	public void setSelecteds(ImageIcon selected) {
		this.selecteds = selected;
	}

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
	
	public PiezaOldWarriorTales getUnidad() {
		return unidad;
	}

	public void setUnidad(PiezaOldWarriorTales unidad) {
		this.unidad = unidad;
	}


//	public MapPanel(Board map){
	public MapPanel(Board map, ArrayList<PiezaOldWarriorTales> piezasJugador1,ArrayList<PiezaOldWarriorTales> piezasJugador2,GameWindow gameWindow){	
	
		this.gameWindow = gameWindow;
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
		layer.add(flecha,new Integer(20));
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
			redunits.add(new JLabel(circrojo));
			layer.add(redunits.get(i), new Integer(layer.getLayer(this.mapa[x][y])+2));
			redunits.get(i).setBounds(labels.get(i).getLocation().x,labels.get(i).getLocation().y+60,80,50);
		}
		for(int i = 0;i<unidadesjug2.size();i++){
			labels2.add(new JLabel(unidadesjug2.get(i).getImagen()));
			int x = unidadesjug2.get(i).getPosition_x();
			int y = unidadesjug2.get(i).getPosition_y();
			layer.add(labels2.get(i), new Integer(layer.getLayer(this.mapa[x][y])+2));
			labels2.get(i).addMouseListener(this);
			labels2.get(i).setBounds(this.mapa[x][y].getLocation().x+10, mapa[x][y].getLocation().y-55, 70, 125);
			blueunits.add(new JLabel(circazul));
			layer.add(blueunits.get(i), new Integer(layer.getLayer(this.mapa[x][y])+2));
			blueunits.get(i).setBounds(labels2.get(i).getLocation().x,labels2.get(i).getLocation().y+60,80,50);
		}
	}
	/**Coloca los JLabel del array en el layerpane  
	 * Decide además en que capa del layer se introduciran los elementos
	 */
	public void anyadirArray(JLabel[][] arr){
		for(int j = 0; j<arr.length;j++){
		for(int i = 0; i<arr[j].length;i++){
			layer.add(arr[j][i], new Integer(i));
			}
	}}

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
			i=0;
			while(i<unitsimg02.size()&&!enc){
				if(unitsimg02.get(i).equals(x))
					enc = true;
				i++;
			}
			if(!enc)
				return false;
			}
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
	if(seleccionado&&mover==true){
		JLabel x = (JLabel) arg0.getSource();
		for(int i = 0; i<mapa.length;i++ ){
			for(int j = 0; j<mapa[i].length;j++){
				if(mapa[i][j].equals(x)){
					int z = 0;
					if(tab.getBoard()[i][j].getPiece()==null){
					boolean enc = false;
					if(turno==0)
					{
					while(z<unitsimg01.size()&&!enc){
						if(unitsimg01.get(z).equals(selectedUnit)){
							try {
								unidad.move(i, j);
								unitsimg01.get(z).setBounds(this.mapa[i][j].getLocation().x+10,this.mapa[i][j].getLocation().y-50,80,90);
								layer.setLayer(unitsimg01.get(z), layer.getLayer(x)+2);
								flecha.setBounds(unitsimg01.get(z).getX()+15,unitsimg01.get(z).getY()-35,36,57);
								redunits.get(z).setBounds(unitsimg01.get(z).getLocation().x,unitsimg01.get(z).getLocation().y+60,80,50);
								layer.setLayer(redunits.get(z), layer.getLayer(x)+2);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								JOptionPane.showMessageDialog(this, e.getMessage());
								seleccionado = false;
							}
							finally{
								seleccionado=false;
								mover = false;
								enc =true;
								flecha.setVisible(false);
								recargarMapa();
							}
						}
							z++;
					}			
			}
					else{
						while(z<unitsimg02.size()&&!enc){
							if(unitsimg02.get(z).equals(selectedUnit)){
								try {
									unidad.move(i, j);
									unitsimg02.get(z).setBounds(this.mapa[i][j].getLocation().x+10,this.mapa[i][j].getLocation().y-50,80,90);
									layer.setLayer(unitsimg02.get(z), layer.getLayer(x)+2);
									flecha.setBounds(unitsimg02.get(z).getX()+15,unitsimg02.get(z).getY()-35,36,57);
									blueunits.get(z).setBounds(unitsimg02.get(z).getLocation().x,unitsimg02.get(z).getLocation().y+60,80,50);
									layer.setLayer(blueunits.get(z), layer.getLayer(x)+2);
								} catch (Exception e) {
									// TODO Auto-generated catch block
									JOptionPane.showMessageDialog(this, e.getMessage());
									e.printStackTrace();
								}finally{
									seleccionado=false;
									mover = false;
									enc =true;
									flecha.setVisible(false);
									recargarMapa();
								}
							}
								z++;
						}			
					}
					}
			}
		}
		}
	}
	else if(seleccionado&&atacar==true){
			if(turno==0){
			for(int y = 0;y<unitsimg02.size();y++){
				if(unitsimg02.get(y).equals(arg0.getSource())){
					objectiveUnit = (JLabel) arg0.getSource();
					int i = 0;
					try{
					selectedUnit.setIcon(new ImageIcon(getClass().getResource("/img/"+unidad.getType()+".gif")));
					}
					catch(Exception e){
					}
					boolean en = false;
					while(i<unitsimg02.size()&&!en){
						if(objectiveUnit == unitsimg02.get(i)){
							en = true;
							atacar= false;							
							unidadEnemiga = piezasJugador2.get(i);
							try {
								if(unidad.attack(unidadEnemiga.getPosition_x(), unidadEnemiga.getPosition_y()))
									if(unidadEnemiga.getLife()<=0){
										unidad.setExperience(unidad.getExperience()+25);
										int indice = i;
										selectedUnit=null;
										unitsimg02.get(i).setVisible(false);
										unitsimg02.remove(indice);
										blueunits.remove(indice);
										piezasJugador2.remove(indice);
										tab.getBoard()[unidadEnemiga.getPosition_x()][unidadEnemiga.getPosition_y()].setPiece(null);
										if(unidadEnemiga.getType().equals("King")){
											JOptionPane.showMessageDialog(this, "El rey enemigo ha caido. Felicidades "+gameWindow.getJug2().getNick()+", has ganado.");
											gameWindow.dispose();
										}
										unidadEnemiga = null;
									}
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
								JOptionPane.showMessageDialog(this, e.getMessage());
							}
							recargarMapa();
					}
						i++;
					}
						
					seleccionado = true;
			}
			}
		}
			else{
				for(int y = 0;y<unitsimg01.size();y++){
					if(unitsimg01.get(y).equals(arg0.getSource())){
						objectiveUnit = (JLabel) arg0.getSource();
						int i = 0;
						try{
						selectedUnit.setIcon(new ImageIcon(getClass().getResource("/img/"+unidad.getType()+".gif")));
						}
						catch(Exception e){
						}
						boolean en = false;
						while(i<unitsimg01.size()&&!en){
							if(objectiveUnit == unitsimg01.get(i)){
								en = true;
								atacar= false;							
								unidadEnemiga = piezasJugador1.get(i);
								try {
									if(unidad.attack(unidadEnemiga.getPosition_x(), unidadEnemiga.getPosition_y()))
										if(unidadEnemiga.getLife()<=0){
											unidad.setExperience(unidad.getExperience()+25);
											int indice = i;
											selectedUnit=null;
											unitsimg01.get(i).setVisible(false);
											unitsimg01.remove(indice);
											redunits.get(i).setVisible(false);
											redunits.remove(indice);
											piezasJugador1.remove(indice);
											tab.getBoard()[unidadEnemiga.getPosition_x()][unidadEnemiga.getPosition_y()].setPiece(null);
											if(unidadEnemiga.getType().equals("King")){
												JOptionPane.showMessageDialog(this, "El rey enemigo ha caido. Felicidades "+gameWindow.getJug1().getNick()+", has ganado.");
												gameWindow.dispose();
											}
											unidadEnemiga = null;
										}
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
									JOptionPane.showMessageDialog(this, e.getMessage());
								}
								recargarMapa();
						}
							i++;
						}
							
						seleccionado = true;
				}
				}
			}
	}
	else{
		recargarMapa();
		if(turno==0){
		for(int y = 0;y<unitsimg01.size();y++){
			if(unitsimg01.get(y).equals(arg0.getSource())){
				selectedUnit = (JLabel) arg0.getSource();
						flecha.setVisible(true);
						flecha.setBounds(unitsimg01.get(y).getX()+10,unitsimg01.get(y).getY()-20,36,57);
						unidad = piezasJugador1.get(y);
						gameWindow.getHabilitiesButtons().update(unidad);
						gameWindow.getUnitData().update(unidad);
				}

				seleccionado = true;
		}
		}
		else{
			for(int y = 0;y<unitsimg02.size();y++){
				if(unitsimg02.get(y).equals(arg0.getSource())){
					selectedUnit = (JLabel) arg0.getSource();
							flecha.setVisible(true);
							flecha.setBounds(unitsimg02.get(y).getX()+10,unitsimg02.get(y).getY()-20,36,57);
							unidad = piezasJugador2.get(y);
							gameWindow.getHabilitiesButtons().update(unidad);
							gameWindow.getUnitData().update(unidad);
					}

					seleccionado = true;
			}
			}
	}
//		layer.setLayer(unit01, layer.getLayer(x)+2);
//		unit01.setLocation(x.getX(), x.getY()-50);
	}
	
	public JLabel[][] getMapa() {
		return mapa;
	}

	public void setMapa(JLabel[][] mapa) {
		this.mapa = mapa;
	}

	public JLabel getFlecha() {
		return flecha;
	}

	public int getTurno() {
		return turno;
	}

	public void setTurno(int turno) {
		this.turno = turno;
	}

	public void setFlecha(JLabel flecha) {
		this.flecha = flecha;
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
	public void recargarMapa(){
		for(int p = 0;p<mapa.length;p++){
			for(int o = 0;o<mapa[p].length;o++){
				mapa[p][o].setIcon(new ImageIcon(getClass().getResource(tab.getBoard()[p][o].getSquare().getImage())));
			}
		}
	}
}
