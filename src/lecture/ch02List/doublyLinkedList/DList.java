package lecture.ch02List.doublyLinkedList;

import java.util.NoSuchElementException;

public class DList <E> {
    protected DNode head, tail;
    protected int size;
    public DList() { // 생성자
        // Dummy Node: head와 tail이 가리키는 노드 초기화, 실제로 항목을 저장하지 않는 노드에 해당
        head = new DNode(null, null, null);
        tail = new DNode(null, head, null); // tail의 이전 노드를 head로 만든다.
        head.setNext(tail); // head의 다음 노드를 tail로 만든다.
        size = 0;
    }

    // 삽입 메소드
    public void insertBefore(DNode p, E newItem) { // p가 가리키는 노드 앞에 삽입
        DNode t = p.getPrevious();
        DNode newNode = new DNode(newItem, t, p);
        p.setPrevious(newNode);
        t.setNext(newNode);
        size++;
    }

    public void insertAfter(DNode p, E newItem) { // p가 가리키는 노드 뒤에 삽입
        DNode t = p.getNext();
        DNode newNode = new DNode(newItem, p, t);
        t.setPrevious(newNode);
        p.setNext(newNode);
        size++;
    }

    // 삭제 메소드: 노드 x 삭제
    public void delete(DNode x) { // x가 가리키는 노드 삭제
        if (x == null)
            throw new NoSuchElementException();
        DNode f = x.getPrevious();
        DNode r = x.getNext();
        f.setNext(r);
        r.setPrevious(f);
        size--;
    }

}
