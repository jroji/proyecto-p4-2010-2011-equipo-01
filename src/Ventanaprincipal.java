
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Ventanaprincipal extends JFrame  {
	
	private PanelMenuPrincipal O;
	
	public Ventanaprincipal(){
		this.setLayout(new BorderLayout());
		/**
		 * Pagestart simbolo juego
		 * Posible nombre PageEnd...
		 */
		O = new PanelMenuPrincipal(this);
		this.add(O,BorderLayout.CENTER);
	}

}
