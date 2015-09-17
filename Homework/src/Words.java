
public class Words {
	static int i,j,k,c=0,w;

	public static void main(String[] args) {
  String line = "Test this concept!";
  frequencycount(line);
	}
  static void frequencycount(String text)
  
  { 
      char[] temp=new char[text.length()];
      for(w=0;w<text.length();w++)
      temp[w]=text.charAt(w);
      for(i=0;i<w;i++)
      {
          char ch=temp[i];
          for(j=i+1;j<w;j++)
          {
              if(temp[j]==ch)
              {
                  for(k=j;k<(w-1);k++){
                	  temp[k]=temp[k+1];  
                  }                  
                  w--;
                  j=i;
              }
          }
      }
      for(i=0;i<w;i++)
      {
          for(j=0,c=0;j<text.length();j++)
          {
              if(temp[i]==text.charAt(j))
              c++;
          }
          System.out.print(temp[i]+"="+c+",");
      }
  }
}
