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
        if (n == null) return null;

        int t = k.compareTo((Key) n.getKey());
        if (t < 0) {
            n.setLeft(delete_mod(n.getLeft(), k));
        } else if (t > 0) {
            n.setRight(delete_mod(n.getRight(), k));
        } else {
            if (n.getLeft() == null) return n.getRight();
            if (n.getRight() == null) return n.getLeft();

            Node<Key, Value> maxNode = max(n.getLeft());
            n.setKey(maxNode.getKey());
            n.setValue(maxNode.getValue());
            n.setLeft(deleteMax(n.getLeft()));
        }
        return n;
    }

    // 비재귀적으로 트리에 key를 삽입하는 메소드
    public void put_mod(Key k, Value v) {
        Node newNode = new Node(k, v); // 새 노드 생성

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent;

        while (true) {
            parent = current; // 현재 노드를 부모 노드로 설정

            int t = current.getKey().compareTo(k);
            if (t > 0) { // 현재 노드의 키가 새 키보다 큰 경우
                current = current.getLeft(); // 왼쪽 자식으로 이동
                if (current == null) { // 왼쪽 자식이 없으면 새 노드를 여기에 삽입
                    parent.setLeft(newNode);
                    return;
                }
            } else if (t < 0) { // 현재 노드의 키가 새 키보다 작은 경우
                current = current.getRight(); // 오른쪽 자식으로 이동
                if (current == null) { // 오른쪽 자식이 없으면 새 노드를 여기에 삽입
                    parent.setRight(newNode);
                    return;
                }
            } else { // 현재 노드의 키가 새 키와 같은 경우
                current.setValue(v); // 값을 업데이트하고 종료
                return;
            }
        }
    }

    public void inorder(Node n) {
        if (n != null) {
            inorder(n.getLeft());
            System.out.print(n.getKey() + " ");
            inorder(n.getRight());
        }
    }
}
