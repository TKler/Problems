package p140to159;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Goldman Sachs.
//
//Given a list of numbers L, implement a method sum(i, j) which returns the sum from 
//the sublist L[i:j] (including i, excluding j).
//
//For example, given L = [1, 2, 3, 4, 5], sum(1, 3) should return sum([2, 3]), 
//which is 5.
//
//You can assume that you can do some pre-processing. sum() should be optimized 
//over the pre-processing step.
public class Problem149
{
	public int getSum(int[] array, int leftIndex, int rightIndex)
	{
		assert(leftIndex >= 0 && leftIndex < array.length);
		assert(rightIndex >= 0 && rightIndex <= array.length);
		
		int sum = 0;
		
		for(int i = leftIndex; i < rightIndex; i++)
		{
			sum += array[i];
		}
		
		return sum;
	}
	
	public int getSumPreprocess(int[] array, int leftIndex, int rightIndex)
	{
		assert(leftIndex >= 0 && leftIndex < array.length);
		assert(rightIndex >= 0 && rightIndex <= array.length);
		assert(leftIndex <= rightIndex);
		
		int[] sumLeftToRight = new int[array.length];
//		int[] sumRightToLeft = processRightToLeft(array);
		int sum = 0;
		for(int i = 0; i < array.length; i++)
		{
			sum += array[i];
			sumLeftToRight[i] = sum;
		}
		
		return sumLeftToRight[rightIndex-1] - (leftIndex > 0 ? sumLeftToRight[leftIndex-1] : 0);
	}
	
	@Nested
	public class TestProblem149
	{
		@Test
		void test()
		{
			int[] input = {1,2,3,4,5,6,7,8};
			assertEquals(10, getSum(input, 0, 4));
			assertEquals(10, getSumPreprocess(input, 0, 4));
			
			assertEquals(36, getSum(input, 0, 8));
			assertEquals(36, getSumPreprocess(input, 0, 8));
			
			assertEquals(26, getSum(input, 4, 8));
			assertEquals(26, getSumPreprocess(input, 4, 8));
			
			assertEquals(18, getSum(input, 4, 7));
			assertEquals(18, getSumPreprocess(input, 4, 7));
		}
	}
}
