package entity;

public class TreeNode<T> {

	public int val;
	public T data;
	public TreeNode right;
	public TreeNode left;
	
	public TreeNode(){}

	public TreeNode(int val, T data) {
		super();
		this.val = val;
		this.data = data;
	};

	public TreeNode(int val){
		this.val = val;
	}



}
