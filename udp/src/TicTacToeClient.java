
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
/**
 * This class is the client which plays tic tac toe with the server using the udp connection.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 12/08/2014
 * 
 */

public class TicTacToeClient {

	String hostName = "129.21.30.38";
    int  port = 4242;
    static int isServerChance = 1;
    DatagramSocket aClientsocket;

	/**
	* This method plays the game and communicates with the server with the udp communication..
	*
	* @param   void 
	* 
	* @return void
	*/
   public void doTheJob()	{
	try {
		
		GameClient g = new GameClient();
		System.out.println("Player connected: " + hostName);
		System.out.println("Starting Game...");
		g.printBoard();
		Scanner scanner = new Scanner(System.in);
		int row,col =0;
		char r;
		byte buf[] = new byte[64];
		DatagramSocket aClientsocket = new DatagramSocket();     //create socket
		InetAddress aInetAddress = InetAddress.getByName(hostName);
		
		for(;;){
			if(isServerChance==1){
				DatagramPacket dp = new DatagramPacket(buf, buf.length);  // create packet
				DatagramPacket packet = new DatagramPacket(buf,
						buf.length, aInetAddress, port);
				aClientsocket.send(packet);   //send packet
				aClientsocket.receive(dp);   //receive packet
				String info=new String(dp.getData());
				r=info.charAt(0);
				row=Character.getNumericValue(r);
				r=info.charAt(1);
				col=Character.getNumericValue(r);
				g.isClient = false;
				g.play(row, col);
				isServerChance=0;
				r=info.charAt(2);
			}
			
			if(isServerChance==0){

            	System.out.println("Your Move!");
            	System.out.println("Enter the row position");
            	row = scanner.nextInt();
            	System.out.println("Enter the col position");
            	col = scanner.nextInt();            	
            	isServerChance = 1;
            	DatagramPacket packetsend = new DatagramPacket(buf, buf.length,aInetAddress,port);
            	String info=""+row+col+isServerChance;
            	buf=info.getBytes();
            	InetAddress address = packetsend.getAddress();
            	packetsend = new DatagramPacket(buf, buf.length,address,port);
            	aClientsocket.send(packetsend);
            	g.isClient=true;
            	g.play(row, col);
			}
		}
		
		
	} catch (Exception e) {
		System.out.println (e);
	}
   }
   
	/**
	* The main program.
	*
	* @param    args    command line arguments 
	*/
   public static void main(String argv[]) {
	TicTacToeClient client = new TicTacToeClient();
	client.doTheJob();

   }
}