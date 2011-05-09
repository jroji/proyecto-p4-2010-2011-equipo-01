package proyecto.p4.Ventana.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

public class OldWarriorButton extends javax.swing.JPanel implements MouseListener,ActionListener{
	             
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton OldWarriorButton;
    public JInternalFrame internalFrame;
    public JLabel Text;
    private JLayeredPane layeredpane;
    private String ruta = "D:\\BottonBackground.gif";
    private String rutapulsado = "D:\\BottonBackgroundPulsado.gif";
    private boolean BP;

    /** Creates new form OldWarriorButton */
    public OldWarriorButton(String TextButton) {

        internalFrame = new JInternalFrame();
        layeredpane = new JLayeredPane();
        Text = new JLabel();
        OldWarriorButton = new JButton();
        
        OldWarriorButton.addMouseListener(this);
        OldWarriorButton.addActionListener(this);

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
        layeredpane.add(Text, new Integer(1));

        OldWarriorButton.setFont(new java.awt.Font("Tahoma", 0, 14)); 
        OldWarriorButton.setIcon(new ImageIcon(ruta));
        OldWarriorButton.setBounds(0, 0, 140, 60);
        layeredpane.add(OldWarriorButton,  new Integer(0));

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


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JButton x = (JButton) arg0.getSource();
		x.setIcon(new ImageIcon(rutapulsado));
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		JButton x = (JButton) arg0.getSource();
		x.setIcon(new ImageIcon(ruta));
	}


	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()== OldWarriorButton)
		BP=true;
	}
	
	public boolean isPulsed(){
		return BP;
	}
	

	public boolean isBP() {
		return BP;
	}


	public void setBP(boolean bP) {
		BP = bP;
	}

	public void setText(String text){
		Text.setText(text);
	}


	public String getText() {
		return Text.getText();
	}

}
