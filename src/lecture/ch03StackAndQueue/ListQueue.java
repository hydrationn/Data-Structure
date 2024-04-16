package lecture.ch03StackAndQueue;

import java.util.NoSuchElementException;
public class ListQueue<E> {
    private Node<E> front, rear;
    private int size;
    public ListQueue() { // 생성자
        front = rear = null;
        size = 0;
    }
    public int size() { return size; } // 큐의 항목의 수 반환
    public boolean isEmpty() { return size == 0; } // 큐가 empty이면 true 반환

    // add(), remove() 메소드 선언

    // add(): 새 항목 rear 다음에 삽입
    public void add(E newItem) {
        Node newNode = new Node(newItem, null); // 새 노드 생성
        if (isEmpty())
            front = newNode; // 큐가 empty이었으면 front도 newNode를 가리키게
        else
            rear.setNext(newNode); // 그렇지 않으면 rear의 next를 newNode를 가리키게
        rear = newNode; // 마지막으로 rear가 newNode를 가리키게
        size++; // 큐 항목 수 1 증가
    }

    // remove(): 앞(front)에서 삭제
    public E remove() {
        if (isEmpty())
            throw new NoSuchElementException(); // underflow 경우 프로그램 정지
        E frontItem = front.getItem(); // front가 가리키는 노드의 항목을 frontItem에 저장
        front = front.getNext(); // front가 front 다음 노드를 가리키게
        size--; // 큐 항목 수 1 감소
        if (isEmpty()) // 큐가 empty이면 rear = null
            rear = null;
        return frontItem;
    }
}
