package entity;

/**
 * @author Hubert
 */
public class Node<E> {

    E item;
    Node<E> prev;
    Node<E> next;

    public Node() {
    }

    public Node(E item, Node<E> prev, Node<E> next) {
        this.item = item;
        this.prev = prev;
        this.next = next;
    }
}
