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
           String msgin = "solomon säger"+ "", msgout = "solomon svarar" +"";

           while (!msgin.equals("end")) {
               msgout = din.readUTF();
               System.out.println("solomon säger"+ msgout);

               msgin = br.readLine();
               dout.writeUTF("solomon säger"+msgin);
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}