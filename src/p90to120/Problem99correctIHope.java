package p90to120;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Microsoft.
//
//Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
//
//For example, given [100, 4, 200, 1, 3, 2], the longest consecutive element sequence is [1, 2, 3, 4]. Return its length: 4.
//
//Your algorithm should run in O(n) complexity.

public class Problem99correctIHope
{
	Set<Integer> set = new HashSet<Integer>();	
	
	public int longestConsecutiveSequence(int[] array)
	{
		if(array.length == 0)
			return 0;
		if(array.length == 1)
			return 1;
		
		
		for(int a : array)
			this.set.add(a);
		
		int max = 1;
		for(int a : array)
			max = Math.max(max, getConsecutiveSequenceLength(a));
		
		return max;
	}
	
	private int getConsecutiveSequenceLength(int a)
	{
		int max = 1;
		int aStart = a;
		this.set.remove(a);
		while(this.set.contains(a-1))
		{
			this.set.remove(a-1);
			max++;
			a--;
		}
		a = aStart;
		while(this.set.contains(a+1))
		{
			this.set.remove(a+1);
			max++;
			a++;
		}
		return max;
	}

	@Test
	public void testProblem99correctIHope()
	{
		int[] array1 = {};
		int[] array2 = {2};
		int[] array3 = {100,4,200,1,3,2};
		int[] array4 = {1,2,3,4};
		
		assertEquals(0, longestConsecutiveSequence(array1));
		assertEquals(1, longestConsecutiveSequence(array2));
		assertEquals(4, longestConsecutiveSequence(array3));
		assertEquals(4, longestConsecutiveSequence(array4));
	}
}
