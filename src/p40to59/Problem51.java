package p40to59;

import java.util.ArrayList;
import java.util.List;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Facebook.
//
//Given a function that generates perfectly random numbers between 1 and k (inclusive), 
//where k is an input, write a function that shuffles a deck of cards represented as an array using only swaps.
//
//It should run in O(N) time.
//
//Hint: Make sure each one of the 52! permutations of the deck is equally likely.
public class Problem51
{
	public int[] shuffleDeck()
	{
		int[] deck = new int[52];
		for(int i = 1; i < 53; i++)
		{
			deck[i-1] = i;
		}
		
		List<Integer> newDeck = new ArrayList<Integer>();
		for(int i = 0; i < 52; i++)
		{
			int rand = random(i);
			newDeck.add(rand, deck[i]);
		}
		
		return deck;
	}

	private int random(int i)
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
