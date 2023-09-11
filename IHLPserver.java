import java.io.*;
import java.net.*;
import java.util.Scanner;

public class IHLPserver {
    public static void main(String[] args) throws Exception {
        String clienttext;
        String clientText;
        //same as in the client program, we use two variables for incoming text and a modified one.
        //it is important to be connected to the same port number as the server.
        ServerSocket welcome = new ServerSocket(5000);
        String serverName = "server of Dinakar Cheruku...";
        System.out.println("server ready");
        //initiating a static integer as server number.
        int servernum = 55;
        while(true){
            //java.Socket is a module that deals with the socket connections between end systems, sockets are the doorways between devices and processes.
            Socket connection = welcome.accept();
            int integer;
            System.out.println("Connected!");
            BufferedReader fromclient = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            DataOutputStream toclient = new DataOutputStream(connection.getOutputStream());
            clienttext = fromclient.readLine();
            integer = fromclient.read();
            //defining the logic to reject any invalid interger values as per the problem statement.
            if (integer>100||integer<1){
                System.out.println("Integer value not valid.");
                clientText= "Integer value not valid";
                toclient.writeBytes(clientText);
                break;
            }
            int sum = integer+servernum;
            clientText=clienttext.toUpperCase()+" from the "+serverName+" "+" client number:"+integer+" server number:"+servernum+" sum:"+sum+'\n';
            toclient.writeBytes(clientText);
        }

    }
}
