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
	ImageIcon Barbaro = new ImageIcon(getClass().getResource("/img/barbaro.gif"));
	ImageIcon piedra = new ImageIcon(getClass().getResource("/img/piedra.png"));
//	ImageIcon fond = new ImageIcon(getClass().getResource("/img/fondo.jpg"));
	ImageIcon selected = new ImageIcon(getClass().getResource("/img/SELECCION.png"));
//	ImageIcon circrojo = new ImageIcon(getClass().getResource("/img/marcaroja.png"));
	ImageIcon castillo = new ImageIcon(getClass().getResource("/img/castillo.png"));
	ImageIcon villa = new ImageIcon(getClass().getResource("/img/villa.png"));
	Icon viejoimg;
	Board tab = new Board();
	
//	JLabel fondo = new JLabel(fond);
	
	JLabel unit01 = new JLabel(sold);
	JLabel unit02 = new JLabel(Barbaro);

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
	JLabel img010 = new JLabel(img);
	JLabel img011 = new JLabel(img);
	JLabel img012 = new JLabel(img);
	JLabel img013 = new JLabel(img);
	
	JLabel img11 = new JLabel(img);
	JLabel img12 = new JLabel(img);
	JLabel img13 = new JLabel(castillo);
	JLabel img14 = new JLabel(img);
	JLabel img15 = new JLabel(img);
	JLabel img16 = new JLabel(img);
	JLabel img17 = new JLabel(img);
	JLabel img18 = new JLabel(img);
	JLabel img19 = new JLabel(img);
	JLabel img110 = new JLabel(img);
	JLabel img0111 = new JLabel(img);
	JLabel img0112 = new JLabel(img);
	JLabel img0113 = new JLabel(img);
	
	JLabel img21 = new JLabel(img);
	JLabel img22 = new JLabel(img);
	JLabel img23 = new JLabel(piedra);
	JLabel img24 = new JLabel(piedra);
	JLabel img25 = new JLabel(img);
	JLabel img26 = new JLabel(img);
	JLabel img27 = new JLabel(img);
	JLabel img28 = new JLabel(img);
	JLabel img29 = new JLabel(img);
	JLabel img210 = new JLabel(img);
	JLabel img211 = new JLabel(img);
	JLabel img212 = new JLabel(img);
	JLabel img213 = new JLabel(img);
	
	JLabel img31 = new JLabel(img);
	JLabel img32 = new JLabel(img);
	JLabel img33 = new JLabel(img);
	JLabel img34 = new JLabel(img);
	JLabel img35 = new JLabel(img);
	JLabel img36 = new JLabel(villa);
	JLabel img37 = new JLabel(img);
	JLabel img38 = new JLabel(img);
	JLabel img39 = new JLabel(img);
	JLabel img310 = new JLabel(img);
	JLabel img311 = new JLabel(img);
	JLabel img312 = new JLabel(img);
	JLabel img313 = new JLabel(img);
	
	JLabel img41 = new JLabel(img);
	JLabel img42 = new JLabel(img);
	JLabel img43 = new JLabel(img);
	JLabel img44 = new JLabel(img);
	JLabel img45 = new JLabel(img);
	JLabel img46 = new JLabel(img);
	JLabel img47 = new JLabel(img);
	JLabel img48 = new JLabel(img);
	JLabel img49 = new JLabel(img);
	JLabel img410 = new JLabel(img);
	JLabel img411 = new JLabel(img);
	JLabel img412 = new JLabel(img);
	JLabel img413 = new JLabel(img);
	
	JLabel img51 = new JLabel(img);
	JLabel img52 = new JLabel(img);
	JLabel img53 = new JLabel(img);
	JLabel img54 = new JLabel(img);
	JLabel img55 = new JLabel(img);
	JLabel img56 = new JLabel(piedra);
	JLabel img57 = new JLabel(img);
	JLabel img58 = new JLabel(img);
	JLabel img59 = new JLabel(img);
	JLabel img510 = new JLabel(img);
	JLabel img511 = new JLabel(img);
	JLabel img512 = new JLabel(img);
	JLabel img513 = new JLabel(img);
	
	JLabel img61 = new JLabel(img);
	JLabel img62 = new JLabel(img);
	JLabel img63 = new JLabel(img);
	JLabel img64 = new JLabel(img);
	JLabel img65 = new JLabel(piedra);
	JLabel img66 = new JLabel(piedra);
	JLabel img67 = new JLabel(img);
	JLabel img68 = new JLabel(img);
	JLabel img69 = new JLabel(img);
	JLabel img610 = new JLabel(img);
	JLabel img611 = new JLabel(img);
	JLabel img612 = new JLabel(img);
	JLabel img613 = new JLabel(img);
	
	JLabel img71 = new JLabel(img);
	JLabel img72 = new JLabel(img);
	JLabel img73 = new JLabel(img);
	JLabel img74 = new JLabel(img);
	JLabel img75 = new JLabel(castillo);
	JLabel img76 = new JLabel(villa);
	JLabel img77 = new JLabel(img);
	JLabel img78 = new JLabel(img);
	JLabel img79 = new JLabel(img);
	JLabel img710 = new JLabel(img);
	JLabel img711 = new JLabel(img);
	JLabel img712 = new JLabel(img);
	JLabel img713 = new JLabel(img);
	
	JLabel img81 = new JLabel(img);
	JLabel img82 = new JLabel(img);
	JLabel img83 = new JLabel(img);
	JLabel img84 = new JLabel(img);
	JLabel img85 = new JLabel(img);
	JLabel img86 = new JLabel(img);
	JLabel img87 = new JLabel(villa);
	JLabel img88 = new JLabel(img);
	JLabel img89 = new JLabel(img);
	JLabel img810 = new JLabel(img);
	JLabel img811 = new JLabel(img);
	JLabel img812 = new JLabel(img);
	JLabel img813 = new JLabel(img);
	
	JLabel img91 = new JLabel(img);
	JLabel img92 = new JLabel(img);
	JLabel img93 = new JLabel(img);
	JLabel img94 = new JLabel(img);
	JLabel img95 = new JLabel(img);
	JLabel img96 = new JLabel(img);
	JLabel img97 = new JLabel(villa);
	JLabel img98 = new JLabel(img);
	JLabel img99 = new JLabel(img);
	JLabel img910 = new JLabel(img);
	JLabel img911 = new JLabel(img);
	JLabel img912 = new JLabel(img);
	JLabel img913 = new JLabel(img);
	
	JLabel img101 = new JLabel(img);
	JLabel img102 = new JLabel(img);
	JLabel img103 = new JLabel(img);
	JLabel img104 = new JLabel(img);
	JLabel img105 = new JLabel(img);
	JLabel img106 = new JLabel(img);
	JLabel img107 = new JLabel(villa);
	JLabel img108 = new JLabel(img);
	JLabel img109 = new JLabel(img);
	JLabel img1010 = new JLabel(img);
	JLabel img1011 = new JLabel(img);
	JLabel img1012 = new JLabel(img);
	JLabel img1013 = new JLabel(img);
	
	JLabel img111 = new JLabel(img);
	JLabel img112 = new JLabel(img);
	JLabel img113 = new JLabel(img);
	JLabel img114 = new JLabel(img);
	JLabel img115 = new JLabel(img);
	JLabel img116 = new JLabel(img);
	JLabel img117 = new JLabel(villa);
	JLabel img118 = new JLabel(img);
	JLabel img119 = new JLabel(img);
	JLabel img1110 = new JLabel(img);
	JLabel img1111 = new JLabel(img);
	JLabel img1112 = new JLabel(img);
	JLabel img1113 = new JLabel(img);
	
	JLabel img121 = new JLabel(img);
	JLabel img122 = new JLabel(img);
	JLabel img123 = new JLabel(img);
	JLabel img124 = new JLabel(img);
	JLabel img125 = new JLabel(img);
	JLabel img126 = new JLabel(img);
	JLabel img127 = new JLabel(villa);
	JLabel img128 = new JLabel(img);
	JLabel img129 = new JLabel(img);
	JLabel img1210 = new JLabel(img);
	JLabel img1211 = new JLabel(img);
	JLabel img1212 = new JLabel(img);
	JLabel img1213 = new JLabel(img);
	
	JLabel img131 = new JLabel(img);
	JLabel img132 = new JLabel(img);
	JLabel img133 = new JLabel(img);
	JLabel img134 = new JLabel(img);
	JLabel img135 = new JLabel(img);
	JLabel img136 = new JLabel(img);
	JLabel img137 = new JLabel(villa);
	JLabel img138 = new JLabel(img);
	JLabel img139 = new JLabel(img);
	JLabel img1310 = new JLabel(img);
	JLabel img1311 = new JLabel(img);
	JLabel img1312 = new JLabel(img);
	JLabel img1313 = new JLabel(img);
	
	
	
	
	JLabel[] fila0 = { img01, img02, img03, img04, img05, img06, img07, img08, img09, img010, img011, img012, img013};
	JLabel[] fila1 = { img11, img12, img13, img14, img15, img16, img17, img18, img19, img110, img0111, img0112, img0113};
	JLabel[] fila2 = { img21, img22, img23, img24, img25, img26, img27, img28, img29, img210, img211, img212, img213};
	JLabel[] fila3 = { img31, img32, img33, img34, img35, img36, img37, img38, img39, img310, img311, img312, img313};
	JLabel[] fila4 = { img41, img42, img43, img44, img45, img46, img47, img48, img49, img410, img411, img412, img413};
	JLabel[] fila5 = { img51, img52, img53, img54, img55, img56, img57, img58, img59, img510, img511, img512, img513};
	JLabel[] fila6 = { img61, img62, img63, img64, img65, img66, img67, img68, img69, img610, img611, img612, img613};
	JLabel[] fila7 = { img71, img72, img73, img74, img75, img76, img77, img78, img79, img710, img711, img712, img713};
	JLabel[] fila8= { img81, img82, img83, img84, img85, img86, img87, img88, img89, img810, img811, img812, img813};
	JLabel[] fila9= { img91, img92, img93, img94, img95, img96, img97, img98, img99, img910, img911, img912, img913};
	JLabel[] fila10= { img101, img102, img103, img104, img105, img106, img107, img108, img109, img1010, img1011, img1012, img1013};
	JLabel[] fila11= { img111, img112, img113, img114, img115, img116, img117, img118, img119, img1110, img1111, img1112, img1113};
	JLabel[] fila12= { img121, img122, img123, img124, img125, img126, img127, img128, img129, img1210, img1211, img1212, img1213};
	JLabel[] fila13= { img131, img132, img133, img134, img135, img136, img137, img138, img139, img1310, img1311, img1312, img1313};

	JLabel[][] mapa = {fila0,fila1,fila2,fila3,fila4,fila5,fila6,fila7,fila8,fila9,fila10,fila11,fila12,fila13}; 
	
	
	
	JLayeredPane layer = new JLayeredPane();


