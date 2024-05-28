package lab.lab20240521;

public class Node<Key extends Comparable<Key>, Value> {
  protected Key id;
  protected Value name;
  protected int height;
  protected Node left, right;

  public Node(Key newID, Value newName, int newHt) { // 생성자
    id = newID;
    name = newName;
    height = newHt;
    left = right = null;
  }
}
