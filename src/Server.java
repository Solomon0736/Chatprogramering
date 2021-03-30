import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        int port = 1234;
        boolean run = true;
        //ServerSocket serverSocket;
        //  Socket socket;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
                Socket socket = serverSocket.accept();

                DataInputStream din = new DataInputStream(socket.getInputStream());
                DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String msgin = "", msgout = "";
                while (!msgin.equals("end")) {
                    msgin = din.readUTF();
                    System.out.println("Client säger: " + msgin);
                    msgout = br.readLine();
                    dout.writeUTF(msgout);
                    dout.flush();
                }
                socket.close();

            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }

