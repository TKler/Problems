package p20to40;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Facebook.
//
//You are given an array of non-negative integers that represents a two-dimensional elevation map where each element 
//is unit-width wall and the integer is the height. Suppose it will rain and all spots between two walls get filled up.
//
//Compute how many units of water remain trapped on the map in O(N) time and O(1) space.
//
//For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.
//
//Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index 
//(we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
public class Problem30
{
	public int trappedWater(int[] wall)
	{
		int leftWall = wall[0];
		int leftWallIndex = 0;
		int count = 0;
		for(int i = 1; i < wall.length; i++)
		{
			if(leftWall > wall[i])
				count += leftWall - wall[i];
			else
			{
				leftWall = wall[i];
				leftWallIndex = i;
			}
		}
		
		int rightWall = wall[wall.length-1];
		int overFlow = 0;
		for(int i = wall.length-1; i > leftWallIndex; i--)
		{
			if(rightWall < wall[i])
				rightWall = wall[i];
			
			overFlow = overFlow + leftWall - rightWall;
		}
		
		return count - overFlow;
	}
	
	/*
	 * We have at max O(2n) time with O(5) space, so the requirements are met.
	 */
	
	@Nested
	public class testProblem30
	{
		@Test
		void test1()
		{
			assertEquals(1, trappedWater(new int[] {2, 1, 2}));
		}
		
		@Test
		void rightHigh()
		{
			assertEquals(8, trappedWater(new int[] {3, 0, 1, 3, 0, 5}));
		}
		
		@Test
		void middleHigh()
		{
			assertEquals(8, trappedWater(new int[] {3, 0, 1, 5, 0, 3}));
		}
		
		@Test
		void leftHigh()
		{
			assertEquals(8, trappedWater(new int[] {5, 0, 1, 3, 0, 3}));
		}
		
		@Test
		void leftHighMiddle()
		{
			assertEquals(8, trappedWater(new int[] {5, 0, 4, 2, 0, 3}));
		}
	}
}
