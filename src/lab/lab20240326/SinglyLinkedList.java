package lab.lab20240326;

public class SinglyLinkedList {

    public static Node head;

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

    // 리스트 맨 마지막에 원소를 삽입하는 메소드
    public static void insertLast(int newItem) {
        Node newNode = new Node(newItem);
        if (head == null) {
            head = newNode;
        } else {
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
    }

    // 삽입이 끝난 리스트를 출력하는 메소드
    public static void printall() {
        Node node = head;

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    // 역방향 연결 리스트로 변환하는 메서드
    public static void reverse() {
        Node previous = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next; // 다음 노드를 임시 저장
            current.next = previous; // 현재 노드의 다음을 이전 노드로 설정하여 역순 만들기
            previous = current; // 이전 노드를 현재 노드로 업데이트
            current = next; // 현재 노드를 다음 노드로 업데이트
        }
        head = previous; // 헤드를 역순 리스트의 새 헤드로 설정
    }
}

