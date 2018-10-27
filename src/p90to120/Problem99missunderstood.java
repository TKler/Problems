package p90to120;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Microsoft.
//
//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.
//
//Your algorithm should run in O(n) complexity.

/**
 * Did first think of the longest chain of increasing values
 * decided to do it anyway, since it's easy^^
 */
public class Problem99missunderstood
{
	public int longestIncreaseStreak(int[] array)
	{
		if(array.length == 0)
			return 0;
		if(array.length == 1)
			return 1;
		
		int last = array[0];
		int next;
		int count = 1;
		int max = 1;
		
		for(int i = 1; i < array.length; i++)
		{
			next = array[i];
			if(last < next)
				count++;
			else
			{
				max = Math.max(max, count);
				count = 1;
			}
			last = next;
		}
		max = Math.max(max, count);
		
		return count;
	}
	
	@Test
	public void testProblem99missunderstood()
	{
		int[] array1 = {2,1,5,4,3,4,8};
		int[] array2 = {};
		int[] array3 = {2};
		
		assertEquals(longestIncreaseStreak(array1), 3);
		assertEquals(longestIncreaseStreak(array2), 0);
		assertEquals(longestIncreaseStreak(array3), 1);
	}

	
}
