package problemOneToTwenty;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Airbnb.
//
//Given a list of integers, write a function that returns the largest sum of non-adjacent numbers. Numbers can be 0 or negative.
//
//For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should return 10, since we pick 5 and 5.
//
//Follow-up: Can you do this in O(N) time and constant space?
public class Problem9
{
//	@assume array != null or empty
	public int largestSumOfNonadjacentNumbers(int[] array)
	{
		return step(array, 0);
	}

	private int step(int[] array, int index)
	{
		if(index >= array.length)
			return 0;//neutral element
		
		return Math.max(array[index] + step(array, index+2), step(array, index+1));
	}
	
	@Nested
	public class TestProblem9
	{
		@Test
		void test1()
		{
			assertEquals(largestSumOfNonadjacentNumbers(new int[] {5,1,1,5}), 10);
		}
		
		@Test
		void test2()
		{
			assertEquals(largestSumOfNonadjacentNumbers(new int[] {2,4,6,2,5}), 13);
		}
		
		@Test
		void test3()
		{
			assertEquals(largestSumOfNonadjacentNumbers(new int[] {-2,-4,0,-2,-5}), 0);
		}
	}
}
