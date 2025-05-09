import java.io.*;
import java.util.*;
import java.time.LocalTime;
import java.net.*;

public class Client{
	public static void main(String[] args)throws Exception{
		Socket client = new Socket("localhost", 5000);
		
		LocalTime currTime = LocalTime.now().withNano(0);
		System.out.println(" - Before Synchronization: "+currTime);
		
		String time = currTime.toString();
		DataOutputStream output = new DataOutputStream(client.getOutputStream());
		output.writeUTF(time);
		
		DataInputStream input = new DataInputStream(client.getInputStream());
		int offset = input.readInt();
		
		LocalTime syncTime = currTime.plusSeconds(offset);
		System.out.println("   After Synchronization by offset ("+(offset)+"): "+syncTime);
	}
}
