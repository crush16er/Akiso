import java.io.*;
import java.net.*;
import java.util.ArrayList;

class ClientSocket
{
    ServerSocket myServerSocket;
    Socket socket; 
    ArrayList<String> my =  new ArrayList<String>();
    ArrayList<ArrayList> data = new ArrayList<ArrayList>();
    int port;



    public void connection(int portNumber)
    {
    	this.port = portNumber;
    	
        try
        {
            myServerSocket = new ServerSocket(port);
            socket = myServerSocket.accept(); 
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }

    public void tmpData()
    {
        my.add("Game");
        my.add("Data");
    }


    public void callClient(ArrayList<ArrayList> send)
    {
        try 
        {
            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(send);               
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        
    }
    
    public void recieveData()
    {
    	try
        {
            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream()); //Error Line!
            
            System.out.println("123");
            try
            {
                Object object = objectInput.readObject();
                data =  (ArrayList<ArrayList>) object;
                System.out.println("456");
                
                for(int i=0; i<data.get(0).size(); i++)
                {
                	
                    System.out.println(data.get(0).get(i));
                }
                
            }
            catch (ClassNotFoundException e)
            {
                System.out.println("The title list has not come from the server");
                e.printStackTrace();
            }
        }
        catch (IOException e)
        {
            System.out.println("The socket for reading the object has problem");
            e.printStackTrace();
        }
    }
    
    public void endConnection()
    {
    	try
    	{
            myServerSocket.close();
            System.out.println("The server is shut down!");
        } catch (IOException e){System.out.println("error");}
    }
    
    

}