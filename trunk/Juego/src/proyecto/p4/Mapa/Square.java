package proyecto.p4.Mapa;


public abstract class Square {

	protected String image; //Contiene la imagen del terreno
	protected String terrain;
	

	public Square (){
		iniName();
		iniImage();
	}

	//Inicializar nombre
	public abstract void iniName();
	
	//Inicializar Imagen
	public abstract void iniImage();
	
	//Devuelve la imagen
	public  String getImage(){
		return image;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	



}
