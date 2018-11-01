package p90to120;

import static org.junit.Assert.assertEquals;
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
	public String reverseWordOrder(String words)
	{
		String result = "";
		words = " " + words;
		
		int index = words.length()-1;
		while(index >= 0)
		{
			int wordEnd = index;
			
			while(!Character.isWhitespace(words.charAt(index)))
				index--;
			
			result = result + (words.substring(index, wordEnd+1));
			
			index--;
		}
		return result.substring(1, result.length());
	}
	
//	Can be done in place, but sure is much more work if you really want to do it with only indicies and space efficient. 
//	Otherwise you can identify and "safe" the last word and cut it to the front of the word, hopefully you got something like a List data structure and remove it at the end.
	
//	As to 114, no but that can be changed. you could also use some custom method or lambda instead of isWhitespace for the delimiter detection.
	
	@Nested
	class TestProblem113
	{
		@Test
		void test()
		{
			String input = "hello world here";
			String output = "here world hello";
			assertEquals(output, reverseWordOrder(input));
		}
	}
}
