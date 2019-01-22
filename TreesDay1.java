package misc;

class Node {
	int val;
	Node left;
	Node right;
	
	Node(int val) {
		this.val = val;
		right = null;
		left = null;
	}
}

public class TreesDay1 {	
	static Node rt;
	
	private static Node addRec(Node cur, int val) {
		if (cur == null) {
			return new Node(val);
		}
		
		if (val < cur.val) {
			cur.left = addRec(cur.left, val);
		} else if (val > cur.val) {
			cur.right = addRec(cur.right, val);
		} else {
			// val exists
			return cur;
		}
	
		return cur;
	}
	
	public static void add(int val) {
		root = addRec(root, val);
	}
	
	private static boolean containsNodeRecursive(Node cur, int val) {
	    if (cur == null) {
	        return false;
	    } 
	    if (val == cur.val) {
	        return true;
	    } 
	    return val < cur.val
	      ? containsNodeRecursive(cur.left, val)
	      : containsNodeRecursive(cur.right, val);
	}
	
	public static boolean containsNode(int val) {
	    return containsNodeRecursive(root, val);
	}
	
	public static void main(String[] args) {
		TreesDay1 bt = new TreesDay1();
		
		bt.add(100);
		
		for (int i = 0; i < 20; i++)
           	    bt.add((int) (Math.random() * 200));

//		System.out.println(containsNode(5));
		
		print("-", root, false);
	}
	
	public static void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.val);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }

}
