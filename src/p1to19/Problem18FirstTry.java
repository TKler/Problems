package p1to19;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Google.
//
//Given an array of integers and a number k, where 1 <= k <= length of the array, compute the maximum values of each subarray of length k.
//
//For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get: [10, 7, 8, 8], since:
//
//    10 = max(10, 5, 2)
//    7 = max(5, 2, 7)
//    8 = max(2, 7, 8)
//    8 = max(7, 8, 7)
//
//Do this in O(n) time and O(k) space. You can modify the input array in-place and you do not need to store the results. You can simply print them out as you compute them.
public class Problem18FirstTry
{
//	@assert array != empty or null
//	@assert subarraySize != 0
	public int[] getMaximumValuesOfSubarrays(int[] array, int subarraySize)
	{
		ArrayList<Integer> result = new ArrayList<Integer>(array.length - subarraySize+1);

		int windowMaxIndex = computeMaxIndex(array, subarraySize, 0);
		
		result.add(array[windowMaxIndex]);
		
		for(int i = 1; i < array.length - subarraySize + 1; i++)
		{
			int newIndex = i+subarraySize-1;
			int newValue = array[newIndex];
			int oldValue = array[windowMaxIndex];
			
			if(newValue >= oldValue)
				windowMaxIndex = newIndex;
			
			if(windowMaxIndex == i-1)
				windowMaxIndex = computeMaxIndex(array, subarraySize, i);
			
			result.add(array[windowMaxIndex]);
		}
		return result.stream().mapToInt(Integer::valueOf).toArray(); 
	}

//	@assert no out of bound
	private int computeMaxIndex(int[] array, int subarraySize, int offSet)
	{
		int windowMaxIndex = offSet;
		for(int i = offSet; i < offSet + subarraySize; i++)
		{
			if(array[i] >= array[windowMaxIndex])
				windowMaxIndex = i;
		}
		return windowMaxIndex;
	}
	// This runs in O(c) space aside from the result structure
	// As time goes, this runs in k steps for the initialization and then every time a new max
	//  has to be calculated in k steps again which ... yeah can happen n-k times if we get a 
	//  inverted array. (And we got n-k loop steps) wonderful so more like k + n-k * n-k. 
	//  thats not in O(n).
	
	@Nested
	public class TestProblem18FirstTry
	{
		@Test
		void test()
		{
			assertArrayEquals(new int[] {10,7,8,8}, getMaximumValuesOfSubarrays
					(new int[]{10, 5, 2, 7, 8, 7}, 3));
		}
	}
}
