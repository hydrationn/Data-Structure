package lecture.ch05SearchTree;

public class AVL<Key extends Comparable<Key>, Value> {
    public AVLNode root;
    public AVLNode getRoot() { return root; }
    public AVL(Key newId, Value newName, int n) { // AVL 생성자
        root = new AVLNode(newId, newName, n);
    }

    // get, put, min, deleteMin, delete
    // 메소드들 선언

    private AVLNode rotateRight(AVLNode n) {
        AVLNode x = n.left;
        n.left = x.right;
        x.right = n;
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        x.height = tallerHeight(height(x.left), height(x.right)) + 1;
        return x;
    }

    private AVLNode rotateLeft(AVLNode n) {
        AVLNode x = n.right;
        n.right = x.left;
        x.left = n;
        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        x.height = tallerHeight(height(x.left), height(x.right)) + 1;
        return x;
    }

    public void put(Key k, Value v) { root = put(root, k, v); }
    private AVLNode put(AVLNode n, Key k, Value v) {
        if(n == null)
            return new AVLNode(k, v, 1);

        int t = k.compareTo((Key) n.id);
        if(t < 0)
            n.left = put(n.left, k, v);
        else if(t > 0)
            n.right = put(n.right, k, v);
        else {
            n.name = v; // k가 이미 트리에 있으므로 v만 갱신
            return n;
        }

        n.height = tallerHeight(height(n.left), height(n.right)) + 1;
        return balance(n); // 노드 n의 균형 점검 및 불균형을 바로 잡음
    }

    private AVLNode balance(AVLNode n) {
        if (bf(n) > 1) { // 노드 n의 왼쪽 서브트리가 높아서 불균형 발생
            // LR-회전
            if (bf(n.left) < 0) { // 노드 n의 왼쪽 자식 노드의 오른쪽 서브트리가 높은 경우
                n.left = rotateLeft(n.left); // --
            } //                                  | LR-회전
            n = rotateRight(n); // LL-회전       --
        }
        else if (bf(n) < -1) { // 노드 n의 오른쪽 서브트리가 높아서 불균형 발생
            if(bf(n.right) > 0) { // 노드 n의 오른쪽 자식 노드의 왼쪽 서브트리가 높은 경우
                n.right = rotateRight(n.right); // --
            } //                                     | RL-회전
            n = rotateLeft(n); // RR-회전           --
        }
        return n;
    }

    // bf(n): (노드 n의 왼쪽 서브트리 높이)-(오른쪽 서브트리 높이) 반환
    private int bf(AVLNode n) {
        return height(n.left) - height(n.right);
    }

    private int height(AVLNode n) {
        if(n == null)
            return 0;

        return n.height;
    }

    private int tallerHeight(int x, int y) {
        if(x > y)
            return x;
        else
            return y;
    }
}
