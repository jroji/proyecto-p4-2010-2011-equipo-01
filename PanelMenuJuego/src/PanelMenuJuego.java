import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;


public class PanelMenuJuego extends JPanel implements ActionListener {

	JPanel J; 
	JFrame f; //Ventana del juego
	JButton bGuardar; //Partida Rapida
	JButton bCargar; //Partida Personalizada
	JButton bSalir; //Boton Salir
	JButton si;
	JButton No;
	JDialog F;

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
		this.setSize(400,200);
	}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==bSalir){
			//Declaracion JDialog
			F = new JDialog();
			F.setLayout(new BorderLayout());
			F.setSize(200,100);
			
			//Poner Botones y Jlabel
			F.add(new JLabel("¿Desea guardar la partida?"),BorderLayout.PAGE_START);
			JPanel j = new JPanel();
			j.setLayout(new SpringLayout());
			j.add(new JLabel("     "));
			si = new JButton("Si");
			si.addActionListener(this);
			j.add(si);
			No = new JButton("No");
			No.addActionListener(this);
			j.add(No);
			j.add(new JLabel());
			SpringUtilities.makeCompactGrid(j,1,4,6,6,6,6);
			F.add(j,BorderLayout.CENTER);
			F.setVisible(true);
		}else if(e.getSource()==No){
			F.dispose();
			f.dispose();
		}else if(e.getSource()==si){
			//Operacion guardar
			F.dispose();
			f.dispose();
		}
	}

	public static void main(String[]args){
		JFrame v = new JFrame();
		v.setSize(400,200);
		PanelMenuJuego p=new PanelMenuJuego(v);
		v.add(p);
		v.setVisible(true);
	}
}
