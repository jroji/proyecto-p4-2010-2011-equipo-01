package proyecto.p4.Ventana.JFrames;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ResourceBundle;

import proyecto.p4.Ventana.Button.BotoneraV;
import proyecto.p4.Ventana.JPanels.CreditsPanel;
import proyecto.p4.Ventana.JPanels.LanguagePanel;
import proyecto.p4.Ventana.JPanels.SoundPanel;
import javax.swing.*;

public class OptionWindow extends javax.swing.JFrame // implements MouseListener 
{

	private static final long serialVersionUID = 217355762236510969L;
    private BotoneraV Buttons;
    private JLabel Logo;
    private LanguagePanel languagePanel1;
    private SoundPanel soundPanel1;
    private int ButtonP;

 
	public OptionWindow(String Language,boolean Sound) {
        initComponents(Language,Sound);
    }

    private void initComponents(String Language,boolean Sound){
    	
    	if(Language.equals("Spanish")){
    		Buttons = new BotoneraV("",ResourceBundle.getBundle("MyResource_Es").getString("label_credits"),ResourceBundle.getBundle("MyResource_Es").getString("label_exit"),"","");
    	}else if(Language.equals("English")){
    		Buttons = new BotoneraV("",ResourceBundle.getBundle("MyResource_En").getString("label_credits"),ResourceBundle.getBundle("MyResource_En").getString("label_exit"),"","");
    	}else if(Language.equals("French")){
    		Buttons = new BotoneraV("",ResourceBundle.getBundle("MyResource_Fr").getString("label_credits"),ResourceBundle.getBundle("MyResource_Fr").getString("label_exit"),"","");
    	}

        soundPanel1 = new SoundPanel();
        languagePanel1 = new LanguagePanel(Language);
        
        Logo = new JLabel();
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/lgo.jpg")));
        

     
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
        
        while(true){
       		if(Buttons.getButtonP3()){
    			Buttons.setButtonP3(false);
       			this.dispose();
       			Language= languagePanel1.getSelection();
    			new MainWindow(Language,soundPanel1.SoundOn());
    		}
       		else if(Buttons.getButtonP2()){
       			this.dispose();
       			new CreditWindow();
           }
    }
    }

    public static void main(String args[]) {
    	OptionWindow x = new OptionWindow();

   }

	}





