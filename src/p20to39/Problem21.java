package p20to39;

import static org.junit.Assert.assertEquals;

import java.util.Map.Entry;
import java.util.SortedMap;
import java.util.TreeMap;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Snapchat.
//
//Given an array of time intervals (start, end) for classroom lectures 
//(possibly overlapping), find the minimum number of rooms required.
//
//For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
public class Problem21
{
	/*
	 * Idea is discrete event simulation (DES)
	 * I changed the input slightly so it is not as hard to create test cases.
	 */
	public int requiredNumberOfRooms(int[] schedule)
	{
		int max = 0;
		int currentLectures = 0;
		SortedMap<Integer, Integer> eventSchedule = initializeList(schedule);

		for(Entry<Integer, Integer> pair : eventSchedule.entrySet())
		{
			currentLectures += pair.getValue();
			assert currentLectures >= 0;
			max = Math.max(max, currentLectures);
		}
		
		return max;
	}

	private SortedMap<Integer, Integer> initializeList(int[] schedule)
	{
		SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>(); 
		boolean start = true;
		for(int time : schedule)
		{
			map.merge(time, start ? 1 : -1, Integer::sum);
			start = start ? false : true;
		}
		
		return map;
	}
	
	@Nested
	public class TestProblem21
	{
		@Test
		void test()
		{
			int[] inputArray = new int[] {30,75, 0,50, 60,150};
			int output = 2;
			assertEquals(output, requiredNumberOfRooms(inputArray)); 
		}
		
		@Test
		void allOneTime()
		{
			int[] inputArray = new int[] {30,75, 30,75, 30,75};
			int output = 3;
			assertEquals(output, requiredNumberOfRooms(inputArray)); 
		}
		
		@Test
		void fullMorning()
		{
			int[] inputArray = new int[] {30,75, 30,75, 30,75, 20,80, 10,70, 120,150, 130,150};
			int output = 5;
			assertEquals(output, requiredNumberOfRooms(inputArray)); 
		}
		
		@Test
		void sparse()
		{
			int[] inputArray = new int[] {10,12, 20,26, 100,120};
			int output = 1;
			assertEquals(output, requiredNumberOfRooms(inputArray)); 
		}
		
		@Test
		void oneUnderAll()
		{
			int[] inputArray = new int[] {10,12, 20,26, 100,120, 1,200};
			int output = 2;
			assertEquals(output, requiredNumberOfRooms(inputArray)); 
		}
	}

}
