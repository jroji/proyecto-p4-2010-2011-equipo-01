package proyecto.p4.Ventana.JPanels;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import proyect.Reflectividad;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;


/**
 *
 * @author Jon
 */
public class ListAndImage extends javax.swing.JPanel implements ActionListener {
	
    /**
	 * 
	 */
	private JList UnitList;
    private JPanel ImagePanel;
    private JScrollPane scrollPane;
    private OldWarriorButton oldWarriorButton1;
    private ResourceBundle Language;
    private PiezaOldWarriorTales p;
    private ArrayList<PiezaOldWarriorTales> instancias;

    public OldWarriorButton getOldWarriorButton1() {
		return oldWarriorButton1;
	}


	/** Creates new form Units */
   public ListAndImage(ResourceBundle language) {
   //   public ListAndImage() {

	    p= null;
	   	Language = language;
        ImagePanel = new JPanel();
        scrollPane = new JScrollPane();
        UnitList = new JList();
        oldWarriorButton1 = new OldWarriorButton(Language.getString("label_reclute"));
        oldWarriorButton1.getOldWarriorButton().addActionListener(this);
        //oldWarriorButton1 = new OldWarriorButton("H");
        
    	PiezaOldWarriorTales[] array = new PiezaOldWarriorTales[8];
		
		for(int i = 0; i<array.length;i++){
			UnitList = new JList(array);
		}

        ImagePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout ImagePanelLayout = new javax.swing.GroupLayout(ImagePanel);
        ImagePanel.setLayout(ImagePanelLayout);
        ImagePanelLayout.setHorizontalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );
        ImagePanelLayout.setVerticalGroup(
            ImagePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 198, Short.MAX_VALUE)
        );

        UnitList.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        UnitList.setFont(new java.awt.Font("Tahoma", 0, 18));
        UnitList.setModel(new javax.swing.AbstractListModel() {
        	
        	
        	/**
			 * 
			 */
			//METER DATOS
           String[] strings = {};
            public int getSize() { return strings.length; }
           public Object getElementAt(int i) { return strings[i]; }
        });
        
        
        
        scrollPane.setViewportView(UnitList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ImagePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(scrollPane)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(oldWarriorButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(oldWarriorButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(ImagePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cargarUnidadesEnList();
    }


      public void cargarUnidadesEnList(){
      	
      	ArrayList<Object> nombres= new ArrayList<Object>(); 
      	nombres=Reflectividad.instanciarDireccion("UnitsFile");
      	for (Object o:instancias){
      		if (o instanceof PiezaOldWarriorTales){
      			instancias.add((PiezaOldWarriorTales) o);
      			UnitList.add(o.getClass().getName(), new JLabel (o.toString()));
      			//nombres.add(o);
      		}
      	}
      	 //UnitList.setModel(new javax.swing.DefaultComboBoxModel(instancias.toArray()));

      }


	public PiezaOldWarriorTales getP() {
		return instancias.get(UnitList.getSelectedIndex());
	}


	public void setP(PiezaOldWarriorTales p) {
		this.p = p;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == oldWarriorButton1.getOldWarriorButton()){
			p= instancias.get(UnitList.getSelectedIndex());
		}
	}
      
}

