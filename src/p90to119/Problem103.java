package p90to119;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.Map;





//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Square.
//
//Given a string and a set of characters, return the shortest substring containing all the characters in the set.
//
//For example, given the string "figehaeci" and the set of characters {a, e, i}, you should return "aeci".
//
//If there is no substring containing all the characters in the set, return null.
public class Problem103
{	
//  @assert string != null or ""
//	@assert atleast one of the chars in array exists in the string
//	@assert array != empty or the empty array
//  @assert array is a set   not sure if needed but seems reasonable
	char[] _array;
	String _string;
	Map<Character, Integer> _map;
	Window _currentSmallestWindow = new Window(0, Integer.MAX_VALUE);
	
	public String getSubStringWithOccurences(char[] array, String str)
	{
		
		_array = array;
		_string = pruneString(str);
		_map = new HashMap<Character, Integer>();
		
		
		int leftIndex = 0;
		int rightIndex = 0;
		boolean flagEndNotReached = true;
		
		while(flagEndNotReached)
		{
			//expand right side
			while(notAllCharsHaveOccured())
			{
				if(arrayContains(_string.charAt(rightIndex)))
					_map.merge(_string.charAt(rightIndex), 1, Integer::sum);
				rightIndex++;
				if(rightIndex == _string.length())
				{
					flagEndNotReached = false;
					if(notAllCharsHaveOccured())
						return smallestWindow();
				}
			}
			
			// collapse left side
			while(allCharsHaveOccured())
			{
				if(arrayContains(_string.charAt(leftIndex)))
					decreaseOrRemoveMapEntry(_string.charAt(leftIndex), -1);
				leftIndex++;
			}
			noteWindow(leftIndex-1, rightIndex);
		}	
		
		return smallestWindow();
	}

	private boolean allCharsHaveOccured()
	{
		return _map.size() == _array.length;
	}


	private boolean notAllCharsHaveOccured()
	{
		return _map.size() < _array.length;
	}

	private void decreaseOrRemoveMapEntry(char charAt, int i)
	{
		_map.merge(charAt, i, Integer::sum);
		_map.remove(charAt, 0);
	}


	private String smallestWindow()
	{
		if(_currentSmallestWindow.getRight() == Integer.MAX_VALUE)
			return null;
		else
			return _string.substring(_currentSmallestWindow.getLeft(), _currentSmallestWindow.getRight());
	}


	private void noteWindow(int leftIndex, int rightIndex)
	{
		if((rightIndex - leftIndex) < _currentSmallestWindow.getSize())
			_currentSmallestWindow = new Window(leftIndex, rightIndex);
	}

	private boolean arrayContains(char charAt)
	{
		for(char c : _array)
			if(c == charAt)
				return true;
		return false;
	}

	private String pruneString(String str)
	{
		int indexLeft = 0;
		while(!arrayContains(str.charAt(indexLeft))) 
			indexLeft++;
		
		if(str.isEmpty())
			return "";
	
		int indexRight = str.length()-1;
		while(!arrayContains(str.charAt(indexRight)))
			indexRight--;
		
		return str.substring(indexLeft, indexRight+1);
	}

	public class Window
	{
		int _leftIndex, _rightIndex, _size;
		public Window(int left, int right)
		{
			_leftIndex = left;
			_rightIndex = right;
			_size = _rightIndex - _leftIndex;
		}
		public int getLeft() {return _leftIndex;}
		public int getRight() {return _rightIndex;}
		public int getSize() {return _size;}
	}

	@Test 
	void testProblem1031()
	{
		char[] array = {'a', 'e', 'i'};
		String str = "figehaeci";
		
		assertEquals("aeci", getSubStringWithOccurences(array, str));
	}
	@Test 
	void testProblem1032() 	
	{
		char[] array = {'a', 'b', 'c'};
		String str = "aaaaaaceeeeeeeeeeeeb";
		
		assertEquals("aceeeeeeeeeeeeb", getSubStringWithOccurences(array, str));
	}
	@Test 
	void testProblem1033() 	
	{
		char[] array = {'A', 'B', 'C'};
		String str = "AerererererCefdfdfdfdfdfdfB";
		
		assertEquals(str, getSubStringWithOccurences(array, str));
	}
	@Test 
	void testProblem1034() 	
	{
		char[] array = {'A'};
		String str = "BBBBACCC";
		
		assertEquals("A", getSubStringWithOccurences(array, str));
	}
	@Test 
	void testProblem1035() 	
	{
		char[] array = {'A', 'D'};
		String str = "BBBBACCC";
		
		assertEquals(null, getSubStringWithOccurences(array, str));
	}
}
