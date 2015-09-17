// this code is incorrect.
// find out what is incorrect, show it to me and get 100% for this hw.
import java.util.Scanner;
import java.io.File;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CrossWord {
  static final int MAX = 13;
  static final String inputFile = "C:/Users/Amit/workspace/Homework/src/words_hpb.txt";
  static final int HORIZONATAL = 1;
  static final int VERTICAL = 2;
  static int soManyWords = readWordsOrCountLines(false);
  static String[] theWords = new String[soManyWords];
  static char[][] thePuzzle = new char[MAX][MAX];
  static int[][]  thePuzzleLastAdd = new int[MAX][MAX];
  static int backtrackingLevel = 0;
  static int recursionLevel = 0;

   	// better would have been static init. 
  public static void initPuzzle()	{
	for ( int row = 0; row < MAX; row ++ )	{		// init no words are in
		for ( int column = 0; column < MAX; column ++ )	{
			thePuzzle[row][column] = '.';
			thePuzzleLastAdd[row][column] = -1;		// no word filled in
		}
	}
	for ( int row = 0; row < MAX/2; row ++ )	{	// top left
		for ( int column = 0; column < MAX/2 - row ;  column ++ )	{
			thePuzzle[row][column] = 'X';
		}
	}
	for ( int row = 0; row < MAX/2; row ++ )	{	// top right
		for ( int column = row + MAX/2 + 1; column < MAX; column ++ )	{
			thePuzzle[row][column] = 'X';
		}
	}
	for ( int row = MAX/2; row < MAX; row ++ )	{	// bottom left
		for ( int column = 0; column < row - MAX/2 ; column ++ )	{
			thePuzzle[row][column] = 'X';
		}
	}
	int counter = 0;
	for ( int row = MAX/2; row < MAX; row ++ )	{	// bottom right
		for ( int column = 0; column < counter;  column ++ )	{
			thePuzzle[row][MAX - column - 1] = 'X';
		}
		counter++;
	}
	thePuzzle[1][5] = 'f';
	thePuzzle[1][6] = 'u';
	thePuzzle[1][7] = 'n';

	                                    thePuzzle[4][6] = 'X';
	                  thePuzzle[5][5] = thePuzzle[5][6] =  thePuzzle[5][7] = 'X';
	thePuzzle[6][4] = thePuzzle[6][5] = thePuzzle[6][6] =  thePuzzle[6][7] = thePuzzle[6][8] = 'X';
	                  thePuzzle[7][5] = thePuzzle[7][6] =  thePuzzle[7][7] = 'X';
	                                    thePuzzle[8][6] = 'X';
	                                    
	                              
  }
  public static void printPuzzle()	{
	for ( int row = 0; row < MAX; row ++ )	{
		for ( int column = 0; column < MAX; column ++ )	{
			System.out.print(thePuzzle[row][column]);
		}
		System.out.println();
	}
  }
	// not used
  public static void printWords()	{
	int counter = 0;
	for ( int index = 0; index < 10; index ++ )	{
		System.out.println(index + ": " + theWords[index]);
	}
  }
  public static int readWordsOrCountLines(boolean fillArray)	{
	int counter = 0;
	try {
		String line;
		Scanner sc  = new Scanner( new File(inputFile) );
		while ( sc.hasNext() )	{
			line = sc.nextLine();
			if ( fillArray )	{
				theWords[counter] = line.toLowerCase();
			}
			counter ++;
		}
		sc.close();
	} catch ( Exception e ) {
		counter = -1;
                e.printStackTrace();
                System.err.println("Something went wrong!");
        }
	return counter;
  }
  public static void removeWord()	{
	for  ( int row = 0; row < MAX; row ++ )	{
		for ( int column = 0; column < MAX; column ++ )	{
			if ( thePuzzleLastAdd[row][column] == recursionLevel )	{
				thePuzzleLastAdd[row][column] = -1;
				thePuzzle[row][column] = '.';
			}
		}
	}
  }
  public static void addThisWord(String thisWord, int row, int column, int direction)	{
		for ( int index = 0; index < thisWord.length(); index ++ )	{
			if ( direction == HORIZONATAL ) {
				thePuzzle       [row][column+index] = thisWord.charAt(index);
				thePuzzleLastAdd[row][column+index] = -1;
			} else {
				thePuzzle        [row+index][column] = thisWord.charAt(index);
				thePuzzleLastAdd[row+index][column] = thisWord.charAt(index);
			}
		}
  }
  public static String doesAWordFit(String inHere)	{
        Pattern p = Pattern.compile(inHere);	
	Matcher m ;
	for ( int index = 0; index < theWords.length; index ++ )	{
		m = p.matcher(theWords[index]);
		if ( m.matches() )
			return theWords[index];
	}
	return "";
  }
  public static boolean addWord(int r, int c, int direction)	{
	boolean rValue = false;
	String theWord = "";
	String foundThisOne = "";
	int row = r;
	int column = c;
	if ( direction == HORIZONATAL )	{		//  what is already there
		while ( ( column < MAX ) 				&&
			( ( thePuzzle[row][column] == '.' ) ||
			  ( ( 'a' <= thePuzzle[row][column]  ) && ( thePuzzle[row][column]  <= 'z' ) )
			)
		      )	{
			theWord = theWord + thePuzzle[row][column++];
		}
	} else {
		while ( ( row < MAX ) 				&&
			( ( thePuzzle[row][column] == '.' ) ||
			  ( ( 'a' <= thePuzzle[row][column]  ) && ( thePuzzle[row][column]  <= 'z' ) )
			)
		      )	{
			theWord = theWord + thePuzzle[row++][column];
		}
	}

	if ( theWord.length() == 1 )	// theWord is what is already in the puzzle
		rValue =  false;
	else	{
		if (  ( foundThisOne = doesAWordFit(theWord) ) != "")	{	// which one would fit
			addThisWord(foundThisOne, r, c, direction);
			rValue = true;
		}
	}
	return rValue;
  }
  public static boolean isThisAStartingPoint(int row, int column, int direction)	{
	if ( direction == HORIZONATAL )	{
		if ( row == 0 )
			return thePuzzle[row][column] == '.';
		return ( thePuzzle[row][column] == '.' ) && ( thePuzzle[row-1][column] == 'X'  );
	} else {
		if ( column == 0 )
			return thePuzzle[row][column] == '.';
		return ( thePuzzle[row][column] == '.' ) && ( thePuzzle[row][column-1] == 'X'  );
	}
  }
  public static void solvePuzzle()	{
	for ( int row = 0; row < MAX; row ++ )	{
		for ( int column = 0; column < MAX; column ++ )	{
			for ( int direction = HORIZONATAL; direction <= VERTICAL; direction ++ )	{
				if ( isThisAStartingPoint(row, column, direction ) )	{
					if ( addWord(row, column, direction) ) 	{
						recursionLevel ++;
						solvePuzzle();
						recursionLevel --;
						removeWord();
					}
				}
			}
		}
	}
  }
  public static void main( String[] args ) {
	System.err.println("soManyWords " + soManyWords );
	readWordsOrCountLines(true);
	initPuzzle();
	solvePuzzle();
	printPuzzle();
  }
}