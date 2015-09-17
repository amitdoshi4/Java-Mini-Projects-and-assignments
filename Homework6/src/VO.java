public class VO {
	String name;
    public static void main(String[] args) {
    	
        VO vo1 = new VO();
        VO vo2 = new VO();
        VO vo4 = new VO();
        VO vo3;

        vo1.setName("Sourav");
        vo2.setName("Anil");

        vo3 = vo1;
        vo4 = vo1;

        System.out.println(" " + vo4.getName());

        vo1.setName("Abhishek.");
        vo3.setName("Amit");

        System.out.println(vo1.getName() + "  " + vo2.getName() + " " + vo3.getName() + " " + vo4.getName());
    }

	private String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	private void setName(String string) {
		this.name = string;
		// TODO Auto-generated method stub
		
	}
	public String[] arrayTest(){
		String [] a = new String[1];
		a[0]= "Amit";
		a[1] = "Doshi";
		return a;
		
	}
}