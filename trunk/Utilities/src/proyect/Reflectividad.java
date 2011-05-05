package proyect;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;



public class Reflectividad {
	//fichero que dispone la direccion de los jar

	
	/** 
	 * Devuelve un arrayList con una instancia de cada clase instanciable en el jar
	 * 
	 * @param jarPath Archivo jar a recorrer.
	 * @throws IOException 
	 * @throws IllegalArgumentException Si la longitud del nombre del archivo jar es menor que 5 o no termina en .jar
	 */
	public static ArrayList <Object> jarInstance (File file) throws IOException, IllegalArgumentException{
		ArrayList <Object> objectArray= new ArrayList <Object>();
		
		//si el tamaño del nombre del fichero es menor de 5 lanza la excepcion
		if (file.getName().length()<5){
			throw new IllegalArgumentException("The jar file´s name must have more than 4 characters");
		}
		//asegurarse de que el archivo es .jar, en caso contrario se lanza una excepcion.
		if (file.getName().substring(file.getName().length()-4).equals(".jar")){
			JarFile jarFile= new JarFile (file.getAbsolutePath());
			
			//introduce en el enumerador todas los componentes de jar
			Enumeration<?> entries=jarFile.entries();
			
			//recorre todas los componentes
			while(entries.hasMoreElements()){
				ZipEntry entry= (ZipEntry) entries.nextElement();
				String nom=entry.getName();
				System.out.println(nom);
				nom=nom.replaceAll("/", ".");
				nom=nom.replaceAll(".class", "");
				System.out.println(nom);
				URL[] jarFileURLs= {file.toURI().toURL()};
				ClassLoader classLoader = new URLClassLoader(jarFileURLs);
				try {
					Class <?> clase= Class.forName(nom, false, classLoader);
					Object instance = clase.newInstance();
					objectArray.add(instance);
				} catch (InstantiationException e) {
				} catch (IllegalAccessException e) {
				} catch (ClassNotFoundException e) {
				}
			}
			}
		else{
			throw new IllegalArgumentException("The file name in not correct");
		}
		return objectArray;
	}
	/**
	 * Carga todos las instancias de los objetos instanciables de los jar
	 * disponibles en el directorio indicado en la primera linea del fichero txt indicado
	 * @param direccion Direccion del fichero txt del que se obtendra la direccion del directorio
	 * en el que se buscaran los jar.
	 * @return
	 */
	public static ArrayList <Object> instanciarDireccion(String direccion){
		//cargar fichero con la direccion en donde buscar los jar
		File file= new File (direccion);
		FileInputStream fileInputStream;
		ArrayList<Object> instances= new ArrayList<Object>();
		//recuperar del fichero el directorio de los jar
		try {
			fileInputStream = new FileInputStream(file);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader= new BufferedReader(inputStreamReader);
			String line = bufferedReader.readLine();
			
			//cargar el fichero de los jar
			File folder= new File (line);
			//directorios dentro del directorio
			String [] files = folder.list();
			
			//reconocimiento y procesamiento de los jar
			for (String s: files){
				if (s.length()>4){
					//si es un jar entra en el if
					if (s.substring(s.length()-4, s.length()).equals(".jar")){
						ArrayList<Object> idiomas=jarInstance(new File(line+"\\"+s));
						for (Object ob: idiomas){
							instances.add(ob);
						
						}
						
						}
					}
				}
			System.out.println("idiomas disponibles:");
			
			for (Object ob: instances){
					System.out.println(ob);
			}
			return instances;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}
	public static void main(String[] args) throws IllegalArgumentException, IOException {
		final String direccion="LanguagesFile";
		instanciarDireccion(direccion);
	
	
	}

}
