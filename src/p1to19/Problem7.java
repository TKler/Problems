package p1to19;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Facebook.
//
//Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
//
//For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
//
//You can assume that the messages are decodable. For example, '001' is not allowed.
public class Problem7
{
//	@assert message is decodable iE no 0 or non digit chars
//	@assert decoding is as above
	public int numberOfWaysToDecode(String encodedWord)
	{
		return step(encodedWord);
	}

	private int step(String encodedWord)
	{
		int len = encodedWord.length();
		if(len <= 1)
			return 1;
		
		char c = encodedWord.charAt(encodedWord.length()-1);
		char c2= encodedWord.charAt(encodedWord.length()-2);
		int number =  (c2 - '0') * 10 +  (c - '0');
		int count = 0;
		
		count += step(encodedWord.substring(0, len-1));
		if(number < 27)
			count += step(encodedWord.substring(0, len-2));
		
		return count;
	}
	
	
	@Nested
	public class testProblem7
	{
		@Test
		void test()
		{
			assertEquals(3, numberOfWaysToDecode("111"));
		}
		
		@Test
		void test2()
		{
			assertEquals(5, numberOfWaysToDecode("1121"));
		}
		
		@Test
		void test3()
		{
			assertEquals(1, numberOfWaysToDecode("4444444"));
		}
		
		@Test
		void test4()
		{
			assertEquals(5, numberOfWaysToDecode("122281"));
		}
	}
}
