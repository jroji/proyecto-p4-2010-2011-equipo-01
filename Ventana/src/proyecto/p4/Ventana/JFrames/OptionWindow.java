package proyecto.p4.Ventana.JFrames;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

import proyecto.p4.Ventana.Button.BotoneraV;
import proyecto.p4.Ventana.JPanels.CreditsPanel;
import proyecto.p4.Ventana.JPanels.LanguagePanel;
import Languages.MyResources_Es;
import proyecto.p4.Ventana.JPanels.SoundPanel;
import javax.swing.*;


public class OptionWindow extends javax.swing.JFrame implements ActionListener // implements MouseListener 
{

	private static final long serialVersionUID = 217355762236510969L;
    private BotoneraV Buttons;
    private JLabel Logo;
    private LanguagePanel languagePanel1;
    private SoundPanel soundPanel1;
    private ResourceBundle Language;
    private boolean Sound;

 
	public OptionWindow(ResourceBundle language,boolean sound) {
		Language=language;
		Sound = sound;
        initComponents(Sound);
    }

    private void initComponents(boolean Sound){
    	
    	
    	Buttons = new BotoneraV("",Language.getString("label_credits"),Language.getString("label_exit"),"","");
    	this.setResizable(false);

        soundPanel1 = new SoundPanel(Language);
        languagePanel1 = new LanguagePanel(Language);
        
        Logo = new JLabel();
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lgo.jpg")));
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

     
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
        this.setVisible(true);
        Buttons.getBoton3().getOldWarriorButton().addActionListener(this);
        Buttons.getBoton2().getOldWarriorButton().addActionListener(this);
//        while(true){
//       		if(Buttons.getButtonP3()){
//    			Buttons.setButtonP3(false);
//       			this.dispose();
//       			Language= languagePanel1.GetSelection();
//    			new MainWindow(Language,soundPanel1.SoundOn());
//    		}
//       		else if(Buttons.getButtonP2()){
//       			this.dispose();
//      			new CreditsPanel(Language,Sound);
//           }
//    }
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==Buttons.getBoton2().getOldWarriorButton()){
			this.dispose();
  			new CreditsWindow(Language,Sound);
		}else if(e.getSource()==Buttons.getBoton3().getOldWarriorButton()){
			Buttons.setButtonP3(false);
   			this.dispose();
   			Language= languagePanel1.GetSelection();
			new MainWindow(Language,soundPanel1.SoundOn());
		}
		
	}
    public static void main(String args[]) {
    	MyResources_Es language = new MyResources_Es();
    	OptionWindow x = new OptionWindow(language,true);
   }


	}





