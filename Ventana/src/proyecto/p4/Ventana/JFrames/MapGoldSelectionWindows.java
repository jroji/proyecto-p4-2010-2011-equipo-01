

 package proyecto.p4.Ventana.JFrames;

 import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

 import javax.swing.*;


import proyecto.p4.Juego.*;
import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.Ventana.JPanels.AvatarPanel;
 
 
public class MapGoldSelectionWindows extends javax.swing.JFrame implements ActionListener{

	private AvatarPanel AvatarPanel;
    private BotoneraH Botonera;
    private JSlider GoldSelection;
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
        GoldSelection = new JSlider();
        Botonera = new BotoneraH(Language.getString("label_back"),"",Language.getString("label_accept"));
        AvatarPanel = new AvatarPanel(J);
        
        ((OldWarriorButton)Botonera.getComponent(0)).getOldWarriorButton().addActionListener(this);
		((OldWarriorButton)Botonera.getComponent(2)).getOldWarriorButton().addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        MapList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(MapList);

        GoldSelection.setMaximum(5000);
        GoldSelection.setMinimum(1000);
        GoldSelection.setValue(3000);
        GoldSelection.setPaintTicks(true);
        GoldSelection.setPaintTrack(true);
        GoldSelection.setPaintLabels(true);

        javax.swing.GroupLayout BotoneraLayout = new javax.swing.GroupLayout(Botonera);
        Botonera.setLayout(BotoneraLayout);
        BotoneraLayout.setHorizontalGroup(
            BotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 260, Short.MAX_VALUE)
        );
        BotoneraLayout.setVerticalGroup(
            BotoneraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 63, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout AvatarPanelLayout = new javax.swing.GroupLayout(AvatarPanel);
        AvatarPanel.setLayout(AvatarPanelLayout);
        AvatarPanelLayout.setHorizontalGroup(
            AvatarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );
        AvatarPanelLayout.setVerticalGroup(
            AvatarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

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
            .addGap(18, 18, 18)
            .addComponent(Botonera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(21, 21, 21))))
        );
        pack();
    }
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new MapGoldSelectionWindows().setVisible(true);
//            }
//        });
//    }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==((OldWarriorButton)Botonera.getComponent(0)).getOldWarriorButton()){
			this.dispose();
			new MainWindow(Language, Sound,J);
		}else{
			this.dispose();
			SelectArmy(Language,Sound,J);
		}
		
	}

}
