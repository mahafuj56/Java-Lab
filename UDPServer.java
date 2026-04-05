// Write a client-server UDP socket program in java that the server listens for connection requests, and whatever message within 1024 bytes the client sends,
// the server converts it to uppercase and sends it back after 6 ms.

// Server Code


import java.net.*;

public class UDPServer {
    public static void main(String[] args) throws Exception {

        // Create socket on port 9000
        DatagramSocket ds = new DatagramSocket(9000);
        System.out.println("Server running...");

        // Buffer (1024 bytes)
        byte[] b = new byte[1024];

        // Receive data
        DatagramPacket dp = new DatagramPacket(b, b.length);
        ds.receive(dp);

        // Convert to string
        String msg = new String(dp.getData(), 0, dp.getLength());
        System.out.println("Client: " + msg);

        // Wait 6 ms
        Thread.sleep(6);

        // Convert to uppercase
        msg = msg.toUpperCase();
        byte[] send = msg.getBytes();

        // Send back to client
        DatagramPacket dp2 = new DatagramPacket(
                send, send.length, dp.getAddress(), dp.getPort());
        ds.send(dp2);

        // Close socket
        ds.close();
    }
}
