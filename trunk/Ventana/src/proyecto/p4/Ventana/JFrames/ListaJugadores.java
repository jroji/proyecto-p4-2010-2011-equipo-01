package proyecto.p4.Ventana.JFrames;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import proyecto.p4.Jugador.Jugador;


public class ListaJugadores extends JFrame {
	
	private JTable table;
	
	public ListaJugadores(ArrayList<Jugador>listaJugadores)
	{
		this.setSize(400, 500);
		
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.setColumnCount(3);
		Object [] l= {"Nick","Avatar"};
		Object[]fila=new String[2];
		for(Jugador j: listaJugadores)
		{
			fila[0]=j.getNick();
			fila[1]=j.getAvatar();
			modelo.addRow(fila);
		}
		modelo.setColumnIdentifiers(l);
		table=new JTable(modelo);
		
		JScrollPane sp= new JScrollPane(table); 
		this.getContentPane().add(sp);
		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		Jugador j1= new Jugador();
		j1.setNick("Raquel");
		j1.setAvatar("Mongola");
		ArrayList<Jugador> array= new ArrayList<Jugador>();
		for(int i=0; i<200; i++)
			array.add(j1);
		ListaJugadores list =new ListaJugadores(array);

	}

}
