import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * This class implements the shuffle and sort methods for a collection.
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 10/13/2014
 * 
 */

public class YourCollections {
  public static void shuffleList(List<String> a) {
    int n = a.size();
    Random random = new Random();
    for (int i = 0; i < n; i++) {
      int change = i+ random.nextInt(n - i);
      swap(a, i, change);
    }
  }
  
/**
* Swapping the elements of the arrayList
* @param a List of String type
* @param change integer
* @return  void
*/	
  private static void swap(List<String> a, int i, int change) {
    String replace =  a.get(i);
    a.set(i, a.get(change));
    a.set(change, replace);
  }
  
/**
* The main program.
*
* @param    args    command line arguments (ignored)
* @param	list    The List of Strings type
* @param	l       The List of integer type
*/
  public static void main(String[] args) {
    List<String> list = new ArrayList<String>();
    List<Integer> l = new ArrayList<Integer>();
    initialize(list);
    initializeSort(l);
    shuffleList(list);
    sort(l);
    Iterator<String> it = list.iterator();
    Iterator<Integer> itl = l.iterator();
    System.out.println("\nThe shuffled cards");
    while(it.hasNext()){         
      String print = (String) it.next();
      System.out.println(print);
    }
   System.out.println("\nThe sorted list");
   while(itl.hasNext()){
	   int printInt = (int)itl.next();
	   System.out.println(printInt);
   }
  }
  /**
  * Sorting the elements of the arrayList
  * @param l List of integer type
  * @return  void
  */
private static void sort(List<Integer> l) {
	for(int i =0; i<l.size(); i++){
		for(int j=0; j<l.size()-i-1;j++){
		Integer left =   l.get(j);
		Integer rigth =  l.get(j+1);
			if(left.compareTo(rigth)>0){
		     int temp = (int) l.get(j);
		     l.set(j, l.get(j+1));
		     l.set(j+1, temp);
			}
		}
	}
	
}

/**
* initializing the elements for sorting the arrayList
* @param l List of integer type
* @return  void
*/
private static void initializeSort(List<Integer> l) {
	// TODO Auto-generated method stub
	for(int i=10;i>0;i--){
		l.add(i);
	}
    Iterator<Integer> it = l.iterator();
    System.out.println("\nThe unsorted list");
    while(it.hasNext()){         
      int print = (int) it.next();
      System.out.println(print);
    }
	
}
/**
* initializing the elements for shuffling the arrayList
* @param l List of string type
* @return  void
*/
private static void initialize(List<String> list) {
	System.out.println("The unshuffled cards \n");
	for(int i=1;i<14;i++){
		list.add("Club" +i);
	}
	for(int i=1;i<14;i++){
		list.add("Heart" +i);
	}
	for(int i=1;i<14;i++){
		list.add("Spade" +i);
	}
	for(int i=1;i<14;i++){
		list.add("Diamond" +i);
	}
	Iterator<String> it = list.iterator();
	   while(it.hasNext()){         
		   String print = (String) it.next();
		      System.out.println(print);
		    }
	// TODO Auto-generated method stub
	
}

} 