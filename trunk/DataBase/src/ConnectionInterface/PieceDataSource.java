package ConnectionInterface;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;

import proyecto.p4.piezaOldWarriorTales.PiezaOldWarriorTales;

	
	public interface PieceDataSource{
		
		/**
		 * Returns a collection of all the pieces that are inside the specific 
		 * piece data source.
		 * @return The collection of all the pieces inside the data source.
		 * @throws Exception If there is any error during the retrieval of all the
		 * pieces.
		 */
		public Collection<PiezaOldWarriorTales> getAll() throws Exception;
		
		/**
		 * Inserts a new default piece inside the specific piece data source. The id
		 * primary key field is auto-incremental so a new id will be stored in the data source.
		 * @return 0 if the new default piece is not inserted correctly or 1 if the
		 * new default piece is inserted correctly.
		 * @throws Exception If there is any error during the insertion of the new default piece.
		 */
		public int insert() throws Exception;
		
		/**
		 * Removes the given piece from the piece data source.
		 * @param piece The piece that will be removed from the piece data source.
		 * @return The number of pieces that are removed (0 or 1).
		 * @throws Exception If there is any error during the removal of the given piece.
		 */
		public int remove(PiezaOldWarriorTales piece) throws Exception;
		
		/**
		 * Modifies a piece in the data source. A reference to the new piecet is given.
		 * @param newPiece The new piece with the information to modify the corresponding data source product.
		 * @return The number of piece that are modified (0 or 1).
		 * @throws Exception If there is any error during the modification of the piece.
		 */
		public int modify(PiezaOldWarriorTales newPiece) throws Exception;
	

}

