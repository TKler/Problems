package problemNinetyToOnehundretTen;
import java.util.LinkedList;
import java.util.Queue;

//Good morning! Here's your coding interview problem for today.
//
//This problem was asked by Microsoft.
//
//Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.
//
//  1
// / \
//2   3
//   / \
//  4   5

public class Problem107
{
	public void printLevelWise(Node root)
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while(!queue.isEmpty())
		{
			Node node = queue.poll();
			if(node.hasLeftChild())
				queue.add(node.getLeftChild());
			
			if(node.hasRightChild())
				queue.add(node.getRightChild());
			
			System.out.print(node.toString());
		}
	}
	
	public interface Node
	{
		public Node getLeftChild();
		public Node getRightChild();
		public boolean hasLeftChild();
		public boolean hasRightChild();
		//obviously more
	}
}
