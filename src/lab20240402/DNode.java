package lab20240402;

public class DNode {
    private Integer data;
    private DNode previous;
    private DNode next;

    public DNode(Integer data, DNode previous, DNode next) {
        this.data = data;
        this.previous = previous;
        this.next = next;
    }

    public Integer getData() {
        return data;
    }

    public DNode getPrevious() {
        return previous;
    }

    public DNode getNext() {
        return next;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public void setPrevious(DNode previous) {
        this.previous = previous;
    }

    public void setNext(DNode next) {
        this.next = next;
    }
}
