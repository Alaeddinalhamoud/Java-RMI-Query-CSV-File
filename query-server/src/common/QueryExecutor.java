package common;
import java.rmi.Remote;
import java.rmi.RemoteException;
 


//Interface that provides the method for running a given query
public interface QueryExecutor <T>  extends Remote{
	 public Object []  executeQuery(Query<T> q) throws RemoteException;
}
