package proyecto.p4.Ventana.JPanels;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Jon
 */
public class NickPanel extends javax.swing.JPanel {

    private JLabel Nick1;
    private JLabel Nick2;
    private JTextField nicktext;
    private JTextField nicktext2;
    
    /** Creates new form NickPanel */

    public NickPanel() {
    	
        Nick1 = new JLabel();
        Nick2 = new JLabel();
        nicktext = new JTextField();
        nicktext2 = new JTextField();

        Nick2.setFont(new java.awt.Font("Tahoma", 0, 18));
        Nick1.setFont(new java.awt.Font("Tahoma", 0, 18));
        
        setPreferredSize(new Dimension(500, 260));

        Nick1.setText("Nick 1");
        Nick2.setText("Nick 1");

        nicktext.setText("");

        nicktext2.setText("");

        // Código para colocar y organizar componentes//
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Nick1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nick2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nicktext2)
                    .addComponent(nicktext, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nick1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nicktext, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nick2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nicktext2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }

}
