import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


class ServerSockett
{
	private static ServerSockett Instance;
	private GameBoard gameBoard;
    private Socket socket;;
    ArrayList<String> data = new ArrayList<String>();
    private int port;
    
    public ServerSockett(){};
    
    public static ServerSockett getInstance(){
    	if(Instance == null){
    		Instance = new ServerSockett();
    	}
    	return Instance;
    }
    
	public void setUpGameBoard(GameBoard gb){
		this.gameBoard = gb;
	}
	
	
    public void connection(int portNumber)
    {
    	port = portNumber;
    	
        try{       
        	socket = new Socket("localhost", port);           
        }
        catch (UnknownHostException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
            
    public void recieveData(){
        try{
        	ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream()); //Error Line!
            try{
                Object object = objectInput.readObject();
                data =  (ArrayList<String>) object;
                
                for(int i=0; i<data.size(); i++){
                    System.out.println(data.get(i));
                }
                
            }
            catch (ClassNotFoundException e){
                System.out.println("The title list has not come from the server");
                e.printStackTrace();
            }
        }
        catch (IOException e){
            System.out.println("The socket for reading the object has problem");
            e.printStackTrace();
        }
    }
    
    public void callServer(ArrayList<ArrayList> send)
    {
        try{
        	
        	//send.add("serversocket");
            ObjectOutputStream objectOutput = new ObjectOutputStream(socket.getOutputStream());
            objectOutput.writeObject(send);               
        } 
        catch (IOException e){
            e.printStackTrace();
        } 
        
    }
    
    public void endConnection(){
    	//...
    }
    
    public void sendMoveParamsToServer(int[][]board, int oldX, int oldY, int newX, int newY){
    	//tu wysyla do servera 
    	
    }
    
    public void sendResponseToGameBoard(int[][] newBoard){
    	gameBoard.receiveServerResponse(newBoard);
    }
    
    public void startUsersTurn(){
    	gameBoard.startUserTurn();
    }
    
    public void endUsersTurn(){
    	System.out.println("callin g S");
    }
    
   
    
    public Board getBoardFromServer(){
    	Board b = null;
    	int[] k = {2,2,2,1,2,2};
    	try {
			b = Board.getInstance();
			Board.getInstance().setUp(k);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return b;
    }
    
    public int getCornerNumber(){
    	return 5;
    }
    
    public int[] getPlayers(){
    	int[] k = {2,2,2,1,2,2};
    	return k;
    }

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}
	
	public boolean checkPort(int port){
		//??????????????????????????????????
		return true;
	}
}