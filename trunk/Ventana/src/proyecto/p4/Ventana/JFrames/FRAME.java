package proyecto.p4.Ventana.JFrames;

import javax.swing.JFrame;
import javax.swing.JTable;

import proyecto.p4.Ventana.JPanels.ListAndImage;

public class FRAME extends JFrame {
	
	public FRAME(){
		this.setSize(1024,720);
		this.setLayout(null);
		ListAndImage x = new ListAndImage();
		JTable table = new JTable();
		this.add(x);
		x.setBounds(0, 0, 280, 720);
		this.setVisible(true);
	}
	public static void main(String[] args){
		new FRAME();
	}

}
