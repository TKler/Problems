package problemOneToTwenty;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was recently asked by Google.
//
//Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
//
//For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
//
//Bonus: Can you do this in one pass?
public class Problem1
{
	public boolean doTheyAddUp(int[] candidates, int goalSum)
	{
		HashSet<Integer> possibleValues = new HashSet<Integer>(candidates.length);
		for(int i : candidates)
		{
			if(possibleValues.contains(i))
				return true;
			possibleValues.add(goalSum - i);
		}
		
		return false;
	}
	
	@Nested
	public class TestProblem1
	{
		@Test
		void test()
		{
			assertTrue(doTheyAddUp(new int[]{10, 15, 3, 7}, 17));
		}
	}
}
