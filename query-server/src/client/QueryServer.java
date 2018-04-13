package client;

import java.io.File;
import java.rmi.Naming;
 
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
 
import common.Query;
import common.QueryExecutor;
 //Query Server Classs, The main job for this class to execute the code send it from the client.
public class QueryServer  extends UnicastRemoteObject  implements QueryExecutor<Object> {
	 
	private static final long serialVersionUID = 1L;
	protected QueryServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object [] executeQuery(Query query) throws RemoteException {
		return query.execute();
	}
	 
	 
	public static void main(String... args)  {
		
		try {
			//Create Registry its same as when we run it from the Termanal 
			LocateRegistry.createRegistry(1099);// same as >> rmiregistry -J-Djava.rmi.server.useCodebaseOnly=false
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//this method to set the codebase properites.
		//you can comment it, in case to run the application form the Terminal.
		setProperties();
		
		if (System.getSecurityManager() == null) {
            System.setSecurityManager(new SecurityManager());
        }
		//The Name to be binded in the regestry.
		String name = "RMIServer";
		
		
		try {
			QueryExecutor<?> engine = new QueryServer();
			//Rebind the engine object with the name of my server.
		    Naming.rebind(name, engine);
		    System.out.println("Server bound");
		} catch (Exception e) {
		    System.err.println("Server exception: " + 
				       e.getMessage());
		    e.printStackTrace();
		}
		
		 
	}

	public static void setProperties() {
	  // System.setProperty("java.rmi.server.codebase", "file:///C:/Java/server.jar");//Can be uncommented in case of test it local
		 System.setProperty("java.rmi.server.codebase", "http://a-hamoud.com/UOL/server.jar");
	     System.setProperty("java.rmi.server.useCodebaseOnly","false");
	     System.setProperty("java.security.policy","file:/C:/Java/policy.permission");//Should change the path to your local computer.
	   
	}

	
	

}
