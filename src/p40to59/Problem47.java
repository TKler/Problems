package p40to59;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Facebook.
//
//Given a array of numbers representing the stock prices of a company in chronological order, 
//write a function that calculates the maximum profit you could have made from buying and selling that stock once. 
//You must buy before you can sell it.
//
//For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you could buy the stock at 5 dollars and sell it at 10 dollars.
public class Problem47
{
	public int getMaxWin(int[] stockPriceDevelopment)
	{
		if(stockPriceDevelopment == null || stockPriceDevelopment.length == 0)
			return 0;
		
		int maxWin = 0;
		int lowest = stockPriceDevelopment[0];

		for(int price : stockPriceDevelopment)
		{
			maxWin = Math.max(maxWin, price - lowest);
			if(price < lowest)
				lowest = price;
		}
		
		return maxWin;
	}
	
	@Nested
	public class TestProblem47
	{
		@Test
		void test()
		{
			int[] input = {9,11,8,5,7,10};
			int output = 5;
			assertEquals(output, getMaxWin(input));
		}
	}
}
