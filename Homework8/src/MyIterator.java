import java.util.Iterator;


public class MyIterator implements Iterator {
	Object o[];
	 int i=-1;
	 int j=-1;
	MyIterator(Object[] o){
		this.o=o;
	}

/**
* The main program.
*
* @param    args    command line arguments (ignored)
* 
*/

public static void main(String args[])
{
	
}
@Override

/**
* Checks if the TreeSet hasNext element
* @return boolean
*/	

public boolean hasNext() {
	// TODO Auto-generated method stub
	i++;
	if(i<(o.length))
		return true;
	else
		return false;
}
@Override

/**
* This Method returns the next element in TreeSet
* @param Object e
* @return boolean
*/	

public Object next() {
	// TODO Auto-generated method stub
	
	//if(hasNext()==false)
	//	return null;
	//else
	j++;
		return o[j];
				
}
@Override
public void remove() {
	// TODO Auto-generated method stub
	
}
}
