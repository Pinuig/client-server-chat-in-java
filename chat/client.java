import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(string[] args)
    {
        try(Socket clientSockets = new Socket("localHost", 8080)) {
            System.out.println("Client connected to server");
           

            BufferedReader serverInput = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter clientOutput = new PrintWriter(clientSocket.getOutputStream(),true)

            Thread receivThread = new Thread(() -> {
                try{
                    String message;
                    while ((message = clientInput.readLine()) != null){
                        System.out.println("Server:" + message);
                    }
                } catch (IOException e){
                    System.err.println("Error recieving message from server:" + e.getMessage());
                }
            });
            receivThread.start();

            Scanner scanner = new Scanner(System.In);
            while (true){
                String message = scanner.nextLine();
                clientOutput.println(message);
            }
        } catch (IOException e) {
            System.err.println("Error connecting to server: " + e.getMessage());
        }
    }
}