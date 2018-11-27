package p120to139;

import java.util.Iterator;

//This problem was asked by Google.
//
//Given an iterator with methods next() and hasNext(), 
//create a wrapper iterator, PeekableInterface, which also implements peek(). peek shows the next element that would be returned on next().
//
//Here is the interface:
//
//class PeekableInterface(object):
//    def __init__(self, iterator):
//        pass
//
//    def peek(self):
//        pass
//
//    def next(self):
//        pass
//
//    def hasNext(self):
//        pass
public class Problem139
{
	boolean _wasPeeked = false;
	Iterator<Object> _iter;
	Object _peeked;
	
	
	public Object next()
	{
		Object result = _wasPeeked ? _peeked : _iter.next();
		_wasPeeked = false;
		return result; 
	}
	
	public boolean hasNext()
	{
		return _wasPeeked ? true : _iter.hasNext();
	}
	
	public Object peek()
	{
		if(_wasPeeked)
			return _peeked;
		else
		{
			_wasPeeked = true;
			_peeked = _iter.next();
			return _peeked;
		}
	}
}
