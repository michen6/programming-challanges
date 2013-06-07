import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Tree implements Serializable {

  /**
	 * 
	 */
	private static final long serialVersionUID = 5929282787615315919L;

	TreeNode[] treeNodes;

	int size;
	int maxSize;

	public Tree() {
		this(100);
	}

	public Tree(int size) {
		this.treeNodes = new TreeNode[size];
		this.size = 0;
		this.maxSize = size;
	}

	public void add(TreeNode parent, TreeNode child) {
		if (this.size == this.maxSize) {
			System.out.println("Full! Cannot add " + child.getValue()
					+ ". Size: " + this.maxSize);
		} else {
			child.setId(this.size);
			this.treeNodes[this.size] = child;
			parent.addChild(this.size++);
		}
	}

	public void addRoot(TreeNode root) {
		if (this.size() == 0) {
			root.setId(0);
			this.treeNodes[0] = root;
			this.size++;
		} else {
			System.out.println("Not Empty!");
		}
	}

	public String print(int parentId, int level) {
		TreeNode parent = this.treeNodes[parentId];
		String message = "";
		for (int i = 0; i < level; i++) {
			message += "\t";
		}
		message += parent.getId() + " " + parent.value;
		if (parent.hasChild()) {
			ArrayList<Integer> children = parent.getChildren();
			Iterator<Integer> iter = children.iterator();
			while (iter.hasNext()) {
				message += "\n";
				message += print(this.treeNodes[iter.next()].getId(), level + 1);
			}
		}
		return message;
	}

	public int size() {
		return this.size;
	}

	public String toString() {
		return print(0, 0);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree(10);
		TreeNode a = new TreeNode("a");
		TreeNode b = new TreeNode("b");
		TreeNode c = new TreeNode("c");
		TreeNode d = new TreeNode("d");
		TreeNode e = new TreeNode("e");
		TreeNode f = new TreeNode("f");
		TreeNode g = new TreeNode("g");
		TreeNode h = new TreeNode("h");
		TreeNode i = new TreeNode("i");
		TreeNode j = new TreeNode("j");
		TreeNode k = new TreeNode("k");

		tree.addRoot(a);
		tree.add(a, b);
		tree.add(a, c);
		tree.add(b, d);
		tree.add(c, e);
		tree.add(d, f);
		tree.add(e, g);
		tree.add(b, h);
		tree.add(a, i);
		tree.add(d, j);
		tree.add(a, k);

		System.out.println(tree);
	}
}

class TreeNode {
	int id;

	ArrayList<Integer> children;

	String value;

	public TreeNode(String value) {
		this.id = 0;
		this.value = value;
		children = new ArrayList<Integer>();
	}

	public void addChild(int id) {
		children.add(id);
	}

	public boolean hasChild() {
		if (children.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

	public ArrayList<Integer> getChildren() {
		return children;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String toString() {
		return value;
	}
}
