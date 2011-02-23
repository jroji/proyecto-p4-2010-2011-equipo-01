
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Ventanaprincipal extends JFrame  {
	
	public Ventanaprincipal(){
		this.setLayout(new BorderLayout());
		this.setSize(1024, 760);
		JPanel J = new JPanel();
		J.setLayout(new SpringLayout());
		J.add(new JLabel());
		JComboBox sGame = new JComboBox();
		sGame.addItem("Old Warriors Tales");
		J.add(sGame);
		J.add(new JLabel("Nick 1: "));
		JTextField Nick1 = new JTextField();
		J.add(Nick1);
		J.add(new JLabel("Nick 2: "));
		JTextField Nick2 = new JTextField();
		J.add(Nick2);
		
		
	}

}
