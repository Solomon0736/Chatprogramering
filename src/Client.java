import javax.swing.*;
import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args)  {
       try {
           Socket s = new Socket("192.168.197.1",1201);
           DataInputStream din = new DataInputStream(s.getInputStream());
           DataOutputStream dout = new DataOutputStream(s.getOutputStream());

           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           String msgin = "", msgout = "";

           while (!msgin.equals("end")) {
               msgin = din.readUTF();
               System.out.println(msgin);
               msgout = br.readLine();
               dout.writeUTF(msgout);
           }

       } catch (Exception e) {
           e.printStackTrace();
       }
    }
}