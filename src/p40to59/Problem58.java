package p40to59;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Amazon.
//
//An sorted array of integers was rotated an unknown number of times.
//
//Given such an array, find the index of the element in the array in faster than linear time. 
//If the element doesn't exist in the array, return null.
//
//For example, given the array [13, 18, 25, 2, 8, 10] and the element 8, return 4 (the index of 8 in the array).
//
//You can assume all the integers in the array are unique.
public class Problem58
{
	//assume unrotated you would go divide and conquer with always asking for arraysize/2 until you get the element, narrowing it down by virtue of <
	//this is a bit more complicated here. We have to detect the border basically.
	public int findElementIndexInSorted(int[] array, int element)
	{
		int index = array.length/2;
		int change = array.length/4 + (array.length/2)%2;
		int steps = (int) (Math.log(array.length) + 2);
		
		while(inBound(array, index) && steps >= 0)
		{
			
			if(array[index] == element)
				return index;
			else if(array[index] < element)
				index += change;
			else 
				index -= change;
			
			change = change/2 + change % 2;
			steps--;
		}
		
		return -1;
	}
	
	public int findElementIndexInRotated(int[] array, int element)
	{
		int numberOfRotations = findMaxIndex(array);

		int index = array.length/2;
		int change = array.length/4 + (array.length/2) % 2;
		int steps = (int) (Math.log(array.length) + 1);

		index = getRealIndex(index - numberOfRotations, array.length);
		
		while(inBound(array, index) && steps >= 0)
		{
			if(array[index] == element)
				return index;
			else if(array[index] < element)
				index += change;
			else 
				index -= change;
			
			change = change/2 + change%2;

			index = getRealIndex(index, array.length);
			steps--;
		}
		
		return -1;
	}
	
	private int getRealIndex(int index, int length)
	{
		int result = index % length;
		if(result < 0)
			result += length;
				
		return result;
	}

	private int findMaxIndex(int[] array)
	{
		if(array[0] < array[array.length-1])
			return 0;
		
		int firstValue = array[0];
		int index = array.length/2;
		int change = index/2;
		
		while(inBound(array, index))
		{
			if(array[index] > array[index+1])
				return index;
			else if(array[index] < firstValue)
				index -= change;
			else
				index += change;
			
			if(change > 1)
				change = change / 2;
		}
		
		assert false;
		return -1;
	}

	private boolean inBound(int[] array, int pos)
	{
		return 0 <= pos && pos < array.length;
	}

	@Nested
	public class TestProblem58Sorted
	{
		@Test
		void testSorted()
		{
			int[] input = {1,3,5,7,9,11,13};
			int input2 = 11;
			int output = 5;
			assertEquals(output, findElementIndexInSorted(input, input2));
		}
		@Test
		void test2Sorted()
		{
			int[] input = {1,3,5,7,9,11,13};
			int input2 = 1;
			int output = 0;
			assertEquals(output, findElementIndexInSorted(input, input2));
		}
		@Test
		void test3Sorted()
		{
			int[] input = {1,3,5,7,9,11,13};
			int input2 = 13;
			int output = input.length-1;
			assertEquals(output, findElementIndexInSorted(input, input2));
		}
		@Test
		void testSortedFail()
		{
			int[] input = {1,3,5,7,9,11,13};
			int input2 = 14;
			int output = -1;
			assertEquals(output, findElementIndexInSorted(input, input2));
		}
	}
	
	@Nested
	public class TestProblem58Rotated
	{
//		@Test
//		void testFindMaxIndex()
//		{
//			int[] input = {14,15,1,3,5,7,9,11,13};
//			int output = 1;
//			assertEquals(output, findMaxIndex(input));
//			
//			int[] input2 = {15,1,3,5,7,9,11,13};
//			int output2 = 0;
//			assertEquals(output2, findMaxIndex(input2));
//			
//			int[] input3 = {1,2,3,4,5,6,7,8,9,0};
//			int output3 = 8;
//			assertEquals(output3, findMaxIndex(input3));
//		}
//		@Test
//		void testRotatedMiddle()
//		{
//			int[] input = {9,11,13,1,3,5,7};
//			int input2 = 3;
//			int output = 4;
//			assertEquals(output, findElementIndexInRotated(input, input2));
//		}
		@Test
		void testRotatedMiddleRight()
		{
			int[] input = {9,11,13,1,3,5,7};
			int input2 = 5;
			int output = 5;
			assertEquals(output, findElementIndexInRotated(input, input2));
		}
//		@Test
//		void test2RotatedFirst()
//		{
//			int[] input = {14,1,3,5,7,9,11,13};
//			int input2 = 14;
//			int output = 0;
//			assertEquals(output, findElementIndexInRotated(input, input2));
//		}
//		
//		@Test
//		void test3RotatedUnrotated()
//		{
//			int[] input = {1,3,5,7,9,11,13};
//			int input2 = 13;
//			int output = input.length-1;
//			assertEquals(output, findElementIndexInRotated(input, input2));
//		}
//		@Test
//		void test3RotatedAllButOne()
//		{
//			int[] input = {3,5,7,9,11,13,1};
//			int input2 = 13;
//			int output = input.length-2;
//			assertEquals(output, findElementIndexInRotated(input, input2));
//		}
//		@Test
//		void testRotatedFail()
//		{
//			int[] input = {11,13,1,3,5,7,9};
//			int input2 = 14;
//			int output = -1;
//			assertEquals(output, findElementIndexInRotated(input, input2));
//		}
	}
}
