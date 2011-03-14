package ConnectionInterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Collection;

import ConnectionInterface.Piece;


public abstract class PieceJDBC implements PieceDataSource {

	public static final String DRIVER_CLASS_NAME = "org.sqlite.JDBC";
	public static final String CONNECTION_URL = "jdbc:sqlite:db/Users.s3db";
	public static Connection connection;
	
	@Override
	public Collection<PiezaOldWarriorTales> getAll() throws Exception {
		
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
	public int remove(PiezaOldWarriorTales piece) throws Exception {
		
		return 0;
	}

	@Override
	public int modify(PiezaOldWarriorTales newPiece) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
	public static void main(String [] args){
		Class.forName(DRIVER_CLASS_NAME);
		connection= DriverManager.getConnection(CONNECTION_URL);
	}

	

}
