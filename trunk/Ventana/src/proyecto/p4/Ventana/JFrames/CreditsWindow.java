package proyecto.p4.Ventana.JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import proyecto.p4.Ventana.Button.OldWarriorButton;

public class CreditsWindow extends javax.swing.JFrame implements ActionListener{

	private OldWarriorButton Button;
    private javax.swing.JLabel Credits;
    private javax.swing.JLabel Eneko;
    private javax.swing.JLabel Implementation;
    private javax.swing.JLabel Jon;
    private javax.swing.JLabel Julen;
    private javax.swing.JLabel Pello;
    private javax.swing.JLabel Raquel;
    private javax.swing.JLabel bandaSonora;
    private ResourceBundle Language;
    private boolean Sound;
	
    public CreditsWindow(ResourceBundle language, boolean sound) {
    	Language = language;
    	Sound = sound;
        initComponents();
        
    }
    
    private void initComponents() {

        Julen = new javax.swing.JLabel();
        Raquel = new javax.swing.JLabel();
        Jon = new javax.swing.JLabel();
        Pello = new javax.swing.JLabel();
        bandaSonora = new javax.swing.JLabel();
        Eneko = new javax.swing.JLabel();
        Button = new OldWarriorButton(Language.getString("label_back"));
        Implementation = new javax.swing.JLabel();
        Credits = new javax.swing.JLabel();
        Button.getOldWarriorButton().addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Julen.setText("Julen Telleria Viana");

        Raquel.setText("Raquel Cagigas Tabares");

        Jon.setText("Jon Roji Taboada");

        Pello.setText("Pello Mugica Lopez");

        bandaSonora.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        bandaSonora.setText("Banda Sonora:");

        Eneko.setText("Eneko Villaroel Labanda");
        
     

        Implementation.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        Implementation.setText("Implementacion");

        Credits.setFont(new java.awt.Font("DejaVu Sans", 1, 18)); // NOI18N
        Credits.setText(Language.getString("label_credits"+":"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(42, 42, 42)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Implementation)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(Jon))
            .addGroup(layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(Pello))
            .addGroup(layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addComponent(Eneko))
            .addComponent(bandaSonora)
            .addGroup(layout.createSequentialGroup()
            .addGap(12, 12, 12)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Julen)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(Credits)
            .addComponent(Raquel)))))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addContainerGap(81, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Credits)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(Implementation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Julen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Raquel)
                .addGap(12, 12, 12)
                .addComponent(Jon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pello)
                .addGap(12, 12, 12)
                .addComponent(bandaSonora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Eneko)
                .addGap(18, 18, 18)
                .addComponent(Button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84))
        );

        pack();
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==Button){
			this.dispose();
	    	new OptionWindow(Language,Sound);
		}
	}

}
