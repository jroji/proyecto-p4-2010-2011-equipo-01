package proyecto.p4.Ventana.JFrames;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import proyecto.p4.Ventana.Button.BotoneraV;

public class MainWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindow(){
		this.setSize(1024,720);
		this.setLayout(null);
		ImageIcon img = new ImageIcon(getClass().getResource("/img/fondojpg.jpg"));
		JLabel fondo = new JLabel(img);
		JLayeredPane layer = new JLayeredPane();
		layer.setBounds(0, 0, 1024, 720);
		
		this.add(layer, new Integer(0));
		layer.add(fondo);
		fondo.setBounds(0, 0, 1024, 720);
		BotoneraV botoneraV = new BotoneraV("Partida Rápida", "P. Personalizada", "Opciones", "Editor de mapas", "   Salir");
		layer.add(botoneraV, new Integer (1));
		
		botoneraV.setBounds(750, 150,500,500);
		this.setVisible(true);
		this.setResizable(false);
		
	}

	public static void main(String[] args)
	{
		new MainWindow();
	}
}
