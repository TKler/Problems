package p120to139;
//This problem was asked by Microsoft.
//
//Let's represent an integer in a linked list format by having each node represent a digit in the number. 
//The nodes make up the number in reversed order.
//
//For example, the following linked list:
//
//1 -> 2 -> 3 -> 4 -> 5
//
//is the number 54321.
//
//Given two linked lists in this format, return their sum in the same linked list format.
//
//For example, given
//
//9 -> 9
//
//5 -> 2
//
//return 124 (99 + 25) as:
//
//4 -> 2 -> 1

import java.util.Iterator;
import java.util.LinkedList;

public class Problem127
{
	public LinkedList<Integer> sum(LinkedList<Integer> number1, LinkedList<Integer> number2)
	{
		LinkedList<Integer> sum = new LinkedList<Integer>();
		Iterator<Integer> iter1 = number1.iterator();
		Iterator<Integer> iter2 = number2.iterator();
		int borrow = 0;
		
		for(int i = 0; i < Math.max(number1.size(), number2.size()); i++)
		{
			int result = borrow;
			
			if(iter1.hasNext())
				result += iter1.next();
			if(iter2.hasNext())
				result += iter2.next();
			
			borrow = result / 10;
			sum.add(result % 10);
		}
		
		return sum;
	}
}
