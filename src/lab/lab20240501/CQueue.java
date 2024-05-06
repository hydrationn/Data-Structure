package lab.lab20240501;

public class CQueue {
    protected Node rear;
    protected int size;

    public CQueue() {
        rear = null;
        size = 0;
    }

    // 원형 큐에 새로운 데이터를 추가한다.
    void insert(int newItem) {
        Node newNode = new Node(newItem, null); // 새 노드 생성
        if (size == 0){
            newNode.setNext(newNode);
        }
        else {
            newNode.setNext(rear.getNext()); // 마지막으로 rear가 newNode를 가리리게
            rear.setNext(newNode); // 그렇지 않으면 rear의 next를 newNode를 가리키게
        }
        rear = newNode; // rear가 newNode를 가리키게
        size++; // 큐 항목 수 1 증가
    }

    // 가장 먼저 삽입된 노드를 삭제하고 출력한다.
    void delete() {
        if (size == 0) {
            System.out.print("empty ");
            return;
        }

        int deleteItem = rear.getNext().getData(); // rear가 가리키는 노드의 다음 항목을 deleteItem에 저장
        rear.setNext(rear.getNext().getNext());
        size--; // 큐 항목 수 1 감소

        if (size == 0) // 큐가 empty이면 rear = null
            rear = null;

        System.out.print(deleteItem + " ");
    }
}
