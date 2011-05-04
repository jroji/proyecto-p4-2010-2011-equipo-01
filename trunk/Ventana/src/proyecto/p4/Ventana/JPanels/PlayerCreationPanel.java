
 package proyecto.p4.Ventana.JPanels;

import java.util.HashMap;
import java.util.ResourceBundle;

import javax.swing.*;
import proyecto.p4.Ventana.Button.OldWarriorButton;


public class PlayerCreationPanel extends javax.swing.JPanel {


    private OldWarriorButton AcceptButton;
    private JLabel Avatar;
    private JComboBox AvatarSelection;
    private JLabel Nick;
    private JTextField NickSelection;
    private ResourceBundle Language;
    private String[] NombreAvatares = new String[10];

    public PlayerCreationPanel(ResoruceBundle language) {
        Language = language;
        for(int i = 0;i<NombreAvatares.length;i++)
        	NombreAvatares[i] = "avatar"+(i+1)".jpg";
        initComponents();
        }

   
    private void initComponents() {
        Nick = new JLabel();
        NickSelection = new JTextField();
        AvatarSelection = new JComboBox(NombreAvatares);
        AvatarSelection.setSelectedIndex(0);
        Avatar = new JLabel(new ImageIcon(getClass.getResource("/img/"+(String)AvatarSelection.getSelectedItem())));
        AcceptButton = new OldWarriorButton();
        

        Nick.setText("Nick: ");

        NickSelection.setColumns(20);
        NickSelection.setToolTipText("");

        Avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        AcceptButton.setText(Language.getString("label_accept"));
        
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
            .addComponent(AcceptButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(41, 41, 41))
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
            .addContainerGap(50, Short.MAX_VALUE))
        );
        }
}
