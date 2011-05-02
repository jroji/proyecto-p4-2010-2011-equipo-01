package proyecto.p4.Ventana.JPanels;

import java.util.ResourceBundle;

import javax.swing.*;

public class LanguagePanel extends JPanel {


	private JComboBox Language;
    private JLabel LanguageText;
	
    public LanguagePanel(String Language) {
        initComponents(Language);
    }

    private void initComponents(String Language) {
    	
        LanguageText = new javax.swing.JLabel();
        Language = new javax.swing.JComboBox();
        if(Language.equals("Spanish")){
        LanguageText.setText(ResourceBundle.getBundle("MyResource_Es").getString("label_Language") + ":");
        }else if(Language.equals("English")){
        	LanguageText.setText(ResourceBundle.getBundle("MyResource_En").getString("label_credits") + ":");
        }else ig(Language.equals("French")){
        	LanguageText.setText(ResourceBundle.getBundle("MyResource_Fr").getString("label_credits") + ":");
        }
        Language.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Español", "Ingles", "Frances"}));
        Language.setSelectedIndex(0);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(24, 24, 24)
            .addComponent(LanguageText, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(Language, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(LanguageText, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

	public String GetSelection(){
    	if((String)Language.getSelectedItem().equals("Español")){
    		return Spanish; 
    	}else if((String)Language.getSelectedItem().equals("Ingles")){
    		return English;
    	}else if((String)Language.getSelectedItem().equals("Frances")){
    		return French;
    	}
    }
    

}
