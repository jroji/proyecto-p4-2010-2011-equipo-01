import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PanelMenuPrincipal extends JPanel implements ActionListener{
	JPanel J; 
	JFrame f; //Ventana del juego
	JButton pRapida; //Partida Rapida
	JButton pPersonalizada; //Partida Personalizada
	JButton pTutorial; //Tutorial
	JButton pOnline; // Online
	JButton bEstadistica; //Ver estadisticas
	JButton bSalir; //Boton Salir

	public PanelMenuPrincipal(JFrame z){
		//Formato Ventana
		f=z;
		J=new JPanel();
		J.setLayout(new SpringLayout());
		
		//Declaracion JButtons
		pRapida = new JButton("Partida rapida");
		pPersonalizada = new JButton("Partida Personalizada");
		pOnline = new JButton("Partida online");
		pTutorial = new JButton ("Partida Tutorial");
		bEstadistica = new JButton ("Estadistica");
		bSalir = new JButton ("Salir");
		
		//Poner ActionListener Botones
		pRapida.addActionListener(this);
		pPersonalizada.addActionListener(this);
		pTutorial.addActionListener(this);
		pOnline.addActionListener(this);
		bEstadistica.addActionListener(this);
		bSalir.addActionListener(this);
		
		//Poner Botones
		J.add(pRapida);
		J.add(pPersonalizada);
		J.add(pOnline);
		J.add(pTutorial);
		J.add(bEstadistica);
		J.add(bSalir);
		SpringUtilities.makeCompactGrid(J,6,1,6,6,6,6);
		this.add(J);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bSalir){
			f.dispose();
		}
	}

	public static void main(String[]args){
		JFrame v = new JFrame();
		PanelMenuPrincipal p=new PanelMenuPrincipal(v);
		v.add(p);
		v.setVisible(true);
	}
}
