package p90to120;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Google.
//
//You are in an infinite 2D grid where you can move in any of the 8 directions:
//
// (x,y) to
//    (x+1, y),
//    (x - 1, y),
//    (x, y+1),
//    (x, y-1),
//    (x-1, y-1),
//    (x+1,y+1),
//    (x-1,y+1),
//    (x+1,y-1)
//
//You are given a sequence of points and the order in which you need to cover the points. Give the minimum number of steps in which you can achieve it. You start from the first point.
//
//Example:
//
//Input: [(0, 0), (1, 1), (1, 2)]
//Output: 2
//
//It takes 1 step to move from (0, 0) to (1, 1). It takes one more step to move from (1, 1) to (1, 2).
public class Problem100
{
	public int numberOfStepsToReachAllPoints(Point[] array)
	{
		int numberOfSteps = 0;
		for(int i = 0; i < array.length-1; i++)
		{
			numberOfSteps += stepsToNextPoint(array[i], array[i+1]);
		}
		
		return numberOfSteps;
	}
	
	private int stepsToNextPoint(Point start, Point end)
	{
		return Math.max(getDistanceBetween(start.getX(), end.getX()), 
						getDistanceBetween(end.getY(), start.getY()) );
	}
	
	private int getDistanceBetween(int a, int b)
	{
		return Math.abs(a - b);
	}
	
	public class Point
	{
		public int x;
		public int y;

		public Point(int x, int y)
		{
			this.x = x;
			this.y = y;
		}
		public int getX() {return this.x;}
		public int getY() {return this.y;}
	}
	
	@Test
	void testProblem100()
	{
		Point[] array1 = {new Point(0,0), new Point(1,1), new Point(2,2)};
		Point[] array2 = {new Point(1,5), new Point(1,6), new Point(-2,-3)}; 
		Point[] array3 = {new Point(1,5), new Point(1,6), new Point(-2,-3), new Point(2, -5)}; 
		
		assertEquals( 2, numberOfStepsToReachAllPoints(array1));
		assertEquals(10, numberOfStepsToReachAllPoints(array2));
		assertEquals(14, numberOfStepsToReachAllPoints(array3));
	}
	
	
}
