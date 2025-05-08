import java.util.*;

public class TokenRing{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of nodes in ring: ");
		int n = sc.nextInt();

		if (n <= 1) {
            		System.out.println("Number of nodes must be at least 2.");
            		return;
        	}

		int ch = 0;

		do{
			System.out.print("Enter Sender: ");
			int sender = sc.nextInt();

			System.out.print("Enter Receiver: ");
			int receiver = sc.nextInt();

			if (sender >= n || receiver >= n || sender < 0 || receiver < 0) {
                		System.out.println("Invalid sender or receiver.");
                		continue;
            		}

			System.out.print("Enter Data: ");
			int data = sc.nextInt();

			int token = 0;

			System.out.println("Token passing from ");
			for(int i = token; i != sender; i = (i + 1) % n){
				System.out.print(i + " -> ");
			}

			System.out.println(sender);

			System.out.println("Sender " + sender + " is sending data: " + data);

			for(int i = sender; i != receiver; i = (i + 1) % n){
				System.out.println("Data forwarded by " + i);
			}

			System.out.println("Receiver " + receiver + " received data.");

			token = sender;

			System.out.print("Do you want to send data again?\n1. Yes\n0. No\nChoice: ");
			ch = sc.nextInt();
		}while(ch == 1);
	}
}
