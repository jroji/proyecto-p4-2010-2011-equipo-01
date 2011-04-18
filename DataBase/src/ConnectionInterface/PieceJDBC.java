package ConnectionInterface;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;


public class PieceJDBC implements PieceDataSource {

	public static final String DRIVER_CLASS_NAME = "org.sqlite.JDBC";
	public static final String CONNECTION_URL = "jdbc:sqlite:C:/Users/Julen/eclipseWorkSpaces/workspace/DataBase/src/OldWarriorTales.s3db";
	public static Connection connection;
	
	/**
	 * Constructor por defecto que crea un nuevo objeto PieceJDBC con una connection a la base de datos indicada en el
	 * atributo CONNECTION_URL.
	 * @throws ClassNotFoundException 
	 * @throws SQLException
	 */
	public PieceJDBC() throws ClassNotFoundException, SQLException{
		
		Class.forName(DRIVER_CLASS_NAME);
		connection= DriverManager.getConnection(CONNECTION_URL);
		

	}
	/**
	 * This method prints the names of each table of the database.
	 * 
	 * @throws SQLException
	 */
	public void nombreTablas() throws SQLException{
		
		String nombreTablas = "%"; // Listamos todas las tablas
		String tipos[] = new String[1]; // Listamos solo tablas
		tipos[0] = "TABLE";
		DatabaseMetaData dbmd = connection.getMetaData();
		ResultSet tablas = dbmd.getTables( null, null, 
		  nombreTablas, tipos );
		boolean seguir = tablas.next();
		while( seguir ) {
		  // Mostramos solo el nombre de las tablas, guardado
		  // en la columna "TABLE_NAME"
		  System.out.println( 
		    tablas.getString(tablas.findColumn( "TABLE_NAME" )));
		  seguir = tablas.next();
		}
		
	}
	
	/**
	 * This method inserts a value on the specified field of one object.
	 * 
	 * @param instance this is the object in which the value will be inserted.
	 * @param field This is the information about the field whose value will be modified.
	 * @param valor This is the value of the field.
	 * @throws Exception When the type of the field is not one of the next: String, Int, Boolean, Char, Double.
	 */
	public void insertFiels(Object instance, Field field, String valor ) throws Exception{
		
		try{
			field.set(instance,valor );
		}catch(Exception e){
			try{
				field.set(instance,Integer.parseInt(valor) );
			}catch(Exception ex){
				try{
					field.set(instance,Boolean.parseBoolean(valor));
				}catch(Exception exc){
					try{
						field.set(instance,Double.parseDouble(valor ));
					}catch(Exception exce){
						try{
							field.set(instance,valor.toCharArray()[0] );
						}catch(Exception excep){
							try{
								
								Class<?> clase = Class.forName(field.getType().getCanonicalName());
								
								String nombreTablas = "%"; // Listamos todas las tablas
								String tipos[] = new String[1]; // Listamos solo tablas
								tipos[0] = "TABLE";
								DatabaseMetaData dbmd = connection.getMetaData();
								ResultSet tablas = dbmd.getTables( null, null, 
								  nombreTablas, tipos );
								boolean seguir = tablas.next();
								while( seguir ) {
								  
								  if(tablas.getString(tablas.findColumn( "TABLE_NAME" )).equals(clase.getName())){
								    seguir=false;
								    
								    
								    String sqlStatementString = "SELECT * FROM "+ "tableName";
								  }else
								  seguir = tablas.next();
								}
								field.set(instance,Double.parseDouble(valor ));
							}catch(Exception except){
								throw new Exception ("Type not accepted!!!!");
							}
					}
				}
			}
		}
	}
	}
	
	/**
	 * @param tableName This is the name of the database table from which value fields will be extracted.
	 * @param className
	 * @returns ArrayList<Object>
	 * @throws Exception When the type of the field is not one of the next: String, Int, Boolean, Char, Double.
	 */
	public ArrayList<Object> getAll(String tableName,String className) throws Exception {
		ArrayList <Object> c= new ArrayList <Object>();
		
		//Consulta de todos los datos
		Statement statement = connection.createStatement();
		String sqlStatementString = "SELECT * FROM "+ tableName;
		ResultSet resultSet= statement.executeQuery(sqlStatementString);
		
		ResultSetMetaData metaData=resultSet.getMetaData();
		Class<?> clase= Class.forName(className);
		Class[] interfaces=clase.getInterfaces();
		
		//comprobar si la clase implementa storableInDataBase
		int j=0;
		boolean implementa=false;
		while (j<interfaces.length&&!implementa){
			if(interfaces[j].getSimpleName().equals("storableInDataBase"))
				implementa=true;
			j++;
		}
		
		//solo se realiza el proceso si la clase implementa el interfaz
		if(implementa)
		{
		//atributos de la clase
		Field fields[]=clase.getDeclaredFields();
		while (resultSet.next()){
			
			Object instance = clase.newInstance();
			for (Field field : fields){
					int i=0;
					boolean enc =false;
					
					while(i<metaData.getColumnCount() && !enc){
						
						if (metaData.getColumnName(i+1).toLowerCase().equals(field.getName())){
							
							String valor=resultSet.getString(i+1);							
							
							insertFiels(instance, field, valor);							
							
							enc=true;
						}
						i++;
					}
				}
			c.add(instance);
			
		}
		statement.close();
		}
		//sino se lanza una excepcion
		else{
			throw new Exception("This class cannot be stored in the database");
		}
		return c;
	}
	
	
 @Override
	public int insert(String tableName, storableInDataBase object) throws Exception{
		String sqlStatementString = null;
		Statement statement = null;
		statement = connection.createStatement();
		
		ArrayList <Field> fields = object.fieldsToStore(); 
		if (fields==null){
			throw new Exception ("Atributos no disponibles");
		}
		
		String columnas="";
		String valores="";
		for(Field field: fields){
			try {
				if (field.getType().getName().toLowerCase().contains("string")){
					try{
					valores=valores+"'"+field.get(object)+"',";
					columnas=columnas+field.getName()+",";
					}catch (IllegalAccessException iae){
						field.setAccessible(true);
						valores=valores+"'"+field.get(object)+"',";
						columnas=columnas+field.getName()+",";
						field.setAccessible(false);
					}

				}else
					try{
						valores=valores+field.get(object)+",";
						columnas=columnas+field.getName()+",";
					}catch (IllegalAccessException iae){

						System.out.println("dentro");
						field.setAccessible(true);
						valores=valores+field.get(object)+",";
						columnas=columnas+field.getName()+",";
						field.setAccessible(false);
					}
			} catch (IllegalArgumentException e) {
				
			}
		}
		valores=valores.substring(0, valores.length()-1);
		columnas=columnas.substring(0,columnas.length()-1);
		
		sqlStatementString = "INSERT INTO "+tableName+"("+columnas+")"+ "VALUES" +"("+valores+");";
		System.out.println(sqlStatementString);
		statement.executeUpdate(sqlStatementString);
		statement.close();
		
		return 0;
	}

	@Override
	public int remove() throws Exception {
		String sqlStatementString = null;
		Statement statement = null;
		statement = connection.createStatement();
		sqlStatementString = "DELETE FROM Pieces WHERE ()";
		statement.executeUpdate(sqlStatementString);
		statement.close();
		
		
		return 0;
	}

	@Override
	public int modify() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	

	

}
