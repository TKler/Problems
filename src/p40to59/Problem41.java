package p40to59;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//This problem was asked by Facebook.
//
//Given an unordered list of flights taken by someone, each represented as (origin, destination) pairs, 
//and a starting airport, compute the person's itinerary. If no such itinerary exists, return null. 
//If there are multiple possible itineraries, return the lexicographically smallest one. All flights must be used in the itinerary.
//
//For example, given the list of flights [('SFO', 'HKO'), ('YYZ', 'SFO'), ('YUL', 'YYZ'), ('HKO', 'ORD')] 
//and starting airport 'YUL', you should return the list ['YUL', 'YYZ', 'SFO', 'HKO', 'ORD'].
//
//Given the list of flights [('SFO', 'COM'), ('COM', 'YYZ')] and starting airport 'COM', you should return null.
//
//Given the list of flights [('A', 'B'), ('A', 'C'), ('B', 'C'), ('C', 'A')] and starting airport 'A', you should 
//return the list ['A', 'B', 'C', 'A', 'C'] even though ['A', 'C', 'A', 'B', 'C'] is also a valid itinerary. 
//However, the first one is lexicographically smaller.
public class Problem41
{
//	removed return in favor of print, this is worse, but way less hassle, would solve this way different if given the task and wanted to
//	try if I could get recursive dfs to work which is not nice for return :D
	public void dfsSearchForIntiniery(List<String> flights, String startAirport)
	{
		Collections.sort(flights);
		boolean[] visited = new boolean[flights.size()-1]; 
		
		recursiveCall(flights, visited , getStartIndex(flights, startAirport), new ArrayList<String>());
	}
	
	private int getStartIndex(List<String> flights, String startAirport)
	{
		int index = 0;
		for(String flight : flights)
		{
			if(flight.length() > startAirport.length() 
					&& startAirport.equals(flight.substring(0, startAirport.length())))
				return index;
			index++;
		}
		return 0;
	}

	private void recursiveCall(List<String> flights, boolean[] visited, int currentAirportIndex, List<String> intinery)
	{
		visited[currentAirportIndex] = true;
		String targetAirport = getTarget(flights.get(currentAirportIndex));
		intinery.add(targetAirport);
		
		if(intinery.size() == flights.size())
		{
			System.out.println(intinery);
		}
		
		for(int i = 0; i < flights.size(); i++)
		{
			if(flights.get(i).length() > targetAirport.length() 
					&& targetAirport.equals(flights.get(i).substring(0, targetAirport.length()))
					&& !visited[i])
			{
				recursiveCall(flights, visited, i, intinery);
			}
		}
	}

	private String getTarget(String string)
	{
		String[] airports = string.split(" ");
		return airports[1];
	}
}
