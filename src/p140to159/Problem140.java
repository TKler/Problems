package p140to159;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Facebook.
//
//Given an array of integers in which two elements appear exactly once and all 
//other elements appear exactly twice, find the two elements that appear only once.
//
//For example, given the array [2, 4, 6, 8, 10, 2, 6, 10], return 4 and 8. The order does not matter.
//
//Follow-up: Can you do this in linear time and constant space?
public class Problem140
{
	//linear time and linear space
	public Integer[] getSingleElements(int[] array)
	{
		Set<Integer> once = new HashSet<Integer>();
		for(int i : array)
		{
			if(once.contains(i))
				once.remove(i);
			else
				once.add(i);
		}
		Integer[] result = new Integer[2];
		return once.toArray(result);
//		return once; return type collection
	}
	
	/*
	 * For just a single single element we simply XOR everything and we get the result. Here we get a+b as result where a and b are the single numbers.
	 * Since a and b are distinct we can now divide the array into two different arrays, those whichs numbers have a 1 at some position in our XOR result
	 * and those that don't. a has to be in one set, b in the other. Now we again have two single sets with single singles.
	 */
	// this runs in 2n time and 3space, well 2, but 3 here for clarity
	public Integer[] getSingleElementsXOR(int[] array)
	{
		int xor = 0;
		for(int i : array)
		{
			xor ^= i;
		}
		
		int indexMaskBit = find1InXOR(xor);
		
		//divide into different xors
		int xor0 = 0; 
		int xor1 = 0;
		for(int i : array)
		{
			if(((i >> indexMaskBit) & 1) == 1)
				xor1 ^= i;
			else
				xor0 ^= i;
		}
		return new Integer[] {xor0, xor1};
	}

	private int find1InXOR(int xor)
	{
		for(int i = 0; i < 32; i++)
		{
			if(((xor >> i) & 1) == 1)
				return i;
		}
		assert(false);
		return 0;
	}
	
	@Nested
	public class TestProblem140
	{
		int[] input = {2, 4, 6, 8, 10, 2, 6, 10};
		Integer[] output = {4, 8};

		@Test
		public void test()
		{
			Integer[] outputMethod = getSingleElements(input);
			Arrays.sort(outputMethod, Integer::compareTo);
			assertTrue(Arrays.equals(output, outputMethod));
		}
		
		@Test
		public void testXOR()
		{
			Integer[] outputMethod = getSingleElementsXOR(input);
			Arrays.sort(outputMethod, Integer::compareTo);
			assertTrue(Arrays.equals(output, outputMethod));
		}
	}
}
