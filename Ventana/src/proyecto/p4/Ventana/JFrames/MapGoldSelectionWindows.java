

 package proyecto.p4.Ventana.JFrames;

 import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.ResourceBundle;

 import javax.swing.*;


import proyect.Reflectividad;
import proyecto.p4.Juego.*;
import proyecto.p4.JuegoOldWarriorTales.JuegoOldWarriorTales;
import proyecto.p4.Mapa.Board;
import proyecto.p4.Ventana.Button.BotoneraH;
import proyecto.p4.Ventana.Button.OldWarriorButton;
import proyecto.p4.Ventana.JPanels.AvatarPanel;
import proyecto.p4.Ventana.JPanels.GoldSelectionPanel;
 
 
public class MapGoldSelectionWindows extends JFrameFondo implements ActionListener{

	private AvatarPanel AvatarPanel;
    private BotoneraH Botonera;
  //  private JSlider GoldSelection;
    private GoldSelectionPanel GoldSelection;
    private JList MapList;
    private JScrollPane mapList;
    private ResourceBundle Language;
    private boolean Sound;
    private Juego J;
    private ArrayList<Board> boardArray;
    private JuegoOldWarriorTales juego;
    
    public MapGoldSelectionWindows(ResourceBundle language,boolean sound,Juego j) {
    	J = j;
    	Sound = sound;
    	Language = language;
    	juego=new JuegoOldWarriorTales();
        initComponents();
        this.setVisible(true);
    }

    private void initComponents() {

        mapList = new javax.swing.JScrollPane();
        MapList = new javax.swing.JList();
        cargarMapas();
        Botonera = new BotoneraH(Language.getString("label_back"),"",Language.getString("label_accept"));
        GoldSelection = new GoldSelectionPanel(Language);
        AvatarPanel = new AvatarPanel(J);
        AvatarPanel.setVisible(true);
        GoldSelection.setOpaque(false);
        AvatarPanel.setOpaque(false);
        ((OldWarriorButton)Botonera.getComponent(0)).getOldWarriorButton().addActionListener(this);
		((OldWarriorButton)Botonera.getComponent(2)).getOldWarriorButton().addActionListener(this);

		GoldSelection.getAdd().addActionListener(this);
		GoldSelection.getMinus().addActionListener(this);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        mapList.setViewportView(MapList);
        

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addContainerGap()
            .addComponent(MapList, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
            .addGap(84, 84, 84)
            .addComponent(GoldSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(AvatarPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Botonera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
            .addContainerGap()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
            .addComponent(AvatarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGap(18, 18, 18)
            .addComponent(GoldSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(Botonera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(MapList, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
            .addContainerGap())
        );

        setImagen("/img/madera.jpg");
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
			juego.setTablero(boardArray.get(MapList.getSelectedIndex()));
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
	private void cargarMapas()
	{
		ArrayList<Object> array=Reflectividad.instanciarDireccion("Mapas");
		ArrayList<String> nameArray=new ArrayList<String>();
		boardArray= new ArrayList<Board>();
		for(Object o: array)
		{
			if (o instanceof Board)
			{
				nameArray.add(((Board) o).getBoardName());
				boardArray.add((Board) o);
			}
		}
		MapList.setListData(nameArray.toArray());
		MapList.setSelectedIndex(0);
	}

}
