import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;


public class MapPanel extends JPanel {
	
	ImageIcon img = new ImageIcon(getClass().getResource("/img/hierba.png"));

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
	JLabel img13 = new JLabel(img);
	JLabel img14 = new JLabel(img);
	JLabel img15 = new JLabel(img);
	JLabel img16 = new JLabel(img);
	JLabel img17 = new JLabel(img);
	JLabel img18 = new JLabel(img);
	JLabel img19 = new JLabel(img);
	
	JLabel img21 = new JLabel(img);
	JLabel img22 = new JLabel(img);
	JLabel img23 = new JLabel(img);
	JLabel img24 = new JLabel(img);
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
	JLabel img36 = new JLabel(img);
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
	JLabel img56 = new JLabel(img);
	JLabel img57 = new JLabel(img);
	JLabel img58 = new JLabel(img);
	JLabel img59 = new JLabel(img);
	
	JLabel[] fila0 = { img01, img02, img03, img04, img05, img06, img07, img08, img09};
	JLabel[] fila1 = { img11, img12, img13, img14, img15, img16, img17, img18, img19};
	JLabel[] fila2 = { img21, img22, img23, img24, img25, img26, img27, img28, img29};
	JLabel[] fila3 = { img31, img32, img33, img34, img35, img36, img37, img38, img39};
	JLabel[] fila4 = { img41, img42, img43, img44, img45, img46, img47, img48, img49};
	JLabel[] fila5 = { img51, img52, img53, img54, img55, img56, img57, img58, img59};
	JLabel[][] mapa = {fila0,fila1,fila2,fila3,fila4,fila5};
	JLayeredPane layer = new JLayeredPane();
	
	public MapPanel(){
		
		setSize(1000,700);
		setLayout(null);
		
		layer.setBounds(0, 0, 1000, 700);
		add(layer);

		anyadirArray(mapa);
		
		int x = 500;
		int y = 10;
		colocarMapa(mapa,x,y);
	}

	/*Coloca los JLabel del array en línea empezando recibido en las coordenadas x e y 
	 */
	public void colocarMapa(JLabel[][] imag,int x, int y){
		int inix = x;
		int iniy = y;
		for(int j= 0;j<imag.length;j++){
		for(int i  = 0; i<imag[j].length;i++){
			imag[j][i].setBounds(x, y,img.getIconWidth(), img.getIconHeight());
			x = x+44;
			y = y+38;
		}
		x= inix -55;
		y= iniy +36;
		inix = x;
		iniy = y;}
	}
	
	public void anyadirArray(JLabel[][] arr){
		for(int j = 0; j<arr.length;j++){
		for(int i = 0; i<arr[j].length;i++){
			layer.add(arr[j][i], new Integer(i));
			}
	}}
}
