package lecture.ch02List.singlyLinkedList;

import lecture.ch02List.singlyLinkedList.Node;

import java.util.NoSuchElementException;

public class SList <E> {
    protected Node head; // 연결 리스트의 첫 노드 가리킴
    private int size;
    public SList() { // 연결 리스트 생성자
        head = null;
        size = 0;
    }

    // 탐색 메서드: target을 찾기 위해 순차 탐색
    public int search(E target) { // target을 탐색
        Node p = head;
        for (int k=0; k<size; k++) {
            if(target == p.getItem())
                return k;
            p = p.getNext();
        }
        return -1; // 탐색에 실패한 경우 -1 리턴
    }

    // 삽입 메서드
    public void insertFront(E newItem) { // 연결 리스트 맨 앞에 새 노드 삽입
        head = new Node<>(newItem, head);
        size++;
    }

    public void insertAfter(E newItem, Node p) { // 연결 리스트 맨 뒤에 새 노드 삽입
        p.setNext(new Node(newItem, p.getNext()));
        size++;
    }

    // 삭제 메서드
    public void deleteFront() { // 리스트의 첫 노드 삭제
        if (size == 0)
            throw new NoSuchElementException();
        head = head.getNext();
        size--;
    }

    public void deleteAfter(Node p) { // p가 가리키는 노드의 다음 노드를 삭제
        if(p == null)
            throw new NoSuchElementException();
        Node t = p.getNext();
        p.setNext(t.getNext());
        t.setNext(null);
        size--;
    }
}
