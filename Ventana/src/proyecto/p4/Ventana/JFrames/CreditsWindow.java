/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CreditsWindow.java
 *
 * Created on 01-jun-2011, 12:53:33
 */

package proyecto.p4.Ventana.JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import proyecto.p4.Ventana.Button.OldWarriorButton;

public class CreditsWindow extends javax.swing.JFrame implements ActionListener{


    private OldWarriorButton Button;
    private javax.swing.JLabel Eneko;
    private javax.swing.JLabel Jon;
    private javax.swing.JLabel Julen;
    private javax.swing.JLabel Pello;
    private javax.swing.JLabel Raquel;
    private javax.swing.JLabel bandaSonora;
    private ResourceBundle Language;
    private boolean Sound;
    
	
    public CreditsWindow(ResourceBundle language, boolean sound) {
    	Sound= sound;
    	Language= language;
        initComponents();
    }

    private void initComponents() {

        Julen = new javax.swing.JLabel();
        Raquel = new javax.swing.JLabel();
        Jon = new javax.swing.JLabel();
        Pello = new javax.swing.JLabel();
        bandaSonora = new javax.swing.JLabel();
        Eneko = new javax.swing.JLabel();
        Button = new OldWarriorButton(Language.getString("label_back"));
        Button.getOldWarriorButton().addActionListener(this);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Julen.setText("Julen Telleria Viana");

        Raquel.setText("Raquel Cagigas Tabares");

        Jon.setText("Jon Roji Taboada");

        Pello.setText("Pello Mugica Lopez");

        bandaSonora.setText("Banda Sonora:");

        Eneko.setText("Eneko Villaroel Labanda");

        Button.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(62, 62, 62)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(Eneko))
            .addComponent(bandaSonora)
            .addComponent(Pello)
            .addComponent(Jon)
            .addComponent(Raquel)
            .addComponent(Julen))
            .addContainerGap(176, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap(256, Short.MAX_VALUE)
            .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(38, 38, 38)
            .addComponent(Julen)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(Raquel)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(Jon)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(Pello)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(bandaSonora)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(Eneko)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
            .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(25, 25, 25))
        );
        pack();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Button){
			this.dispose();
	    	new OptionWindow(Language,Sound);
		}
	}
}