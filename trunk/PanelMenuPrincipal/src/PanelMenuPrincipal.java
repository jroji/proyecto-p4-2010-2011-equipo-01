import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PanelMenuPrincipal extends JPanel implements ActionListener{
	JPanel J;
	JButton pRapida;//Partida Rapida
	JButton pPersonalizada;//Partida Personalizada
	JButton pTutorial;//Tutorial
	//JButton bOpciones;//Entrar opciones
	JButton bSalir;//Boton Salir

	public PanelMenuPrincipal(){
		//Formato Ventana
		J=new JPanel();
		J.setLayout(new SpringLayout());
		
		//Declaracion JButtons
		pRapida = new JButton("Partida rapida");
		pPersonalizada = new JButton("Partida Personalizada");
		pTutorial = new JButton ("Partida Tutorial");
		bSalir = new JButton ("Salir");
		
		//Poner ActionListener Botones
		pRapida.addActionListener(this);
		pPersonalizada.addActionListener(this);
		pTutorial.addActionListener(this);
		bSalir.addActionListener(this);
		
		//Poner Botones
		J.add(pRapida);
		J.add(pPersonalizada);
		J.add(pTutorial);
		J.add(bSalir);
		SpringUtilities.makeCompactGrid(J,4,1,6,6,6,6);
		this.add(J);
		
		
	}
	public void actionPerformed(ActionEvent e) {
		
	}

	public static void main(String[]args){
		JFrame v = new JFrame();
		PanelMenuPrincipal p=new PanelMenuPrincipal();
		v.add(p);
		v.setVisible(true);
	}
}
