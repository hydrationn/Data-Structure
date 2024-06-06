package lab.lab20240528;

public class Heap<Key extends Comparable<Key>, Value> {
  private Entry<Key, Value>[] a;
  private int N;
  private boolean isMinHeap;

  public Heap(int capacity, boolean isMinHeap) {
    a = new Entry[capacity + 1];
    this.isMinHeap = isMinHeap;
    N = 0;
  }

  private void upheap(int k) {
      while (k > 1 && greater(k/2, k)) {
        swap(k/2, k);
        k = k/2;
      }
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

  public Entry peekRoot() {
    // 최상단 원소 접근 메서드
    if (N > 0)
      return a[1];
    else
      return null;
  }

  private void swap(int i, int j) {
    Entry temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }

  public void insert(Key newKey, Value newValue) {
    Entry temp = new Entry<>(newKey, newValue);
    a[++N] = temp;
    upheap(N);
  }

  public int size() {
    return N;
  }

  public Entry deleteRoot() {
    Entry min = a[1];
    swap(1, N--);
    a[N+1] = null;
    downheap(1);
    return min;
  }

  private boolean greater(int i, int j) {
    if (isMinHeap == true)
      return a[i].getKey().compareTo(a[j].getKey()) > 0;
    else
      return a[i].getKey().compareTo(a[j].getKey()) < 0;
  }
}
