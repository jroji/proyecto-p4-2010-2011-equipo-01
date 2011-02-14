import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class PanelMenuJuego extends JPanel implements ActionListener {

	JPanel J; 
	JFrame f; //Ventana del juego
	JButton bGuardar; //Partida Rapida
	JButton bCargar; //Partida Personalizada
	JButton bSalir; //Boton Salir

	public PanelMenuJuego(JFrame z){
		//Formato Ventana
		f=z;
		J=new JPanel();
		J.setLayout(new SpringLayout());
		
		//Declaracion JButtons
		bGuardar = new JButton("Guardar Partida");
		bCargar = new JButton("Cargar Partida");
		bSalir = new JButton ("Salir");
		
		//Poner ActionListener Botones
		bGuardar.addActionListener(this);
		bCargar.addActionListener(this);
		bSalir.addActionListener(this);
		
		//Poner Botones
		J.add(bGuardar);
		J.add(bCargar);
		J.add(bSalir);
		SpringUtilities.makeCompactGrid(J,3,1,6,6,6,6);
		this.add(J);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bSalir){
			f.dispose();
		}
	}

	public static void main(String[]args){
		JFrame v = new JFrame();
		PanelMenuJuego p=new PanelMenuJuego(v);
		v.add(p);
		v.setVisible(true);
	}
}
