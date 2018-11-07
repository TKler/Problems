package p120to139;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Google.
//
//Given a string which we can delete at most k, return whether you can make a palindrome.
//
//For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
public class Problem121
{
	public boolean canWeMakeAPalindrome(String word, int deletions)
	{
		return canWeMakeAPalindrome(word, 0, word.length()-1, deletions);
	}

	private boolean canWeMakeAPalindrome(String word, int left, int right, int deletions)
	{
		while(left < right)
		{
			if(! (word.charAt(left) == word.charAt(right)) )
			{
				if(deletions == 0)
					return false;
				else
				{
					return (canWeMakeAPalindrome(removeCharAt(word, left), left, right-1, deletions-1) ||
							canWeMakeAPalindrome(removeCharAt(word, right), left, right-1, deletions-1) );
				}
			}
			left++;
			right--;
		}
		
		return true;
	}
	
	private String removeCharAt(String word, int indexToDelete)
	{
		if(indexToDelete == 0)
			return word.substring(1);
		else if(indexToDelete == word.length()-1)
		{
			return word.substring(0, indexToDelete);
		}
		else
			return word.substring(0, indexToDelete) + word.substring(indexToDelete+1);
	}

	@Nested
	public class TestProblem121
	{
		@Test
		void test()
		{
			String inputString = "waterrfetawx";
			int deletions = 2;
			boolean output = true;
			assertEquals(output, canWeMakeAPalindrome(inputString, deletions));
		}
		
		@Test
		void testSimplePositiv()
		{
			String inputString = "waterretaw";
			int deletions = 2;
			boolean output = true;
			assertEquals(output, canWeMakeAPalindrome(inputString, deletions));
		}
		@Test
		void testOneDeletion()
		{
			String inputString = "waterretaxw";
			int deletions = 1;
			boolean output = true;
			assertEquals(output, canWeMakeAPalindrome(inputString, deletions));
		}
		
		@Test 
		void testRemoveCharAt()
		{
			assertEquals("tet", removeCharAt("test", 2));
			assertEquals("tes", removeCharAt("test", 3));
			assertEquals("est", removeCharAt("test", 0));
		}
	}
	// 15 till "correct" 25 till bug fixed cause idiot :D
}
