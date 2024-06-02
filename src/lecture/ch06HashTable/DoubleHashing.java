package lecture.ch06HashTable;

public class DoubleHashing<K, V> {
  private int N = 0, M = 13; // 테이블 크기
  private K[] a = (K[]) new Object[M]; // 해시 테이블
  private V[] dt = (V[]) new Object[M]; // key 관련 데이터 저장

  private int hash(K key) {
    return key.hashCode() & 0x7fffffff % M; // 나눗셈 함수
  }

  private void put(K key, V data) {
    int initialpos = hash(key); // 초기 위치
    int i = initialpos, loop_limit = 20; // 저장 시도 횟수 제한
    int j = 1;
    int d = (7 - (int)key % 7); // 두 번째 해시 함수, d(key) = 7 - key % 7
    do {
      if (a[i] == null) { // 삽입 위치 발견
        a[i] = key; // key를 해시 테이블에 저장
        dt[i] = data; // key 관련 데이터 저장
        N++;
        return;
      }
      if (a[i].equals(key)) { // 이미 key 존재
        dt[i] = data; // 데이터만 갱신
        return;
      }
      i = (initialpos + j*d) % M; // i = 다음 위치
      j++;
      loop_limit -= 1;
    } while (loop_limit > 0);
  }

  public V get(K key) {
    int initialpos = hash(key); // 초기 위치
    int i = initialpos, loop_limit = 20; // 탐색 횟수 제한
    int j = 1;
    int d = (7 - (int) key % 7);
    while (a[i] != null & loop_limit > 0) {
      if (a[i].equals(key))
        return dt[i]; // 탐색 성공
      i = (initialpos + j*d) % M; // i = 다음 위치
      j++;
      loop_limit -= 1;
    }
    return null; // 탐색 실패
  }
}
