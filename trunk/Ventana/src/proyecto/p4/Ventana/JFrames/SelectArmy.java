package proyecto.p4.Ventana.JFrames;

import javax.swing.JFrame;
import javax.swing.JTable;

import proyecto.p4.Ventana.JPanels.ListAndImage;


public class SelectArmy extends JFrame{

     /**
	 * 
	 */
	private static final long serialVersionUID = -710066457784512920L;
	ListAndImage  x =new ListAndImage();
     JTable table = new JTable();
	
	public SelectArmy()
	{
		this.setSize(1024,720);
		this.setLayout(null);
		this.add(x);
		x.setBounds(0, 0, 280, 720);
		this.setVisible(true);
	}
	public static void main(String[] args)
	{
		SelectArmy x = new SelectArmy();
	}
}
