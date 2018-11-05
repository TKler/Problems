package p1to19;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Amazon.
//
//Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.
//
//For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb".
public class Problem13
{
	public int getLengthofLongestSubstringWithDistinctChars(String word, int distinctChars)
	{
		int max = 0;
		Map<Character, Integer> charCount = new HashMap<Character, Integer>(distinctChars);
		int startIndex = 0;
		int endIndex = 0;
		
		while(endIndex < word.length()-1)
		{
			while(endIndex < word.length()-1 && charCount.size() <= distinctChars)
			{
				charCount.merge(word.charAt(endIndex), 1, (a,b) -> a + b);
				endIndex++;
			}
			
			max = Math.max(max, endIndex - startIndex +1 -1); // both index are on point so +1, but -1 since we count one char too many
			
			while(charCount.size() > distinctChars)
			{
				Character charAtStart = word.charAt(startIndex);
				if(charCount.get(charAtStart) > 1)
					charCount.merge(charAtStart, -1, (a,b) -> a + b);
				else
					charCount.remove(charAtStart);
				
				startIndex++;
			}
		}
		
		return max;
	}
	
	@Nested
	public class TestProblem13
	{
		@Test
		void test()
		{
			int inputInt = 2;
			String inputWord = "abcba";
			int output = 3;
			assertEquals(output, getLengthofLongestSubstringWithDistinctChars(inputWord, inputInt));
		}
		@Test
		void test2()
		{
			int inputInt = 2;
			String inputWord = "abcb";
			int output = 3;
			assertEquals(output, getLengthofLongestSubstringWithDistinctChars(inputWord, inputInt));
		}
		@Test
		void test3()
		{
			int inputInt = 2;
			String inputWord = "abcbcbaaaaaacbcabcaccccccccccc";
			int output = 12;
			assertEquals(output, getLengthofLongestSubstringWithDistinctChars(inputWord, inputInt));
		}
	}
}
