import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Pinterest.
//
//Given an integer list where each number represents the number of hops you can make, determine whether you can reach to the last index starting at index 0.
//
//For example, [2, 0, 1, 0] returns true while [1, 1, 0, 1] returns false.

public class Problem106
{
	public boolean hopToTheEnd(int[] hops)
	{
		if(hops == null || hops.length == 0 || hops.length == 1)
			return false;

		return step(hops, 0);
	}

	private boolean step(int[] hops, int index)
	{
		if(index == hops.length-1)
			return true;
		
		if(index < 0 || index > hops.length-1 || hops[index] == 0)
			return false;
		
		int hopLength = hops[index];
		hops[index] = 0;
		
		return step(hops, index - hopLength) 
				|| step(hops, index + hopLength);
	}
	
	@Nested
	public class TestProblem98 extends TestCase
	{

		private int[] succes1, failSimple, fail1, succesSimple, succesComplex;

		@BeforeEach
		public void setUp()
		{
			this.failSimple = new int[]{0, 0};
			this.succesSimple = new int[]{1, 1};
			this.succes1 = new int[]{2, 0, 1, 0};
			this.fail1 = new int[]{1, 1, 0, 1};
			this.succesComplex = new int[] {2,5,1,1,1,0,1};
		}

		@Test void test1() {assertFalse(hopToTheEnd(failSimple));}
		@Test void test2() {assertTrue(hopToTheEnd(succesSimple));}
		@Test void test3() {assertFalse(hopToTheEnd(fail1));}
		@Test void test4() {assertTrue(hopToTheEnd(succes1));}
		@Test void test5() {assertTrue(hopToTheEnd(succesComplex));}
	}

}
