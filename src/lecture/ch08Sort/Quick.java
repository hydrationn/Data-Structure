package lecture.ch08Sort;

import java.lang.Comparable;

public class Quick {
  public static void sort(Comparable[] a) {
    sort(a, 0, a.length-1);
  }

  private static void sort(Comparable[] a, int low, int high) {
    if (high <= low)
      return;

    int j = partition(a, low, high);
    sort(a, low, j-1); // 피벗보다 작은 부분 순환 호출
    sort(a, j+1, high); // 피벗보다 큰 부분 순환 호출
  }

  private static int partition(Comparable[] a, int pivot, int high) {
    int i = pivot;
    int j = high + 1;
    Comparable p = a[pivot];
    while (true) {
      while (isless(a[++i], p)) // 피벗보다 작으면
        if (i == high)
          break;
      while (isless(p, a[--j])) // 피벗보다 크면
        if (j == pivot)
          break;
      if (i >= j) // i와 j가 교차되면 루프 나가기
        break;
      swap(a, i, j);
    }
    swap(a, pivot, j); // 피벗과 a[j] 교환
    return j; // a[j]의 피벗이 "영원히" 자리 잡은 곳
  }

  private static boolean isless(Comparable u, Comparable v) {
    return (u.compareTo(v) < 0);
  }

  private static void swap(Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
}
