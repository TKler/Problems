package problemNinetyToOnehundretTen;

import java.util.Collections;
import java.util.List;
import java.util.Random;

//Good morning! Here's your coding interview problem for today.
//
//This question was asked by Google.
//
//Given an integer n and a list of integers l, write a function that randomly 
//generates a number from 0 to n-1 that isn't in l (uniform).
public class Problem90
{
	/*
	 * Runs in O(1 + sum (maxRange/#invalidNumbers)^n for n-> infinite)
	 */
	public int generateRandom(int maxRangeExclusive, List<Integer> invalidNumbers)
	{
		int result = -1;
		Random randomGen = new Random();
		boolean validNumberRolled = false;
		while(!validNumberRolled)
		{
			result = randomGen.nextInt(maxRangeExclusive);
			if(invalidNumbers.contains(result))
				validNumberRolled = true;
		}
		return result;
	}
	
	/*
	 *  If rerolling is to expensive (or checking) you could use this
	 *  Each roll is in O(1), but the initialisation is in maxRangeExclusive 
	 */
	public int generateRandom2(int maxRangeExclusive, List<Integer> invalidNumbers)
	{
		int result = -1;
		Random randomGen = new Random();
		int[] numbersSkipped = new int[invalidNumbers.size()-1];
		
		Collections.sort(invalidNumbers);
		int count = 0;
		int index = 0;
		for(int i : invalidNumbers)
		{
			while(index < i)
			{
				numbersSkipped[index] = count;
				index++;
			}
			count++;
		}
		result = randomGen.nextInt(maxRangeExclusive-invalidNumbers.size()+1);
		result += numbersSkipped[result];
		return result;
	}
	
	/*
	 * break even with a = #invalid b= #total and c = #requests where a/b = 0.5
	 * 2*c   = b + c*1 -> b = 1c
	 * for a/b = 0.25  =>  1.3c = b+c*1 -> b = 0.3c
	 * 
	 * meaning we get b/c = limit(sum(a/b)^n) n->infinite
	 */
}
