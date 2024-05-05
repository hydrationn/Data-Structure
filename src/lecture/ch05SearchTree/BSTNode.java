package lecture.ch05SearchTree;

public class BSTNode <Key extends  Comparable<Key>, Value> {
    private Key id;
    private Value name;
    private BSTNode left, right;
    public BSTNode(Key newId, Value newName) { // 노드 생성자
        id = newId;
        name = newName;
        left = right = null;
    }
    // get과 set 메소드들
    public Key getKey() { return id; }
    public Value getValue() { return name; }
    public BSTNode getLeft() { return left; }
    public BSTNode getRight() { return right; }
    public void setKey(Key newId) { id = newId; }
    public void setValue(Value newName) { name = newName; }
    public void setLeft(BSTNode newLeft) { left = newLeft; }
    public void setRight(BSTNode newRight) { right = newRight; }
}
