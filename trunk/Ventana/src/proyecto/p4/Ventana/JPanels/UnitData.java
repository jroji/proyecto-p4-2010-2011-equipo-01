package proyecto.p4.Ventana.JPanels;


import java.awt.Dimension;

import javax.swing.*;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;

/**
 * 
 * Este panel nos informa de la situacion de la pieza que queramos en plena partida.
 *
 */

public class UnitData extends JPanel {
	
	
	private static final long serialVersionUID = 1L;
	private JProgressBar EnergyBar; //Muestra la energia restante de la pieza
    private JProgressBar ExperienceBar; //Muestra la experiencia adquirida por la pieza
    private JProgressBar HealthBar; //Muestra la vida restante de la pieza
    private JLabel Image;
    private PiezaOldWarriorTales P; //Pieza de la que obtendremos toda la informacion
    private String experience;
    
    
    public UnitData(PiezaOldWarriorTales p) {
    	P=p;
        initComponents();
    }

    private void initComponents() {
        Image = new JLabel();
        HealthBar = new JProgressBar();
        EnergyBar = new JProgressBar();
        ExperienceBar = new JProgressBar();
        experience = new String();
        experience.

        this.setOpaque(false);
        
        setPreferredSize(new Dimension(242, 121));

        Image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

       
        /**
         * Iniciamos las barras con toda la informaci�n necesaria.
         */
        

        HealthBar.setForeground(new java.awt.Color(255, 0, 0));
        HealthBar.setValue(P.getLife());
        HealthBar.setString(P.getLife()+"/100");
        HealthBar.setStringPainted(true);
        

        EnergyBar.setValue(P.getEnergy());
        EnergyBar.setString(P.getEnergy()+"/100");
        EnergyBar.setStringPainted(true);

        //ExperienceBar.setBackground(new java.awt.Color(0, 51, 204));
        ExperienceBar.setForeground(new java.awt.Color(51, 255, 51));
        ExperienceBar.setValue(P.getExperience());
        ExperienceBar.setString(P.getExperience()+"");
        ExperienceBar.setStringPainted(true);
        ExperienceBar.setForeground(java.awt.Color.red);

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
    public void update(PiezaOldWarriorTales piece){
    	this.EnergyBar.setValue(piece.getEnergy());
    	this.EnergyBar.setString(piece.getEnergy()+"/100");
    	this.ExperienceBar.setValue(piece.getExperience());
    	this.ExperienceBar.setString(piece.getExperience()+"");
    	this.HealthBar.setValue(piece.getLife());
    	this.HealthBar.setString(piece.getLife()+"/100");
    }
}
