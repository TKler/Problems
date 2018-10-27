package p1to19;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Uber.
//
//Given an array of integers, return a new array such that each element at index i of 
//the new array is the product of all the numbers in the original array except the one 
//at i.
//
//For example, if our input was [1, 2, 3, 4, 5], the expected output 
//would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], 
//the expected output would be [2, 3, 6].
//
//Follow-up: what if you can't use division?
public class Problem2
{
	//@assert no element is 0;
	//@assert fullProduct will be under Intmax
	//@assert arraysize over 1
	public int[] productAllWithoutThemselfs2(int[] array)
	{
		int fullProduct = 1;
		for(int i : array)
			fullProduct = fullProduct * i;
		
		for(int i = 0; i < array.length; i++)
			array[i] = fullProduct / array[i];
		
		return array;
	}
	
	
	public int[] productAllWithoutThemselfs(int[] array)
	{
		int[] leftProduct = new int[array.length];
		int[] rightProduct = new int[array.length];
		leftProduct[0] = array[0];
		rightProduct[array.length-1] = array[array.length-1];
		
		for(int i = 1; i < array.length; i++)
			leftProduct[i] = leftProduct[i-1] * array[i];
			
		for(int i = array.length-2; i > -1; i--)
			rightProduct[i] = rightProduct[i+1] * array[i];
		
		for(int i= 1; i < array.length-1; i++)
		{
			array[i] = leftProduct[i-1] * rightProduct[i+1];
		}
		array[0] = rightProduct[1];
		array[array.length-1] = leftProduct[array.length-2];
		
		return array;
	}
	
	// ANSWER: Runtime increases from 2n to 3n.
	
	@Nested
	public class testProblem2
	{
		@Test
		void test1()
		{
			assertArrayEquals(new int[] {120, 60, 40, 30, 24}, 
					productAllWithoutThemselfs(new int[] {1, 2, 3, 4, 5}));
		}
		
		@Test
		void test2()
		{
			assertArrayEquals(new int[] {2, 3, 6}, 
					productAllWithoutThemselfs(new int[] {3, 2, 1}));
		}
	}
}
