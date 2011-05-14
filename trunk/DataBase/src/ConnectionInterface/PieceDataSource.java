package ConnectionInterface;

import java.sql.SQLException;
import java.util.ArrayList;


	
	public interface PieceDataSource{
		
		/**
		 * Returns a collection of all the pieces that are inside the specific 
		 * piece data source.
		 * @return The collection of all the pieces inside the data source.
		 * @throws Exception If there is any error during the retrieval of all the
		 * pieces.
		 */
		public ArrayList <storableInDataBase> getAll(String tableName, String className) throws Exception;
		
		/**
		 * Inserts a new default piece inside the specific piece data source. The id
		 * primary key field is auto-incremental so a new id will be stored in the data source.
		 * @return 0 if the new default piece is not inserted correctly or 1 if the
		 * new default piece is inserted correctly.
		 * @throws Exception If there is any error during the insertion of the new default piece.
		 */
		public int insert(String tableName, storableInDataBase object) throws SQLException, IllegalAccessException, Exception;
		
		/**
		 * Removes the given piece from the piece data source.
		 * @param piece The piece that will be removed from the piece data source.
		 * @return The number of pieces that are removed (0 or 1).
		 * @throws Exception If there is any error during the removal of the given piece.
		 */
		public int remove (String tableName, storableInDataBase objectToRemove) throws Exception;
		
		
		

}

