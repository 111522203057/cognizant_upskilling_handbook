//server.java
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int PORT = 12345;
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for client...");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String received, send;

            System.out.println("Type messages to send to client. Type 'bye' to quit.");

            while (true) {
                // Read from client
                if (in.ready()) {
                    received = in.readLine();
                    if (received == null || received.equalsIgnoreCase("bye")) {
                        System.out.println("Client disconnected.");
                        break;
                    }
                    System.out.println("Client: " + received);
                }

                // Read from server user input
                if (userInput.ready()) {
                    send = userInput.readLine();
                    out.println(send);
                    if (send.equalsIgnoreCase("bye")) {
                        System.out.println("Connection closed.");
                        break;
                    }
                }
                // Small pause to reduce CPU usage
                Thread.sleep(100);
            }

            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//client.java
import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        final String SERVER = "localhost";
        final int PORT = 12345;

        try (Socket socket = new Socket(SERVER, PORT)) {
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            String received, send;

            System.out.println("Type messages to send to server. Type 'bye' to quit.");

            while (true) {
                // Read from server
                if (in.ready()) {
                    received = in.readLine();
                    if (received == null || received.equalsIgnoreCase("bye")) {
                        System.out.println("Server disconnected.");
                        break;
                    }
                    System.out.println("Server: " + received);
                }

                // Read from client user input
                if (userInput.ready()) {
                    send = userInput.readLine();
                    out.println(send);
                    if (send.equalsIgnoreCase("bye")) {
                        System.out.println("Connection closed.");
                        break;
                    }
                }
                Thread.sleep(100);
            }

            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

