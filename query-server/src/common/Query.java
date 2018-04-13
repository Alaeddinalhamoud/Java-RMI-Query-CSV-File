package common;

import java.util.List;

//interface that provides common methods for server and client in order to perform
//a specific query.
public interface Query<T>  {
	
	
	//this method will retuen the finalresult
	 public Object [] execute();
	 //will create carfuel or houseprice class 
	 public   T create  (String[] data);
	 //this method will retur list of carfuel or houseprice by passing the csv file name
    public List<T>  GetDateFromFile(String FileName);
	 
	
}