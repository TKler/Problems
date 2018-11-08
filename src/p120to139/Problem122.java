package p120to139;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This question was asked by Zillow.
//
//You are given a 2-d matrix where each cell represents number of coins in that 
//cell. Assuming we start at matrix[0][0], and can only move right or down, 
//find the maximum number of coins you can collect by the bottom right corner.
//
//For example, in this matrix
//
//0 3 1 1
//2 0 0 4
//1 5 3 1
//
//The most we can collect is 0 + 2 + 1 + 5 + 3 + 1 = 12 coins.

public class Problem122
{
	public int getMaxCoins(int[][] array)
	{
		return getMaxCoins(array, 0, 0, 0);
	}

	private int getMaxCoins(int[][] array, int posX, int posY, int coinsSoFar)
	{
		coinsSoFar = coinsSoFar+array[posX][posY];
		
		boolean sideMaxReached = (posX == array.length-1);
		boolean bottomMaxReached = (posY == array[posX].length-1);
		
		if(sideMaxReached && bottomMaxReached)
			return coinsSoFar;
		
		else if(sideMaxReached)
			return getMaxCoins(array, posX, posY+1, coinsSoFar);
		
		else if(bottomMaxReached)
			return getMaxCoins(array, posX+1, posY, coinsSoFar);
		
		else
			return Math.max(getMaxCoins(array, posX, posY+1, coinsSoFar), 
					getMaxCoins(array, posX+1, posY, coinsSoFar));
	}
	
	@Nested
	public class TestProblem122
	{
		@Test
		void test()
		{
			int[][] input = {{0, 3, 1, 1}
							,{2, 0, 0, 4}
							,{1, 5, 3, 1}};
			int output = 12;
			assertEquals(output, getMaxCoins(input));
		}
	}
}
