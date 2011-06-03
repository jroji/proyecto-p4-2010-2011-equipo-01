package ConnectionInterface;

import java.sql.SQLException;
import java.util.ArrayList;


	
	public interface PieceDataSource{
		
		/**
		 * Returns a collection of all the objects that are inside the specific tableName
		 * @return The collection of all the objects inside the specific tableName.
		 * @param tableName this is the name of the table of the objects that will be returned.
		 * @param className this is the name of the object class.
		 * @throws Exception If there is any error during the retrieval of all the
		 * storableInDataBase objects.
		 */
		public ArrayList <storableInDataBase> getAll(String tableName, String className) throws Exception;
		
		/**
		 * Inserts a new default storableInDataBase object inside the specific tableNsme. 
		 * @return 0 if the new default storableInDataBase object is not inserted correctly or 1 if the
		 * new default storableInDataBase is inserted correctly.
		 * @param tableName this is the name of the table on which a new storableInDatabase object will be inserted.
		 * @param object this is the object that will be inserted on the tableName.
		 * @throws Exception If there is any error during the insertion of the new default object.
		 * @throws SQLException If there is any mistake during the insert to the dataBase.
		 * @throws IllegalAccessException if the currently executing method has not information about the invoked method, 
		 * the field to modify or the instance to create. 
		 */
		public int insert(String tableName, storableInDataBase object) throws SQLException, IllegalAccessException, Exception;
		
		/**
		 * Removes the given storableInDataBase objectToRemove from the tableName.
		 * @param tableName The name of the table which has the objectToRemove.
		 * @param objectToRemove the storableInDataBase object that will be deleted from the tableName.
		 * @return The number of storableInDataBase objects that are removed (0 or 1).
		 * @throws Exception If there is any error during the removal of the given object.
		 */
		public int remove (String tableName, storableInDataBase objectToRemove) throws Exception;
		
		
		

}

