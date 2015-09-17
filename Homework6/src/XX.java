public class  XX  extends X {
	static int varX = 3;
	public static void main(String args[]){
		XX child = new XX();
		X base = new XX();
		X baseO = new X();
		child.print();
		base.print();
		baseO.print();

		System.out.println(base.varX);
	}
	public  void  print(){
		X base = new XX();
		System.out.println(varX);
		System.out.println("Child class");
		
	}
}