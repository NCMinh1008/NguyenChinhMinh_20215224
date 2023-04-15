import java.util.Arrays; 
import java.util.Scanner;  
public class SumArray {
	public static void main(String[] args){   
	    
		int n;  
		Scanner sc=new Scanner(System.in);  
		System.out.print("Enter the number of elements you want to store: ");  
		n=sc.nextInt();  
		int[] array = new int[n];  
		System.out.println("Enter the elements of the array: ");  
		for(int i=0; i<n; i++)  
		{   
		array[i]=sc.nextInt();  
		}  
	               
	    System.out.println("Original numeric array : " + Arrays.toString(array));
	    Arrays.sort(array);
	    System.out.println("Sorted numeric array : " + Arrays.toString(array));
	    int sum = 0;
	       for(int i=0; i < n ; i++)
	        sum = sum + array[i];
	        System.out.println("Average value of the array elements is : " + sum); 
	        double average = sum / n;
	        System.out.println("Average value of the array elements is : " + average); 
	}
}
