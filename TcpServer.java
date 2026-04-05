/// Write a client-server TCP socket program in java that the server listens for connection requests, and whatever message the client sends,
// the server converts it to uppercase and sends it back.

//server code


import java.io.*;
import java.net.*;

public class TcpServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(6000);
            System.out.println("Server is waiting...");

            Socket socket = server.accept();
            System.out.println("Client connected!");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            String msg = in.readLine();

            if (msg != null) {
                System.out.println("Client: " + msg);

                String response = msg.toUpperCase();
                out.println(response);
            }

            socket.close();
            server.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
