package lecture.ch06HashTable;

public class Chaining<K, V> {
  private int M = 13; // 테이블 크기
  private Node[] a = new Node[M]; // 해시 테이블
  public static class Node { // Node 클래스
    private Object key;
    private Object data;
    private Node next;
    public Node(Object newKey, Object newData, Node ref) {
      key = newKey;
      data = newData;
      next = ref;
    }
    public Object getKey() { return key; }
    public Object getData() { return data; }
  }

  private int hash(K key) { // 해시 코드
    return (key.hashCode() & 0x7fffffff) % M; // 나눗셈 연산
  }

  public V get(K key) { // 탐색 연산
    int i = hash(key);
    for (Node x = a[i]; x != null; x = x.next) // 연결 리스트 탐색
      if (key.equals(x.key))
        return (V) x.data; // 탐색 성공
    return null; // 탐색 실패
  }

  private void put(K key, V data) { // 삽입 연산
    int i = hash(key);
    for (Node x = a[i]; x != null; x = x.next)
      if (key.equals(x.key)) { // 이미 key 존재
        x.data = data; // 데이터만 갱신
        return;
      }
    a[i] = new Node(key, data, a[i]); // 연결 리스트의 첫 노드로 삽입
  }
}
