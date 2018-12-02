package p140to159;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Google.
//
//Given the head of a singly linked list, swap every two nodes and return its head.
//
//For example, given 1 -> 2 -> 3 -> 4, return 2 -> 1 -> 4 -> 3.
public class Problem145<T>
{
	public T swapNodes(LinkedList<T> list)
	{
		for(int i = 0; i/2 < list.size()/2; i = i+2)
		{
			T first = list.get(i);
			list.set(i, list.get(i+1));
			list.set(i+1, first);
		}
		return list.getFirst();
	}
	
	public List<T> getSwappedList(LinkedList<T> list)
	{
		for(int i = 0; (i/2) < (list.size()/2); i = i + 2)
		{
			T first = list.get(i);
			list.set(i, list.get(i+1));
			list.set(i+1, first);
		}
		return list;
	}
	
	@Nested
	public class TestProblem145
	{
		@Test
		public void test()
		{
			Problem145<Integer> test = new Problem145<Integer>();
			LinkedList<Integer> input = new LinkedList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
			Integer output = 2;
			assertEquals(test.swapNodes(input), output);
			LinkedList<Integer> outputList = new LinkedList<Integer>(Arrays.asList(2,1,4,3,6,5,7));
			assertEquals(outputList, input);
		}
	}
}
