package problemNinetyToOnehundretTen;
import java.util.ArrayList;
import java.util.Stack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import junit.framework.TestCase;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Coursera.
//
//Given a 2D board of characters and a word, find if the word exists in the grid.
//
//The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
//For example, given the following board:
//
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//exists(board, "ABCCED") returns true, exists(board, "SEE") returns true, exists(board, "ABCB") returns false.
public class Problem98
{
	private int _xPos = 0;
	private int _yPos = 0;
	private char[][] _boardChars;
	Stack<DFSStep> _stack = new Stack<DFSStep>();
	private int _depth;
	private ArrayList<Node> _trace;
	private boolean[][] _boardVisited;
	
//	@assert board has the form NxM probably not necessary here, lets see
	public boolean exists(char[][] board, String word)
	{
		init(board, word);
		if(!checks(board, word))
			return false;
		
		if(!findStarts(word.charAt(0)))
			return false;

		if(word.length() == 1)
			return true;

		while(!_stack.isEmpty())
		{
			goToNode(_stack.pop());

			if(findNextChar(word.charAt(_depth)))
				if(_depth+1 == word.length()) // depth has not yet been updated so check for +1
					return true;
		}
		return false; 
	}
	
	private boolean checks(char[][] board, String word)
	{
		return !(board==null || board.length==0 || word==null || word.length()==0);
	}

	private void init(char[][] board, String word)
	{
		_boardChars = board;
		initializeVisitedBoard();
		_depth = 0;
		_trace = new ArrayList<Node>(word.length());
	
	}

	private boolean findStarts(char c)
	{
		boolean flag = false;
		while(_xPos < _boardChars.length)
		{
			while(_yPos < _boardChars[_xPos].length)
			{
				if(c == _boardChars[_xPos][_yPos])
				{
					_stack.push(currentState(_xPos, _yPos));
					flag = true;
				}
				_yPos++;
			}
			_yPos = 0;
			_xPos++;
		}
		return flag;
	}
	
	private boolean findNextChar(char charAt)
	{
		boolean flag = false;
		for(int xPosOffset = -1; xPosOffset < 2; xPosOffset++)
		{
			for(int yPosOffset = -1; yPosOffset < 2; yPosOffset++)
			{
				int xPos = _xPos + xPosOffset;
				int yPos = _yPos + yPosOffset;
				if(isAValidIndex(xPos, yPos) && _boardChars[xPos][yPos] == charAt && !_boardVisited[xPos][yPos])
				{
					_stack.push(currentState(xPos, yPos));
					flag = true;
				}
			}
		}
		return flag;
	}
	
	private boolean isAValidIndex(int xPos, int yPos)
	{
		if(xPos != -1 && xPos != _boardChars.length && yPos != -1 && yPos != _boardChars[xPos].length)
			return true;
		return false;
	}
	
	private DFSStep currentState(int xPos, int yPos)
	{
		return new DFSStep(xPos, yPos, _depth+1);
	}
	/**
	 * Loads the state we need to be in
	 * Setting x, y and depth to the values of the node from where we want to explore
	 * backtracking the trace and reseting the visited boardspaces to reflect the not taken steps
	 * @param stateToLoad our new state
	 */
	private void goToNode(DFSStep stateToLoad)
	{
		_xPos = stateToLoad.getXPos();
		_yPos = stateToLoad.getYPos();
		_depth = stateToLoad.getDepth();
		for(int i = _trace.size()-1; i != _depth-2; i--)
		{
			_boardVisited[_trace.get(i).getXPos()][_trace.get(i).getYPos()] = false;
			_trace.remove(i);
		}
		
		markVisited(_xPos, _yPos);
	}

	private void markVisited(int x, int y)
	{
		_trace.add(new Node(x, y));
		_boardVisited[x][y] = true;
	}

	private void initializeVisitedBoard()
	{
		_boardVisited = new boolean[_boardChars.length][];
		for(int i = 0; i < _boardChars.length; i++)
		{
			_boardVisited[i] = new boolean[_boardChars[i].length];
		}
	}
	
	
	public class DFSStep
	{
		private int _dfsDepth;
		private int _dfsxPos, _dfsyPos;

		DFSStep(int xPos, int yPos, int depth)
		{_dfsxPos = xPos; _dfsyPos = yPos; _dfsDepth = depth;}
		
		public int getDepth() {return _dfsDepth;}
		public int getXPos() {return _dfsxPos;}
		public int getYPos() {return _dfsyPos;}
	}
	
	public class Node
	{
		private int _nodexPos, _nodeyPos;
		Node(int x, int y)
		{_nodexPos = x; _nodeyPos = y;}
		
		public int getXPos() {return _nodexPos;}
		public int getYPos() {return _nodeyPos;}
	}

	@Nested
	public class TestProblem98 extends TestCase
	{
		private char[][] _testBoard;

		@BeforeEach
		public void setUp()
		{
			_testBoard = new char[][] {	{'A','B','C','E'},
				   						{'S','F','C','S'},
				   						{'A','D','E','E'} };
		}

		@Test void test1() {assertTrue(exists(_testBoard, "A"));}
		@Test void test2() {assertFalse(exists(_testBoard, "AA"));}
		@Test void test3() {assertTrue(exists(_testBoard, "AB"));}
		@Test void test4() {assertTrue(exists(_testBoard, "ABCCE"));}
		@Test void test5() {assertTrue(exists(_testBoard, "ABCCED"));}
		@Test void test6() {assertTrue(exists(_testBoard, "SEE"));}
		@Test void test7() {assertFalse(exists(_testBoard, "ABCB"));}
		@Test void test8() {assertFalse(exists(_testBoard, "ABA"));}
	}
	
}
//I am tempted to write little helper methods for each condition, should be better in this case
//Or we don't care and write it all up into one call and two loops so we iterate over each case
//	private boolean findNext(char charAt)
//	{
//		int xPos, yPos;
//		
//		xPos = _xPos-1;
//		yPos = _yPos;
//		if(xPos != -1 && true && _board[xPos][yPos] == charAt) // x-1
//			return true;
//		
//		xPos = _xPos+1;
//		yPos = _yPos;
//		if(xPos != _board.length && true && _board[xPos][yPos] == charAt)
//			return true;
//		
//...
//	}
