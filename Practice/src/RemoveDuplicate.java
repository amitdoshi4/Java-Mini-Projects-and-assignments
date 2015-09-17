import java.util.Arrays;


public class RemoveDuplicate {
public static void main(String args[]) {
	
	int arr[]={1,2,2,3,3,4,5};
	
	System.out.println("l = " + remove(arr));
	
}

private static int remove(int[] arr) {
	int l = arr.length;
	int i =0;
	int m = arr.length-1;
	// TODO Auto-generated method stub
	while(i<arr.length-1&&i+1<m){
			if(arr[i]==arr[i+1]){
				l--;
				for(int k = i+1;k<arr.length-1;k++)
					arr[k]=arr[k+1];
				m--;
			}
				
			
			i++;
		}
	int a[] = Arrays.copyOf(arr, l);
	for(int j =0 ;j<arr.length;j++)
		System.out.println(arr[j]);
	return l;
}
}
