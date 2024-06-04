package lecture.ch08Sort;

import java.lang.Comparable;

public class Merge {
  private static void merge(Comparable[] a, Comparable[] b, int low, int mid, int high) {
    int i = low, j = mid+1;
    for (int k = low; k <= high; k++) { // 배열 a의 앞부분과 뒷부분을 합병하여 보조 배열 b에 저장
      if (i > mid) // 앞부분이 먼저 소진된 경우
        b[k] = a[j++];
      else if (j > high) // 뒷부분이 먼저 소진된 경우
        b[k] = a[i++];
      else if (isless(a[j], a[i])) { // a[j]가 승자
        b[k] = a[j++];
      }
      else // a[i]가 승자
        b[k] = a[i++];
    }

    for (int k = low; k <= high; k++) // 보조 배열 b를 배열 a에 복사
      a[k] = b[k];
  }

  private static void sort(Comparable[] a, Comparable[] b, int low, int high) {
    if (high <= low)
      return;

    int mid = low + (high - low) / 2;
    sort(a, b, low, mid); // 앞부분 순환 호출
    sort(a, b, mid+1, high); // 뒷부분 순환 호출
    merge(a, b, low, mid, high); // 합병 수행
  }

  public static void sort(Comparable[] a) {
    Comparable[] b = new Comparable[a.length];
    sort(a, b, 0, a.length-1);
  }

  public static boolean isless(Comparable v, Comparable w) {
    return (v.compareTo(w) < 0);
  }
}
