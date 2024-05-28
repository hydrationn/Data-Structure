package lab.lab20240521;

public class AVLTree<Key extends Comparable<Key>, Value> {
  public Node root;

  public Node getRoot() {
    return root;
  }

  public AVLTree() {
    root = null;
  }

  public AVLTree(Key newId, Value newName, int n) { // AVL 생성자
    root = new Node(newId, newName, n);
  }

  // get, put, min, deleteMin, delete
  // 메소드들 선언

  private Node rotateRight(Node n) {
    Node x = n.left;
    n.left = x.right;
    x.right = n;
    n.height = tallerHeight(height(n.left), height(n.right)) + 1;
    x.height = tallerHeight(height(x.left), height(x.right)) + 1;
    return x;
  }

  private Node rotateLeft(Node n) {
    Node x = n.right;
    n.right = x.left;
    x.left = n;
    n.height = tallerHeight(height(n.left), height(n.right)) + 1;
    x.height = tallerHeight(height(x.left), height(x.right)) + 1;
    return x;
  }

  public void put(Key k, Value v) {
    root = put(root, k, v);
  }
  private Node put(Node n, Key k, Value v) {
    if (n == null) {
      return new Node(k, v, 1);
    }

    int t = k.compareTo((Key) n.id);
    if (t < 0) {
      n.left = put(n.left, k, v);
    } else if (t > 0) {
      n.right = put(n.right, k, v);
    } else {
      n.name = v; // k가 이미 트리에 있으므로 v만 갱신
      return n;
    }

    n.height = tallerHeight(height(n.left), height(n.right)) + 1;
    return balance(n); // 노드 n의 균형 점검 및 불균형을 바로 잡음
  }

  private Node balance(Node n) {
    if (bf(n) > 1) { // 노드 n의 왼쪽 서브트리가 높아서 불균형 발생
      // LR-회전
      if (bf(n.left) < 0) { // 노드 n의 왼쪽 자식 노드의 오른쪽 서브트리가 높은 경우
        n.left = rotateLeft(n.left); // --
      } //                                | LR-회전
      n = rotateRight(n); // LL-회전     --
    }
    else if (bf(n) < -1) { // 노드 n의 오른쪽 서브트리가 높아서 불균형 발생
      if(bf(n.right) > 0) { // 노드 n의 오른쪽 자식 노드의 왼쪽 서브트리가 높은 경우
        n.right = rotateRight(n.right); // --
      } //                                   | RL-회전
      n = rotateLeft(n); // RR-회전         --
    }
    return n;
  }

  // bf(n): (노드 n의 왼쪽 서브트리 높이)-(오른쪽 서브트리 높이) 반환
  private int bf(Node n) {
    return height(n.left) - height(n.right);
  }

  private int height(Node n) {
    if (n == null) {
      return 0;
    }

    return n.height;
  }

  private int tallerHeight(int x, int y) {
    if (x > y) {
      return x;
    } else {
      return y;
    }
  }


  // min 메서드 이용 삭제 방법
  private Node min(Node n) {
    if(n.left == null)
      return n;
    return min(n.left);
  }
  public Node deleteMin(Node n) {
    if(n.left == null)
      return n.right; // if (n의 왼쪽 자식==null) n의 오른쪽 자식 반환
    n.left = deleteMin(n.left); // if (n의 왼쪽 자식!=null) n의 왼쪽 자식으로 순환 호출
    return balance(n); // 불균형 처리 후 반환
  }

  public void delete_min(Key k) {
    root = delete_min(root, k);
  }
  public Node delete_min(Node n, Key k) {
    if (n == null)
      return null;

    int t = n.id.compareTo(k);

    if (t > 0) { // if (k < 노드 n의 id) 왼쪽 자식으로 이동
      n.left = delete_min(n.left, k);
    } else if (t < 0) { // if (k > 노드 n의 id) 오른쪽 자식으로 이동
      n.right = delete_min(n.right, k);
    } else {
      if (n.right == null) return n.left; // case 0, 1
      if (n.left == null) return n.right; // case 1

      Node target = n; // case 2
      n = min(target.right); // 삭제할 노드 자리로 옮겨올 노드를 찾아 n이 가리키게 함
      n.right = deleteMin(target.right);
      n.left = target.left;
    }
    return balance(n); // 불균형 처리 후 반환
  }


  // max 메서드 이용 삭제 방법
  private Node max(Node n) {
    if(n.right == null)
      return n;
    return max(n.right);
  }
  public Node deleteMax(Node n) {
    if(n.right == null)
      return n.left;
    n.right = deleteMax(n.right);
    return balance(n); // 불균형 처리 후 반환
  }

  public void delete_max(Key k) {
    root = delete_max(root, k);
  }
  public Node delete_max(Node n, Key k) {
    if (n == null)
      return null;

    int t = n.id.compareTo(k);

    if (t > 0) { // if (k < 노드 n의 id) 왼쪽 자식으로 이동
      n.left = delete_max(n.left, k);
    } else if (t < 0) { // if (k > 노드 n의 id) 오른쪽 자식으로 이동
      n.right = delete_max(n.right, k);
    } else {
      if (n.right == null) return n.left; // case 0, 1
      if (n.left == null) return n.right; // case 1

      Node target = n; // case 2
      n = max(target.left); // 삭제할 노드 자리로 옮겨올 노드를 찾아 n이 가리키게 함
      n.left = deleteMax(target.left);
      n.right = target.right;
    }
    return balance(n); // 불균형 처리 후 반환
  }


  public void inorder_mod(Node n) {
    if (n != null) {
      inorder_mod(n.left);
      System.out.print("(" + n.id + ", " + bf(n) + ") ");
      inorder_mod(n.right);
    }
  }
}
