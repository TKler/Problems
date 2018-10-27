package p20to40;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Amazon.
//
//Run-length encoding is a fast and simple method of encoding strings. 
//The basic idea is to represent repeated successive characters as a single 
//count and character. For example, the string "AAAABBBCCDAA" would be encoded as "4A3B2C1D2A".
//
//Implement run-length encoding and decoding. You can assume the string to 
//be encoded have no digits and consists solely of alphabetic characters. 
//You can assume the string to be decoded is valid.
public class Problem29
{
	public String encoding(String toEncode)
	{
		String result = "";
		int index = 0;
		while(index < toEncode.length())
		{
			char c = toEncode.charAt(index);
			int counter = 0;
			while(index < toEncode.length() && c == toEncode.charAt(index))
			{
				counter++;
				index++;
			}
			result = result + counter + c;
		}
		return result;
	}
	
	public String decoding(String toDecode)
	{
		String result = "";
		int index = 0;
		while(index < toDecode.length())
		{
			char c = toDecode.charAt(index+1);
			int count = toDecode.charAt(index) - '0';
			while(count > 0)
			{
				result = result + c;
				count--;
			}
			index += 2;
		}
		return result;
	}
	
	@Nested
	public class testProblem29
	{
		@Test
		void testEncode()
		{
			assertEquals(encoding("AAAABBBCCDAA"), "4A3B2C1D2A");
		}
		@Test
		void testDecode()
		{
			assertEquals("AAAABBBCCDAA", decoding("4A3B2C1D2A"));
		}
	}
}
