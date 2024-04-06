package lab.lab20240402;

public class CDList {
    protected DNode head;
    protected int size;

    public CDList() {
        head = new DNode(null, null, null);
        head.setPrevious(head);
        head.setNext(head);
        size = 0;
    }

    public void insert(int newItem) {
        DNode newNode = new DNode(newItem, head, head.getNext());
        if (head.getNext() == null) {
            head.setNext(newNode);
            head.setPrevious(newNode);
        } else {
            head.getNext().setPrevious(newNode);
            head.setNext(newNode);
        }
        size++;
    }

    public void delete() {
        if(size == 0)
            return;
        DNode f = head.getPrevious().getPrevious();
        DNode r = head;
        f.setNext(r);
        r.setPrevious(f);
        size--;
    }

    public void printall() {
        DNode dNode = head.getNext();
        while (dNode != head) {
            System.out.print(dNode.getData() + " ");
            dNode = dNode.getNext();
        }
        System.out.println();
    }
}
