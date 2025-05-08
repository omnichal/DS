import java.rmi.*;
import java.util.*;

public class Client{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		try{
			String serverUrl = "rmi://localhost/Server";
			ServerInterface si = (ServerInterface) Naming.lookup(serverUrl);
			System.out.print("Enter String a: ");
			String a = sc.nextLine();
			System.out.print("Enter String b: ");
			String b = sc.nextLine();
			System.out.print("Concatenated String: "+ si.concat(a,b));
			sc.close();
		}catch(Exception e){
			System.out.println("Exception occurred at client: "+e);
			e.printStackTrace();
		}
	}
}