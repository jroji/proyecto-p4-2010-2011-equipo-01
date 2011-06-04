
 package proyecto.p4.Ventana.JPanels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.*;
import proyecto.p4.Ventana.Button.OldWarriorButton;

/**
 * 
 * Este panel nos va a permitir crear jugadores dejandoles seleccionar un avatar 
 * de los que hemos creado para la ocasion.
 *
 */


public class PlayerCreationPanel extends javax.swing.JPanel implements ActionListener {



	private static final long serialVersionUID = -3650563557524546815L;
	private OldWarriorButton AcceptButton;  //Boton para confirmar la creacion
    private JLabel Avatar; //Label donde pondremos la imagen del avatar
    private JComboBox AvatarSelection; //Aqui iran los diferentes avatares que tengamos.
    private JLabel Nick; 
    private JTextField NickSelection; //Campo para introducir el nick deseado por el usuario
    private ResourceBundle Language;
    private String[] NombreAvatares = new String[10]; //String donde guardaremos los nombre de los avatares

  public PlayerCreationPanel(ResourceBundle language) {

        Language = language;
        for(int i = 0;i<NombreAvatares.length;i++)
        	NombreAvatares[i] = "avatar"+(i+1)+".jpg"; //Cargamos en un array los nombres de los avatares.
        initComponents();
        }

   
    private void initComponents() {
        Nick = new JLabel();
        Nick.setOpaque(false);
        Nick.setForeground(java.awt.Color.yellow);
        NickSelection = new JTextField();
        //NickSelection.setOpaque(false);
        AvatarSelection = new JComboBox(NombreAvatares); //Cargamos los avatares en el JComboBox
        AvatarSelection.setSelectedIndex(0);
        Avatar = new JLabel(new ImageIcon(getClass().getResource("/img/"+(String)AvatarSelection.getSelectedItem()))); //Cargamos en el label la imagen del avatar que ha seleccionado.
        Avatar.setOpaque(false);
        AcceptButton = new OldWarriorButton(Language.getString("label_accept"));
        
        Nick.setText("Nick: ");

        NickSelection.setColumns(20);
        NickSelection.setToolTipText("");

        Avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AvatarSelection.addActionListener(this);
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(35, 35, 35)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
            .addGroup(layout.createSequentialGroup()
            .addComponent(AvatarSelection, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
            .addComponent(Nick)
            .addGap(40, 40, 40)
            .addComponent(NickSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(232, Short.MAX_VALUE)
            .addComponent(AcceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(Nick)
            .addComponent(NickSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addComponent(Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(AcceptButton))
            .addComponent(AvatarSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(50, Short.MAX_VALUE)));
            
          
        }


	public OldWarriorButton getAcceptButton() {
		return AcceptButton;
	}


	public void setAcceptButton(OldWarriorButton acceptButton) {
		AcceptButton = acceptButton;
	}

	public String getNick(){
		return NickSelection.getText();
	}
	
	public String getAvatar(){
		return "/img/"+(String)AvatarSelection.getSelectedItem();
	}
	/**
	 * Metodo que nos permite que el label de la imagen se modifique cuando cambiamos la opcion del JComboBox
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == AvatarSelection)
			Avatar.setIcon(new ImageIcon(getClass().getResource("/img/"+(String)AvatarSelection.getSelectedItem()))); 
	}
}
