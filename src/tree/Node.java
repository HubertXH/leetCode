package tree;

public class Node<T> {

	public int number;
	public T date;
	public Node rightchild;
	public Node leftchild;
	
	public Node(){}

	public Node(int number, T date) {
		super();
		this.number = number;
		this.date = date;
	};

}
