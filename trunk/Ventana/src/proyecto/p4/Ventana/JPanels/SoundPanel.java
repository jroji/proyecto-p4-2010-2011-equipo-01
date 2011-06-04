 package proyecto.p4.Ventana.JPanels;
 
 import java.awt.Color;
import java.util.ResourceBundle;
import javax.swing.*;

 /**
  * 
  * Mediante este panel vamos a poder seleccionar si queremos sonido en el juego
  *
  */
 
 public class SoundPanel extends javax.swing.JPanel {

    private JRadioButton NoButton;
    private JLabel SoundLabel;
    private JRadioButton YesButton;
    private ButtonGroup buttonGroup1;
    private ResourceBundle Language;

   
    public SoundPanel(ResourceBundle language) {
    	Language = language;
        initComponents();
    }

   
    private void initComponents() {

    	
        buttonGroup1 = new javax.swing.ButtonGroup();
        SoundLabel = new javax.swing.JLabel();
        SoundLabel.setOpaque(false);
        YesButton = new javax.swing.JRadioButton();
        YesButton.setOpaque(false);
        NoButton = new javax.swing.JRadioButton();
        NoButton.setOpaque(false);

        SoundLabel.setText(Language.getString("label_sound") + ":");
        SoundLabel.setForeground(java.awt.Color.yellow);


        buttonGroup1.add(YesButton);
        YesButton.setText(Language.getString("Yes"));
        YesButton.setForeground(java.awt.Color.yellow);

        buttonGroup1.add(NoButton);
        NoButton.setText(Language.getString("No"));
        NoButton.setForeground(java.awt.Color.yellow);
        
        //buttonGroup1.setSelected((ButtonModel) YesButton, true);
        
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


    /**
     * 
     * Este metodo va a retornar un boolean para saber si hemos 
     * seleccionado si queremos el sonido activado
     * 
     */
	public boolean SoundOn(){
    	return YesButton.isSelected();
    }


}
