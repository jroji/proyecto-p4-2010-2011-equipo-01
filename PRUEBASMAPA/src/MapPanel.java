import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import Proyecto.p4.casilla.Casilla;
import Proyecto.p4.mapa.Board;


public class MapPanel extends JPanel implements MouseListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ImageIcon img = new ImageIcon(getClass().getResource("/img/hierba.png"));
	ImageIcon sold = new ImageIcon(getClass().getResource("/img/arquero.png"));
	ImageIcon piedra = new ImageIcon(getClass().getResource("/img/piedra.png"));
	ImageIcon fond = new ImageIcon(getClass().getResource("/img/fondo.jpg"));
	ImageIcon selected = new ImageIcon(getClass().getResource("/img/SELECCION.png"));
//	ImageIcon circrojo = new ImageIcon(getClass().getResource("/img/marcaroja.png"));
	ImageIcon castillo = new ImageIcon(getClass().getResource("/img/castillo.png"));
	ImageIcon villa = new ImageIcon(getClass().getResource("/img/villa.png"));
	Icon viejoimg;
	Board tab = new Board();
	
	JLabel fondo = new JLabel(fond);
	
	JLabel unit01 = new JLabel(sold);
//	JLabel circrojo01 = new JLabel(circrojo);
	
	
	int SelectedX;
	int SelectedY;
	
	JLabel viejo = new JLabel(img);
