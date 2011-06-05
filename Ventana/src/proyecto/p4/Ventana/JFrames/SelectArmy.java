package proyecto.p4.Ventana.JFrames;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import proyect.Reflectividad;
import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.VentanaJuego.GameWindow;
import proyecto.p4.JuegoOldWarriorTales.JuegoOldWarriorTales;
import proyecto.p4.Mapa.Board;
import proyecto.p4.Piece.Colours;
import proyecto.p4.Piece.Piece;
import proyecto.p4.PiezasOldWarriorTales.PiezaOldWarriorTales;
import proyecto.p4.piezaOldWarriorTales.Unidades.King;



	
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
	private JuegoOldWarriorTales J;
	private DefaultTableModel modelo;
	private int gold;
	private boolean selected;
	private boolean sound;
    private ArrayList<PiezaOldWarriorTales> instancias;
    private ArrayList<PiezaOldWarriorTales> array ;
	private ArrayList<PiezaOldWarriorTales> array2 ;
    
    public SelectArmy(ResourceBundle Language,boolean Sound,JuegoOldWarriorTales j,boolean j1Selected,int gold, ArrayList<PiezaOldWarriorTales> array, ArrayList<PiezaOldWarriorTales> array2) {
    	language = Language;
    	J=j;
		this.gold=gold;
		this.array = array;
		this.array2 = array2;
	
		sound = Sound;
		selected = j1Selected;
		modelo = new DefaultTableModel();
		modelo.setColumnCount(3);
		instancias= new ArrayList<PiezaOldWarriorTales>();
		Object [] l= {Language.getString("Name"),Language.getString("Health"),Language.getString("Mana")};
		modelo.setColumnIdentifiers(l);
		
    	initComponents();
        cargarUnidadesEnList();
    	setVisible(true);
    }

    private void initComponents() {

    	
        UnitList = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(modelo);
        BotoneraH = new BotoneraH(language.getString("label_reclute"),"",language.getString("label_accept"));
        GoldLeft = new javax.swing.JLabel();
        Gold = new javax.swing.JLabel();
        PlayerNick = new javax.swing.JLabel();
        PlayerAvatar = new javax.swing.JLabel();
        PlayerAvatar.setOpaque(false);
        
        PlayerAvatar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        PlayerNick.setForeground(java.awt.Color.yellow);
        
        Gold.setText(language.getString("label_gold")+":");
        Gold.setForeground(java.awt.Color.yellow);
        
        GoldLeft.setText(Integer.toString(gold));
        GoldLeft.setForeground(java.awt.Color.yellow);
        
        if(selected){
        PlayerNick.setText(J.getJugador1().getNick());
        
        PlayerAvatar = new JLabel(new ImageIcon(getClass().getResource(J.getJugador1().getAvatar())));
        }else  if(!selected){
        PlayerNick.setText(J.getJugador2().getNick());
        
        PlayerAvatar = new JLabel(new ImageIcon(getClass().getResource(J.getJugador2().getAvatar())));
        }
        
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
            .addComponent(UnitList, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BotoneraH, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)))
            .addGroup(layout.createSequentialGroup()
            .addGap(205, 205, 205)
            .addComponent(Gold, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(GoldLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
            .addGroup(layout.createSequentialGroup()
            .addGap(143, 143, 143)
            .addComponent(PlayerAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap()))
            .addGroup(layout.createSequentialGroup()
            .addGap(195, 195, 195)
            .addComponent(PlayerNick, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UnitList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
            .addComponent(PlayerAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(14, 14, 14)
            .addComponent(PlayerNick, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(BotoneraH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
            .addComponent(Gold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(GoldLeft, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(UnitList, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
            .addGap(3, 3, 3)
            .addComponent(PlayerAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(PlayerNick, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(18, 18, 18)
            .addComponent(BotoneraH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(GoldLeft, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Gold, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addContainerGap())
        );
        
        setImagen("/img/madera.jpg");
        
        pack();
        this.setResizable(false);
    }

    public void cargarUnidadesEnList(){
      	
      	ArrayList<Object> nombres= new ArrayList<Object>(); 
      	nombres=Reflectividad.instanciarDireccion("UnitsFile");
      	ArrayList<String> nombresPiezas= new ArrayList<String>(); 
      	for (Object o:nombres){
      		if (o instanceof PiezaOldWarriorTales){
      			if(!o.getClass().getSimpleName().equals("King")){
	      			instancias.add((PiezaOldWarriorTales) o);
	      			nombresPiezas.add(o.getClass().getSimpleName());
	      		}
      		}
      	}
      	jList1.setListData(nombresPiezas.toArray());
  	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==((OldWarriorButton)BotoneraH.getComponent(0)).getOldWarriorButton()){
			if(instancias.get(jList1.getSelectedIndex())!=null){

				if(Integer.parseInt(GoldLeft.getText())-instancias.get(jList1.getSelectedIndex()).getPrice()>=0){

				Object[]fila=new String[3];
				fila[0] = instancias.get(jList1.getSelectedIndex()).getType();
				fila[1] =new Integer(instancias.get(jList1.getSelectedIndex()).getLife()).toString();
				fila[2] =new Integer (instancias.get(jList1.getSelectedIndex()).getEnergy()).toString();
				modelo.addRow(fila);
				GoldLeft.setText(Integer.toString(Integer.parseInt(GoldLeft.getText())-instancias.get(jList1.getSelectedIndex()).getPrice()));
				if(selected){
					Piece p;
					try {
						p= instancias.get(jList1.getSelectedIndex()).getClass().newInstance();
						((PiezaOldWarriorTales) p).setBoard(J.getTablero());
						((PiezaOldWarriorTales) p).setColor(Colours.rojo);
						array.add((PiezaOldWarriorTales) p);
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					//((PiezaOldWarriorTales) p).setPosition(positionX, positionY);
					//J.getTablero()[((PiezaOldWarriorTales) p).getPosition_x()][((PiezaOldWarriorTales) p).getPosition_y()].setPiece(p);
				}
				else if(!selected){
					Piece p;
					try {
						p = instancias.get(jList1.getSelectedIndex()).getClass().newInstance();
						((PiezaOldWarriorTales) p).setBoard(J.getTablero());
						((PiezaOldWarriorTales) p).setColor(Colours.azul);
						array2.add((PiezaOldWarriorTales) p);
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					

//					((PiezaOldWarriorTales) p).setPosition(positionX, positionY);
//					J.getTablero()[((PiezaOldWarriorTales) p).getPosition_x()][((PiezaOldWarriorTales) p).getPosition_y()].setPiece(p);
				}
				}
			}
		}else if(e.getSource()==((OldWarriorButton)BotoneraH.getComponent(2)).getOldWarriorButton()){
			if(selected){
			this.dispose();
			new SelectArmy(language,sound,J,false,gold, array,array2);
			}else if(!selected){
				this.dispose();
				
				//cargar Partida con el mapa y las unidades.
				King king = new King();
				King king2 = new King();
				king.setBoard(J.getTablero());
				king.setBoard(J.getTablero());
				king.setColor(Colours.rojo);
				array.add(0, king);
				king2.setColor(Colours.azul);
				array2.add(0, king2);
				
				colocarUnidades(array, J.getTablero());
				colocarUnidades(array2,J.getTablero());
				
				new GameWindow(J);
				
			}
		}
	}

	public void colocarUnidades(ArrayList<PiezaOldWarriorTales> array, Board z){
		int indice = 1;
	try{
		if(array.get(0).getColor().equals(Colours.rojo)){
			array.get(0).setPosition(0, 6);
			z.getBoard()[0][6].setPiece(array.get(0));
			for(int i = 1;i<=2;i++){
				for(int j = 0;j<i+1;j++){
					array.get(indice).setPosition(array.get(0).getPosition_x()+j, array.get(0).getPosition_y()-i);
					z.getBoard()[array.get(0).getPosition_x()+j][array.get(0).getPosition_y()-i].setPiece(array.get(indice));
					indice++;
				}
				if(i==2){
					array.get(indice).setPosition(array.get(0).getPosition_x()+i, array.get(0).getPosition_y()-1);
					z.getBoard()[array.get(0).getPosition_x()+i][array.get(0).getPosition_y()-1].setPiece(array.get(indice));
					indice++;
				}
				array.get(indice).setPosition(array.get(0).getPosition_x()+i, array.get(0).getPosition_y());
				z.getBoard()[array.get(0).getPosition_x()+i][array.get(0).getPosition_y()].setPiece(array.get(indice));
				indice++;
				if(i==2){
					array.get(indice).setPosition(array.get(0).getPosition_x()+i, array.get(0).getPosition_y()+1);
					z.getBoard()[array.get(0).getPosition_x()+i][array.get(0).getPosition_y()+1].setPiece(array.get(indice));
					indice++;
				}
				for(int j = i;j>=0;j--){
					array.get(indice).setPosition(array.get(0).getPosition_x()+j, array.get(0).getPosition_y()+i);
					z.getBoard()[array.get(0).getPosition_x()+j][array.get(0).getPosition_y()+i].setPiece(array.get(indice));
					indice++;
				}
			}	
		
		}
		else{
			array.get(0).setPosition(13, 6);
			z.getBoard()[13][6].setPiece(array.get(0));
			for(int i = 1;i<=2;i++){
				for(int j = 0;j<i+1;j++){
					array.get(indice).setPosition(array.get(0).getPosition_x()-j, array.get(0).getPosition_y()+i);
					z.getBoard()[array.get(0).getPosition_x()-j][array.get(0).getPosition_y()+i].setPiece(array.get(indice));
					indice++;
				}
				if(i==2){
					array.get(indice).setPosition(array.get(0).getPosition_x()-i, array.get(0).getPosition_y()+1);
					z.getBoard()[array.get(0).getPosition_x()-i][array.get(0).getPosition_y()+1].setPiece(array.get(indice));
					indice++;
				}
				array.get(indice).setPosition(array.get(0).getPosition_x()-i, array.get(0).getPosition_y());
				z.getBoard()[array.get(0).getPosition_x()-i][array.get(0).getPosition_y()].setPiece(array.get(indice));
				indice++;
				if(i==2){
					array.get(indice).setPosition(array.get(0).getPosition_x()-i, array.get(0).getPosition_y()-1);
					z.getBoard()[array.get(0).getPosition_x()-i][array.get(0).getPosition_y()-1].setPiece(array.get(indice));
					indice++;
				}
				for(int j = i;j>=0;j--){
					array.get(indice).setPosition(array.get(0).getPosition_x()-j, array.get(0).getPosition_y()-i);
					z.getBoard()[array.get(0).getPosition_x()-j][array.get(0).getPosition_y()-i].setPiece(array.get(indice));
					indice++;
				}
			}
		}
			
		
	}
	catch(Exception ex){
	}
	}
}
