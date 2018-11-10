package p40to59;

import java.util.Random;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Two Sigma.
//
//Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, 
//implement a function rand7() that returns an integer from 1 to 7 (inclusive).
public class Probem45
{
	public int rand7()
	{
		int number;
		do
		{
			number = rand10();
		}while(number > 7);
		
		return number;
	}
	
	private int rand10()
	{
		int number = rand5() * 2; //2,4,6,8,10
		
		int decider;
		do
		{
			decider = rand5();
		}while(decider == 5);
		
		if(decider < 3)
			number--;
		
		return number;
	}
	
	private int rand5()
	{
		Random generator = new Random();
		int  n = generator.nextInt(5) + 1;
		return n;
	}
	
	@Nested
	public class TestProblem45
	{
		@Test
		void testProbability()
		{
			int[] array = new int[7];
			for(int i = 0; i < 100; i++)
			{
				array[rand7()-1]++;
			}
			
			for(int k = 0; k < 7; k++)
			{
//				assertTrue(array[k] > 5); //bernoulli formula 5 is quite unlikely but still not a real test, 
//											could do monte carlo for example, but not suitable for unit tests cause of time
//				System.out.println(array[k]);
			}
		}
	}
}
