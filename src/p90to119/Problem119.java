package p90to119;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Google.
//
//Given a set of closed intervals, find the smallest set of numbers that covers all the intervals. 
//If there are multiple smallest sets, return any of them.
//
//For example, given the intervals [0, 3], [2, 6], [3, 4], [6, 9], one set of numbers that covers all these intervals is {3, 6}.
public class Problem119
{
	// better with extra class Interval, but then it's hard to construct test cases.
	public int[] getSmallestInterval(int[] intervals)
	{
		boolean hasOverlap = true;
		int[] overlap = new int[] {intervals[0], intervals[1]};
		int leftIntervalBorder = 0, rightIntervalBorder = 0;
		for(int i = 2; i < intervals.length; i = i+2)
		{
			int leftValue = intervals[i];
			int rightValue = intervals[i+1];
			if(hasOverlap)
			{
				overlap[0] = leftValue > overlap[0] ? leftValue : overlap[0];
				overlap[1] = rightValue < overlap[1] ? rightValue : overlap[1];
				if(overlap[0] > overlap[1])
				{
					hasOverlap = false;
					leftIntervalBorder = overlap[1];
					rightIntervalBorder = overlap[0];
				}
			}
			else
			{
				leftIntervalBorder = (rightValue < leftIntervalBorder) ? rightValue : leftIntervalBorder;
				rightIntervalBorder = (leftValue > rightIntervalBorder) ? leftValue : rightIntervalBorder;
			}
		}
		
		if(hasOverlap)
			return new int[] {overlap[0], overlap[0]};
		else
			return new int[] {leftIntervalBorder, rightIntervalBorder};
	}
	
	@Nested
	public class TestProblem119
	{
		@Test
		void expandRightBorder()
		{
			int[] input = new int[] {0,3, 2,6, 3,4, 4,6, 7,9, 3,6};
			int[] output = new int[] {3,7};
			assertArrayEquals(output, getSmallestInterval(input));
		}
		
		@Test
		void expandLeftBorder()
		{
			int[] input = new int[] {0,3, 2,6, 3,4, 0,1, 3,6};
			int[] output = new int[] {1,3};
			assertArrayEquals(output, getSmallestInterval(input));
		}
		
		@Test
		void expandBothBorders()
		{
			int[] input = new int[] {0,3, 2,6, 3,4, 6,9, 0,1, 2,6};
			int[] output = new int[] {1,6};
			assertArrayEquals(output, getSmallestInterval(input));
		}
		
		@Test
		void allIntervalsOverlap()
		{
			int[] input = new int[] {0,3, 2,6, 3,4};
			int[] output = new int[] {3,3};
			assertArrayEquals(output, getSmallestInterval(input));
		}
	}
//	30 minutes | 35 till 100% test cover
}
