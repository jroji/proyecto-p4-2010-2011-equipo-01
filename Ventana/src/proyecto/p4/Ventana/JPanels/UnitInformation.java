package proyecto.p4.Ventana.JPanels;

import java.util.ResourceBundle;

import javax.swing.*;
import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

/**
 * 
 * Este panel nos va a informar de la informacion más esencial de la pieza
 * que sea transferida al panel.
 *
 */
public class UnitInformation extends JPanel {

 
	private static final long serialVersionUID = 1L;
	private JLabel Attack; 
    private JLabel AttackData; //Aqui se mostrara la information del ataque
    private JLabel Defense;
    private JLabel DefenseData; // Aqui se mostrara la informacion de la defensa
    private JLabel Image; //Imagen de la pieza
    private JLabel Movement; 
    private JLabel MovementData; //Informacino sobre su movimiento
    private JLabel Probability;
    private JLabel ProbabilityData; // La probabilidad de la figura
    private ResourceBundle Language;

    public UnitInformation(PiezaOldWarriorTales P,ResourceBundle language) {
    	Language = language;
        initComponents(P);
    }
    
    private void initComponents(PiezaOldWarriorTales P) {

    	/**
    	 * Iniciamos todos los componentes
    	 */
        Image = new JLabel();
        Attack = new JLabel();
        Defense = new JLabel();
        Movement = new JLabel();
        Probability = new JLabel();
        AttackData = new JLabel();
        DefenseData = new JLabel();
        MovementData = new JLabel();
        ProbabilityData = new JLabel();

        this.setOpaque(false);
        
        Image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Attack.setText(Language.getString("label_attack")+":");
        Defense.setText(Language.getString("label_defense")+":");
        Movement.setText(Language.getString("label_movement")+":");
        Probability.setText(Language.getString("label_probability")+":");
        
        /**
         * Ponemos toda la informacion en su respectivo campo
         */
        AttackData.setText(P.getAttack()+"");
        DefenseData.setText(P.getDefense()+"");
        MovementData.setText(P.getMovement()+"");
        ProbabilityData.setText(P.getProbability()+"%");
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addComponent(Probability)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(ProbabilityData))
            .addGroup(layout.createSequentialGroup()
            .addComponent(Movement)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(MovementData))
            .addGroup(layout.createSequentialGroup()
            .addComponent(Defense)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(DefenseData))
            .addGroup(layout.createSequentialGroup()
            .addComponent(Attack, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(AttackData)))
            .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(5, 5, 5)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(Attack)
            .addComponent(AttackData))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(Defense)
            .addComponent(DefenseData))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(Movement)
            .addComponent(MovementData))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(Probability)
            .addComponent(ProbabilityData)))
            .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

}
