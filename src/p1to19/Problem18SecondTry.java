package p1to19;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.LinkedList;

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
//	Idea, sorted linkedlist like structure. add at the smaller elements, throw everything with low index or to low value out.
//	this might end up amortising itself.
//	think about
//	insert is either end in O(1) or at the beginning, meaning iteration over all elements but also reseting since we delete all others so max O(n) 
//	which only happens when we get O(1) cases before. average cases: for each step we take deeper into the list we also prune the list by the number of steps.
//	this means we gain future runtime for each step and are in O(2n).
//	As for getting the max, this is now easy, just take the first, check index take the next first.
//	So idealy O(n) operations, if it is not ideal we end up with 2n operations, but again we prune the list and thus make insert easier.
//	we should end up with something between insert in 2n or getMax in 2n, but not both. Running in O(3n) amortised 
//	(which is, luckily, a word in english too :D).
//	Space is also in O(k)? but worst in O(n), but average should average out.	
//	
//	Actually do we run in O(2n)? we insert each element once and we take it out once, hm not sure how placement factors in, too tired

	
//	@assert array != empty or null
//	@assert subarraySize != 0
	public int[] getMaximumValuesOfSubarrays(int[] array, int subarraySize)
	{
		ArrayList<Integer> result = new ArrayList<Integer>(array.length - subarraySize+1);

		LinkedList<Node> list = new LinkedList<Node>();
		
		for(int i = 0; i < subarraySize; i++)
		{
			insertIntoList(list, 0, new Node(i, array[i]));
		}
		result.add(getMaxFromList(list, 0));
		
		for(int lowestIndex = 1; lowestIndex < array.length-subarraySize+1; lowestIndex++)
		{
			int newIndex = lowestIndex+subarraySize-1;
			insertIntoList(list, lowestIndex, new Node(newIndex, array[newIndex]));
			result.add(getMaxFromList(list, lowestIndex));
		}
		return result.stream().mapToInt(Integer::valueOf).toArray(); 
	}
	
	private Integer getMaxFromList(LinkedList<Node> list, int lowestValidIndex)
	{
		while(list.peekFirst().getIndexInArray() < lowestValidIndex)
			list.removeFirst();
		
		return list.peekFirst().getValue();
	}

	private void insertIntoList(LinkedList<Node> list, int lowestValidIndex, Node node)
	{
		while(!list.isEmpty() && (list.peekLast().getIndexInArray() < lowestValidIndex || node.getValue() >= list.peekLast().getValue()))
			list.removeLast();
		
		list.addLast(node);
	}

	public class Node
	{
		int _value,_indexInArray;
		public Node(int indexFoundIn, int value)
		{
			_indexInArray = indexFoundIn;
			_value = value;
		}
		public int getValue()
		{return _value;}
		public int getIndexInArray()
		{return _indexInArray;}
	}
	
	@Nested
	public class TestProblem18SecondTry
	{
		@Test
		void test()
		{
			int[] inputArray = new int[]{10, 5, 2, 7, 8, 7};
			int[] output = new int[] {10,7,8,8};
			assertArrayEquals(output, 
					getMaximumValuesOfSubarrays(inputArray, 3));
		}
		
		@Test
		void testDecreasingArray()
		{
			int[] inputArray = new int[]{10, 9, 8, 7, 6, 5};
			int[] output = new int[] {10,9,8,7};
			assertArrayEquals(output, 
					getMaximumValuesOfSubarrays(inputArray, 3));
		}
		
		@Test
		void testIncreasingArray()
		{
			int[] inputArray = new int[]{5,6,7,8,9,10};
			int[] output = new int[] {7,8,9,10};
			assertArrayEquals(output, 
					getMaximumValuesOfSubarrays(inputArray, 3));
		}
	}
}