//	
//	JLabel img01 = new JLabel();
//	JLabel img02 = new JLabel();
//	JLabel img03 = new JLabel();
//	JLabel img04 = new JLabel();
//	JLabel img05 = new JLabel();
//	JLabel img06 = new JLabel();
//	JLabel img07 = new JLabel();
//	JLabel img08 = new JLabel();
//	JLabel img09 = new JLabel();
//	
//	JLabel img11 = new JLabel();
//	JLabel img12 = new JLabel();
//	JLabel img13 = new JLabel();
//	JLabel img14 = new JLabel();
//	JLabel img15 = new JLabel();
//	JLabel img16 = new JLabel();
//	JLabel img17 = new JLabel();
//	JLabel img18 = new JLabel();
//	JLabel img19 = new JLabel();
//	
//	JLabel img21 = new JLabel();
//	JLabel img22 = new JLabel();
//	JLabel img23 = new JLabel();
//	JLabel img24 = new JLabel();
//	JLabel img25 = new JLabel();
//	JLabel img26 = new JLabel();
//	JLabel img27 = new JLabel();
//	JLabel img28 = new JLabel();
//	JLabel img29 = new JLabel();
//	
//	JLabel img31 = new JLabel();
//	JLabel img32 = new JLabel();
//	JLabel img33 = new JLabel();
//	JLabel img34 = new JLabel();
//	JLabel img35 = new JLabel();
//	JLabel img36 = new JLabel();
//	JLabel img37 = new JLabel();
//	JLabel img38 = new JLabel();
//	JLabel img39 = new JLabel();
//	
//	JLabel img41 = new JLabel();
//	JLabel img42 = new JLabel();
//	JLabel img43 = new JLabel();
//	JLabel img44 = new JLabel();
//	JLabel img45 = new JLabel();
//	JLabel img46 = new JLabel();
//	JLabel img47 = new JLabel();
//	JLabel img48 = new JLabel();
//	JLabel img49 = new JLabel();
//	
//	JLabel img51 = new JLabel();
//	JLabel img52 = new JLabel();
//	JLabel img53 = new JLabel();
//	JLabel img54 = new JLabel();
//	JLabel img55 = new JLabel();
//	JLabel img56 = new JLabel();
//	JLabel img57 = new JLabel();
//	JLabel img58 = new JLabel();
//	JLabel img59 = new JLabel();
//	
//	JLabel img61 = new JLabel();
//	JLabel img62 = new JLabel();
//	JLabel img63 = new JLabel();
//	JLabel img64 = new JLabel();
//	JLabel img65 = new JLabel();
//	JLabel img66 = new JLabel();
//	JLabel img67 = new JLabel();
//	JLabel img68 = new JLabel();
//	JLabel img69 = new JLabel();
//	
//	JLabel img71 = new JLabel();
//	JLabel img72 = new JLabel();
//	JLabel img73 = new JLabel();
//	JLabel img74 = new JLabel();
//	JLabel img75 = new JLabel();
//	JLabel img76 = new JLabel();
//	JLabel img77 = new JLabel();
//	JLabel img78 = new JLabel();
//	JLabel img79 = new JLabel();
//	
//	JLabel img81 = new JLabel();
//	JLabel img82 = new JLabel();
//	JLabel img83 = new JLabel();
//	JLabel img84 = new JLabel();
//	JLabel img85 = new JLabel();
//	JLabel img86 = new JLabel();
//	JLabel img87 = new JLabel();
//	JLabel img88 = new JLabel();
//	JLabel img89 = new JLabel();
//	
	

	
	JLabel img01 = new JLabel(img);
	JLabel img02 = new JLabel(img);
	JLabel img03 = new JLabel(img);
	JLabel img04 = new JLabel(img);
	JLabel img05 = new JLabel(img);
	JLabel img06 = new JLabel(img);
	JLabel img07 = new JLabel(img);
	JLabel img08 = new JLabel(img);
	JLabel img09 = new JLabel(img);
	
	JLabel img11 = new JLabel(img);
	JLabel img12 = new JLabel(img);
	JLabel img13 = new JLabel(castillo);
	JLabel img14 = new JLabel(img);
	JLabel img15 = new JLabel(img);
	JLabel img16 = new JLabel(img);
	JLabel img17 = new JLabel(img);
	JLabel img18 = new JLabel(img);
	JLabel img19 = new JLabel(img);
	
	JLabel img21 = new JLabel(img);
	JLabel img22 = new JLabel(img);
	JLabel img23 = new JLabel(piedra);
	JLabel img24 = new JLabel(piedra);
	JLabel img25 = new JLabel(img);
	JLabel img26 = new JLabel(img);
	JLabel img27 = new JLabel(img);
	JLabel img28 = new JLabel(img);
	JLabel img29 = new JLabel(img);
	
	JLabel img31 = new JLabel(img);
	JLabel img32 = new JLabel(img);
	JLabel img33 = new JLabel(img);
	JLabel img34 = new JLabel(img);
	JLabel img35 = new JLabel(img);
	JLabel img36 = new JLabel(villa);
	JLabel img37 = new JLabel(img);
	JLabel img38 = new JLabel(img);
	JLabel img39 = new JLabel(img);
	
	JLabel img41 = new JLabel(img);
	JLabel img42 = new JLabel(img);
	JLabel img43 = new JLabel(img);
	JLabel img44 = new JLabel(img);
	JLabel img45 = new JLabel(img);
	JLabel img46 = new JLabel(img);
	JLabel img47 = new JLabel(img);
	JLabel img48 = new JLabel(img);
	JLabel img49 = new JLabel(img);
	
	JLabel img51 = new JLabel(img);
	JLabel img52 = new JLabel(img);
	JLabel img53 = new JLabel(img);
	JLabel img54 = new JLabel(img);
	JLabel img55 = new JLabel(img);
	JLabel img56 = new JLabel(piedra);
	JLabel img57 = new JLabel(img);
	JLabel img58 = new JLabel(img);
	JLabel img59 = new JLabel(img);
	
	JLabel img61 = new JLabel(img);
	JLabel img62 = new JLabel(img);
	JLabel img63 = new JLabel(img);
	JLabel img64 = new JLabel(img);
	JLabel img65 = new JLabel(piedra);
	JLabel img66 = new JLabel(piedra);
	JLabel img67 = new JLabel(img);
	JLabel img68 = new JLabel(img);
	JLabel img69 = new JLabel(img);
	
	JLabel img71 = new JLabel(img);
	JLabel img72 = new JLabel(img);
	JLabel img73 = new JLabel(img);
	JLabel img74 = new JLabel(img);
	JLabel img75 = new JLabel(castillo);
	JLabel img76 = new JLabel(villa);
	JLabel img77 = new JLabel(img);
	JLabel img78 = new JLabel(img);
	JLabel img79 = new JLabel(img);
	
	JLabel img81 = new JLabel(img);
	JLabel img82 = new JLabel(img);
	JLabel img83 = new JLabel(img);
	JLabel img84 = new JLabel(img);
	JLabel img85 = new JLabel(img);
	JLabel img86 = new JLabel(img);
	JLabel img87 = new JLabel(villa);
	JLabel img88 = new JLabel(img);
	JLabel img89 = new JLabel(img);
	
		
	
	
	
	
	
	
	JLabel[] fila0 = { img01, img02, img03, img04, img05, img06, img07, img08, img09};
	JLabel[] fila1 = { img11, img12, img13, img14, img15, img16, img17, img18, img19};
	JLabel[] fila2 = { img21, img22, img23, img24, img25, img26, img27, img28, img29};
	JLabel[] fila3 = { img31, img32, img33, img34, img35, img36, img37, img38, img39};
	JLabel[] fila4 = { img41, img42, img43, img44, img45, img46, img47, img48, img49};
	JLabel[] fila5 = { img51, img52, img53, img54, img55, img56, img57, img58, img59};
	JLabel[] fila6 = { img61, img62, img63, img64, img65, img66, img67, img68, img69};
	JLabel[] fila7 = { img71, img72, img73, img74, img75, img76, img77, img78, img79};
	JLabel[] fila8= { img81, img82, img83, img84, img85, img86, img87, img88, img89};

	JLabel[][] mapa = {fila0,fila1,fila2,fila3,fila4,fila5,fila6,fila7,fila8}; 
	
	
	
	JLayeredPane layer = new JLayeredPane();


