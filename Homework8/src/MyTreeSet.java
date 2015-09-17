import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * Implementation of TreeSet class. Not using anything besides basic types, arrays, and our own classes
 *
 * Version 1.0
 * 
 * @author Amit Doshi
 * @author Swanand Pathak
 *
 * Date: 10/18/2014
 * 
 */

public class MyTreeSet extends TreeSet {
	Object []o;
	int pos;
	MyTreeSet(){
		o = new Object[0];
		pos =11;
	}

/**
* The main program.
*
* @param    args    command line arguments (ignored)
* 
*/

public static void main(String args[]){
	
	
}

/**
* Checks if a specific element present in TreeSet
* @param Object e
* @return boolean
*/	

public boolean contains(Object e) {
	//for(int i=0;i<o.length;i++){
		// if((int)o[i]==Integer.valueOf((String) e))
	int i = Math.abs(Integer.valueOf((String) e));
	if(i<o.length){
	if((int)o[i]==Integer.valueOf((String) e))
			 return true;
	}
	//}
	return false;
	
}

/**
* This Method Clears all the elements of the TreeSet
* 
*/	
public void clear() {
	Object o2[]=new Object[0];
	o=o2;
	
}
/**
* This Method adds elements to the TreeSet
* @param Object ob
* @return boolean
*/	
public boolean add(Object ob){
	if(!isDuplicate(ob)){
	int e = Integer.parseInt((String) ob);
	Test t = new Test();
	int length = t.MAX_ELEMENTS;
        //find insert point
       int i = o.length;
       o=Arrays.copyOf(o, o.length+1);
       o[i] = e;
       if(i+1==length)
    	  Arrays.sort(o);
	}

	return true;		
}
/**
* Checks if a specific element already present in TreeSet
* @param Object e
* @return boolean
*/	
public boolean isDuplicate(Object e) {
	//for(int i=0; i<o.length-1;i++){
		//if((int)o[i]==Integer.valueOf((String) e))
	int i =-1;
	i = Arrays.binarySearch(o, Integer.valueOf((String) e));
	if(i>=0)
			return true;
	else
	return false;
	
}
/**
* Returns the Size of the TreeSet
* 
*/	
public int size(){
	return o.length;

}
/**
* Iterator Method with return type iterator
* 
*/	
	public MyIterator iterator(){
		MyIterator it = new MyIterator(o);
		return it;
		
	}
}

