

 package proyecto.p4.Ventana.JFrames;

 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

 import javax.swing.*;


import proyecto.p4.Juego.*;
import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.Ventana.JPanels.AvatarPanel;
import proyecto.p4.Ventana.JPanels.GoldSelectionPanel;
 
 
public class MapGoldSelectionWindows extends javax.swing.JFrame implements ActionListener{

	private AvatarPanel AvatarPanel;
    private BotoneraH Botonera;
  //  private JSlider GoldSelection;
    private GoldSelectionPanel GoldSelection;
    private JList MapList;
    private JScrollPane jScrollPane1;
    private ResourceBundle Language;
    private boolean Sound;
    private Juego J;
    
    public MapGoldSelectionWindows(ResourceBundle language,boolean sound,Juego j) {
    	J = j;
    	Sound = sound;
    	Language = language;
        initComponents();
        this.setVisible(true);
    }

    
    private void initComponents() {

        jScrollPane1 = new JScrollPane();
        MapList = new JList();
        GoldSelection = new GoldSelectionPanel(Language);
        Botonera = new BotoneraH(Language.getString("label_back"),"",Language.getString("label_accept"));
        AvatarPanel = new AvatarPanel(J);
        AvatarPanel.setVisible(true);
        
        ((OldWarriorButton)Botonera.getComponent(0)).getOldWarriorButton().addActionListener(this);
		((OldWarriorButton)Botonera.getComponent(2)).getOldWarriorButton().addActionListener(this);

		GoldSelection.getAdd().addActionListener(this);
		GoldSelection.getMinus().addActionListener(this);
		
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MapList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(MapList);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Botonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(AvatarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(GoldSelection, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(31, 31, 31)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
            .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addComponent(AvatarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(GoldSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(13, 13,13)
            .addComponent(Botonera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(21, 21, 21))))
        );
        pack();
    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==((OldWarriorButton)Botonera.getComponent(0)).getOldWarriorButton()){
			this.dispose();
			new MainWindow(Language, Sound,J);
		}else if (e.getSource()==((OldWarriorButton)Botonera.getComponent(2)).getOldWarriorButton()){
			this.dispose();
			ArrayList<Object> Jugador1 = new ArrayList<Object>();
			ArrayList<Object> Jugador2 = new ArrayList<Object>();
			new SelectArmy(Language,Sound,J,Jugador1,Jugador2,true,GoldSelection.getText());

		}else if(e.getSource()==GoldSelection.getAdd()){
			if(GoldSelection.getText()+1000<=5000){
				GoldSelection.setText(Integer.toString(GoldSelection.getText()+1000));
			}
		}else if(e.getSource()==GoldSelection.getMinus()){
			if(GoldSelection.getText()-1000>=1000){
				GoldSelection.setText(Integer.toString(GoldSelection.getText()-1000));
			}
		}
		
	}

}
