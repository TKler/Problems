package problemOneToTwenty;

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
public class Problem18SecondTry
{
//	IDea, sorted linkedlist like structure. add at the smaller elements, throw everything with low index or to low value out.
//	this might end up amortising itself.
//	think about
//	insert is either end in O(1) or at the beginning, meaning iteration over all elements but also reseting since we delete all others so max O(n) 
//	which only happens when we get O(1) cases before. average cases: for each step we take deeper into the list we also prune the list by the number of steps.
//	this means we gain future runtime for each step and are in O(2n).
//	As for getting the max, this is now easy, just take the first, check index take the next first.
//	So idealy O(n) operations, if it is not ideal we end up with 2n operations, but again we prune the list and thus make insert easier.
//	we should end up with something between insert in 2n or getMax in 2n, but not both. Running in O(3n) amortised (which is luckily a word in english too :D).
//	Space is also in O(k)? but worst in O(n), but averge should average out.
	
//	
//	
////	@assert array != empty or null
////	@assert subarraySize != 0
	public int[] getMaximumValuesOfSubarrays(int[] array, int subarraySize)
	{
		ArrayList<Integer> result = new ArrayList<Integer>(array.length - subarraySize+1);
//
//		int windowMaxIndex = computeMaxIndex(array, subarraySize, 0);
//		
//		result.add(array[windowMaxIndex]);
//		
//		for(int i = 1; i < array.length - subarraySize + 1; i++)
//		{
//			int newIndex = i+subarraySize-1;
//			int newValue = array[newIndex];
//			int oldValue = array[windowMaxIndex];
//			
//			if(newValue >= oldValue)
//				windowMaxIndex = newIndex;
//			
//			if(windowMaxIndex == i-1)
//				windowMaxIndex = computeMaxIndex(array, subarraySize, i);
//			
//			result.add(array[windowMaxIndex]);
//		}
		return result.stream().mapToInt(Integer::valueOf).toArray(); 
	}
//
////	@assert no out of bound
//	private int computeMaxIndex(int[] array, int subarraySize, int offSet)
//	{
//		int windowMaxIndex = offSet;
//		for(int i = offSet; i < offSet + subarraySize; i++)
//		{
//			if(array[i] >= array[windowMaxIndex])
//				windowMaxIndex = i;
//		}
//		return windowMaxIndex;
//	}
	
	
	@Nested
	public class TestProblem18SecondTry
	{
		@Test
		void test()
		{
			assertArrayEquals(new int[] {10,7,8,8}, getMaximumValuesOfSubarrays
					(new int[]{10, 5, 2, 7, 8, 7}, 3));
		}
	}
}
