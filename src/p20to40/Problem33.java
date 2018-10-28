package p20to40;
//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Microsoft.
//
//Compute the running median of a sequence of numbers. 
//That is, given a stream of numbers, print out the median of the list so far on each new element.
//
//Recall that the median of an even-numbered list is the average of the two middle numbers.
//
//For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
//
//2
//1.5
//2
//3.5
//2
//2
//2

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Problem33
{
	public List<Double> printMedian(IntStream stream)
	{
		List<Double> result = new ArrayList<Double>();
		PriorityQueue<Integer> leftMaxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
		PriorityQueue<Integer> rightMinHeap = new PriorityQueue<Integer>();
		Iterator<Integer> iter = stream.iterator();

		if(!iter.hasNext())
			return result;
//		init the left heap so we can peek it
		leftMaxHeap.add(iter.next());
		result.add((double)leftMaxHeap.peek());
		while(iter.hasNext())
		{
//			add next element
			int value = iter.next();
			if(leftMaxHeap.peek() > value)
				leftMaxHeap.add(value);
			else
				rightMinHeap.add(value);
			
//			balance heaps
			if(Math.abs(leftMaxHeap.size()-rightMinHeap.size()) > 1 )
			{
				if(leftMaxHeap.size() > rightMinHeap.size())
					rightMinHeap.add(leftMaxHeap.poll());
				else
					leftMaxHeap.add(rightMinHeap.poll());
			}
			assert(Math.abs(leftMaxHeap.size()-rightMinHeap.size()) < 2);
			
//			safeResult    right.peek() is not called unless it is not empty!
			if(leftMaxHeap.size() == rightMinHeap.size())
				result.add((((double)(rightMinHeap.peek() + leftMaxHeap.peek()))/2));
			else
			{
				if(leftMaxHeap.size() > rightMinHeap.size())
					result.add((double)leftMaxHeap.peek());
				else
					result.add((double)rightMinHeap.peek());
			}
		}
		return result;
	}
	
	@Nested
	public class TestProblem33
	{
		@Test
		void test()
		{
			IntStream input = Arrays.stream(new int[] {2, 1, 5, 7, 2, 0, 5});
			Double[] array = new Double[] {2.0 ,1.5 ,2.0 ,3.5 ,2.0, 2.0, 2.0};
			List<Double> output = Arrays.asList(array);
			
			assertEquals(output, printMedian(input));
		}
	}
}
