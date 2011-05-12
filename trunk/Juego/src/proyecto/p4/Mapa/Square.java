package proyecto.p4.Mapa;


public abstract class Square {

	protected String image; //Contiene la imagen del terreno
	protected String name; // Contiene el nombre del terreno
	
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
	
	//Devuelve el nombre del terreno
	public String getName(){
		return name;
	}


}
