package ConnectionInterface;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Esta clase implementa el interfaz PieceDataSource, y codifica los métodos insert, getAll y remove además de hacer
 * la conexión con la Base de Datos de OldWarriorTales.
 */
public class PieceJDBC implements PieceDataSource {

	public static final String DRIVER_CLASS_NAME = "org.sqlite.JDBC";
	//public static final String CONNECTION_URL = "jdbc:sqlite:C:/Users/Julen/eclipseWorkSpaces/workspace/DataBase/src/OldWarriorTales.s3db";
	public static final String CONNECTION_URL = "jdbc:sqlite:database/OldWarriorTales.s3db";
	//public static final String CONNECTION_URL = "jdbc:sqlite:C:/Users/Raquel/workspace/DataBase/src/OldWarriorTales.s3db";
	public static Connection connection;
	
	/**
	 * Constructor por defecto que crea un nuevo objeto PieceJDBC con una connection a la base de datos indicada en el
	 * atributo CONNECTION_URL.
	 * @throws ClassNotFoundException the specified class could not found.
	 * @throws SQLException if there is any mistake during the access to the dataBase
	 */
	public PieceJDBC() throws ClassNotFoundException, SQLException{
		Class.forName(DRIVER_CLASS_NAME);
//		connection= DriverManager.getConnection(CONNECTION_URL);
		
	}
	/**
	 * This method prints the names of each table of the database.
	 * 
	 * @throws SQLException if there is any mistake during the access to the dataBase
	 * @throws ClassNotFoundException the specified class could not found.
	 */
	public void nombreTablas() throws SQLException, ClassNotFoundException{
		
		connection= DriverManager.getConnection(CONNECTION_URL);
		// Listamos todas las tablas
		String nombreTablas = "%"; 
		// Listamos solo tablas
		String tipos[] = new String[1]; 
		tipos[0] = "TABLE";
		//get the information about the dataBase
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
		connection.close();
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
		connection= DriverManager.getConnection(CONNECTION_URL);
		try{
			field.set(instance, valor);
		}catch(Exception e){
			try{
				
				field.set(instance,Integer.parseInt(valor));
			}catch(Exception ex){
				//Para poder insertar booleanos en la base de datos hay que hacer una conversión de char a boolean.
				try{
					if(valor.equals("Y"))
						valor="true";
					else
						if(valor.equals("N"))
							valor="false";
					
					field.set(instance,Boolean.parseBoolean(valor));
				}catch(Exception exc){
					try{
						field.set(instance,Double.parseDouble(valor ));
					}catch(Exception exce){
						try{
							field.set(instance,valor.toCharArray()[0] );
						}catch(Exception excep){
							//si lo que se va a insertar es una clase:
							try{
								//carga una clase con el nombre del atributo
								Class<?> clase = Class.forName(field.getType().getCanonicalName());
								
								//si es un enum
								if(clase.isEnum()){
									boolean encontrado=false;
									//busca el elemento del enum que sea igual a valor
									for(int i=0; i<clase.getEnumConstants().length&&!encontrado;i++)
									{
										if(clase.getEnumConstants()[i].toString().equalsIgnoreCase(valor))
										{
											field.set(instance, clase.getEnumConstants()[i]);
											encontrado=true;
										}
									}
								}
								//no es un enum
								else
								{
								//recoge todas las tablas de la base de datos
								String nombreTablas = "%"; // Listamos todas las tablas
								String tipos[] = new String[1]; // Listamos solo tablas
								tipos[0] = "TABLE";
								DatabaseMetaData dbmd = connection.getMetaData();
								ResultSet tablas = dbmd.getTables( null, null, 
								  nombreTablas, tipos );
								boolean seguir = tablas.next();
								
								//recorre todas las tablas de la base de datos
									while( seguir ) {
									//comprueba que el nombre de la tabla sea igual al nombre del tipo del atributo (o clase)
										if(tablas.getString(tablas.findColumn( "TABLE_NAME" )).toLowerCase().equals(clase.getSimpleName().toLowerCase())){									
											seguir=false;
											//recoge en un arrayList el contenido de la tabla
										    ArrayList<storableInDataBase> array=getAll(clase.getSimpleName(),clase.getName());
										    //obtiene las claves primarias de la tabla
										    ResultSet primaryKeys= dbmd.getPrimaryKeys(null,null, clase.getSimpleName());
										    boolean hayMasClavesPrimarias=primaryKeys.next();
										    
										    //recorre todas las claves primarias de la tabla
										    while(hayMasClavesPrimarias){
										    	
										    	boolean encontrado=false;
										    	
										    	//recoge el atributo de la clase con el mismo nombre que la clave primaria
									    		Field field1=clase.getDeclaredField(primaryKeys.getString("COLUMN_NAME"));
									    		
									    		//recorre el array de objetos cargados de la tabla
										    	for(int i=0;i<array.size()&&!encontrado;i++){
										    		
										    		Object object=array.get(i);
										    		//comprueba que el valor de la clave primaria sea igual al valor del atributo
										    		//con el mismo nombre
										    		try{
										    		if(valor.equals(field1.get(object).toString())){
										    			//introduce el objeto como atributo
										    			field.set(instance, object);
										    			
										    			encontrado=true;
										    		}
										    		}//si el atributo no es accesible
										    		catch (IllegalAccessException iae) {
											    		field1.setAccessible(true);
											    		if(valor.equals(field1.get(object).toString())){
												    		//introduce el objeto como atributo
												    		field.set(instance, object);
												    		
												    		encontrado=true;
												    	}
											    		field1.setAccessible(false);
										    		}
		
										    	}
										    	hayMasClavesPrimarias=primaryKeys.next();
										    }
										  }
										else
											seguir = tablas.next();
								}
								}
							
							}catch(Exception except){
								//System.out.println(field.getName()+"//"+field.getType());
								throw new Exception ("Type not accepted!!!!" +"[Type:"+field.getType()+" Value: "+valor+"]");
							}
							
					}
				}
			}
		}
	}
		connection.close();
	}
	
