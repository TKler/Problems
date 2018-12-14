package p140to159;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Amazon.
//
//Given a string, determine whether any permutation of it is a palindrome.
//
//For example, carrace should return true, since it can be rearranged to form 
//racecar, which is a palindrome. daily should return false, since there's no 
//rearrangement that can form a palindrome.
public class Problem157
{
	// string is all lowerCase
	public boolean possiblePalindrome(String word)
	{
		assert(word != null && word.length() != 0);
		
		int[] array = new int[26];
		for(int i = 0; i < word.length(); i++)
		{
			int arrayPosition = word.charAt(i)-'a';
			assert(arrayPosition >= 0 && arrayPosition < 26);
			array[arrayPosition]++;
		}
		
		boolean uneven = false;
		boolean result = true;
		for(int i : array)
		{
			if(i % 2 == 1)
			{
				if(uneven)
					result = false;
				else
					uneven = true;
			}
		}
		
		return result;
	}
	
	@Nested
	public class TestProblem157
	{
		@Test
		void test()
		{
			assertTrue(possiblePalindrome("hheello"));
			assertTrue(possiblePalindrome("racecar"));
			assertTrue(possiblePalindrome("carrace"));
			assertFalse(possiblePalindrome("hhello"));
		}
	}
}
