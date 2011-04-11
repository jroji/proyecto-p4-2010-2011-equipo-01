package proyecto.p4.Ventana.Button;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class OldWarriorButton extends javax.swing.JPanel {

	             
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton OldWarriorButton;
    public JInternalFrame internalFrame;
    public JLabel Text;
    private JLayeredPane layeredpane;
    private String ruta = "D:\\BottonBackground.gif";

    /** Creates new form OldWarriorButton */
    public OldWarriorButton(String TextButton) {

        internalFrame = new JInternalFrame();
        layeredpane = new JLayeredPane();
        Text = new JLabel();
        OldWarriorButton = new javax.swing.JButton();

        Text.setText(TextButton);
        
        internalFrame.setVisible(true);

        javax.swing.GroupLayout internalFrameLayout = new javax.swing.GroupLayout(internalFrame.getContentPane());
        internalFrame.getContentPane().setLayout(internalFrameLayout);
        internalFrameLayout.setHorizontalGroup(
            internalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        internalFrameLayout.setVerticalGroup(
            internalFrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Text.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        Text.setForeground(new java.awt.Color(255, 255, 153));
        Text.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Text.setBounds(30, 20, 140, 20);
        layeredpane.add(Text, javax.swing.JLayeredPane.DEFAULT_LAYER);

        OldWarriorButton.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        OldWarriorButton.setIcon(new javax.swing.ImageIcon(ruta));
        OldWarriorButton.setBounds(0, 0, 140, 60);
        layeredpane.add(OldWarriorButton, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredpane, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layeredpane, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
        );}                           

}
