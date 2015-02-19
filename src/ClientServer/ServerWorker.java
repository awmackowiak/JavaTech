package ClientServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by artur.mackowiak on 19/02/15.
 */
public class ServerWorker implements Runnable {

    private Socket socket;

    public ServerWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (
                InputStream inputStream = socket.getInputStream();
//                OutputStream outputStream = socket.getOutputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader)
        ) {

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println("Nowa wiadomosc: " + line + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
