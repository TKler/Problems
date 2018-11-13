package p120to139;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Stack;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Facebook.
//
//Write a function that rotates a list by k elements. For example, [1, 2, 3, 4, 5, 6] rotated by two becomes [3, 4, 5, 6, 1, 2]. 
//Try solving this without creating a copy of the list. How many swap or move operations do you need?
public class Problem126
{
	// easy of linked list obviously
	// doing this on an array instead, can do the same with lists with slightly altered syntax, but this feel cleaner and harder.
	// In place possible with n steps	
	public Object[] rotateList(Object[] array, int rotateBy)
	{
		int length = array.length;
		if(array == null || length <= 1)
			return array;
		
		rotateBy = rotateBy % length;
		
		if(rotateBy == 0)
			return array;
		
		Stack<Integer> startIndizies = new Stack<Integer>();
		for(int i = rotateBy-1; i >= 0; i--)
			startIndizies.push(i);
		
		while(!startIndizies.isEmpty())
		{
			int startIndex = startIndizies.pop();
			Object oldSwap = array[startIndex];
			Object newSwap;
			int currentIndex = startIndex;
			int nextIndex;
			boolean notGoingInCircles = true;
			
			do 
			{
				nextIndex = currentIndex + rotateBy;
				if(nextIndex >= length)
				{
					nextIndex -= length;
					if(startIndizies.contains(nextIndex))
						startIndizies.remove((Object) nextIndex);
					else
						notGoingInCircles = false;
				}
				newSwap = array[nextIndex];
				array[nextIndex] = oldSwap;
				oldSwap = newSwap;
				currentIndex = nextIndex;
			}while(notGoingInCircles);
		}
		return array;
	}
	
	@Nested
	public class testProblem126
	{
		@Test
		void test()
		{
			Object[] input = {1,2,3,4,5,6};
			Object[] output = {5,6,1,2,3,4};
			assertArrayEquals(output, rotateList(input, 2));
		}
		@Test
		void test2()
		{
			Object[] input = {1,2,3,4,5,6};
			Object[] output = {5,6,1,2,3,4};
			assertArrayEquals(output, rotateList(input, 8));
		}
		@Test
		void test3()
		{
			Object[] input = {1,2,3,4,5};
			Object[] output = {3,4,5,1,2};
			assertArrayEquals(output, rotateList(input, 3));
		}
	}
}
