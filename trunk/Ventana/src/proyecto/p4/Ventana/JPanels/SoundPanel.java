 package proyecto.p4.Ventana.JPanels;
 
 import java.util.ResourceBundle;

import javax.swing.*;
public class SoundPanel extends javax.swing.JPanel {

    private JRadioButton NoButton;
    private JLabel SoundLabel;
    private JRadioButton YesButton;
    private ButtonGroup buttonGroup1;

   
    public SoundPanel() {
        initComponents();
    }

   
    private void initComponents() {

    	
        buttonGroup1 = new javax.swing.ButtonGroup();
        SoundLabel = new javax.swing.JLabel();
        YesButton = new javax.swing.JRadioButton();
        NoButton = new javax.swing.JRadioButton();

        	if(Language.equals("Spanish")){
        		SoundLabel.setText(ResourceBundle.getBundle("MyResource_Es").getString("label_sound") + ":");
            }else if(Language.equals("English")){
            	SoundLabel.setText(ResourceBundle.getBundle("MyResource_En").getString("label_sound") + ":");
            }else ig(Language.equals("French")){
            	SoundLabel.setText(ResourceBundle.getBundle("MyResource_Fr").getString("label_sound") + ":");
            }

        buttonGroup1.add(YesButton);
        YesButton.setText("Si");

        buttonGroup1.add(NoButton);
        NoButton.setText("No");
        
        buttonGroup1.setSelected(YesButton, true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(25, 25, 25)
            .addComponent(SoundLabel)
            .addGap(18, 18, 18)
            .addComponent(YesButton)
            .addGap(18, 18, 18)
            .addComponent(NoButton)
            .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(SoundLabel)
            .addComponent(YesButton)
            .addComponent(NoButton))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }


	public boolean SoundOn(){
    	return YesButton.isSelected();
    }


}