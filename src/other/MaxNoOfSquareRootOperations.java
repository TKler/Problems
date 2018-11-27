package other;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class MaxNoOfSquareRootOperations
{
	public int getMaxNumberOfConsecutiveSquarerootOps(int start, int end)
	{
		int depth = 0;
		
		while(start <= end)
		{
			start = (int) Math.ceil(Math.sqrt(start));
			end = (int) Math.floor(Math.sqrt(end));
			if(start <= end)
				depth++;
		}
		
		return depth;
	}
	
	@Nested
	public class TestMaxNoOfSquareOperations
	{
		@Test
		void test()
		{
			assertEquals(2, getMaxNumberOfConsecutiveSquarerootOps(2, 16));
			assertEquals(2, getMaxNumberOfConsecutiveSquarerootOps(3, 17));
			assertEquals(3, getMaxNumberOfConsecutiveSquarerootOps(7, 16*16));
			assertEquals(4, getMaxNumberOfConsecutiveSquarerootOps(19, 16*16*16*16+5));
			assertEquals(0, getMaxNumberOfConsecutiveSquarerootOps(6, 7));
			assertEquals(0, getMaxNumberOfConsecutiveSquarerootOps(7, 7));
			assertEquals(1, getMaxNumberOfConsecutiveSquarerootOps(9, 9));
		}
	}
}
