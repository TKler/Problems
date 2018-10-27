package p1to19;

import java.util.Random;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Facebook.
//
//Given a stream of elements too large to store in memory, pick a random 
//element from the stream with uniform probability.
public class Problem15
{
	int _n = 0;
	Object _element;
	Random _random= new Random();
	
//	@assert we get each next element from some driver
	public void pickFromStream(Object nextElement)
	{
		_n++;
		if(_random.nextInt(_n)+1 == _n)
			_element = nextElement;
	}
}
// This chooses the first element since random(1) -> 0
// For all other elements, they get a chance of 1/n to get chosen, where n is the current number of seen elements.
// This mean the first element is chosen at 1 but then has a 0.5 chance of being replaced followed by 0.33 etc. 
//This should sum up that each element has a 1/n chance of being chosen where n is this time the total number of elements 
