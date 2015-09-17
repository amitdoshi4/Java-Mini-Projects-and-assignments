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

   ServerSocket 	aServerSocket;
   static int	port     = 4242;

   public TicTacToeServer()	{
       try { 
           aServerSocket = new ServerSocket(port);
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
	   int count ;
	   Game g = new Game();
	   boolean isServerChance = true;

	    try {
	        Socket clnt = aServerSocket.accept();
	        System.out.println("Player Connected: " + clnt.getInetAddress());
            System.out.println("Starting Game...");
            g.printBoard();
	        Scanner scanner = new Scanner(System.in);
        	for(int i =0;i<9;i++) {
        		count = 0;
        		BufferedReader input = new BufferedReader(
                        new InputStreamReader(clnt.getInputStream()));
        		//row = input.read();
                PrintWriter out = new PrintWriter
                    (clnt.getOutputStream (), true);
                if(isServerChance){
                	System.out.println("Your Move!");
                System.out.println("Enter the row position");
           		
           		row = scanner.nextInt();
           		System.out.println("Enter the col position");
           		col = scanner.nextInt();
           		isServerChance = false;
           		g.isServer=true;
           		out.println(row);
           		out.println(col);
                }
                  
                else{
                	while(!input.ready()){
                    	  sleep(5);
                    }
            		 row = Integer.parseInt(input.readLine());
            			while(!input.ready()){
            				sleep(5);
                        }
            		 col = Integer.parseInt(input.readLine());
            		 isServerChance = true;
            		 g.isServer=false;
                }
                out.println(isServerChance);
           		g.play(row, col);
            }
        	clnt.close();
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