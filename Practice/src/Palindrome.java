class Palindrome
{
   public static void main(String args[])
   {
      String original = "Red rum si r is mur der";
     String reverse = "";
 
      int length = original.length();
      String o1 = original.toLowerCase();
 
      for ( int i = length - 1; i >= 0; i-- )
         reverse = reverse + o1.charAt(i);
 
      if (original.equals(reverse))
         System.out.println("Entered string is a palindrome.");
      else
         System.out.println("Entered string is not a palindrome.");
 
   }
}	