package p120to139;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Google.
//
//Find the minimum number of coins required to make n cents.
//
//You can use standard American denominations, that is, 1¢, 5¢, 10¢, and 25¢.
//
//For example, given n = 16, return 3 since we can make it with a 10¢, a 5¢, and a 1¢.
public class Problem138
{
	int[] coins = {25,10,5,1}; // coins have to be in order
	public int getNumberOfCoins(int sum)
	{
		int result = 0;
		for(int coin : coins)
		{
			result += sum / coin;
			sum %= coin;
			//we could also do a break if sum == 0;
		}
		return result;
	}
	
	@Nested
	public class TestProblem138
	{
		@Test
		void test()
		{
			int input = 16;
			int output = 3;
			assertEquals(output, getNumberOfCoins(input));
		}
	}
}
