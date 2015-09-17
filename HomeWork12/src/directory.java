import java.io.File;
import java.util.ArrayList;



public class directory {
	ArrayList<File> files = new ArrayList<File>();
	
	public void listf(String directoryName) {
	    File directory = new File(directoryName);

	    // get all the files from a directory
	    File[] fList = directory.listFiles();
	    for (File file : fList) {
	        if (file.isFile()) {
	            files.add(file);
	        } else if (file.isDirectory()) {
	        	if(!directory.isHidden())
	            listf(file.getAbsolutePath());
	        }
	    }
	}
	
	public static void main(String args[]){
		directory d = new directory();
		d.listf("C:/Users/Amit");
		System.out.println(d.files);
		
	}
}
