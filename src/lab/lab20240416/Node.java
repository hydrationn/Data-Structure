package lab.lab20240416;

public class Node<E> {
    private E data;
    private Node<E> next;

    Node(E data) {
        this.data = data;
    }

    Node(E data, Node next) {
        this.data = data;
        this.next = next;
    }

    public E getData() {
        return this.data;
    }

    public Node<E> getNext() {
        return this.next;
    }

    public void setData(E newData) {
        this.data = newData;
    }

    public void setNext(Node<E> newNext) {
        this.next = newNext;
    }
}
