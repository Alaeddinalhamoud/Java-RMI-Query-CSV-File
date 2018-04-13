//Want to use switch to let the user to chosse which querey he want price or year
//1. query about a price
//2.query about year 
package client;


import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

import common.QueryExecutor;
import model.CarFuel;
import model.HousesPrices;
import queries.CarFuelQuery;
import queries.HousePriceQuery;

public class QueryClient {
	
	 static QueryExecutor comp;
	 static HousePriceQuery HousePriceQuerytask;//TO store the prepered task of houseprice 
	 static CarFuelQuery CarFuelQuerytask;//TO store the prepered task of Carfuel 
	 static int input = 0 ;//useing this in switch statment
	 static Object [] Result = null;//Result back from or the result of execute the task befor print it
	 static Scanner s;//to read the input.
	 static String CarFuelfileName;// name of the csv file //carfuel
	 static CarFuel carfuel;
	 static String HousesPricesfileName;// name of the csv file //Houseprice
	 static HousesPrices houseprices;
	 
	public static void main(String[] args) {
		
		//this method to set the codebase properites.
		//you can comment it, in case to run the application form the Terminal.
		setProperties();
		
		 if (System.getSecurityManager() == null) {
	            System.setSecurityManager(new SecurityManager());
	        }
		//Prepare the Sacnner to read the user input
		 s=new Scanner(System.in);
		 
		 //Object from CarFuel + The DataSet FileName on the Server...
		 CarFuelfileName="CarFuel.csv";
		 carfuel=new CarFuel();
		 //Object from HousePrice + The DataSet FileName on the Server...
		 HousesPricesfileName ="HousesPrices.csv";
		 houseprices= new HousesPrices();
	        try {
	            String name = "rmi://127.0.0.1/RMIServer";//Name of the server with IP address .
	            //looking up for the passed server.
	            comp = (QueryExecutor) Naming.lookup(name);
	    do {//Do while loop to read the user input
	    	 
	        	print("RMI....CW2");
	    	    print("1. Query Car Fuel By Price.");
	            print("2. Query Car Fuel By Year.");
	            print("3. House Prices  By Price.");
	            print("4. House Prices By Year.");
	            print("5. House Prices By PostCode.");
	            print("6. Exit.");
	            print("Chooes one of the options:");
	            //read the user input
	            input=s.nextInt();
	            switch (input) {
	            	case 1:
	            		 print("Enter The Fuel Price (00.0):");
	            		 Double price=Double.parseDouble(s.next());
	            		 //set the value readed from the user
	            	     carfuel.setyear(null);//null needed to execute the query
	            		 carfuel.setPumpPricePetrol(price);//set the Price from the user
	            		 executCarFuelQuery();//execute the code
	            		break;
	            	case 2:
	            		 print("Enter The Fuel Year:");
	            		 String fuelyear= s.next();
	            		 carfuel.setPumpPricePetrol(null);
	            		 carfuel.setyear(fuelyear);
	            		 executCarFuelQuery();
	            		break;
	            	 
	            	case 3:
	            		 print("Enter The Price:");
	            		 int Houseprice=s.nextInt();
	            		 houseprices.setYEAR(null);
	            		 houseprices.setPOSTCODE(null);
	            		 houseprices.setPRICE(Houseprice);
	            		 executHousePriceQuery();
	            		break;
	            	case 4:
	            		 print("Enter The Year:");
	            		 String Houseyear=s.next();
	            		 houseprices.setPRICE(0);
	            		 houseprices.setPOSTCODE(null);
	            		 houseprices.setYEAR(Houseyear);
	            		 executHousePriceQuery();
	            		break;
	            	case 5:
	            		print("Enter The PostCode:");
	            		 String Housepostcode=s.next().toUpperCase();
	            		 houseprices.setPRICE(0);
	            		 houseprices.setYEAR(null);
	            		 houseprices.setPOSTCODE(Housepostcode);
	            		 executHousePriceQuery();
	            		break;
	            	case 6:
	            			System.exit(-1);//to exit if you chooes 6.
	            		break;
	            	default:
	            		System.out.println("Exit...");
	            		break;
	            	}
	            
	     } while(input != -1); //loop if the input not -1
	            
	        } catch (Exception e) {
	            System.err.println("Client exception: " + 
	                               e.getMessage());
	            e.printStackTrace();
	        }
	}
	
	//this method will create the task for CarFuel, depending on the user input
	public static void executCarFuelQuery() {
		 try { 
			 CarFuelQuerytask=new CarFuelQuery(CarFuelfileName, carfuel);
			Result=(comp.executeQuery(CarFuelQuerytask)) ;//execute the task on the server
			CarFuelQuerytask.print(Result);// print the result back form the server
			//printResult(Result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//emillar to the last method jsut execute for the HousePrice
    public static void executHousePriceQuery() {
		 try {
			 HousePriceQuerytask=new HousePriceQuery(HousesPricesfileName, houseprices);
    		 Result=(comp.executeQuery(HousePriceQuerytask)) ;
    		 HousePriceQuerytask.print(Result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    //Its just short way to print ...
	public static void print(String info) {
		 System.out.println(info);
	}
	//Set the Property to run the app
	public static void setProperties() {
		 //  System.setProperty("java.rmi.server.codebase", "file:///C:/Java/client.jar");
	      System.setProperty("java.rmi.server.codebase", "http://a-hamoud.com/UOL/client.jar");
	      System.setProperty("java.rmi.server.useCodebaseOnly","false");
	      System.setProperty("java.security.policy","file:/C:/Java/policy.permission");//Please change the path to your local
	     
	}

}
