package lecture.ch04Tree;

import java.util.*;
public class BinaryTree<Key extends Comparable<Key>> {
    private Node root;
    public BinaryTree() { root = null; } // 트리 생성자
    public Node getRoot() { return root; }
    public void setRoot(Node newRoot) { root = newRoot; }
    public boolean isEmpty() { return root == null; }

    // preorder(), inorder(), postorder(), levelorder(), size(), height(), isEqual() 메소드 선언

    public void preorder(Node n) { // 전위 순회
        if(n != null) {
            System.out.print(n.getKey() + " "); // 노드 n 방문
            preorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
            preorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
        }
    }

    public void inorder(Node n) { // 중위 순회
        if(n != null) {
            inorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
            System.out.print(n.getKey() + " ");
            inorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
        }
    }

    public void postorder(Node n) { // 후위 순회
        if(n != null) {
            postorder(n.getLeft()); // n의 왼쪽 서브트리를 순회하기 위해
            postorder(n.getRight()); // n의 오른쪽 서브트리를 순회하기 위해
            System.out.print(n.getKey() + " ");
        }
    }

    public void levelorder(Node n) { // 레벨 순회
        Queue<Node> q = new LinkedList<Node>(); // 큐 자료구조 이용
        Node t;
        q.add(root); // 루트 큐에 삽입
        while (!q.isEmpty()) {
            t = q.remove(); // 큐에서 가장 앞에 있는 노드 제거
            System.out.print(t.getKey() + " "); // 제거된 노드 출력(방문)
            if(t.getLeft() != null) // 제거된 왼쪽 자식이 null이 아니면
                q.add(t.getLeft()); // 큐에 왼쪽 자식 삽입
            if(t.getRight() != null) // 제거된 오른쪽 자식이 null이 아니면
                q.add(t.getRight()); // 큐에 오른쪽 자식 삽입
        }
    }

    public int size(Node n) { // n을 루트로 하는 (서브)트리에 있는 노드 수
        if(n == null)
            return 0; // null이면 0 반환
        else
            return (1 + size(n.getLeft()) + size(n.getRight()));
    }

    public int height(Node n) { // n를 루트로 하는 (서브)트리의 높이
        if(n == null)
            return 0; // null이면 0 반환
        else
            return (1 + Math.max(height(n.getLeft()), height(n.getRight())));
    }

    public static boolean isEqual(Node n, Node m) { // 두 트리의 동일성 검사
        if(n==null || m==null) // 둘 중에 하나라도 null이면
            return  n == m; // 둘 다 null이면 true, 아니면 false

        if(n.getKey().compareTo(m.getKey()) != 0) // 둘 다 null이 아니면 item 비교
            return false;

        return (isEqual(n.getLeft(), m.getRight()) && // item이 같으면 왼쪽 자식 순환 호출
                isEqual(n.getLeft(), m.getRight())); // 오른쪽 자식 순환 호출
    }
}
