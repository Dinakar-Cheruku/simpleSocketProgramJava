import java.io.*;
import java.net.*;
import java.nio.Buffer;
import java.util.Scanner;

public class IHLPclient {
    public static void main(String[] args) throws Exception{
        //creating two variables for sending and receiving the modified text.
        String text;
        String Text;
        //a variable to carry the client's integer value and prompting the user to enter it and storing it using Scanner, the value is recorded from the keyboard using system.in
        int clientNum;
        System.out.println("Enter your number: ");
        Scanner scan = new Scanner(System.in);
        clientNum = scan.nextInt();
        //prompting the client to enter text
        System.out.println("Enter text: ");
        //we use buffered reader since it has larger buffer memory than scanner method and also server client communication can be multi threaded.
        BufferedReader fromUser = new BufferedReader( new InputStreamReader(System.in));
        //here we use the host address as 127.0.0.1 since its a loopback address and can be tested using a single PC, the port of choice is 5000 and no later than 5000 should be used
        Socket clientsocket = new Socket("127.0.0.1", 5000);
        //since a TCP connection is bi-directional, both input and output streams are to be precicely specified and we use respective streamReaders to capture the data in it.
        DataOutputStream toserver = new DataOutputStream(clientsocket.getOutputStream());
        BufferedReader fromserver = new BufferedReader(new InputStreamReader(clientsocket.getInputStream()));
        //we use the readLine() method to get the data obatained from the streamReaders.
        text = fromUser.readLine();
        toserver.writeBytes(text+'\n');
        toserver.write(clientNum);
        Text = fromserver.readLine();
        System.out.println("From Server: "+Text);
        //it is important to close all sockets after usage to reduce the lane load on server.
        clientsocket.close();


    }
}
