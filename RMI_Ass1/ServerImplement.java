import java.rmi.*;
import java.rmi.server.*;

public class ServerImplement extends UnicastRemoteObject implements ServerInterface{
	public ServerImplement() throws Exception{
	}
	
	public String concat(String a, String b){
		return a+b;
	}
}