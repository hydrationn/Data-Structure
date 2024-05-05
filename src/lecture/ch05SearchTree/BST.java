package lecture.ch05SearchTree;

public class BST<Key extends Comparable<Key>, Value> {
    public BSTNode root;
    public BSTNode getRoot() { return root; }
    public BST(Key newId, Value newName) { // BST 생성자
        root = new BSTNode(newId, newName);
    }
    // get, put, min, deleteMin, delete
    // 메소드들 선언

    public Value get(Key k) { return get(root, k); }
    public Value get(BSTNode n, Key k) {
        if(n == null)
            return null; // k를 발견 못함

        int t = n.getKey().compareTo(k);
        if(t > 0)
            return get(n.getLeft(), k); // if ( k < 노드 n의 id) 왼쪽 서브트리 탐색
        else if (t < 0)
            return get(n.getRight(), k); // if ( k > 노드 n의 id) 오른쪽 서브트리 탐색
        else
            return (Value) n.getValue(); // k를 가진 노드 발견
    }

    public void put(Key k, Value v) { root = put(root, k, v); }
    public BSTNode put(BSTNode n, Key k, Value v) {
        if(n == null)
            return new BSTNode(k, v);

        int t = n.getKey().compareTo(k);
        if(t > 0)
            n.setLeft(put(n.getLeft(), k, v)); // if (k < 노드 n의 id) 왼쪽 서브트리에 삽입
        else if (t < 0)
            n.setRight(put(n.getRight(), k, v)); // if (k < 노드 n의 id) 오른쪽 서브트리에 삽입
        else
            n.setValue(v); // 노드 n의 name을 v로 갱신
        return n;
    }

    public Key min() {
        if(root == null)
            return null;
        return (Key) min(root).getKey();
    }
    private BSTNode min(BSTNode n) {
        if(n.getLeft() == null)
            return n;
        return min(n.getLeft());
    }

    public void deleteMin() {
        if (root == null)
            System.out.println("empty 트리");
        root = deleteMin(root);
    }
    public BSTNode deleteMin(BSTNode n) {
        if(n.getLeft() == null)
            return n.getRight(); // if (n의 왼쪽 자식==null) n의 오른쪽 자식 반환
        n.setLeft(deleteMin(n.getLeft())); // if (n의 왼쪽 자식!=null) n의 왼쪽 자식으로 순환 호출
        return n;
    }

    public void delete(Key k) {
        root = delete(root, k);
    }
    public BSTNode delete(BSTNode n, Key k) {
        if(n == null)
            return null;

        int t = n.getKey().compareTo(k);
        if(t > 0)
            n.setLeft(delete(n.getLeft(), k)); // if (k < 노드 n의 id) 왼쪽 자식으로 이동
        else if (t < 0)
            n.setRight(delete(n.getRight(), k)); // if (k > 노드 n의 id) 오른쪽 자식으로 이동
        else { // 삭제할 노드 발견
            if(n.getRight() == null)
                return n.getLeft(); // case 0, 1
            if(n.getLeft() == null)
                return n.getRight(); // case 1

            BSTNode target = n; // case 2 Line82-85
            n = min(target.getRight()); // 삭제할 노드 자리로 옮겨올 노드 찾아서 n이 가리키게 함
            n.setRight(deleteMin(target.getRight()));
            n.setLeft(target.getLeft());
        }
        return n;
    }
}
