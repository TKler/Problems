package p90to119;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Airbnb.
//
//We're given a hashmap with a key courseId and value a list of courseIds, 
//which represents that the prerequsite of courseId is courseIds. Return a sorted ordering 
//of courses such that we can finish all courses.
//
//Return null if there is no such ordering.
//
//For example, given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, 
//should return ['CSC100', 'CSC200', 'CSCS300'].
public class Problem92
{
	/*
	 * Take the course we can do - the one without prerequisites - and delete the prerequisite from all other courses.
	 * this is the simple stupid approach, we could also check the result list or something similar, but this works just fine
	 */
//	@assert map neither empty nor null;
	public List<Integer> getCourseOrder(HashMap<Integer, List<Integer> > map)
	{
		List<Integer> result = new ArrayList<Integer>();
		int len = map.size();
		
		for(int i = 0; i < len; i++)
		{
			Iterator<Entry<Integer, List<Integer>>> iter = map.entrySet().iterator();
			while(iter.hasNext())
			{
				Entry<Integer, List<Integer>> entry = iter.next();
				if(entry.getValue().size() == 0)
				{
					result.add(entry.getKey());
					map.remove(entry.getKey());
					removeCourseAsConstraints(map, entry.getKey());
					break;
				}
			}
		}
		
		if(map.size() == 0) 
			return result;
		else
			return null;
	}

	private void removeCourseAsConstraints(HashMap<Integer, List<Integer>> map, Integer completedCourse)
	{
		for(List<Integer> list : map.values())
			list.remove(completedCourse);
	}
	
	@Nested
	public class TestProblem92
	{
		@Test 
		void test()
		{
			HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
			ArrayList<Integer> list1 = new ArrayList<Integer>();
			list1.addAll(Arrays.asList(1, 2));
			map.put(3, list1);
			ArrayList<Integer> list2 = new ArrayList<Integer>();
			list2.addAll(Arrays.asList(1));
			map.put(2, list2);
			map.put(1, new ArrayList<Integer>());
			assertTrue(Arrays.asList(1,2,3).equals(getCourseOrder(map)));
		}
	}
}
