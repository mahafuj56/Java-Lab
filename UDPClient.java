// Write a client-server UDP socket program in java that the server listens for connection requests, and whatever message within 1024 bytes the client sends,
// the server converts it to uppercase and sends it back after 6 ms.

// Client Code 

import java.net.*;
import java.util.Scanner;

public class UDPClient {
    public static void main(String[] args) throws Exception {

        // Create socket
        DatagramSocket ds = new DatagramSocket();

        // Server IP
        InetAddress ip = InetAddress.getByName("localhost");

        // Input from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message: ");
        String msg = sc.nextLine();

        // Convert to bytes
        byte[] b = msg.getBytes();

        // Send data
        DatagramPacket dp = new DatagramPacket(b, b.length, ip, 9000);
        ds.send(dp);

        // Receive response
        byte[] r = new byte[1024];
        DatagramPacket dp2 = new DatagramPacket(r, r.length);
        ds.receive(dp2);

        // Show response
        String res = new String(dp2.getData(), 0, dp2.getLength());
        System.out.println("Server reply: " + res);

        // Close
        ds.close();
        sc.close();
    }
}
