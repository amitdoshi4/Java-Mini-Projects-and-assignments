import java.io.File;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * This class fills the crossword from the c:\Users\Homework\src\words file.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 09/16/2014
 * 
 */
public class CrossWord {
	
	static String crossWord[][] = new String [13][13];//declaring the crossWord

	 /**
	   * The main program.
	   *
	   * @param    args    command line arguments (ignored)
	   */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		initializePuzzle();
		printGivenPuzzle();
		firstWord();
		printFinalPuzzle();
	}
	/**
     * Print the final puzzle
     */
	private static void printFinalPuzzle() {int i,j;
	for(i=0;i<13;i++){
		for(j=0;j<13;j++){	
			System.out.print(" ");
			System.out.print(crossWord[i][j]);
		}
		System.out.println();
	}
	System.out.println();
	}
	/**
     * Print the initial puzzle
     */
	private static void printGivenPuzzle() {		int i,j;
	for(i=0;i<13;i++){
		for(j=0;j<13;j++){
			if(crossWord[i][j]==null)
				crossWord[i][j]=".";	
			System.out.print(" ");
			System.out.print(crossWord[i][j]);
		}
		System.out.println();
	}
	System.out.println();
	}
	/**
     * Find the fifth word
     * @return isWord true if the word is placed
     */

	private static boolean fithWord() {

		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

		if(line.length()==4&&crossWord[1][7].charAt(0)==line.charAt(0)&&crossWord[2][7].charAt(0)==line.charAt(1)&&crossWord[3][7].charAt(0)==line.charAt(2)&&!line.contains("'")){
			crossWord[4][7]=String.valueOf(line.charAt(3));
			System.out.println(line + " 5");
			boolean temp = sixtWord();
			isWord =true;
			if(temp)
			break;   		
		}
    		}
    		boolean temp = sixtWord();
			isWord =true;
			if(temp)
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	
	}
	/**
     * Find the sixth word
     * @return isWord true if the word is placed
     */

	private static boolean sixtWord() {

		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

		if(line.length()==4&&crossWord[2][8].charAt(0)==line.charAt(0)&&crossWord[3][8].charAt(0)==line.charAt(1)&&!line.contains("'")){
			crossWord[4][8]=String.valueOf(line.charAt(2));
			crossWord[5][8]=String.valueOf(line.charAt(3));
			System.out.println(line + " 6");
			boolean temp = seventhWord();
			isWord =true;
			if(temp)
			break;   		
		}
    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	
	}
	/**
     * Find the seventh word
     * @return isWord true if the word is placed
     */

	private static boolean seventhWord() {

		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

		if(line.length()==4&&crossWord[2][4].charAt(0)==line.charAt(0)&&crossWord[3][4].charAt(0)==line.charAt(1)&&!line.contains("'")){
			crossWord[4][4]=String.valueOf(line.charAt(2));
			crossWord[5][4]=String.valueOf(line.charAt(3));
			System.out.println(line + " 7");
			boolean temp = eightWord();
			isWord =true;
			if(temp)
			break;   		
		}
    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	
	}
	/**
     * Find the first word
     * @return isWord true if the word is placed
     */

	private static boolean eightWord() {

		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

		if(line.length()==4&&crossWord[4][4].charAt(0)==line.charAt(2)&&crossWord[4][5].charAt(0)==line.charAt(3)&&!line.contains("'")){
			crossWord[4][2]=String.valueOf(line.charAt(0));
			crossWord[4][3]=String.valueOf(line.charAt(1));
			System.out.println(line + " 8");
			boolean temp = ninethWord();
			isWord =true;
			if(temp)
			break;   		
		}
    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	
	}
	/**
     * Find the 9th word
     * @return isWord true if the word is placed
     */
	private static boolean ninethWord() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==7&&crossWord[3][3].charAt(0)==line.charAt(0)&&crossWord[4][3].charAt(0)==line.charAt(1)&&!line.contains("'")){
    				System.out.println("9 " +line);
    				crossWord[5][3]=String.valueOf(line.charAt(2));
    				crossWord[6][3]=String.valueOf(line.charAt(3));
    				crossWord[7][3]=String.valueOf(line.charAt(4));
    				crossWord[8][3]=String.valueOf(line.charAt(5));
    				crossWord[9][3]=String.valueOf(line.charAt(6));
    				System.out.println(line + " 9");
    				boolean temp1 = tenthWord();
    				boolean temp2 = fifeteenWord();
    				isWord =true;
    				if(temp1&&temp2)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}	
	/**
     * Find the 10th word
     * @return isWord true if the word is placed
     */

	private static boolean tenthWord() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==4&&crossWord[5][3].charAt(0)==line.charAt(2)&&crossWord[5][4].charAt(0)==line.charAt(3)&&!line.contains("'")){
    				System.out.println("10 " +line);
    				crossWord[5][1]=String.valueOf(line.charAt(0));
    				crossWord[5][2]=String.valueOf(line.charAt(1));
    				System.out.println(line + " 10");
    				boolean temp1 = eleventhWord();
    				isWord =true;
    				if(temp1)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 11th word
     * @return isWord true if the word is placed
     */

	private static boolean eleventhWord() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==5&&crossWord[4][2].charAt(0)==line.charAt(0)&&crossWord[5][2].charAt(0)==line.charAt(1)&&!line.contains("'")){
    				System.out.println("11 " +line);
    				crossWord[6][2]=String.valueOf(line.charAt(2));
    				crossWord[7][2]=String.valueOf(line.charAt(3));
    				crossWord[8][2]=String.valueOf(line.charAt(4));
    				boolean temp1 = twelvethWord();
    				//boolean temp2 = fifeteenWord();
    				isWord =true;
    				if(temp1)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 15th word
     * @return isWord true if the word is placed
     */

	private static boolean fifeteenWord() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==4&&crossWord[8][2].charAt(0)==line.charAt(0)&&crossWord[8][3].charAt(0)==line.charAt(1)&&!line.contains("'")){
    				System.out.println("15 " +line);
    				crossWord[8][4]=String.valueOf(line.charAt(2));
    				crossWord[8][5]=String.valueOf(line.charAt(3));
    				boolean temp = sixeteenWord();
    				//boolean temp2 = fifeteenWord();
    				isWord =true;
    				if(temp)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 16th word
     * @return isWord true if the word is placed
     */

	private static boolean sixeteenWord() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==4&&crossWord[7][4].charAt(0)==line.charAt(0)&&crossWord[8][4].charAt(0)==line.charAt(1)&&!line.contains("'")){
    				System.out.println("16 " +line);
    				crossWord[9][4]=String.valueOf(line.charAt(2));
    				crossWord[10][4]=String.valueOf(line.charAt(3));
    				boolean temp = sevenTeenth();
    				//boolean temp2 = fifeteenWord();
    				isWord =true;
    				if(temp)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 17th word
     * @return isWord true if the word is placed
     */


	private static boolean sevenTeenth() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==4&&crossWord[8][5].charAt(0)==line.charAt(0)&&!line.contains("'")){
    				System.out.println("17 " +line);
    				crossWord[9][5]=String.valueOf(line.charAt(1));
    				crossWord[10][5]=String.valueOf(line.charAt(2));
    				crossWord[11][5]=String.valueOf(line.charAt(3));
    				boolean temp = eighTeenth();    				
    				//boolean temp2 = fifeteenWord();
    				isWord =true;
    				if(temp)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 18th word
     * @return isWord true if the word is placed
     */

	private static boolean eighTeenth() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==7&&crossWord[9][3].charAt(0)==line.charAt(0)&&crossWord[9][4].charAt(0)==line.charAt(1)&&crossWord[9][5].charAt(0)==line.charAt(2)&&!line.contains("'")){
    				System.out.println("18 " +line);
    				crossWord[9][6]=String.valueOf(line.charAt(3));
    				crossWord[9][7]=String.valueOf(line.charAt(4));
    				crossWord[9][8]=String.valueOf(line.charAt(5));
    				crossWord[9][9]=String.valueOf(line.charAt(6));
    				boolean temp = nineTeenth();    				
    				//boolean temp2 = fifeteenWord();
    				isWord =true;
    				//if(temp)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 19th word
     * @return isWord true if the word is placed
     */

	private static boolean nineTeenth() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==4&&crossWord[9][6].charAt(0)==line.charAt(0)&&!line.contains("'")){
    				System.out.println("19 " +line);
    				crossWord[10][6]=String.valueOf(line.charAt(1));
    				crossWord[11][6]=String.valueOf(line.charAt(2));
    				crossWord[12][6]=String.valueOf(line.charAt(3));
    				boolean temp = twentyTeenth();    				
    				//boolean temp2 = fifeteenWord();
    				isWord =true;
    				if(temp)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}

	private static boolean twentyTeenth() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==5&&crossWord[10][4].charAt(0)==line.charAt(0)&&crossWord[10][5].charAt(0)==line.charAt(1)&&crossWord[10][6].charAt(0)==line.charAt(2)&&!line.contains("'")){
    				System.out.println("20 " +line);
    				crossWord[10][7]=String.valueOf(line.charAt(3));
    				crossWord[10][8]=String.valueOf(line.charAt(4));
    				boolean temp = twentyOneth();    				
    				//boolean temp2 = fifeteenWord();
    				isWord =true;
    				if(temp)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 21th word
     * @return isWord true if the word is placed
     */

	private static boolean twentyOneth() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==4&&crossWord[9][7].charAt(0)==line.charAt(1)&&crossWord[10][7].charAt(0)==line.charAt(2)&&!line.contains("'")){
    				System.out.println("21 " +line);
    				crossWord[8][7]=String.valueOf(line.charAt(0));
    				crossWord[11][7]=String.valueOf(line.charAt(3));
    				boolean temp = twentyTwo();    				
    				//boolean temp2 = fifeteenWord();
    				isWord =true;
    				if(temp)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}

	private static boolean twentyTwo() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==4&&crossWord[8][7].charAt(0)==line.charAt(0)&&!line.contains("'")){
    				System.out.println("22 " +line);
    				crossWord[8][8]=String.valueOf(line.charAt(1));
    				crossWord[8][9]=String.valueOf(line.charAt(2));
    				crossWord[8][10]=String.valueOf(line.charAt(3));
    				boolean temp = twentyThree();    				
    				//boolean temp2 = fifeteenWord();
    				isWord =true;
    				if(temp)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 23rd word
     * @return isWord true if the word is placed
     */

	private static boolean twentyThree() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==4&&!line.contains("'")){
    				System.out.println("23 " +line);
    				crossWord[7][8]=String.valueOf(line.charAt(0));
    				crossWord[7][9]=String.valueOf(line.charAt(1));
    				crossWord[7][10]=String.valueOf(line.charAt(2));
    				crossWord[7][11]=String.valueOf(line.charAt(3));
    				boolean temp1 = twentyFour();    				
    				boolean temp2 = twentyFive();
    				isWord =true;
    				if(temp1&&temp2)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}

	private static boolean twentyFive() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==5&&crossWord[6][10].charAt(0)==line.charAt(2)&&crossWord[7][10].charAt(0)==line.charAt(3)&&crossWord[8][10].charAt(0)==line.charAt(4)&&!line.contains("'")){
    				System.out.println("25 " +line);
    				crossWord[4][10]=String.valueOf(line.charAt(0));
    				crossWord[5][10]=String.valueOf(line.charAt(1));
    				//boolean temp = twentySix();    				
    				//boolean temp2 = fifeteenWord();
    				isWord =true;
    				//if(temp)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 26th word
     * @return isWord true if the word is placed
     */

	private static boolean twentySix() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==4&&crossWord[6][9].charAt(0)==line.charAt(0)&&!line.contains("'")){
    				System.out.println("26 " +line);
    				crossWord[6][10]=String.valueOf(line.charAt(1));
    				crossWord[6][11]=String.valueOf(line.charAt(2));
    				crossWord[6][12]=String.valueOf(line.charAt(3));
    				boolean temp = twentySeven();    				
    				//boolean temp2 = fifeteenWord();
    				isWord =true;
    				if(temp)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 27th word
     * @return isWord true if the word is placed
     */

	private static boolean twentySeven() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==3&&crossWord[6][11].charAt(0)==line.charAt(1)&&crossWord[7][11].charAt(0)==line.charAt(2)&&!line.contains("'")){
    				System.out.println("27 " +line);
    				//crossWord[6][11]=String.valueOf(line.charAt(2));
    				crossWord[5][11]=String.valueOf(line.charAt(0));
    				isWord =true;
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 24th word
     * @return isWord true if the word is placed
     */

	private static boolean twentyFour() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==7&&crossWord[7][9].charAt(0)==line.charAt(4)&&crossWord[8][9].charAt(0)==line.charAt(5)&&crossWord[9][9].charAt(0)==line.charAt(6)&&!line.contains("'")){
    				System.out.println("24 " +line);
    				crossWord[3][9]=String.valueOf(line.charAt(0));
    				crossWord[4][9]=String.valueOf(line.charAt(1));
    				crossWord[5][9]=String.valueOf(line.charAt(2));
    				crossWord[6][9]=String.valueOf(line.charAt(3));
    				//boolean temp1 = twentyFour();  
    				boolean temp = twentySix(); 
    				//boolean temp2 = fifeteenWord();
    				isWord =true;
    				if(temp)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 12th word
     * @return isWord true if the word is placed
     */

	private static boolean twelvethWord() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==4&&crossWord[6][2].charAt(0)==line.charAt(2)&&crossWord[6][3].charAt(0)==line.charAt(3)&&!line.contains("'")){
    				System.out.println("12 " +line);
    				crossWord[6][0]=String.valueOf(line.charAt(0));
    				crossWord[6][1]=String.valueOf(line.charAt(1));
    				boolean temp1 = thirteenthWord();
    				isWord =true;
    				if(temp1)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the 13th word
     * @return isWord true if the word is placed
     */

	private static boolean thirteenthWord() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==4&&crossWord[7][2].charAt(0)==line.charAt(1)&&crossWord[7][3].charAt(0)==line.charAt(2)&&!line.contains("'")){
    				System.out.println("13 " +line);
    				crossWord[7][1]=String.valueOf(line.charAt(0));
    				crossWord[7][4]=String.valueOf(line.charAt(3));
    				//boolean temp = fourteenthWord();
    				isWord =true;
    				//if(temp)
    				break;   
    		}

    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the first word
     * @return isWord true if the word is placed
     */
	private static void firstWord() {
		Scanner sc = null;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();	
    			if(line.length()==4&&crossWord[1][6].charAt(0)==line.charAt(1)&&!line.contains("'")){
    				crossWord[0][6]=String.valueOf(line.charAt(0));
    				crossWord[1][6]=String.valueOf(line.charAt(1));
    				crossWord[2][6]=String.valueOf(line.charAt(2));
    				crossWord[3][6]=String.valueOf(line.charAt(3));
    				boolean temp = secondWord();
    				System.out.println("1 " +line);
    				if(temp)	
    				break;	
    			}
    		}
    		sc.close();
    		    		
    	} catch ( Exception e )	{
    		
    		System.err.println("Something went wrong!" + e.getMessage());
    	}
    }
		
	/**
     * Find the second word
     * @return isWord true if the word is placed
     */

	private static boolean secondWord() {
		// TODO Auto-generated method stub
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

		if(line.length()==5&&crossWord[2][6].charAt(0)==line.charAt(2)&&!line.contains("'")){
			crossWord[2][4]=String.valueOf(line.charAt(0));
			crossWord[2][5]=String.valueOf(line.charAt(1));
			crossWord[2][7]=String.valueOf(line.charAt(3));
			crossWord[2][8]=String.valueOf(line.charAt(4));
			boolean temp = thirdWord();
			System.out.println("2 "+line);
			isWord =true;
			if(temp)
			break;			
		}
    		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
    	return isWord;
		
	}
	/**
     * Find the third word
     * @return isWord true if the word is placed
     */

	private static boolean thirdWord() {

		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==4&&crossWord[1][5].charAt(0)==line.charAt(0)&&crossWord[2][5].charAt(0)==line.charAt(1)&&!line.contains("'")){
    				crossWord[3][5]=String.valueOf(line.charAt(2));
    				crossWord[4][5]=String.valueOf(line.charAt(3));
    				boolean temp = fourthWord();
    				System.out.println("3 "+line);
    				isWord =true;
    				if(temp)
    				break;    				
    			}						
		}
    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
		return isWord;
	
	}
	/**
     * Find the fourth word
     * @return isWord true if the word is placed
     */
	private static boolean fourthWord() {
		Scanner sc = null;
		boolean isWord = false;
    	try {
    		 sc  = new Scanner( new File("C:/Users/Amit/workspace/Homework/src/words_hpb.txt"));
    		while ( sc.hasNext() )	{
    			String line = sc.nextLine();
    			line = line.toUpperCase();

    			if(line.length()==7&&crossWord[3][5].charAt(0)==line.charAt(2)&&!line.contains("'")){
    				crossWord[3][3]=String.valueOf(line.charAt(0));
    				crossWord[3][4]=String.valueOf(line.charAt(1));
    				crossWord[3][7]=String.valueOf(line.charAt(4));
    				crossWord[3][8]=String.valueOf(line.charAt(5));
    				crossWord[3][9]=String.valueOf(line.charAt(6));
    				boolean temp = fithWord();
    				System.out.println("4 "+line);
    				isWord =true;
    				if(temp)
    				break;    				
    			}						
		}

    		sc.close();
    	}
    		catch ( Exception e )	{
        		
        		System.err.println("Something went wrong!" + e.getMessage());
        	}
		return isWord;
	}
	/**
     * Intialize the crpssWord with "FUN" and "."
     */
	private static void initializePuzzle() {
		// TODO Auto-generated method stub
		int i;
		int j;
		int startCol = 5;
		int endCol;
		crossWord[1][5]="F";
		crossWord[1][6]="U";
		crossWord[1][7]="N";
		crossWord[4][6]=" ";
		crossWord[5][5]=" ";
		crossWord[5][6]=" ";
		crossWord[5][7]=" ";
		crossWord[6][4]=" ";
		crossWord[6][5]=" ";
		crossWord[6][6]=" ";
		crossWord[6][7]=" ";
		crossWord[6][8]=" ";
		crossWord[7][5]=" ";
		crossWord[7][6]=" ";
		crossWord[7][7]=" ";
		crossWord[8][6]=" ";
		for(i=0;i<6;i++){
		  for(j=startCol;j>=0;j--){
			crossWord[i][j]=" ";
		}
		startCol--;
		}
		startCol=7;
		for(i=0;i<6;i++){
		  for(j=startCol;j<13;j++){
			crossWord[i][j]=" ";
		}
		startCol++;
		}
		endCol=1;
		for(i=7;i<13;i++){
		  for(j=0;j<endCol;j++){
			crossWord[i][j]=" ";
		}
		  endCol++;
		}
		endCol=11;
		for(i=7;i<13;i++){
			  for(j=12;j>endCol;j--){
				crossWord[i][j]=" 	";
			}
			  endCol--;
			}
	}

}