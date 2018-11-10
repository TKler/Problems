package p120to139;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Microsoft.
//
//You have 100 fair coins and you flip them all at the same time. Any that come up tails you set aside. 
//The ones that come up heads you flip again. How many rounds do you expect to play before only one coin remains?
//
//Write a function that, given n, returns the number of rounds you'd expect to play until one coin remains.
public class Problem124
{
	//prob one higher since you round down. If the question was about knowing this we can solve this with double
	public int numberOfThrows(int coins)
	{
		int steps = 0;
		while(coins > 1)
		{
			coins = coins/2;
			steps++;
		}
		return steps;
	}
	
	@Nested
	public class TestProblem124
	{
		@Test
		void test()
		{
			assertEquals(6, numberOfThrows(100));
		}
	}

}
