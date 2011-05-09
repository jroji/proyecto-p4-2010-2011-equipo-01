package pruebas;

import java.lang.reflect.Field;
import java.util.ArrayList;

import ConnectionInterface.storableInDataBase;

public class coche implements storableInDataBase{

	private int mat;
	private String color;
	
	
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String toString (){
		return "coche";
	}

	@Override
	public ArrayList<Field> fieldsToStore() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int insertIntoDataBase() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public ArrayList<storableInDataBase> takeOutFromDataBase() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int deleteFromDataBase(storableInDataBase objectToRemove) {
		// TODO Auto-generated method stub
		return 0;
	}
}
