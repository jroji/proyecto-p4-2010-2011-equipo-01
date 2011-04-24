package proyecto.p4.Ventana.JPanels;

import javax.swing.*;
import proyecto.p4.piezaOldWarriorTales.*;

public class UnitData extends javax.swing.JPanel {

    /** Creates new form UnitData */
    public UnitData(PiezaOldWarriorTales p) {
        initComponents(p);
    }

    private void initComponents(PiezaOldWarriorTales p) {
    	P=p;
        Image = new javax.swing.JLabel();
        HealthBar = new javax.swing.JProgressBar();
        EnergyBar = new javax.swing.JProgressBar();
        ExperienceBar = new javax.swing.JProgressBar();

        setPreferredSize(new java.awt.Dimension(242, 121));

        Image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        HealthBar.setForeground(new java.awt.Color(255, 0, 0));
        HealthBar.setValue(P.getLife()+"/100");
        HealthBar.setStringPainted(true);

        EnergyBar.setValue(P.getEnergy()+"/100");
        EnergyBar.setStringPainted(true);

        ExperienceBar.setBackground(new java.awt.Color(0, 51, 204));
        ExperienceBar.setForeground(new java.awt.Color(51, 255, 51));
        ExperienceBar.setValue(P.getExperience());
        ExperienceBar.setStringPainted(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(Image, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ExperienceBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(EnergyBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(HealthBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addComponent(Image, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
            .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(HealthBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(EnergyBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(ExperienceBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(26, 26, 26))))
        );
    }
    
    private JProgressBar EnergyBar;
    private JProgressBar ExperienceBar;
    private JProgressBar HealthBar;
    private JLabel Image;
    private PiezaOldWarriorTales P;
    // End of variables declaration//GEN-END:variables

}
