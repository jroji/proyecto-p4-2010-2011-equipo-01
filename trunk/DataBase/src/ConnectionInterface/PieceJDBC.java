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
	public static final String CONNECTION_URL = "jdbc:sqlite:C:/Users/Raquel/workspace/DataBase/src/car.s3db";
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
	
	public ArrayList nombreTablas() throws SQLException{
		ArrayList <String >n = new ArrayList();
		
		
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
		
		
		return n;
	}
	@Override
	public ArrayList<Object> getAll(String tableName,String className) throws Exception {
		ArrayList <Object> c= new ArrayList <Object>();
		nombreTablas();
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
			if(interfaces[j].getSimpleName()=="storableInDataBase")
				implementa=true;
			j++;
		}
		
		//solo se realiza el proceso si la clase implementa el interfaz
		if(implementa)
		{
		//atributos de la clase
		Field fields[]=clase.getDeclaredFields();
		while (resultSet.next()){
			System.out.println(fields.length);
			Object instance = clase.newInstance();
			for (Field field : fields){
					int i=0;
					boolean enc =false;
					
					while(i<metaData.getColumnCount() && !enc){
						System.out.println(metaData.getColumnName(i+1).toLowerCase()+"22222"+field.getName());
						if (metaData.getColumnName(i+1).toLowerCase().equals(field.getName())){
							
							String type=field.getType().getName();
							String valor=resultSet.getString(i+1);
							System.out.println(valor+" 1 dff");
							
							field.set(instance, valor);
							enc=true;
						}
					}
				}
			c.add(instance);
			
		}
		statement.close();
		}
		//sino se lanza una excepcion
		else{
			throw new Exception();
		}
		return c;
	}

	@Override
	public int insert() throws Exception {
		String sqlStatementString = null;
		Statement statement = null;
		statement = connection.createStatement();
		sqlStatementString = "INSERT INTO Pieces VALUES ()";
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
