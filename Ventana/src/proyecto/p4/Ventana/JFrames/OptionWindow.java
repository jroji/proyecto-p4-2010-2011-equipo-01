package proyecto.p4.Ventana.JFrames;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import proyecto.p4.Juego.*;
import proyecto.p4.Ventana.Button.BotoneraV;
import proyecto.p4.Ventana.JPanels.LanguagePanel;
import proyecto.p4.Ventana.JPanels.SoundPanel;
import javax.swing.*;


public class OptionWindow extends JFrameFondo implements ActionListener // implements MouseListener 
{

	private static final long serialVersionUID = 217355762236510969L;
    private BotoneraV Buttons;
    private JLabel Logo;
    private LanguagePanel languagePanel1;
    private SoundPanel soundPanel1;
    private ResourceBundle Language;
    private boolean Sound;
    private Juego selectedGame;

 
	public OptionWindow(ResourceBundle language,boolean sound,Juego j) {
		selectedGame = j;
		Language=language;
		Sound = sound;
        initComponents();
    }

    private void initComponents(){
    	
    	
    	Buttons = new BotoneraV("",Language.getString("label_credits"),Language.getString("label_exit"),"","");
    	this.setResizable(false);

        soundPanel1 = new SoundPanel(Language);
        soundPanel1.setOpaque(false);
        languagePanel1 = new LanguagePanel(Language);
        languagePanel1.setOpaque(false);
        
        Logo = new JLabel();
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lgo.jpg")));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


     
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(84, 84, 84)
            .addComponent(Buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
            .addGap(62, 62, 62)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(soundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(languagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(layout.createSequentialGroup()
            .addGap(88, 88, 88)
            .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)))
            .addGap(72, 72, 72))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(Logo, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(soundPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(languagePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(Buttons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(20, 20, 20))
        );

        pack();
        setImagen("/img/madera.jpg");
        this.setVisible(true);
        Buttons.getBoton3().getOldWarriorButton().addActionListener(this);
        Buttons.getBoton2().getOldWarriorButton().addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==Buttons.getBoton2().getOldWarriorButton()){
			//this.dispose();
  			new CreditsWindow(Language,Sound,selectedGame).setVisible(true);
		}else if(e.getSource()==Buttons.getBoton3().getOldWarriorButton()){
			Buttons.setButtonP3(false);
   			this.dispose();
   			Language= languagePanel1.GetSelection();
			new MainWindow(Language,soundPanel1.SoundOn(),selectedGame);
		}
		
	}

}





