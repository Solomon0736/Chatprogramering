import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  {
       try {
           String ip = (String) JOptionPane.showInputDialog(null,"IP?","Connect to..",JOptionPane.QUESTION_MESSAGE);
           int port = Integer.parseInt(JOptionPane.showInputDialog(null,"Port?","Connect to..",JOptionPane.QUESTION_MESSAGE));
         // Socket socket = null;
           Socket socket = new Socket(ip,port);

           DataInputStream din = new DataInputStream(socket.getInputStream());
           DataOutputStream dout = new DataOutputStream(socket.getOutputStream());

           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           String msgin = "", msgout = "solomon svarar" +"";

           while (!msgin.equals("end")) {

               msgin = br.readLine();
               dout.writeUTF(msgin);
               msgout = din.readUTF();
               System.out.println("Server säger: " + msgout);
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}