//	public MapPanel(Board map){
	public MapPanel(){	
	
		//tab = map;
		
		//Inicializa el mapa de imagenes cogiendo las casillas del Board que recibimos
	//	iniMap(map, mapa);
		setSize(1000,700);
		setLayout(null);
		
		//Añade el layerPane sobre el que irán las casillas
		layer.setBounds(0, 0, 1000, 700);
		add(layer);

		layer.add(fondo, new Integer(-1));
		fondo.setBounds(0, 0, 1000, 700);
		//Añade al layerPane las casillas del mapa.
		anyadirArray(mapa);
		layer.add(unit01, new Integer(13));
	//	layer.add(circrojo01, new Integer(13));
		
		int x = 500;
		int y = 10;
		colocarMapa(mapa,x,y);
		unit01.setBounds(520, 150, sold.getIconWidth(), sold.getIconHeight());
	//	circrojo01.setBounds(unit01.getX()+3, unit01.getY()+30, sold.getIconWidth(), sold.getIconHeight());
	}

	/* 1 = norte, 2 = este, 3 = sur, 4 = oeste
	 * 
	 */
	public void moveMap(boolean cond,int dir){
		if(cond){
			switch(dir){
			case 1:
			{
				layer.setLocation(layer.getX(), layer.getY()+10);
				break;
			}
			case 2:
			{
				layer.setLocation(layer.getX()+10, layer.getY());
				break;
			}
			case 3:
			{
				layer.setLocation(layer.getX(), layer.getY()-10);
				break;
			}
			case 4:
			{
				layer.setLocation(layer.getX()-10, layer.getY());
				break;
			}
			}
		}
			
	}
	
	public void iniMap(Board map, JLabel[][] array)
	{
		for(int i = 0;i<array.length;i++)
		{
			for(int j = 0; j<array[i].length;j++){
				array[i][j].setIcon(map.getMap()[i][j].getSquare().getImage());
			}
		}
	}
	
	/*Coloca cada label con su imagen en el sitio correspodiente
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
	
	/*Coloca los JLabel del array en el layerpane  
	 * Decide además en que capa del layer se introduciran los elementos
	 */
	public void anyadirArray(JLabel[][] arr){
		for(int j = 0; j<arr.length;j++){
		for(int i = 0; i<arr[j].length;i++){
			layer.add(arr[j][i], new Integer(i+j));
			}
	}}
	
	public Casilla buscarCasilla(String x){
	int i = 0;
	int j = 0;
	boolean encontrado= false;
		while(j<mapa.length&&!encontrado){
			while(i<mapa[j].length&&!encontrado){
				if(mapa[j][i].getName().equals(x))
					encontrado = true;
				else
					i++;
				}
		if(!encontrado)
			j++;
		}
		return tab.getMap()[j][i];
	}
	

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
		layer.setLayer(unit01, layer.getLayer(x)+1);
		unit01.setLocation(x.getX(), x.getY()-50);
	}
	

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
