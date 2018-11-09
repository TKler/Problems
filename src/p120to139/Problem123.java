package p120to139;
//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by LinkedIn.
//
//Given a string, return whether it represents a number. 
//Here are the different kinds of numbers:
//
//    "10", a positive integer
//    "-10", a negative integer
//    "10.1", a positive real number
//    "-10.1", a negative real number
//    "1e5", a number in scientific notation
//
//And here are examples of non-numbers:
//
//    "a"
//    "x 1"
//    "a -2"
//    "-"

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.Set;
import java.util.TreeSet;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class Problem123
{
	public boolean isANumber(String number)
	{
		Set<Character> possibleNonDigits = createSet();
		boolean nextNeedsToBeDigit = false;
		boolean nextCanBeMinus = true;
		int index = 0;
			
		
		while(index < number.length())
		{
			char readSymbol = number.charAt(index);
			boolean isDigit = Character.isDigit(readSymbol);
			if(!isDigit)
			{
				if(nextCanBeMinus && readSymbol == '-')
				{
					nextNeedsToBeDigit = true;
					nextCanBeMinus = false;
				}
				else if(nextNeedsToBeDigit)
					return false;
				else if(possibleNonDigits.contains(readSymbol))
				{
					if(readSymbol == 'e')
					{
						possibleNonDigits.add('.');
						nextCanBeMinus = true;
					}
					possibleNonDigits.remove(readSymbol);
					nextNeedsToBeDigit = true;
				}
				else
					return false;
			}
			else
			{
				nextCanBeMinus = false;
				nextNeedsToBeDigit = false;
			}
			index++;
		}
		
		return !nextNeedsToBeDigit;
	}
	
	private Set<Character> createSet()
	{
		Set<Character> list = new TreeSet<Character>();
		list.add('-');
		list.add('.');
		list.add('e');
		return list;
	}

	@Nested
	public class TestProbl123
	{
		@Test
		void testSimpleCases()
		{
			assertTrue(isANumber("10"));
			assertTrue(isANumber("-10"));
			assertTrue(isANumber("10.1"));
			assertTrue(isANumber("-10.1"));
			assertTrue(isANumber("1e5"));
			
			
			assertFalse(isANumber("a"));
			assertFalse(isANumber("1 x"));
			assertFalse(isANumber("-"));
			assertFalse(isANumber("-e"));
		}
		
		@Test
		void testComplextCases()
		{
			assertTrue(isANumber("1.2e10"));
			assertTrue(isANumber("-1.2e10"));
			assertTrue(isANumber("-1.2e-1.0"));
			
			assertFalse(isANumber("-1.e-1.0"));
			assertFalse(isANumber("-1.0e-.0"));
			assertFalse(isANumber("-1.0e-1.0.1"));
		}
	}
}
