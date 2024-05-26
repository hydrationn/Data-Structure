package lab.lab20240514;

public class BST <Key extends Comparable<Key>, Value> {
    private Node root;
    public Node getRoot() { return root; }
    public BST() {
        root = null;
    }

    public BST(Key newId, Value newName) {
        root = new Node<>(newId, newName);
    }

    public Key max() {
        if(root == null)
            return null;
        return (Key) max(root).getKey();
    }

    private Node max(Node n) {
        if(n.getRight() == null)
            return n;
        return max(n.getRight());
    }

    // 트리에서 최댓값을 삭제하는 메소드
    public void deleteMax() {
        if (root == null)
            System.out.println("empty 트리");
        root = deleteMax(root);
    }

    public Node deleteMax(Node n) {
        if(n.getRight() == null)
            return n.getLeft();
        n.setRight(deleteMax(n.getRight()));
        return n;
    }

    // 왼쪽 서브 트리에서 최댓값을 가지는 노드를 이용해 삭제를 수행하는 메소드
    public void delete_mod(Key k) {
        root = delete_mod(root, k);
    }

    public Node delete_mod(Node n, Key k) {
        if (n == null)
            return null;

        int t = n.getKey().compareTo(k);

        if (t > 0) { // if (k < 노드 n의 id) 왼쪽 자식으로 이동
            n.setLeft(delete_mod(n.getLeft(), k));
        } else if (t < 0) { // if (k > 노드 n의 id) 오른쪽 자식으로 이동
            n.setRight(delete_mod(n.getRight(), k));
        } else {
            if (n.getLeft() == null) return n.getRight(); // case 0, 1
            if (n.getRight() == null) return n.getLeft(); // case 1

            Node target = n; // case 2
            n = max(target.getLeft()); // 삭제하 ㄹ노드 자리로 옮겨올 노드를 찾아 n이 가리키게 함
            n.setLeft(deleteMax(target.getLeft()));
            n.setRight(target.getRight());
        }
        return n;
    }

    // 비재귀적으로 트리에 key를 삽입하는 메소드
    public void put_mod(Key k, Value v) {
        root = put_mod(root, k, v);
    }
    public Node put_mod(Node n, Key k, Value v) {
        if (n == null)
            return new Node(k, v);

        Node node = root; // 갱신시킬 노드 선언

        while (true) {
            int t = n.getKey().compareTo(k);

            if (t > 0) { // if (k < 노드 n의 id) 왼쪽 자식으로 이동
                if (n.getLeft() == null) {
                    n.setLeft(new Node<>(k, v));
                    break;
                } else {
                    n = n.getLeft();
                }
            } else if (t < 0) { // if (k > 노드 n의 id) 오른쪽 자식으로 이동
                if (n.getRight() == null) {
                    n.setRight(new Node<>(k, v));
                    break;
                } else {
                    n = n.getRight();
                }
            } else {  // if (k == 노드 n의 id) node 값 갱신
                n.setValue(v);
                break;
            }
        }
        return node; // 갱신된 트리의 루트 노드 반환
    }

    public void inorder(Node n) {
        if (n != null) {
            inorder(n.getLeft());
            System.out.print(n.getKey() + " ");
            inorder(n.getRight());
        }
    }
}