//	public MapPanel(Board map){
	public MapPanel(){	
	
		//tab = map;
		
		//Inicializa el mapa de imagenes cogiendo las casillas del Board que recibimos
	//	iniMap(map, mapa);
		setSize(1500,1000);
		setLayout(null);
		
		//Añade el layerPane sobre el que irán las casillas
		layer.setBounds(0, 0, 1500, 1000);
		add(layer);

//		layer.add(fondo, new Integer(-1));
//		fondo.setBounds(0, 0, 1000, 700);
		//Añade al layerPane las casillas del mapa.
		anyadirArray(mapa);
		layer.add(unit01, new Integer(13));
		layer.add(unit02, new Integer(13));

	//	layer.add(circrojo01, new Integer(13));
		
		int x = 800;
		int y = 10;
		colocarMapa(mapa,x,y);
		unit01.setBounds(520, 150, sold.getIconWidth(), sold.getIconHeight());
		unit02.setBounds(520, 150, sold.getIconWidth(), sold.getIconHeight());

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
	
//	public void iniMap(Board map, JLabel[][] array)
//	{
//		for(int i = 0;i<array.length;i++)
//		{
//			for(int j = 0; j<array[i].length;j++){
//				array[i][j].setIcon(map.getMap()[i][j].getSquare().getImage());
//			}
//		}
//	}
	
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
	
	/**Coloca los JLabel del array en el layerpane  
	 * Decide además en que capa del layer se introduciran los elementos
	 */
	public void anyadirArray(JLabel[][] arr){
		for(int j = 0; j<arr.length;j++){
		for(int i = 0; i<arr[j].length;i++){
			layer.add(arr[j][i], new Integer(i+j));
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
		layer.setLayer(unit01, layer.getLayer(x)+1);
		unit01.setLocation(x.getX(), x.getY()-50);
	}
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
