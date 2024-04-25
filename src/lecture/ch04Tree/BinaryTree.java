package lecture.ch04Tree;

import java.util.*;
public class BinaryTree<Key extends Comparable<Key>> {
    private Node root;
    public BinaryTree() { root = null; } // 트리 생성자
    public Node getRoot() { return root; }
    public void setRoot(Node newRoot) { root = newRoot; }
    public boolean isEmpty() { return root == null; }

    // preorder(), inorder(), postorder(), levelorder(), size(), height(), isEqual() 메소드 선언


}
