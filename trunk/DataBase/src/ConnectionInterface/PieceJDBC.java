package ConnectionInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;

import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;


public abstract class PieceJDBC implements PieceDataSource {

	public static final String DRIVER_CLASS_NAME = "org.sqlite.JDBC";
	public static final String CONNECTION_URL = "jdbc:sqlite:db/OldWarriorTales.s3db";
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
	@Override
	public Collection<?> getAll(String tableName,String className) throws Exception {
		
		Statement statement = null;
		statement = connection.createStatement();
		String sqlStatementString = "SELECT * FROM "+tableName;
		ResultSet resultSet= statement.executeQuery(sqlStatementString);
		while (resultSet.next()){
			Class<?> clase= Class.forName(className);
			Object instance = clase.newInstance();
			
			
		}
		statement.close();
		
		return null;
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
		
		return 0;
	}

	@Override
	public int modify() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	

	

}
