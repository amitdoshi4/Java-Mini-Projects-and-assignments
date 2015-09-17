

import java.net.*;
import java.io.*;
import java.util.*;

/**
 * This class is the server which plays tic tac toe with the server using the TCP connection.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 12/08/2014
 * 
 */
public class TicTacToeServer extends Thread {
   DatagramSocket aServerSocket;
  // ServerSocket 	aServerSocket;
   static int	port     = 4242;

   public TicTacToeServer()	{
       try { 
    	   aServerSocket=new DatagramSocket(port);
          // aServerSocket = new ServerSocket(port); // in java.net
           System.out.println ("Listening on port: " + aServerSocket.getLocalPort());
       } catch(Exception e) {
           System.out.println(e);
       }
   }


	/**
	* This method plays the game and communicates with the client with the TCP communication..
	*
	* @param   void 
	* 
	* @return void
	*/
   public void run()	{
	   int row,col=0;
	   char r;
	  
	   Game g = new Game();
	   int isServerChance = 1;
	   byte[] buf = new byte[512];
	    try {
	    
            System.out.println("Starting Game...");
	        Scanner scanner = new Scanner(System.in);
	        g.printBoard();
        	while(true){
                    if(isServerChance==1){
                    	System.out.println("Your Move!");
                    	System.out.println("Enter the row position");
                    	row = scanner.nextInt();
                    	System.out.println("Enter the col position");
                    	col = scanner.nextInt();
                    	isServerChance = 0;
                    	DatagramPacket packetsend = new DatagramPacket(buf, buf.length);
                    	aServerSocket.receive(packetsend);
                                InetAddress address = packetsend.getAddress();
                                int port = packetsend.getPort();
                    	String info=""+row+col+isServerChance;
                    	buf=info.getBytes();
                    	packetsend = new DatagramPacket(buf, buf.length,address,port);
                    	aServerSocket.send(packetsend);
                    	g.isServer = true;
                    	g.play(row, col);
                    }
                if(isServerChance==0)
                {
       
    				DatagramPacket dp = new DatagramPacket(buf, buf.length);
    				aServerSocket.receive(dp);
    				String info=new String(dp.getData());
    				
    				r=info.charAt(0);
    				row=Character.getNumericValue(r);
    				r=info.charAt(1);
    				col=Character.getNumericValue(r);
    				r=info.charAt(2);
    				g.isServer = false;
    				g.play(row, col);
    				isServerChance=Character.getNumericValue(r);
    				isServerChance=1;
                	
                }
                	
                }
        	
        } catch(Exception e) {
            System.out.println(e);
	    e.printStackTrace();
        }
   }
   /**
	* The main program.
	*
	* @param    args    command line arguments 
	*/
    public static void main(String argv[]) {
     TicTacToeServer ts = new TicTacToeServer();
     ts.start();
    }
}