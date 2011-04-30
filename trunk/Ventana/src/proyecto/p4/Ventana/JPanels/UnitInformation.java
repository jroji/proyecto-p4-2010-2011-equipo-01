package proyecto.p4.Ventana.JPanels;

import javax.swing.*;
import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

public class UnitInformation extends JPanel {

 
	private static final long serialVersionUID = 1L;
	private JLabel Attack;
    private JLabel AttackData;
    private JLabel Defense;
    private JLabel DefenseData;
    private JLabel Image;
    private JLabel Movement;
    private JLabel MovementData;
    private JLabel Probability;
    private JLabel ProbabilityData;

    public UnitInformation() {
        initComponents();
    }
    
    private void initComponents(PiezaOldWarriorTales P) {

        Image = new javax.swing.JLabel();
        Attack = new javax.swing.JLabel();
        Defense = new javax.swing.JLabel();
        Movement = new javax.swing.JLabel();
        Probability = new javax.swing.JLabel();
        AttackData = new javax.swing.JLabel();
        DefenseData = new javax.swing.JLabel();
        MovementData = new javax.swing.JLabel();
        ProbabilityData = new javax.swing.JLabel();

        Image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Attack.setText("Ataque:");

        Defense.setText("Defensa:");

        Movement.setText("Movimiento:");

        Probability.setText("Probabilidad:");
        
        AttackData.setText(P.getAttack());
        DefenseData.setText(P.getDefense());
        MovementData.setText(P.getMovement());
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
