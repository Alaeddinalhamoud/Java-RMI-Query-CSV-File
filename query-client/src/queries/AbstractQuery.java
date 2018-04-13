package queries;
import java.io.Serializable;

import common.Query;

public abstract class AbstractQuery<T>  implements Query<T>, Serializable{

	//the idea from this class to be same as template to any class inherat from it.
	//Serializable coz of pass it to the server.
	private static final long serialVersionUID = 1L;
	String FileName;
    Object obj;
    
	public AbstractQuery(String filename) {
		this.FileName=filename;
	}
	// this constactor will recicve the file name with the data from /Carfuel or HosuePrice//
	public   AbstractQuery (String filename,T obj) {
	 this.FileName=filename;
	this.obj=obj;
	}
	 //will print the final resul depending on the data sent it 
	 public abstract void print(Object[] t);

}