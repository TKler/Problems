import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Stripe.
//
//Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
//
//For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
//
//You can modify the input array in-place.
//	@assert 0 is not a positiv number
public class Problem4
{
// WHY DOES THIS RUN IN O(n);
// The first loop runs n times
// The inner while loop runs potentially n times, but only once. There is a 
//	maximum of n swap operations that take place since max n values can't be at their index.
// The last loop again only runs n times.
// Ergo this runs in O(3n) -> O(n).
	
	public int findTheLowestMissingPositivInteger(int[] array)
	{
		int safe;
		for(int i = 0; i < array.length; i++)
		{
			int value = array[i];
			while(0 < value && value < array.length && value != array[value])
			{
				safe = array[value];
				array[value] = value;
				value = safe;
			}
		}
		
		for(int i = 1; i < array.length; i++)
			if(array[i] != i)
				return i;
		
		return array.length;
	}
	
	@Nested
	public class testProblem4
	{
		@Test
		void test1()
		{
			assertEquals(findTheLowestMissingPositivInteger(new int[] {3, 4, -1, 1}), 2);
		}
		
		@Test
		void test2()
		{
			assertEquals(findTheLowestMissingPositivInteger(new int[] {1,2,0}), 3);
		}
	}
}
