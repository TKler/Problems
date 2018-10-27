package p90to120;
import java.util.Iterator;
import java.util.LinkedList;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Google.
//
//Determine whether a doubly linked list is a palindrome. What if it’s singly linked?
//
//For example, 1 -> 4 -> 3 -> 4 -> 1 returns true while 1 -> 4 returns false.
public class Problem104
{
	public boolean isPalindromeDLL(LinkedList<Integer> list)
	{
		Iterator<Integer> leftIter = list.listIterator();
		Iterator<Integer> rightIter = list.descendingIterator();
		
		for(int i = 0; i < list.size()/2; i++) // might need to be a big bigger, not entirely sure right now
		{
			if(! leftIter.next().equals(rightIter.next()))
				return false;
		}
		return true;
	}
	
	// If it is a single liked list, have fun. Your data structure was not made for this -.-
	// Either build a DLL and do the above
	// Use a stack at n space cost and 2n time
	// Or invert the latter half of the list for 1 space cost and n time, and then move outwards from there instead of inwards
}
