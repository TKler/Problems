package p40to59;

public class a
{
	
	public static void main(String[] args) {

	    int a[] = {5,4,3,2,1,-3,-2,-30};
	    int length = a.length - 1;

	    for (int i = 0 ; i < length ; i++) 
	    {
	        for (int j = 0 ; j < length-i ; j++) 
	        {
	            if (a[j] < a[j+1]) 
	            {
	                int swap = a[j];
	                a[j] = a[j+1];
	                a[j+1] = swap;
	            }
	        }
	    }

	    for (int x : a) {
	        System.out.print(x+" ");
	    }
	}
}
