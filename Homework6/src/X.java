import java.util.HashMap;
import java.util.Map;

public class  X {
	static Integer varX = 2;
	static String a ="2";
	public static void main(String args[]){
		Map m = new HashMap();
		m.put(a, "a");
		m.put(a, "b");
		System.out.println(m.get(a));
	}
	public void print(){
		System.out.println("x class");
	}
}