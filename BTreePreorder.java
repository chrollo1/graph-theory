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

// preorder: root -> left -> right

public class BTreePreorder {
	
	public static void main(String[] args) {
		
		TreeNode root = new TreeNode(1);		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(preorder(root));
		
	}
	
	public static List<Integer> preorder(TreeNode root) {
		
		List<Integer> res = new ArrayList<Integer>();
		
		if (root == null)
			return res;
		
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		
		while (!st.isEmpty()) {
			
			TreeNode p = st.pop();
			res.add(p.val);
			
			if (p.right != null)
				st.push(p.right);
			
			if (p.left != null)
				st.push(p.left);
			
		}	
		return res;		
	}
}
