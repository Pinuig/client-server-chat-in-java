import java.io.*;
import java.net.*;
import java.util.Scanner;

public class server {
    public static void main(string[] args)
    {
        try(serverSocket serverSockets = new ServerSocket(8080)) {
            System.out.println("Server started");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected");

            BufferedReader clientInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter serverOutput = new PrintWriter(clientSocket.getOutputStream(),true)

            Thread receivThread = new Thread(() -> {
                try{
                    String message;
                    while ((message = clientInput.readLine()) != null){
                        System.out.println("Client:" +message);
                    }
                } catch (IOException e){
                    System.err.println("Error recieving message from client:" + e.getMessage());
                }
            });
            receivThread.start();

            Scanner scanner = new Scanner(System.In);
            while (true){
                String message = scanner.nextLine();
                serverOutput.println(message);
            }
        } catch (IOException e) {
            System.err.println("Error starting server: " + e.getMessage());
        }
    }
}