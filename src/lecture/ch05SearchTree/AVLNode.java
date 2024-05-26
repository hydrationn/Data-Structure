package lecture.ch05SearchTree;

public class AVLNode<Key extends Comparable<Key>, Value> {
    protected Key id;
    protected Value name;
    protected int height;
    protected AVLNode left, right;
    public AVLNode(Key newID, Value newName, int newHt) { // 생성자
        id = newID;
        name = newName;
        height = newHt;
        left = right = null;
    }
}
