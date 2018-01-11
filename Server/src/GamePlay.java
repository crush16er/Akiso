import java.util.ArrayList;

public class GamePlay
{
	public void game()
	{
		System.out.println("gameplay client");
		int winner = 0;
		int turn = 0;
		int[][] board = new int[25][17];
		
		
		ClientSocket clientAdmin = new ClientSocket();
        clientAdmin.connection(1111);
        /*client.tmpData();
        client.callClient();
        client.recieveData();
        client.endConnection();*/
        
        ArrayList<ArrayList> data = new ArrayList<ArrayList>();
        
        ArrayList<ClientSocket> sockets = new ArrayList<ClientSocket>();
        ArrayList<Integer> players = new ArrayList<Integer>();
        ArrayList<Integer> type = new ArrayList<Integer>();
        
        
        sockets.add(clientAdmin);
        
       /* while(winner==0)
        {*/
    	while(data.size()==0)
        {
        	clientAdmin.recieveData();
        	data = clientAdmin.data;
        }
    	
    	
    	if((int)data.get(0).get(0) == 1)
    	{
    		//players
    		for(int i=0; i<data.get(1).size(); i++)
    		{
    			players.add((int)data.get(1).get(i));
    			type.add(1);
    		}
    		
    		//bots
    		for(int i=0; i<data.get(2).size(); i++)
    		{
    			players.add((int)data.get(1).get(i));
    			type.add(2);
    		}
    		
    		turn = (int)players.get(0);
    		
    		for(int i=1; i<data.get(1).size(); i++)
    		{
    			ClientSocket tmp = new ClientSocket();
    	        tmp.connection((int)data.get(1).get(i)*1111);
    			sockets.add(tmp);
    		}
        }
        	
        	
        		
        	
        	
        		
        //}
        
    	int present = 0;
    	int x=0;
    	
    	while(winner == 0)
    	{
    		present = 0;
    		
    		for(int i=0; i<players.size(); i++)
    		{
    			if(turn == players.get(i))
    			{
    				present = 1;
    				x=i;
    			}
    		}
    		
    		
    		if(present == 1)
    		{
    			if(type.get(x)==1)
    			{
    				ClientSocket playerr = sockets.get(x);
        			data = new ArrayList<ArrayList>();
        			
        			while(data.size()==0)
        	        {
        	        	playerr.recieveData();
        	        	data = playerr.data;
        	        }
        			
        			int end = 0; 
        			
        			while(end != 1)
        			{
    	    			if((int)data.get(0).get(0) == 2)
    	    			{
    	    				Validator move = new Validator((int[][])data.get(1).get(0), (int)data.get(2).get(0), (int)data.get(2).get(1), (int)data.get(2).get(2), (int)data.get(2).get(3));
    	    				int correct = move.validate();
    	    				
    	    				board = (int[][])data.get(1).get(0);
    	    				
    	    				if(correct == 1)
    	    				{
    	    					board[(int)data.get(2).get(0)][(int)data.get(2).get(1)] = board[(int)data.get(2).get(2)][(int)data.get(2).get(3)];
    	    					board[(int)data.get(2).get(2)][(int)data.get(2).get(3)] = 1;
    	    					end = move.end;
    	    					
    	    					ArrayList<ArrayList> send = new ArrayList<ArrayList>();
    	    					
    	    					ArrayList<Integer> a = new ArrayList<Integer>();
    	    					ArrayList<int[][]> b = new ArrayList<int[][]>();
    	    					
    	    					a.add(1);
    	    					b.add(board);
    	    					
    	    					send.add(a);
    	    					send.add(b);
    	    					
    	    					playerr.callClient(send);
    	    					
    	    					
    	    					for(int i=0; i<players.size(); i++)
    	    		    		{
    	    		    			if(i != x)
    	    		    			{
    	    		    				ClientSocket playerrr = sockets.get(i);
    	    		        			playerrr.callClient(send);
    	    		    			}
    	    		    		}
    	    				}
    	    				else
    	    				{
    	    					ArrayList<ArrayList> send = new ArrayList<ArrayList>();
    	    					
    	    					ArrayList<Integer> a = new ArrayList<Integer>();
    	    					
    	    					a.add(0);
    	    					
    	    					send.add(a);
    	    					
    	    					playerr.callClient(send);
    	    				}
    	    			}
        			}
    			}
    			else
    			{
    				Bot bot = new Bot();
    				bot.board = board;
    				bot.doMove(players.get(x));
    				
    				ArrayList<ArrayList> send = new ArrayList<ArrayList>();
					
					ArrayList<Integer> a = new ArrayList<Integer>();
					ArrayList<int[][]> b = new ArrayList<int[][]>();
					
					a.add(1);
					b.add(board);
					
					send.add(a);
					send.add(b);
    				
    				for(int i=0; i<players.size(); i++)
		    		{
		    			ClientSocket playerrr = sockets.get(i);
		        		playerrr.callClient(send);
		    		}
    			}
    			
    		}
    		else
    		{
    			if(turn == 7)
    			{
    				turn = 2;
    			}
    			else
    			{
    				turn++;
    			}
    			
    		}
    	}
        
        System.out.print("koniec");
        
		
		
		
	}
}
