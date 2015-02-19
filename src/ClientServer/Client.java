package ClientServer;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by artur.mackowiak on 19/02/15.
 */
public class Client {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try (
                Socket socket = new Socket("localhost", 5000);
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
//                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter)
        ) {
            outputStreamWriter.write("Hello....\n");
            outputStreamWriter.flush();
            while (true) {
                String line;
                line = scanner.nextLine();
                if ("exit".equals(line)) {
                    break;
                } else {
                    outputStreamWriter.write(line + "\n");
                    outputStreamWriter.flush();
                }

            }
        } catch (IOException e) {
            System.out.println("Zamkniecie polaczenia.....");
        }
    }
}
