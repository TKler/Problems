package p90to120;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Google.
//
//Given two strings A and B, return whether or not A can be shifted some number of times to get B.
//
//For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.
public class Problem108
{
// ? am I missing something or is this just trivial?
// could also be done with some fun recursion
	public boolean canTheyBeShiftedToMatch(String word1, String word2)
	{
		if(word1 == null || word2 == null || word1.length() != word2.length())
			return false;
		
		int len = word1.length();
		
		if(len == 0)
			return true;
		
		for(int offSet = 0; offSet < len; offSet++)
		{
			for(int index = 0; index < len+1; index++)
			{
				if(index == len)
					return true;
				
				int shiftedIndex = (index + offSet) % len;
				
				if(word1.charAt(index) != word2.charAt(shiftedIndex))
					break;
			}
		}
		return false;
	}
	
	@Nested
	public class TestProblem108
	{
		@Test
		void test1()
		{
			assertTrue(canTheyBeShiftedToMatch("abc", "bca"));
		}
		
		@Test
		void test2()
		{
			assertFalse(canTheyBeShiftedToMatch("acb", "cab"));
		}
		
		@Test
		void test3SpecialCases()
		{
			assertFalse(canTheyBeShiftedToMatch(null, null));
			assertFalse(canTheyBeShiftedToMatch(null, "abc"));
			assertFalse(canTheyBeShiftedToMatch("abc", null));
			assertTrue(canTheyBeShiftedToMatch("", ""));
		}
	}
}
