import java.net.*;
import java.io.*;
import java.util.*;

public class MTS extends Thread {

   ServerSocket 	listen;
   static String 	hostName = "yps";
   int			port     = 4242;
   int 			id 	 = 0;

   public MTS()	{
	listen = null;
   }

   public MTS(int port)	{
        try { 
            listen = new ServerSocket(port);
            System.out.println ("Listening on port: "
                + getLocalPort());
        } catch(Exception e) {
            System.out.println(e);
        }
   }
   public MTS(int port, int id)	{
        this(port);
	this.id = id;
   }

   public int getLocalPort ()	{
        return listen.getLocalPort();
   }

    private void printMessage()	{
	System.out.println("-h		---->	help");
	System.out.println("[-host 		hostName");
	System.out.println(" -port 		port");
	System.out.println(" {-port 		port}");
	System.out.println("or ");
	System.out.println(" no argument");
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
	   	else if (args[i].equals("-port")) {
			port = new Integer(args[++i]).intValue();
			new MTS(port).listenToPort();
		}
	}
   }
   
   public void run()	{
        try {
                Socket clnt = listen.accept();
                System.out.println(clnt.toString());
                PrintWriter out = new PrintWriter
                    (clnt.getOutputStream (), true);
                out.println("It is now: " + new Date());
		System.out.println(id + " .... falling asleep");
		sleep(1000);
		System.out.println("\t" + id + " .... wake up");
                listen.close();
        } catch(Exception e) {
            System.out.println(e);
	    e.printStackTrace();
        }
   }

   public void listenToPort()	{
        try {
	    int id = 0;
            for(;;) {
                Socket clnt = listen.accept();
		int    newSocket;
                System.out.println("Somebody connected ... ");
		MTS aServer = new MTS(0, id++);
		aServer.start();
                System.out.println("offer ... " +
			 aServer.getLocalPort());
                PrintWriter out = new PrintWriter
                    (clnt.getOutputStream (), true);
                out.println(aServer.getLocalPort());
                // clnt.close();
            }
        } catch(Exception e) {
            System.out.println(e);
	    e.printStackTrace();
        }
   }

    public static void main(String argv[]) {
	if ( argv.length == 0 )
		new MTS(0).listenToPort();
	else
		new MTS().parseArgs(argv);
    }
}