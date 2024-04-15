package lecture.ch03StackAndQueue;

public class Node<E> {
    private E item;
    private Node<E> next;
    public Node(E newItem, Node<E> node) { // 생성자
        item = newItem;
        node = next;
    }
    // get과 set 메소드
    public E getItem() { return item; }
    public Node<E> getNext() { return next; }
    public void setItem(E newItem) { item = newItem; }
    public void setNext(Node<E> newNext) { next = newNext; }
}
