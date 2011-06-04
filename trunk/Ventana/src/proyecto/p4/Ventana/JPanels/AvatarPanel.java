//package proyecto.p4.Ventana.JPanels;
//
///**
// *
// * @author Jon
// */
//
//import javax.swing.ImageIcon;
//
//import proyecto.p4.Juego.*;
//import proyecto.p4.Jugador.Jugador;
//
//public class AvatarPanel extends javax.swing.JPanel {
//
//    /**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	
//	private javax.swing.JLabel Player1Name;
//    private javax.swing.JLabel Player2Name;
//    
//    private javax.swing.JLabel Player1Avatar;
//    private javax.swing.JLabel Player2Avatar;
//    
//    /** Creates new form AvatarPanel */
//    public AvatarPanel(Juego j) {
//
//        Player2Name = new javax.swing.JLabel();
//        Player1Name = new javax.swing.JLabel();
//        Player1Avatar = new javax.swing.JLabel();
//        Player2Avatar = new javax.swing.JLabel();
//
//        Player2Name.setFont(new java.awt.Font("Tahoma", 0, 18));
//        Player1Name.setFont(new java.awt.Font("Tahoma", 0, 18));
//        
//        Player2Name.setText(j.getJugador2().getNick());
//        Player1Name.setText(j.getJugador1().getNick());
//        
//        Player1Avatar= new javax.swing.JLabel(new ImageIcon(getClass().getResource(j.getJugador1().getAvatar())));
//        Player2Avatar = new javax.swing.JLabel(new ImageIcon(getClass().getResource(j.getJugador2().getAvatar())));
//
//        this.setOpaque(false);
//        
//        Player1Avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
//
//        javax.swing.GroupLayout Player1AvatarLayout = new javax.swing.GroupLayout(Player1Avatar);
//        Player1Avatar.setLayout(Player1AvatarLayout);
//        Player1AvatarLayout.setHorizontalGroup(
//            Player1AvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 150, Short.MAX_VALUE)
//        );
//        Player1AvatarLayout.setVerticalGroup(
//            Player1AvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 186, Short.MAX_VALUE)
//        );
//
//        Player2Avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
//
//        javax.swing.GroupLayout Player2AvatarLayout = new javax.swing.GroupLayout(Player2Avatar);
//        Player2Avatar.setLayout(Player2AvatarLayout);
//        Player2AvatarLayout.setHorizontalGroup(
//            Player2AvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 152, Short.MAX_VALUE)
//        );
//        Player2AvatarLayout.setVerticalGroup(
//            Player2AvatarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 186, Short.MAX_VALUE)
//        );
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
//        this.setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 502, Short.MAX_VALUE)
//            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//            .addContainerGap()
//            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//            .addComponent(Player1Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//            .addGap(168, 168, 168)
//            .addComponent(Player2Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//            .addGroup(layout.createSequentialGroup()
//            .addGap(29, 29, 29)
//            .addComponent(Player1Name, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
//            .addGap(208, 208, 208)
//            .addComponent(Player2Name, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
//            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGap(0, 286, Short.MAX_VALUE)
//            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//            .addGap(37, 37, 37)
//            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//            .addComponent(Player1Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
//            .addComponent(Player2Avatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//            .addComponent(Player1Name)
//            .addComponent(Player2Name))
//            .addContainerGap(18, Short.MAX_VALUE)))
//        );
//    }          
//
//}

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

        player2Nick.setText(j.getJugador2().getNick());
        player1Nick.setText(j.getJugador1().getNick());
        
        player1Avatar= new javax.swing.JLabel(new ImageIcon(getClass().getResource(j.getJugador1().getAvatar())));
        player2Avatar = new javax.swing.JLabel(new ImageIcon(getClass().getResource(j.getJugador2().getAvatar())));
        
        VS = new javax.swing.JLabel(new ImageIcon(getClass().getResource("/img/VS")));
        
        player2Avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        player1Avatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(player1Nick, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(player1Avatar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VS, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(player2Nick, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                    .addComponent(player2Avatar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(VS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(player1Avatar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(player2Avatar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(player2Nick, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(player1Nick, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addContainerGap(107, Short.MAX_VALUE))
        );
    }// </editor-fold>
    // Variables declaration - do not modify
 
    // End of variables declaration
}
