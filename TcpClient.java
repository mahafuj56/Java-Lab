// Write a client-server TCP socket program in java that the server listens for connection requests, 
//and whatever message the client sends, the server converts it to uppercase and sends it back.

// Client Code


import java.io.*;
import java.net.*;

public class TcpClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 6000);

            BufferedReader input = new BufferedReader(
                    new InputStreamReader(System.in));
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            System.out.print("Enter message: ");
            String msg = input.readLine();

            out.println(msg);

            String response = in.readLine();
            System.out.println("Server replied: " + response);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
