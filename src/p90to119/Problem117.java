package p90to119;

import java.util.List;
import java.util.Stack;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Facebook.
//
//Given a binary tree, return the level of the tree with minimum sum.
public class Problem117
{
	public int getLevelWithMinSum(Node root)
	{
		int min = Integer.MAX_VALUE;
		int minLevel = 0;
		int level = 0;
		int sum = 0;
		Stack<Node> thisLevel = new Stack<Node>();
		thisLevel.push(root);
		Stack<Node> nextLevel;
		
		do
		{
			nextLevel = new Stack<Node>();
			while(!thisLevel.isEmpty())
			{
				Node node = thisLevel.pop();
				sum =+ node.getValue();
				nextLevel.addAll(node.getChildren());
			}
			if(min > sum)
			{
				min = sum;
				minLevel = level;
			}
			
			sum = 0;
			level++;
			thisLevel = nextLevel;
		}while(!thisLevel.isEmpty());
		
		return minLevel;
	}
	
	
	
	public interface Node
	{
		List<Node> getChildren();
		int getValue();
//		boolean hasChildren();
	}
}
