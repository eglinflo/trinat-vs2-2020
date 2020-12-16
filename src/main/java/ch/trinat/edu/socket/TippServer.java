package ch.trinat.edu.socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TippServer {

    public static void main(String[] args) {
        System.out.println("Server Start");
        TippServer server = new TippServer();
        server.los();
    }

    public void los() {
        try (ServerSocket serverSock = new ServerSocket(4242)) {
            Socket sock = serverSock.accept();
            PrintWriter writer = new PrintWriter(sock.getOutputStream());
            String tipp = getTipp();
            writer.println(tipp);
            writer.flush();
            writer.println(tipp);
            writer.flush();
            writer.close();
            System.out.println(tipp);
        }

        catch(IOException ex) {
            ex.printStackTrace();
        }
    }

    private String getTipp() {
        return "Mein Tipp";
    }
}
