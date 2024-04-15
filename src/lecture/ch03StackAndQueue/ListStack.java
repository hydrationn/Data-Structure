package lecture.ch03StackAndQueue;

import java.util.EmptyStackException;
public class ListStack <E> {
    private Node<E> top; // 스택 top 항목을 가진 Node를 가리키기 위해
    private int size; // 스택의 항목 수
    public ListStack() { // 스택의 생성자
        top = null;
        size = 0;
    }
    public int size() { return size; } // 스택의 항목의 수 반환
    public boolean isEmpty() { return size == 0; } // 스택이 empty이면 true 반환

    // peek(), push(), pop() 메소드 선언

    // peek(): 스택의 top 항목만 반환
    public E peek() {
        if (isEmpty())
            throw new EmptyStackException(); // underflow 시 프로그램 정지
        return top.getItem();
    }

    // push(): 스택에 새 항목 삽입
    public void push(E newItem) { // 스택 push 연산
        Node newNode = new Node(newItem, top); // 리스트 앞부분에 삽입
        top = newNode; // top이 새 노드 가리킴
        size++; // 스택 항목 수 1 증가
    }

    // pop(): top이 가리키는 노드의 item을 반환
    public E pop() { // 스택 pop 연산
        if (isEmpty())
            throw new EmptyStackException(); // underflow 시 프로그램 정지
        E topItem = top.getItem(); // 스택 top 항목을 topItem에 저장
        top = top.getNext(); // top이 top 바로 아래 항목을 가리킴
        size--; // 스택 항목 수를 1 감소
        return topItem;
    }
}
