import javax.swing.JFrame;


public class Frame extends JFrame{
	
	GamePanel x;
	public Frame()
	{
		this.setSize(500,500);
		//x = new GamePanel()   -   FALTA METODO DE CARGAR MAPA DESDE BD
		this.add(x);
		
	}

}
