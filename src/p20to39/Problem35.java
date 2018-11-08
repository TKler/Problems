package p20to39;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Google.
//
//Given an array of strictly the characters 'R', 'G', and 'B', segregate the values of the 
//array so that all the Rs come first, the Gs come second, and the Bs come last. 
//You can only swap elements of the array.
//
//Do this in linear time and in-place.
//
//For example, given the array ['G', 'B', 'R', 'R', 'B', 'R', 'G'], it should become 
//['R', 'R', 'R', 'G', 'G', 'B', 'B'].
public class Problem35
{
	public char[] sortArray(char[] array, char[] order)
	{
		int index = 0;
		for(int i = 0; i < order.length-1; i++)
		{
			index = sortToLeft(array, order[i], index);
		}
		
		return array;
	}
	
	private int sortToLeft(char[] array, char c, int startIndex)
	{
		int left = startIndex; 
		int right = array.length-1;
		boolean flag = true;
		
		while(flag)
		{
			while(array[left] == c)
				left++;
			while(array[right] != c)
				right--;
			
			if(left < right)
				swapValuesAtIndizies(array, left, right);
			else
				flag = false;
		}
		return right+1;
	}

	private void swapValuesAtIndizies(char[] array, int left, int right)
	{
		char safe = array[right];
		array[right] = array[left];
		array[left] = safe;
	}
	
	@Nested
	public class TestProblem35
	{
		@Test
		void test()
		{
			char[] input = new char[] {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
			char[] output = new char[] {'R', 'R', 'R', 'G', 'G', 'B', 'B'};
			char[] order = new char[] {'R', 'G', 'B'};
			assertArrayEquals(output, sortArray(input, order));
		}
	}
}
