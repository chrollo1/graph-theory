package trees_and_graphs;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	
	int val;
	TreeNode right;
	TreeNode left;
	
	TreeNode(int x) {
		this.val = x;
	}
}

// inorder: left -> root -> right

public class BTreeInorder {

	static List<Integer> res = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);		
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		System.out.println(inorder(root));
	}
	
	public static List<Integer> inorder(TreeNode root) {
		if (root != null) {
			helper(root);
		}
		
		return res;
	}
	
	public static void helper(TreeNode p) {
		if (p.left != null)
			helper(p.left);
		
		res.add(p.val);
		
		if (p.right != null)
			helper(p.right);
	}

}
