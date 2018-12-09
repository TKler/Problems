package p140to159;

//This problem was asked by Triplebyte.
//
//You are given n numbers as well as n probabilities that sum up to 1. Write a function to generate one of the 
//numbers with its corresponding probability.
//
//For example, given the numbers [1, 2, 3, 4] and probabilities [0.1, 0.5, 0.2, 0.2], 
//your function should return 1 10% of the time, 2 50% of the time, and 3 and 4 20% of the time.
//
//You can generate random numbers between 0 and 1 uniformly.
public class Problem152
{
	int[] numbers;
	double[] probabilities;
	public Problem152(int[] numbers, double[] probabilities)
	{
		assert(numbers.length == probabilities.length);
		this.probabilities = probabilities;
		this.numbers = numbers;
	}
	
	public int getRandomNumber()
	{
		double rand = Math.random();
		double sum = 0;
		int index = 0;
		for(double d : probabilities)
		{
			if(sum + d > rand)
				break;
			else
				sum += d;
			index++; 
		}
		return numbers[index];
	}
}
