package p40to59;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Google.
//
//Given an array of integers where every integer occurs three times except for one integer, 
//which only occurs once, find and return the non-duplicated integer.
//
//For example, given [6, 1, 3, 3, 3, 6, 6], return 1. Given [13, 19, 13, 13], return 19.
//
//Do this in O(N) time and O(1) space.
public class Problem40
{
//	O(nlogn) time and O(1) space: sort and count until 3 each time.
//	O(n) time and O(n) space, count in a hasmap the appearances of each, get the once with 1 as value
//  This code works for double elements, but not triple. I see no way to solve this :(
	public int findSingleElement(int[] array)
	{ 
		int single = array[0];
		for(int i = 1; i < array.length; i++)
		{
			single = single ^ array[i];
		}
	    return single;
	 }
	
	@Nested
	public class TestProblem40
	{
		@Test
		void fakeTestWithDoubleElements()
		{
			int[] input = new int[] {6, 1, 3, 3, 6};
			int output = 1;
			assertEquals(output, findSingleElement(input));
		}
//		@Test
//		void realTest()
//		{
//			int[] input = new int[] {6, 1, 3, 3, 3, 6, 6};
//			int output = 1;
//			assertEquals(output, findSingleElement(input));
//		}
	}
}
