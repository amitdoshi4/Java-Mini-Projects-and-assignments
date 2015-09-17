import java.net.*;
import java.io.*;
import java.util.*;
public class DayTimeServer {

    String hostName = "localHost";
    int    port = 4242;

    private void printMessage()	{
	System.out.println("-h		---->	help");
	System.out.println("[-host 		hostName]");
	System.out.println("[-port 		port]");
   }
	
   /**
     * Parse the commandlind arguments and sets variables.
     */
   public void parseArgs(String args[]) {

	for (int i = 0; i < args.length; i ++) {
	   	if (args[i].equals("-h")) 
			printMessage();
	   	else if (args[i].equals("-host")) 
			hostName = args[++i];
	   	else if (args[i].equals("-port")) 
			port = new Integer(args[++i]).intValue();
	}
   }

   public void doTheJob()	{
	try {
		byte buf[] = new byte[64];
		for(;;){
		InetAddress aInetAddress = InetAddress.getByName(hostName);
		DatagramPacket dp = new DatagramPacket(buf, buf.length);
		DatagramSocket socket = new DatagramSocket();
		DatagramPacket packet = new DatagramPacket(buf,
			buf.length, aInetAddress, port);
		socket.send(packet);

		System.out.println("host: " +  hostName );
		System.out.println("port: " +  port );
		System.out.println("after creation");
		socket.receive(dp);
		System.out.println("received: -" +
			new String(dp.getData() ) + "-"  );
		socket.close();
		}
	} 
	finally{
	}
	}
   

   public static void main(String argv[]) {
	DayTimeServer aDayTimeUDP = new DayTimeServer();
	aDayTimeUDP.parseArgs(argv);
	aDayTimeUDP.doTheJob();

   }
}