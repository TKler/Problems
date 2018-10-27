package p90to120;

import java.util.ArrayList;
import java.util.List;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Facebook.
//
//Given a binary tree, return all paths from the root to leaves.
//
//For example, given the tree
//
//   1
//  / \
// 2   3
//    / \
//   4   5
//
//it should return [[1, 2], [1, 3, 4], [1, 3, 5]].
public class Problem110
{
	List<List<Integer>> _result = new ArrayList<List<Integer>>();
	
	public List<List<Integer>> allPathsToLeaves(Node root)
	{
		step(root, new ArrayList<Integer>());
		return _result;
	}
	
	public void step(Node node, ArrayList<Integer> pathToHere)
	{
		if(node == null)
			_result.add(pathToHere);
		else
		{
			pathToHere.add(node.getValue());
			step(node.getLeft(), pathToHere);
			step(node.getRight(), pathToHere);
		}
	}
	
	public class Node
	{
		Node _left = null, _right = null;
		int _value;
		
		//constructor and stuff
		
		public Node getLeft() {return _left;}
		public Node getRight() {return _right;}
		public int getValue() {return _value;}
	}
}
