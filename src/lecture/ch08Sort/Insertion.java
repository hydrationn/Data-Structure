package lecture.ch08Sort;

import java.lang.Comparable;

public class Insertion {
  public static void sort(Comparable[] a) {
    int N = a.length;
    for (int i = 1; i < N; i++) { // i는 현재 원소의 인덱스
      for (int j = i; j > 0; j--) { // 현재 원소를 정렬된 앞부분에 삽입
        if (isless(a[j], a[j-1]))
          swap(a, j, j-1);
        else break;
      }
    }
  }

  // isless(), swap() 메소드 선언, Selection 클래스와 동일
  private static boolean isless(Comparable i, Comparable j) { // 키 비교
    return (i.compareTo(j) < 0);
  }

  private static void swap(Comparable[] a, int i, int j) { // 원소 교환
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
