import javax.swing.JFrame;


public class GameWindow extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6973735437802698696L;
	GamePanel x = new GamePanel();
	
	public GameWindow()
	{
		this.setSize(1024,720);
		// FALTA METODO DE CARGAR MAPA DESDE BD
		this.add(x);	
//		this.setResizable(false);
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		new GameWindow();
	}
}
