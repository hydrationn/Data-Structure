package lab.lab20240507;

public class Node {
    int parent;
    int size;
    public Node(int newParent, int newSize) {
        parent = newParent;
        size = newSize;
    }
    public int getParent() { return parent; }
    public int getSize() { return size; }
    public void setParent(int newParent) { parent = newParent; }
    public void setSize(int newSize) { size = newSize; }

}