	/** this method returns an arrayList that contains all the storableInDataBase objects from the specified table of the data base.
	 * @param tableName This is the name of the database table from which value fields will be extracted.
	 * @param className this is the name of the class of the object that we want to get the information
	 * @returns ArrayList<storableInDataBase> this is the ArrayList which contains the name and the value of each attribute inside it
	 * @throws Exception When the type of the field is not one of the next: String, Int, Boolean, Char, Double.
	 */
	public ArrayList<storableInDataBase> getAll(String tableName,String className) throws Exception {
		connection= DriverManager.getConnection(CONNECTION_URL);
		ArrayList <storableInDataBase> c= new ArrayList <storableInDataBase>();
		//Consulta de todos los datos
		Statement statement = connection.createStatement();
		//Crea la sentencia sql
		String sqlStatementString = "SELECT * FROM "+ tableName+";";
		ResultSet resultSet= statement.executeQuery(sqlStatementString);
		ResultSetMetaData metaData=resultSet.getMetaData();
		Class<?> clase= Class.forName(className);
		Class<?>claseInt=clase;
		//Obtiene los interfaces que implementa la clase
		Class<?>[] interfaces=new Class[0];
		//copia al array interfaces todos los interfaces que implementa la clase y sus clases padre.
		do{
			Class<?>[] interfac=claseInt.getInterfaces();
			Class<?>[]aux=interfaces;
			interfaces=new Class[interfac.length+aux.length];
			for(int i =0; i<aux.length;i++){
				interfaces[i]=aux[i];
			}
			if(aux.length==0){
				for(int i =0; i<interfac.length;i++){
						interfaces[i]=interfac[i];
				}
			}else
				for(int i =0; i<interfac.length;i++){
					interfaces[aux.length+i]=interfac[i];
				}
			claseInt=claseInt.getSuperclass();
		}while (!claseInt.getSimpleName().equals("Object"));
		
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
		//obtiene los atributos de la clase
			claseInt=clase;
			Field[] fields=new Field[0];
			//copia al array fields los atributos de la clase y de sus clases padre
			do{
				Field[] fiel=claseInt.getDeclaredFields();
				Field[]auxField=fields;
				fields=new Field[fiel.length+auxField.length];
				for(int i =0; i<auxField.length;i++){
					fields[i]=auxField[i];
				}
				if(auxField.length==0){
					for(int i =0; i<fiel.length;i++){
							fields[i]=fiel[i];
					}
				}else
					for(int i =0; i<fiel.length;i++){
						fields[auxField.length-1+i]=fiel[i];
					}
				claseInt=claseInt.getSuperclass();
			}while (!claseInt.getSimpleName().equals("Object"));	

		while (resultSet.next()){
			Object instance = clase.newInstance();
			//Recorre el array de fields comprobando si es nulo o no
			for (Field field : fields){
				if(field==null){
				}else{
					
					int i=0;
					boolean enc =false;
					//si no es nulo realiza el insertFields
					while(i<metaData.getColumnCount() && !enc){
						// si el nombre de la columna es igual al nombre del atributo coge el valor de éste 
						
						if (metaData.getColumnName(i+1).equalsIgnoreCase(field.getName())){
							
							String valor=resultSet.getString(i+1);
							//si el field no es accesible hace que lo sea para la insercción el base de datos
							if(!field.isAccessible()){
								field.setAccessible(true);
								insertFiels(instance, field, valor);		
								field.setAccessible(false);
							}else
								insertFiels(instance, field, valor);		
							
							enc=true;
						}
						i++;
					}
				}
				}
			//añade al array el instance
			c.add((storableInDataBase) instance);
			
			
		}
		
		statement.close();
		}
		//sino se lanza una excepcion
		else{
			throw new Exception("This class cannot be stored in the database (doesn´t implement the required interface)");
		}
		connection.close();
		//devuelve el arrayList con la información de la base de datos
		return c;
		
	}
	
	 
	/** this method insert a new storableInDataBase object on the specified table of the data base. 
	 * @param tableName this is the name of the table in which the object will be inserted
	 * @param object this is the object whose type is storableInDataBase that will be inserted into the tableName
	 * @return insertadas  it returns the number of the inserted rows.
	 * @throws Exception it is thrown when there are no fields
	 */
	public int insert(String tableName, storableInDataBase object) throws Exception{
		
		connection= DriverManager.getConnection(CONNECTION_URL);
		String sqlStatementString = null;
		Statement statement = null;
		statement = connection.createStatement();
		
		//array de atributos a introducir en la base de datos
		ArrayList <Field> fields = object.fieldsToStore(); 
		
		
		//si no hay atributos se lanza una Exception
		if (fields==null){
			throw new Exception ("Atributos no disponibles");
		}
		
		String columnas="";
		String valores="";
		//se recorre el array de atributos
		for(Field field: fields){

			Class<?> clase = this.getClass();	
				try{
				clase = Class.forName(field.getType().getName());
				}catch(ClassNotFoundException cnfe){}
				//si el tipo del atributo es string o enum pone el nombre de éste entre comillas simples
				if (field.getType().getName().toLowerCase().contains("string")||clase.isEnum()){
					
					try{
						try{
							//crea el string de valores y columnas a concatenar en la sentencia sql
							valores=valores+"'"+field.get(object)+"',";
							columnas=columnas+field.getName()+",";
							}catch (IllegalArgumentException ex){
								//si el atributo es de una clase dentro de la propia clase
								//carga esa clase y busca dentro el valor del atributo
								
								Class<?> cla=field.getClass();
								Field[] classFields=cla.getDeclaredFields();
								
								boolean enc= false;
								//recorre todos los atributos de la clase buscando el atributo requerido
								for(int i=0; i<classFields.length&&!enc;i++){
									try
									{
										//encontrado el atributo
										if(classFields[i].getClass().getName().equals(field.getClass().getName())){
											//devuelve el valor del atributo que pertenece a la clase que es atributo de la clase incial.
											Object ob=classFields[i].get(object);
											//obtiene el valor del atributo
											String valor=field.get(ob).toString();
											//introducimos el valor en la sentencia
											valores=valores+"'"+valor+"',";
											columnas=columnas+field.getName()+",";
											enc=true;
										}
										}catch (IllegalAccessException ie){
											//si no es accesible:
											classFields[i].setAccessible(true);
											if(classFields[i].getClass().getName().equals(field.getClass().getName())){
												//devuelve el valor del atributo que pertenece a la clase que es atributo de la clase incial.
												try{
													//obtiene el valor del atributo
													Object o=classFields[i].get(object);
													String valor=field.get(o).toString();
												//introducimos el valor en la sentencia
												valores=valores+"'"+valor+"',";
												columnas=columnas+field.getName()+",";
												enc=true;
												}catch(IllegalArgumentException ia){}
												
												}
											classFields[i].setAccessible(false);
										}
										
										
									}
								}
						
					}
					
					catch (IllegalAccessException iae){
						//si el atributo no es accesible lo pone a accesible
						field.setAccessible(true);
						try{
						valores=valores+"'"+field.get(object)+"',";
						columnas=columnas+field.getName()+",";
						}catch (IllegalArgumentException ex){
							//si el atributo es de una clase dentro de la propia clase
							//carga esa clase y busca dentro el valor del atributo
							Class<?> cla=object.getClass();
							Field[] classFields=cla.getDeclaredFields();
							
							boolean enc= false;
							//recorre todos los atributos de la clase buscando el atributo requerido
							for(int i=0; i<classFields.length&&!enc;i++){
								try
								{
									//si se encuentra el atributo
									if(classFields[i].getClass().getName().equals(field.getClass().getName())){
										//devuelve el valor del atributo que pertenece a la clase que es atributo de la clase incial.
										Object ob=classFields[i].get(object);
										//obtiene el valor del atributo
										String valor=field.get(ob).toString();
										//introducimos el valor en la sentencia
										valores=valores+"'"+valor+"',";
										columnas=columnas+field.getName()+",";
										enc=true;
									}
									}catch (IllegalAccessException ie){
										//si no es accesible:
										classFields[i].setAccessible(true);
										if(classFields[i].getClass().getName().equals(field.getClass().getName())){
											//devuelve el valor del atributo que pertenece a la clase que es atributo de la clase incial.
											try{
												//obtiene el valor del atributo
												Object o=classFields[i].get(object);
												String valor=field.get(o).toString();
											//introducimos el valor en la sentencia
											valores=valores+"'"+valor+"',";
											columnas=columnas+field.getName()+",";
											enc=true;
											}catch(IllegalArgumentException ia){}
											
											}
										classFields[i].setAccessible(false);
									}
									
									
								}
							}

						field.setAccessible(false);
						}
						
					}
				//el atributo no es string o enum
				else{
					//para atributos booleanos
					if(field.getType().getName().equals("boolean")){
						try{
								//si el valor del atributo es true se convierte a 1
								if(field.get(object).toString().equals("true")){
								valores=valores+"1,";
								columnas=columnas+field.getName()+",";}
								//si el valor del atributo es false se convierte a 0
								else {
									valores=valores+"0,";
									columnas=columnas+field.getName()+",";}
								
							}
						//si el field no es accesible se pone accesible y se realiza la misma acción.
						catch (IllegalAccessException iae){
							field.setAccessible(true);
								if(field.get(object).toString().equals("true")){
								valores=valores+"1,";
								columnas=columnas+field.getName()+",";}
								else{
									valores=valores+"0,";
									columnas=columnas+field.getName()+",";}
								field.setAccessible(false);
						}
						}
					
						//atributo no booleano, string o enum.
						else{
							//comprobar si el atributo es una clase y existe como tabla en la BBDD:
							Class<?>atributo=field.getType();
							atributo.getSimpleName();
							//recorrer tablas comparando con el nombre del tipo del atributo
							String nombreTablas = "%"; // Listamos todas las tablas
							String tipos[] = new String[1]; // Listamos solo tablas
							tipos[0] = "TABLE";
							DatabaseMetaData dbmd = connection.getMetaData();
							ResultSet tablas = dbmd.getTables( null, null, 
							  nombreTablas, tipos );
							boolean seguir = tablas.next();
							boolean realizado=false;
							//si hay más tablas en la base de datos
							while( seguir ) {
								//existe el atributo como tabla y se introduce la clave primaria
								if (tablas.getString(tablas.findColumn( "TABLE_NAME" )).toLowerCase().equals(atributo.getSimpleName().toLowerCase())){
									seguir=false;
									//buscar la clave primaria de la tabla
										ResultSet rs=dbmd.getPrimaryKeys(null, null, tablas.getString(tablas.findColumn( "TABLE_NAME" )));
										rs.next();
										//buscar el atributo correspondiente a la clave primaria:
										try
										{
											Field priField=atributo.getDeclaredField(rs.getString("COLUMN_NAME"));
											try{
												valores=valores+"'"+priField.get(field.get(object))+"'"+",";
												columnas=columnas+field.getName()+",";
												//si el field no es accesible lo pone accesible
											}catch (IllegalAccessException ia)
											{
												priField.setAccessible(true);
												field.setAccessible(true);
												valores=valores+"'"+priField.get(field.get(object))+"'"+",";
												columnas=columnas+field.getName()+",";
												priField.setAccessible(false);
												field.setAccessible(true);
											}
											realizado=true;
										}
										catch(NoSuchFieldException e){}
										
									}else
										seguir = tablas.next();
								}
								
							if(!realizado){
								try{
									valores=valores+field.get(object)+",";
									columnas=columnas+field.getName()+",";
								}catch (IllegalAccessException iae)
								{
									field.setAccessible(true);
									valores=valores+field.get(object)+",";
									columnas=columnas+field.getName()+",";
									field.setAccessible(true);
								}
							
							
							}
						
					}
				}

			}
		//elimina la última coma del string de valores y del de columnas
		valores=valores.substring(0, valores.length()-1);
		columnas=columnas.substring(0,columnas.length()-1);
		
		//crea la sentencia sql
		sqlStatementString = "INSERT INTO "+tableName+"("+columnas+")"+ "VALUES" +"("+valores+");";
		//System.out.println(sqlStatementString);
		//número de filas insertadas
		int insertadas=0;
		try{
			insertadas=statement.executeUpdate(sqlStatementString);
		}catch(SQLException sql){
			throw sql;
		}finally{
			statement.close();
			connection.close();
		}
		//devuelve el número de filas insertadas
		return insertadas;
		
	}
	
	                            
	 /** This method remove an storableInDataBase object from one of the table of the data base.
	  * @param tableName this is the name of the table in which objectToRemove will be deleted.
	  * @param objectToRemove this is the storableInDataBase object that will be deleted from the data base.
	  * @throws Exception Exception If there is any error during the removal of the given object.
	  * @return the number of objects that have already deleted from the data base.
	  */
	 public int remove (String tableName, storableInDataBase objectToRemove) throws Exception{
		 //crea la conexión con la url correcta
		connection= DriverManager.getConnection(CONNECTION_URL);
		String sqlStatementString = null;
		Statement statement = null;
		statement = connection.createStatement();
		DatabaseMetaData dbmd = connection.getMetaData();
		//obtiene las claves primarias de la tabla
	    ResultSet primaryKeys= dbmd.getPrimaryKeys(null,null, tableName);
	    boolean hayMasClavesPrimarias=primaryKeys.next();
	    String conditions="";
	    
	    Class <?> classe= Class.forName(objectToRemove.getClass().getCanonicalName());
	    Class <?> classeI= classe;
	 
	    //copia en el array fields los atributos de la clase del objeto a borrar y los de sus clases padre.
		 Field [] fields = new Field[0];
		 do{
			 Field[]fiel =classeI.getDeclaredFields();
			 Field[]aux=fields;
			 fields = new Field [aux.length+fiel.length];
		 for(int i=0;i<aux.length;i++){
			 fields[i]=aux[i];
		 }
		 if(aux.length==0){
			 for(int i=0;i<fiel.length;i++){
				 fields[i]=fiel[i];
			 }
		 }else{
			 for(int i=0; i<fiel.length;i++){
				 fields[aux.length+i-1]=fiel[i];
			 }
		 }
		 	 
		 classeI= classeI.getSuperclass();
		 }while(!classeI.getSimpleName().equals("Object"));
		 

	    //recorre todas las claves primarias de la tabla
	 boolean encontrado=false;
	    while(hayMasClavesPrimarias){   
	    	Field field1=null;
	    	//recoge el atributo de la clase con el mismo nombre que la clave primaria
	    	boolean fieldFound=false;
			 for(int i =0; i<fields.length&&fieldFound==false;i++){
				 if (fields[i].getName().equals(primaryKeys.getString("COLUMN_NAME"))){
					field1=fields[i]; 
					fieldFound=true;
				 }
			 }
    		
    		//guarda en el array la información de la tabla a la que pertenece el objeto a borrar
    		ArrayList<storableInDataBase>arrayWithData= getAll(tableName, objectToRemove.getClass().getName());
    		
    		//recorre el array hasta que el objecto a borrar sea igual que el del array
    		for(int i=0; i<arrayWithData.size()&&!encontrado;i++){
    			Object obj= arrayWithData.get(i);
    			//si el atributo no es accesible lo cambia a accesible
    			if(!field1.isAccessible()){
        			field1.setAccessible(true);	
        			//si el objecto a borrar es igual que el que contiene el array en la posición i deja de recorrer el array
	    			if(field1.get(objectToRemove).equals(field1.get(obj))){
	    				
	    				encontrado=true;
	    				//si el tipo del atributo es string coloca comillas simples en el valor del objecto a borrar y concatena las condiciones
	    				if(field1.getType().getSimpleName().equals("String"))
	    					{	    					
	    				conditions=conditions.concat( field1.getName() +" = '"+field1.get(objectToRemove)+"' and");}
	    				//si no es string hace lo mismo pero sin poner comillas simples al valor del objecto a borrar
	    				else
	    					{	    					
	    					conditions=conditions.concat(field1.getName()+" = "+field1.get(objectToRemove)+" and");}
	    				
	    				
	    			}
	    			field1.setAccessible(false);
    			}
    		}
    		hayMasClavesPrimarias=primaryKeys.next();	
	    }
	    //si la condición tiene más de 4 caracteres se elimina del string el último and
	    if(conditions.length()>4){
	    String cond= conditions.substring(0, conditions.length()-4);
	   
	    //crea la sentencia sql de borrado
	    
		sqlStatementString = "DELETE FROM " +tableName+" WHERE "+cond+";";
	    
		//número de filas borradas de la tabla de la base de datos
		int deleteRows=0;
	    	deleteRows= statement.executeUpdate(sqlStatementString);
	 
		statement.close();
		connection.close();
		//devuelve el número de filas borradas si hay condición
		 return deleteRows;}
	    else{
	    	connection.close();
	    	//si no hay condiciones retorna 0.
	    	return 0;
	    }
	 }
	
	

	

}
