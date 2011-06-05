package proyecto.p4.VentanaJuego;
import proyecto.p4.Ventana.JFrames.JFrameFondo;

public class SavingWindow extends JFrameFondo {

   private javax.swing.JLabel SavingLabel;
	
   public SavingWindow() {
       initComponents();
       this.setResizable(false);
       this.setVisible(true);
       
   }

   private void initComponents() {

       SavingLabel = new javax.swing.JLabel();

       setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

       SavingLabel.setText("Guardando...");
       SavingLabel.setForeground(java.awt.Color.yellow);
       
       javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
       getContentPane().setLayout(layout);
       layout.setHorizontalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(91, 91, 91)
               .addComponent(SavingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(107, Short.MAX_VALUE))
       );
       layout.setVerticalGroup(
           layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
           .addGroup(layout.createSequentialGroup()
               .addGap(25, 25, 25)
               .addComponent(SavingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
               .addContainerGap(33, Short.MAX_VALUE))
       );

       pack();
       setImagen("/img/madera.jpg");
   }
  public static void main (String []args)
  {
	  new SavingWindow ();
  }

}
