import static org.junit.Assert.*;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.net.Socket;
import java.net.UnknownHostException;

import org.junit.Test;

public class ServerSockettTest
{

	@Test
	public void test()
	{
		
		/*ClientSocket client = new ClientSocket();
		
		client.connection();*/
		
		
		Socket socket = null;
		
		try
		{       
        	socket = new Socket("localhost", 5555);           
        }
        catch (UnknownHostException e)
		{
        	System.out.println("1");
            e.printStackTrace();
        }
        catch (IOException e)
		{
        	System.out.println("2");
            e.printStackTrace();
        }
		
		
		
		try
		{
        	ArrayList<ArrayList> data = new ArrayList<ArrayList>();
        	//tmp.add("serversocket");
        	
        	ArrayList<Integer> type = new ArrayList<Integer>();
        	
        	type.add(5);
        	
        	data.add(type);
        	
            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(data);               
        } 
        catch (IOException e)
		{
            e.printStackTrace();
        } 
		
		
		//client.recieveData();
		
		try
    	{
            socket.close();
            System.out.println("The client is shut down!");
        } catch (IOException e){System.out.println("error");}
		
		//client.endConnection();
		
		//fail("Not yet implemented");
	}

}
