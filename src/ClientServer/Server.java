package ClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by artur.mackowiak on 19/02/15.
 */

public class Server {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        try(ServerSocket serverSocket = new ServerSocket(5000)) {

            System.out.println("Server is running.....");
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("asdasdsad");
                new Thread(new ServerWorker(socket)).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
