import java.io.*;
import java.util.*;
import java.net.*;
import java.time.LocalTime;

public class Server{
	public static void main(String[] args) throws Exception{
		ServerSocket server = new ServerSocket(5000);
		System.out.println("Server is running on port: 5000");

		String[] clientTime = new String[3];
		Socket[] client = new Socket[3];

		for(int i = 0; i < 3; i++){
			client[i] = server.accept();
			DataInputStream input = new DataInputStream(client[i].getInputStream());
			clientTime[i] = input.readUTF();
			System.out.println(" - Client " + (i + 1) + " Connected\n -- Before Synchronization: " + clientTime[i]);
		}

		int totalSeconds = 0;
		for(int i = 0; i < 3; i++){
			LocalTime timeObj = LocalTime.parse(clientTime[i]);
			int seconds = timeObj.getHour() * 3600 + timeObj.getMinute() * 60 + timeObj.getSecond();
			totalSeconds += seconds;
		}

		int avgSeconds = totalSeconds / 3;
		int avgHour = avgSeconds / 3600;
		int avgMin = (avgSeconds % 3600) / 60;
		int avgSec = avgSeconds % 60;

		String syncTime = String.format("%02d:%02d:%02d", avgHour, avgMin, avgSec);
		System.out.println(" + Synchronized time sent to all Clients: " + syncTime);

		for(int i = 0; i < 3; i++){
			DataOutputStream output = new DataOutputStream(client[i].getOutputStream());
			output.writeUTF(syncTime);
		}
		server.close();
	}
}
