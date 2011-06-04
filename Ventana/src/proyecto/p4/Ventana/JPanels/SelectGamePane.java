package proyecto.p4.Ventana.JPanels;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import proyect.Reflectividad;
import proyecto.p4.Juego.Juego;
import proyecto.p4.Ventana.JFrames.WelcomeWindow;

/**
 *
 * @author Jon
 */
public class SelectGamePane extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private javax.swing.JComboBox SelectGameCombo;
    private javax.swing.JLabel Image;
    private javax.swing.JPanel ImgPane;
    private  ArrayList<Object> instancias;
    private WelcomeWindow welc;
    
    
    /** Creates new form SelectGamePane */
    public SelectGamePane(WelcomeWindow ww) {

    	welc=ww;
        SelectGameCombo = new javax.swing.JComboBox();
        ImgPane = new javax.swing.JPanel();
        Image = new javax.swing.JLabel();
        instancias= new ArrayList<Object>();
        this.setOpaque(false);
        
        
        
   //     SelectGameCombo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        SelectGameCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelectGameComboActionPerformed(evt);
            }
        });

        ImgPane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        javax.swing.GroupLayout ImgPaneLayout = new javax.swing.GroupLayout(ImgPane);
        ImgPane.setLayout(ImgPaneLayout);
        ImgPaneLayout.setHorizontalGroup(
            ImgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Image, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
        );
        ImgPaneLayout.setVerticalGroup(
            ImgPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Image, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(ImgPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SelectGameCombo, javax.swing.GroupLayout.Alignment.LEADING, 0, 323, Short.MAX_VALUE))
                    .addContainerGap(38, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 367, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(SelectGameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(ImgPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        cargarJuegos();
    }


    public void cargarJuegos(){
    	ArrayList<Object>  inst= new ArrayList<Object>();
    	inst=Reflectividad.instanciarDireccion("GamesFile");
    	ArrayList<String>  model= new ArrayList<String>();
    	
    	for (Object o:inst){
    		System.out.println(o.getClass().getSimpleName());
    		if (o instanceof Juego){
    			instancias.add(o);
    			model.add(o.toString());
    		}
    	}
    	SelectGameCombo.setModel(new javax.swing.DefaultComboBoxModel(model.toArray()));
        SelectGameCombo.setSelectedIndex(0);
    }
    
    private void SelectGameComboActionPerformed(java.awt.event.ActionEvent evt) {
    	Juego x = (Juego) instancias.get(SelectGameCombo.getSelectedIndex());
    	welc.selectedGame=x;
    	Image.setIcon(new ImageIcon(x.getRuta()));
    	
}
}
