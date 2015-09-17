import java.io.File;
import java.util.Scanner;


public class ArrayTest {
	
	//rajmalhotra.h@gmail

	public static void main(String[] args) {
		Scanner sc = null;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==7&&'A'==line.charAt(2)&&!line.contains("'")){
    				System.out.println(line);
    			}
               
    		
    	}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
		
	}

}