package tree;

public class Tree {

	public Node root;
	
	
	/**
	 * 前序遍历二叉树
	 * @param T
	 */
	
	public void PerOrderTraverse(Node T){
		
		if (T == null) {
			return;
		}
		
		System.out.println(T.date);

		PerOrderTraverse(T.leftchild);
		
		PerOrderTraverse(T.rightchild);
	}
	
	/**
	 * 中序遍历
	 * @param T
	 */
	public void InOrderTraverse(Node T){
		
		if(T == null){
			return ;
		}
		
		InOrderTraverse(T.leftchild);
		
		System.out.println(T.date);
		
		InOrderTraverse(T.rightchild);
	}
	
	/**
	 * 后序遍历
	 * @param T
	 */
	public void PostOrderTraverse(Node T){
		
		if (T == null) {
			return;
		}
		
		PostOrderTraverse(T.leftchild);
		
		PostOrderTraverse(T.rightchild);
		
		System.out.println(T.date);
		
	}
	
}
