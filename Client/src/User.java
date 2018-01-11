
public class User {
	private static User INSTANCE;
	private static boolean iHaveStartedTheNewGame;
	private int port = -1;
	
	private User(){};
	public static User getInstance(){
		if(INSTANCE== null){
			INSTANCE = new User(); 
			iHaveStartedTheNewGame = true;
		}
		return INSTANCE;
	}
	
	public void isStartingNewGame(){
		iHaveStartedTheNewGame = true;
	}
	
	public void isJoiningGameOnPort(int port){
		iHaveStartedTheNewGame = false;
		this.port = port;
	}
	
	public boolean startedNewGame(){
		return iHaveStartedTheNewGame;
	}
	
	public int getPort(){
		return port;
	}
}
