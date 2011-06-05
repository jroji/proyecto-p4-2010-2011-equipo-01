
package proyecto.p4.Ventana.JPanels;

import javax.swing.ImageIcon;

import proyecto.p4.Juego.*;
import proyecto.p4.Jugador.Jugador;

public class AvatarPanel extends javax.swing.JPanel {

	private javax.swing.JLabel VS;
	private javax.swing.JLabel player1Avatar;
	private javax.swing.JLabel player1Nick;
	private javax.swing.JLabel player2Avatar;
    private javax.swing.JLabel player2Nick;
	private Juego j;
	
    public AvatarPanel(Juego j) {
    	this.j=j;
        initComponents();
    }

    private void initComponents() {

        player2Avatar = new javax.swing.JLabel();
        player1Avatar = new javax.swing.JLabel();
        VS = new javax.swing.JLabel();
        player1Nick = new javax.swing.JLabel();
        player2Nick = new javax.swing.JLabel();
        
        player2Avatar.setOpaque(false);
        player1Avatar.setOpaque(false);
        VS.setOpaque(false);
        player1Nick.setOpaque(false);
        player2Nick.setOpaque(false);


        player2Nick.setText(j.getJugador2().getNick());
        player1Nick.setText(j.getJugador1().getNick());
        
        player1Nick.setForeground(java.awt.Color.yellow);
        player2Nick.setForeground(java.awt.Color.yellow);
        
        player1Avatar= new javax.swing.JLabel(new ImageIcon(getClass().getResource(j.getJugador1().getAvatar())));
        player2Avatar = new javax.swing.JLabel(new ImageIcon(getClass().getResource(j.getJugador2().getAvatar())));
        
        VS = new javax.swing.JLabel(new ImageIcon(getClass().getResource("/img/VS.png")));
        
        player2Avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        player1Avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(player1Avatar, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
            .addComponent(player1Nick, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(VS, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(player2Nick, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
            .addComponent(player2Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(player1Avatar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(player2Avatar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
            .addComponent(VS, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(player2Nick, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
            .addComponent(player1Nick, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(107, 107, 107))
        );
    }
}
