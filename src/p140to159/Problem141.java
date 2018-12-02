package p140to159;
import java.util.LinkedList;
import java.util.List;

//This problem was asked by Microsoft.
//
//Implement 3 stacks using a single list:
//
//class Stack:
//    def __init__(self):
//        self.list = []
//
//    def pop(self, stack_number):
//        pass
//
//    def push(self, item, stack_number):
//        pass

public class Problem141<T>
{
	List<T> _list = new LinkedList<T>();
	int[] _start; 
	int[] _end;
	int _numberOfStack;
	
	public Problem141(int numberOfStacks)
	{
		_start = new int[numberOfStacks];
		_end = new int[numberOfStacks];
		_numberOfStack = numberOfStacks;
	}
	
	public T pop(int stackID)
	{
		stackID--;
		T result = null;
		if(_start[stackID] < _end[stackID])
		{
			result =  _list.get(_end[stackID]);
			_list.remove(_end[stackID]);
			
			decreaseIndizies(stackID);
		}
		return result;
	}

	private void decreaseIndizies(int stackID)
	{
		for(int i = stackID; i < _numberOfStack; i++)
		{
			_start[i]--;
			_end[i]--;
		}
	}
	
	public void push(T element, int stackID)
	{
		stackID--;
		_list.add(_end[stackID], element);
		increaseIndizies(stackID);
	}
	
	private void increaseIndizies(int stackID)
	{
		for(int i = stackID; i < _numberOfStack; i++)
		{
			_start[i]++;
			_end[i]++;
		}
	}
}
