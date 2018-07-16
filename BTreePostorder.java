package trees_and_graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*  def'n...
 * 
 * 	class TreeNode {
 *
 *		int val;
 *		TreeNode right;
 *		TreeNode left;
 *
 *		TreeNode(int x) {
 *			this.val = x;
 *		}
 *	}
 *
 */

// postorder: left -> right -> root

public class BTreePostorder {

	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(postorder(root));

	}

	public static List<Integer> postorder(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();

		if (root == null) {
			return res;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode temp = stack.peek();
			if (temp.left == null && temp.right == null) {
				TreeNode pop = stack.pop();
				res.add(pop.val);
			}

			else {
				if (temp.right != null) {
					stack.push(temp.right);
					temp.right = null;
				}

				if (temp.left != null) {
					stack.push(temp.left);
					temp.left = null;
				}
			}
		}

		return res;
	}

}
