package proyecto.p4.Ventana.JPanels;

import java.awt.FlowLayout;
import java.util.ResourceBundle;

import javax.swing.*;

import proyecto.p4.Ventana.Button.OldWarriorButton;

public class GoldSelectionPanel extends JPanel {
	
	private JLabel gold;
	private JTextField goldSelection;
	private JButton add;
	private JButton minus;
	private JLabel d;
	
	public GoldSelectionPanel(ResourceBundle language){
	gold = new JLabel(language.getString("label_gold")+":");
	d= new JLabel("                                                 ");
	goldSelection = new JTextField(10);
	goldSelection.setText("3000");
	add = new JButton("+");
	minus = new JButton("-");
	this.setLayout(new FlowLayout());
	this.add(d);
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
