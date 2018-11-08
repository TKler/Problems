package p20to39;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Google.
//
//The power set of a set is the set of all its subsets. Write a function that, given a set, 
//generates its power set.
//
//For example, given the set {1, 2, 3}, it should return 
//{{}, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
//
//You may also use a list or array to represent a set.
public class Problem37
{
	
	public List<List<Integer>> getPowerSet(int[] array)
	{
		List<List<Integer>> powerSet = new ArrayList<List<Integer>>();
		powerSet.add(new ArrayList<Integer>());
		
		for(int i : array)
		{
			int len = powerSet.size();
			for(int j = 0; j < len; j++)
			{
				List<Integer> newList= new ArrayList<Integer>(powerSet.get(j));
				newList.add(i);
				powerSet.add(newList);
			}
		}
		return powerSet;
	}
	
	@Nested
	public class TestProblem37
	{
		@Test
		void test()
		{
			int[] input = new int[] {1,2,3};
			String output = "[[], [1], [2], [1, 2], [3], [1, 3], [2, 3], [1, 2, 3]]";
			// I am testing against string here since lists are "hard" to construct the list for testing.
			assertEquals(output, getPowerSet(input).toString());
		}
	}
}
