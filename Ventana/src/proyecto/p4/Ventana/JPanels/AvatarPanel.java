package proyecto.p4.Ventana.JPanels;

/**
 *
 * @author Jon
 */
public class AvatarPanel extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private javax.swing.JLabel Player1Name;
    private javax.swing.JLabel Player2Name;
    
    private javax.swing.JPanel Player1Avatar;
    private javax.swing.JPanel Player2Avatar;
    
    /** Creates new form AvatarPanel */
    public AvatarPanel(String nick1, String nick2) {

        Player2Name = new javax.swing.JLabel();
        Player1Name = new javax.swing.JLabel();
        Player1Avatar = new javax.swing.JPanel();
        Player2Avatar = new javax.swing.JPanel();

        Player2Name.setFont(new java.awt.Font("Tahoma", 0, 18));
        Player1Name.setFont(new java.awt.Font("Tahoma", 0, 18));
        
        Player2Name.setText(nick1);
        Player1Name.setText(nick2);

        Player1Avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout Player1AvatarLayout = new javax.swing.GroupLayout(Player1Avatar);
        Player1Avatar.setLayout(Player1AvatarLayout);
        Player1AvatarLayout.setHorizontalGroup(
            Player1AvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 150, Short.MAX_VALUE)
        );
        Player1AvatarLayout.setVerticalGroup(
            Player1AvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );

        Player2Avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout Player2AvatarLayout = new javax.swing.GroupLayout(Player2Avatar);
        Player2Avatar.setLayout(Player2AvatarLayout);
        Player2AvatarLayout.setHorizontalGroup(
            Player2AvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 152, Short.MAX_VALUE)
        );
        Player2AvatarLayout.setVerticalGroup(
            Player2AvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(Player1Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(168, 168, 168)
                            .addComponent(Player2Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(Player1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(208, 208, 208)
                            .addComponent(Player2Name, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 286, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Player1Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Player2Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Player1Name)
                        .addComponent(Player2Name))
                    .addContainerGap(18, Short.MAX_VALUE)))
        );
    }          

}
