package proyecto.p4.Ventana.JPanels;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.*;

import proyect.Reflectividad;

public class LanguagePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JComboBox Language;
    private JLabel LanguageText;
    private ResourceBundle selectedLanguage;
    private ArrayList<ResourceBundle> languages;
	
    public LanguagePanel(ResourceBundle language) {
    	selectedLanguage=language;
    	languages=new ArrayList<ResourceBundle>();
        initComponents();
        
    }

    private void initComponents() {
    	
        LanguageText = new javax.swing.JLabel();
        LanguageText.setForeground(java.awt.Color.yellow);
        Language = new javax.swing.JComboBox();
        Language.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Español", "English","French"}));

       	LanguageText.setText(selectedLanguage.getString("label_language") + ":");
       	cargarIdiomasEnCombobox();

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

	public ResourceBundle GetSelection(){
		return (ResourceBundle) Language.getSelectedItem();
    }
    public void cargarIdiomasEnCombobox(){
    	ArrayList<Object> instancias;
    	ArrayList<Object> nombres= new ArrayList<Object>(); 
    	instancias=Reflectividad.instanciarDireccion("name");
    	for (Object o:instancias){
    		if (o instanceof ResourceBundle){
    			languages.add((ResourceBundle) o);
    			nombres.add(o);
    		}
    	}
    	 Language.setModel(new javax.swing.DefaultComboBoxModel(nombres.toArray()));
         Language.setSelectedIndex(0);

    }

}
