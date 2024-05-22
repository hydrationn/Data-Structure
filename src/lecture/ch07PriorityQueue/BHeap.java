package lecture.ch07PriorityQueue;

public class BHeap <Key extends Comparable<Key>, Value> {
  private Entry[] a; // a[0]은 사용 안 함
  private int N; // 힙의 크기
  public BHeap(Entry[] harray, int initialSize) { // 생성자
    a = harray;
    N = initialSize;
  }
  public int size() { return N; } // 힙의 크기 반환
  private void swap(int i, int j) { // a[i]와 a[j]를 교환
    Entry temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  private boolean greater(int i, int j) {
    return a[i].getKey().compareTo(a[j].getKey()) > 0;
  }

  // createheap, 삽입, 최솟값 삭제, downheap, upheap 메소드 선언

  public Entry deleteMin() {
    Entry min = a[1];
    swap(1, N--);
    a[N+1] = null;
    downheap(1);
    return min;
  }

  private void downheap(int i) {
    while (2*i <= N) {
      int k = 2 *i;
      if(k < N && greater(k, k+1))
        k++;
      if(!greater(i, k))
        break;
      swap(i, k);
      i = k;
    }
  }

  public void insert(Key newKey, Value newValue) {
    Entry temp = new Entry(newKey, newValue);
    a[++N] = temp;
    upheap(N);
  }

  private void upheap(int j) {
    while (j > 1 && greater(j/2, j)) {
      swap(j/2, j);
      j = j/2;
    }
  }

  public void createHeap() { // 초기 힙 만들기
    for(int i = N/2; i > 0; i++) {
      downheap(i);
    }
  }

  public void print() {
    for(Entry e: a) {
      if(e == null)
        continue;
      System.out.print("[" + e.getKey()+ " " + e.getValue() + "] ");
    }
    System.out.println();
  }
}
