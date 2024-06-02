package lecture.ch06HashTable;

public class QuadProbing<K, V> {
  private int N = 0, M = 13; // 테이블 크기
  private K[] a = (K[]) new Object[M]; // 해시 테이블
  private V[] d = (V[]) new Object[M]; // key 관련 데이터 저장

  private int hash(K key) {
    return key.hashCode() & 0x7fffffff % M; // 나눗셈 함수
  }

  private void put(K key, V data) { // 삽입 연산
    int initialpos = hash(key); // 초기 위치
    int i = initialpos, j = 1, loop_limit = 20; // 저장 시도 횟수 제한
    do {
      if (a[i] == null) { // 삽입 위치 발견
        a[i] = key; // key 관련 해시 테이블에 저장
        d[i] = data; // key 관련 데이터 저장
        N++;
        return;
      }
      if (a[i].equals(key)) { // 이미 key 존재
        d[i] = data; // data만 갱신
      }
      i = (initialpos + j*j++) % M; // i = 다음 위치
      loop_limit -= 1;
    } while (loop_limit > 0);
  }

  public V get(K key) { // 탐색 연산
    int initialpos = hash(key);
    int i = initialpos, j = 1, loop_limit = 20; // 탐색 횟수 제한
    while (a[i] != null & loop_limit > 0) {
      if (a[i].equals(key))
        return d[i]; // 탐색 성공
      i = (initialpos + j*j++) % M; // i = 다음 위치
      loop_limit -= 1;
    }
    return null; // 탐색 실패
  }
}
