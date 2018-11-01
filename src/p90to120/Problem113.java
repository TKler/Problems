package p90to120;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Google.
//
//Given a string of words delimited by spaces, reverse the words in string. For example, given "hello world here", 
//return "here world hello"
//
//Follow-up: given a mutable string representation, can you perform this operation in-place?
public class Problem113
{
//	As to 114, no but that can be changed. you could also use some custom method or lambda instead of isWhitespace for the delimiter detection.

	
//	public String reverseWordOrder(String words)
//	{
//		String result = "";
//		words = " " + words;
//		
//		int index = words.length()-1;
//		while(index >= 0)
//		{
//			int wordEnd = index;
//			
//			while(!Character.isWhitespace(words.charAt(index)))
//				index--;
//			
//			result = result + (words.substring(index, wordEnd+1));
//			
//			index--;
//		}
//		return result.substring(1, result.length());
//	}
//	
	public char[] reverseWordOrderInPlace(char[] words)
	{
		words = inverseArea(words, 0, words.length-1);
		
		int wordStart = 0;
		while(wordStart < words.length)
		{
			int wordEnd = findDelimiter(words, wordStart);
			words = inverseArea(words, wordStart, wordEnd-1);
			wordStart = wordEnd + 1;
		}
		return words;
	}
	
	private int findDelimiter(char[] words, int index)
	{
		while(index < words.length && !Character.isWhitespace(words[index]))
			index++;
		return index;
	}

	private char[] inverseArea(char[] words, int left, int right)
	{
		while(left < right)
		{
			words = swapChars(words, left, right);
			left++;
			right--;
		}
		return words;
	}

	private char[] swapChars(char[] words, int left, int right)
	{
		char b = words[left];
		words[left] = words[right];
		words[right] = b;
		return words;
	}

	@Nested
	class TestProblem113
	{
//		@Test
//		void test()
//		{
//			String input = "hello world here";
//			String output = "here world hello";
//			assertEquals(output, reverseWordOrder(input));
//		}
		
		@Test
		void testInOrder()
		{
			char [] input ="hello world here".toCharArray();
			char[] output = "here world hello".toCharArray();
			assertTrue(Arrays.equals(output, reverseWordOrderInPlace(input)));
		}
	}
}
