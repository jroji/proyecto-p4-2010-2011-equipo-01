package proyecto.p4.Ventana.JPanels;

import java.awt.FlowLayout;
import java.util.ResourceBundle;

import javax.swing.*;

public class GoldSelectionPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7459961156283125452L;
	private JLabel gold;
	private JTextField goldSelection;
	private JButton add;
	private JButton minus;
	
	public GoldSelectionPanel(ResourceBundle language){
	gold = new JLabel(language.getString("label_gold")+":");
	gold.setOpaque(false);
	gold.setForeground(java.awt.Color.yellow);
	goldSelection = new JTextField(10);
	goldSelection.setText("3000");
	add = new JButton("+");
	add.setOpaque(false);
	minus = new JButton("-");
	minus.setOpaque(false);
	this.setLayout(new FlowLayout());
	this.add(gold);
	this.add(goldSelection);
	this.add(add);
	this.add(minus);
	}
	
	public void setText(String text){
		goldSelection.setText(text);
	}
	
	public int getText(){
		return Integer.parseInt(goldSelection.getText());
	}
	public JButton getAdd(){
		return add;
	}
	public JButton getMinus(){
		return minus;
	}
	
}
