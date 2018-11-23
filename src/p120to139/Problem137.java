package p120to139;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//This problem was asked by Amazon.
//
//Implement a bit array.
//
//A bit array is a space efficient array that holds a value of 1 or 0 at each index.
//
//    init(size): initialize the array with size
//    set(i, val): updates index at i with val where val is either 1 or 0.
//    get(i): gets the value at index i.

//@assert byte has 8 bits
public class Problem137
{
	byte[] _array;
	
	public void init(int size)
	{
		_array = new byte[(size % 8 > 0 ? (size / 8) + 1 : size / 8)];
	}
	
	public void set(int index, boolean value)
	{
		int indexInArray = index/8;
				int indexInByte = index%8;

		if(value)
		{
			_array[indexInArray] |= (byte) Math.pow(2, indexInByte);
		}
		else
		{
			_array[indexInArray] &= ~(byte) Math.pow(2, indexInByte);
		}
	}
	
	public int get(int index)
	{
		byte byt8 = _array[index/8];
		return (byt8 >> (index%8)) & 1;
	}
	
	@Nested
	public class TestProblem137
	{
		@Test
		void testLength1()
		{
			Problem137 input = new Problem137(); 
			input.init(1);
			assertEquals(0, input.get(0));
			input.set(0, true);
			assertEquals(1, input.get(0));
		}
		
		@Test
		void testInit()
		{
			Problem137 input = new Problem137(); 
			input.init(10);
			for(int i = 0; i < 10; i++)
				assertEquals(0, input.get(i));
		}
		
		@Test
		void testLength10()
		{
			Problem137 input = new Problem137(); 
			input.init(10);
			input.set(9, true);
			assertEquals(1, input.get(9));
			for(int i = 0; i < 9; i++)
				assertEquals(0, input.get(i));
			input.set(2, true);
			input.set(4, true);
			assertEquals(1, input.get(2));
			assertEquals(1, input.get(4));
			input.set(2, false);
			assertEquals(0, input.get(2));
			assertEquals(1, input.get(4));
		}
	}
}
