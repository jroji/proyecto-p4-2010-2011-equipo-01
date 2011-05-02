package proyecto.p4.Ventana.JPanels;



import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class CreditsPanel {
	
	CreditsPanel(){
		
		// Se crea la ventana con el BoxLayout
		JFrame v = new JFrame();
		
		v.setMinimumSize(new Dimension(200,200));
		v.getContentPane().setLayout(new BoxLayout(v.getContentPane(),BoxLayout.Y_AXIS));
		
		JLabel etiqueta = new JLabel("Julen Tellería");
		etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
		v.getContentPane().add(etiqueta);
		
		JLabel etiqueta2 = new JLabel("Jon Rojí");
		etiqueta2.setAlignmentX(Component.CENTER_ALIGNMENT);
		v.getContentPane().add(etiqueta2);
		
		JLabel etiqueta3 = new JLabel("Raquel Cagigas");
		etiqueta3.setAlignmentX(Component.CENTER_ALIGNMENT);
		v.getContentPane().add(etiqueta3);
		
		JLabel etiqueta4 = new JLabel("Pello Múgica");
		etiqueta4.setAlignmentX(Component.CENTER_ALIGNMENT);
		v.getContentPane().add(etiqueta4);
		
		JLabel etiqueta6 = new JLabel("Compositor de Banda Sonora;");
		etiqueta6.setAlignmentX(Component.CENTER_ALIGNMENT);
		v.getContentPane().add(etiqueta6);
		
		JLabel etiqueta7 = new JLabel("Eneko Villaroel");
		etiqueta7.setAlignmentX(Component.CENTER_ALIGNMENT);
		v.getContentPane().add(etiqueta7);
		
		
		
		// Visualizar la ventana
		v.pack();
		v.setVisible(true);
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	
	
	public static void main(String [] args)
	{
		new CreditsPanel();
	}
}


//import java.awt.BorderLayout;
//import java.awt.Component;
//import java.awt.FlowLayout;
//
//import javax.swing.BoxLayout;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//
//public class CreditsPanel extends JFrame{
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = -5922278640682529564L;
//	public JLabel Julen = new JLabel("Julen Tellería");
//	public JLabel Raquel = new JLabel("Raquel Cagigas");
//	public JLabel Pello = new JLabel("Pello Múgica");
//	public JLabel Jon = new JLabel("Jon Rojí");
//	public JLabel Eneko = new JLabel("Música compuesta por : Eneko Villaroel");
//	
//
//	public CreditsPanel(){
//		this.setSize(230,200);
//		this.getContentPane().setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
//		Julen.setAlignmentX(Component.CENTER_ALIGNMENT);
//		this.getContentPane().add(Julen);
//
//
//		
//		this.setVisible(true);
//	}
//	public static void main(String[] args){
//		new CreditsPanel();
//	}
//}
