package lab20240326;

public class SinglyLinkedList {

    static class Node {
        private int data;
        private Node next;

        Node(int data) {
            this.data = data;
        }

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return this.data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node newNext) {
            this.next = newNext;
        }
    }


    private static int data;
    private static Node next;

    // 리스트 맨 마지막에 원소를 삽입하는 메소드
    static void insertLast(int x) {
        Node newItem = new Node(x, null);

        if (next == null) {
            next = newItem;
            return;
        }

        Node head = next;
        while (head.next != null){
            head = head.next;
        }
        head.next = newItem;
    }

    // 삽입이 끝난 리스트를 출력하는 메소드
    static void printall() {
        Node node = next;

        if(next == null) {
            return;
        }

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // 역방향 연결 리스트로 변환하는 메서드
    static void reverse() {
        if (next == null) {
            next = null;
            return;
        }

        Node before = null;
        Node head = next;
        Node after = null;

        while (head != null) {
            next = head.getNext(); // 다음 노드를 임시 저장
            head.setNext(before); // 현재 노드의 다음을 이전 노드로 설정하여 역순 만들기
            before = head; // 이전 노드를 현재 노드로 업데이트
            head = next; // 현재 노드를 다음 노드로 업데이트
        }
        head = before; // 머리 노드를 역순 리스트의 새 머리 노드로 설정

        next = before;
    }

    // 리스트를 리셋하는 메서드
    static void listReset() {
        if(next == null) {
            return;
        } else {
            next = null;
        }
    }
}

