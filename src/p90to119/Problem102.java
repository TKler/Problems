package p90to119;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Lyft.
//
//Given a list of integers and a number K, return which contiguous elements of the list sum to K.
//
//For example, if the list is [1, 2, 3, 4, 5] and K is 9, then it should return [2, 3, 4].

public class Problem102
{
	//@assert int a : array > -1
	//@assert limit > 0
	public int[] findSubarray (int[] array, int limit)
	{
		if(array == null)
			return null;

		int start = 0;
		int end = 0;
		int sum = 0;
		for(int a : array)
		{
			sum += a;
			
			while(sum > limit)
			{
				sum -= array[start];
				start++;
			}
			
			if(sum == limit) break;
			
			end++;
		}
		
		if(sum != limit)
			return null;
		
		return Arrays.copyOfRange(array, start, end+1);
		
		//return (sum != limit) ? null : Arrays.copyOfRange(array, start, end+1);
	}
	
	@Test
	void testProblem102()
	{
		int[] array = {1,2,3,4,5};
		int[] result = {2,3,4};
		
		assertTrue(Arrays.equals(result, findSubarray(array, 9)));
		assertEquals(null , findSubarray(array, 20));
		assertEquals(null, findSubarray(null, 15));
	}
}
