package tree;

public class TreeNode<T> {

	public int number;
	public T data;
	public TreeNode right;
	public TreeNode left;
	
	public TreeNode(){}

	public TreeNode(int number, T data) {
		super();
		this.number = number;
		this.data = data;
	};

}
