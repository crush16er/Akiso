import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class GamePlay 
{
	private ServerSockett server;
	private StartDialog startDialog;
	private GameFrame gameFrame; 
	
	public GamePlay(){
		
		startDialog = new StartDialog(this);
	}
	
	private void initGame(){
		
	}
	
	public void startNewGame(){
		startDialog.dispose();
		server = ServerSockett.getInstance();
		gameFrame = new GameFrame(this);
		server.setUpGameBoard(gameFrame.getBoard());
	}
	
	public ServerSockett getSocket(){
		return this.server;
	}
	public void newgame()
	{
		System.out.println("xxx");
		
		server = new ServerSockett();
		server.connection(1111);
		
		/*try
		{*/
        	ArrayList<ArrayList> send = new ArrayList<ArrayList>();
        	//tmp.add("serversocket");
        	
        	ArrayList<Integer> type = new ArrayList<Integer>();
        	
        	type.add(5);
        	
        	send.add(type);
        	
            /*ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(data);               
        } 
        catch (IOException e)
		{
            e.printStackTrace();
        } */
		
       // server.recieveData();
       server.callServer(send);
	}


}
