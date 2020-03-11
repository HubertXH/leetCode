package tree;

import Entity.TreeNode;

public class Tree {

	public TreeNode root;
	
	
	/**
	 * preorder traversal
	 * @param T
	 */
	
	public void PerOrderTraverse(TreeNode T){
		
		if (T == null) {
			return;
		}
		
		System.out.println(T.data);

		PerOrderTraverse(T.left);
		
		PerOrderTraverse(T.right);
	}
	
	/**
	 * inorder traversal
	 * @param T
	 */
	public void InOrderTraverse(TreeNode T){
		
		if(T == null){
			return ;
		}
		
		InOrderTraverse(T.left);
		
		System.out.println(T.data);
		
		InOrderTraverse(T.right);
	}
	
	/**
	 * postorder traversal
	 * @param T
	 */
	public void PostOrderTraverse(TreeNode T){
		
		if (T == null) {
			return;
		}
		
		PostOrderTraverse(T.left);
		
		PostOrderTraverse(T.right);
		
		System.out.println(T.data);
		
	}
	
}
