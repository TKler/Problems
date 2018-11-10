package p40to59;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Google.
//
//Given a list of integers S and a target number k, write a function that returns a subset of S that adds up to k. 
//If such a subset cannot be made, then return null.
//
//Integers can appear more than once in the list. You may assume all numbers in the list are positive.
//
//For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] since it sums up to 24.
public class Problem42
{
	List<Integer> _takenNumbers; 
	
	public List<Integer> getSubset(List<Integer> availableNumbers, int goal)
	{
		List<Integer> list = new ArrayList<Integer>();
		
		takeOrNotTakeNextNumber(availableNumbers, goal, 0, list, 0);
		
		return _takenNumbers;
	}
	
	private boolean takeOrNotTakeNextNumber(List<Integer> availableNumbers, int goal, int index, List<Integer> takenNumbers, int sum)
	{
		int curNumber = availableNumbers.get(index);
		
		if(sum + curNumber == goal)
		{
			takenNumbers.add(curNumber);
			_takenNumbers = takenNumbers;
			return true;
		}
		else if(index == availableNumbers.size()-1)
			return false;
		else if(sum + curNumber < goal)
		{
			List<Integer> takenNumberPlus = new ArrayList<Integer>();
			takenNumberPlus.addAll(takenNumbers);
			takenNumberPlus.add(curNumber);
			return (takeOrNotTakeNextNumber(availableNumbers, goal, index+1, takenNumberPlus, sum + curNumber) 
					|| takeOrNotTakeNextNumber(availableNumbers, goal, index+1, takenNumbers, sum) );
		}
		else
		{
			return takeOrNotTakeNextNumber(availableNumbers, goal, index+1, takenNumbers, sum);
		}
	}
	
	@Nested
	public class TestProblem42
	{
		@Test
		void test()
		{
			List<Integer> input = Arrays.asList(12, 1, 61, 5, 9, 2);
			List<Integer> output = Arrays.asList(12,9,2,1);
			assertTrue(output.containsAll(getSubset(input, 24)) && getSubset(input, 24).containsAll(output));
					
		}
	}
}
