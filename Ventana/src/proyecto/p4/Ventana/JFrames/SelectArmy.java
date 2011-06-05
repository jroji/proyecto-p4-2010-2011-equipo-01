package proyecto.p4.Ventana.JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Languages.*;

import proyect.Reflectividad;
import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.Ventana.JPanels.ListAndImage;
import proyecto.p4.Juego.*;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.piezaOldWarriorTales.Unidades.Arquero;
import proyecto.p4.piezaOldWarriorTales.Unidades.Killer;
import proyecto.p4.piezaOldWarriorTales.Unidades.Magician;
import proyecto.p4.piezaOldWarriorTales.Unidades.Monk;
import proyecto.p4.piezaOldWarriorTales.Unidades.Soldier;
import proyecto.p4.piezaOldWarriorTales.Unidades.knight;


//public class SelectArmy extends JFrameFondo implements ActionListener{
//
//     /**
//	 * 
//	 */
//	private static final long serialVersionUID = -710066457784512920L;
//	ListAndImage  x ;
//	
//     JTable table = new JTable();
//     private ResourceBundle language;
//     private Juego J;
//     private ArrayList<Object> jugador1;
//     private ArrayList<Object> jugador2;
//     private boolean selected;
//     private DefaultTableModel modelo;
//     private boolean sound;
//     private int gold;
//     private JPanel Ventana;
//	
//	public SelectArmy(ResourceBundle Language,boolean Sound,Juego j,ArrayList<Object> j1,ArrayList<Object> j2,boolean j1Selected,int gold)
//	{
//		language = Language;
//		this.gold=gold;
//		jugador1 = j1;
//		jugador2 = j2;
//		sound = Sound;
//		selected = j1Selected;
//		modelo = new DefaultTableModel();
//		modelo.setColumnCount(3);
//		Object [] l= {Language.getString("Name"),Language.getString("Health"),Language.getString("Mana")};
//		modelo.setColumnIdentifiers(l);
//		table= new JTable(modelo);
//		J=j;
//		Ventana= new JPanel();
//		//x.addMouseListener(this);
//		this.setSize(1024,720);
//		this.setLayout(null);
//		x = new ListAndImage(Language);
//		this.add(x);
//		this.add(table);
//		((OldWarriorButton)x.getButtons().getComponent(0)).getOldWarriorButton().addActionListener(this);
//		((OldWarriorButton)x.getButtons().getComponent(2)).getOldWarriorButton().addActionListener(this);	  
//		table.setBounds(280, 320, 650,300 );
//		x.setBounds(0, 0, 280, 720);
//		this.setVisible(true);
//		setImagen("/img/madera.jpg");
//		this.setVisible(true);
//	}
	
public class SelectArmy extends JFrameFondo implements ActionListener{

	private BotoneraH BotoneraH;
	private ResourceBundle language;
	private javax.swing.JLabel Gold;
	private javax.swing.JLabel GoldLeft;
	private javax.swing.JLabel PlayerAvatar;
	private javax.swing.JLabel PlayerNick;
	private javax.swing.JScrollPane UnitList;
	private javax.swing.JList jList1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	private ArrayList<Object> jugador1;
	private ArrayList<Object> jugador2;
	private Juego J;
	private DefaultTableModel modelo;
	private int gold;
	private boolean selected;
	private boolean sound;
    private ArrayList<PiezaOldWarriorTales> instancias;
	
    public SelectArmy(ResourceBundle Language,boolean Sound,Juego j,ArrayList<Object> j1,ArrayList<Object> j2,boolean j1Selected,int gold) {
    	language = Language;
		this.gold=gold;
		jugador1 = j1;
		jugador2 = j2;
		sound = Sound;
		selected = j1Selected;
		modelo = new DefaultTableModel();
		modelo.setColumnCount(3);
		instancias= new ArrayList<PiezaOldWarriorTales>();
		Object [] l= {Language.getString("Name"),Language.getString("Health"),Language.getString("Mana")};
		modelo.setColumnIdentifiers(l);
		J=j;
    	initComponents();
    	setVisible(true);
    }

    private void initComponents() {

    	
        UnitList = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        cargarUnidadesEnList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(modelo);
        BotoneraH = new BotoneraH(language.getString("label_reclute"),"",language.getString("label_accept"));
        GoldLeft = new javax.swing.JLabel();
        Gold = new javax.swing.JLabel();
        PlayerNick = new javax.swing.JLabel();
        PlayerAvatar = new javax.swing.JLabel();
       
        ((OldWarriorButton)BotoneraH.getComponent(0)).getOldWarriorButton().addActionListener(this);
		((OldWarriorButton)BotoneraH.getComponent(1)).getOldWarriorButton().addActionListener(this);
		((OldWarriorButton)BotoneraH.getComponent(2)).getOldWarriorButton().addActionListener(this);	 


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        
        UnitList.setViewportView(jList1);
        jList1.setModel(new javax.swing.AbstractListModel() {
			//METER DATOS
           String[] strings = {};
            public int getSize() { return strings.length; }
           public Object getElementAt(int i) { return strings[i]; }
        });

        jScrollPane1.setViewportView(jTable1);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(UnitList, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
            .addGap(49, 49, 49)
            .addComponent(Gold, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(34, 34, 34)
            .addComponent(GoldLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(BotoneraH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(PlayerNick, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(59, 59, 59)
            .addComponent(PlayerAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PlayerNick, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
            .addGap(35, 35, 35)
            .addComponent(PlayerAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGap(18, 18, 18)
            .addComponent(BotoneraH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(Gold, javax.swing.GroupLayout.DEFAULT_SIZE, 14, Short.MAX_VALUE)
            .addComponent(GoldLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(UnitList, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
            .addContainerGap())
        );

        setImagen("/img/madera.jpg");
        
        pack();
    }

    public void cargarUnidadesEnList(){
      	
      	ArrayList<Object> nombres= new ArrayList<Object>(); 
      	nombres=Reflectividad.instanciarDireccion("UnitsFile");
      	for (Object o:nombres){
      		if (o instanceof PiezaOldWarriorTales){
      			instancias.add((PiezaOldWarriorTales) o);
      			jList1.add(o.getClass().getName(), new JLabel (o.toString()));
      			//jList1.add(o.getClass().getName());
      			//nombres.add(o);
      		}
      	}
  	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==((OldWarriorButton)BotoneraH.getComponent(0)).getOldWarriorButton()){
			if(instancias.get(jList1.getSelectedIndex())!=null){
				Object[]fila=new String[3];
				fila[0] = instancias.get(jList1.getSelectedIndex()).getType();
				fila[1] = instancias.get(jList1.getSelectedIndex()).getLife();
				fila[2] = instancias.get(jList1.getSelectedIndex()).getEnergy();
				modelo.addRow(fila);
				if(selected = true)
					jugador1.add(instancias.get(jList1.getSelectedIndex()));
				else
					jugador2.add(instancias.get(jList1.getSelectedIndex()));
			}
		}else if(e.getSource()==((OldWarriorButton)BotoneraH.getComponent(2)).getOldWarriorButton()){
			if(selected){
			this.dispose();
			new SelectArmy(language,sound,J,jugador1,jugador2,false,gold);
			}else{
				this.dispose();
				//cargar Partida con el mapa y las unidades.
				
			}
		}
	}
}
