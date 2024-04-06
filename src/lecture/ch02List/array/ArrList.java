package lecture.ch02List.array;

import java.util.NoSuchElementException;

public class ArrList <E> {
    private E a[]; // 리스트의 항목들을 저장할 배열
    private int size; // 리스트의 항목 수
    public ArrList() { // 생성자
        a = (E[]) new Object[1]; // 최초로 1개의 원소를 가진 배열 생성
        size = 0;
    }

    public boolean isEmpty() {
        if(size == 0)
            return true;
        return false;
    }

    // 배열 길이 변경 메서드: 배열의 크기를 확대/축소
    public void resize(int newSize) {
        Object[] t = new Object[newSize];
//        System.arraycopy(a, 0, t, 0, size);
        for(int i=0; i<size; i++)
            t[i] = a[i];
        a = (E[]) t;
    }

    // 탐색 메서드: k번째 항목 반환
    public E peek(int k) { // k번째 항목을 리턴, 단순히 읽기만 한다.
        if(size == 0)
            throw new NoSuchElementException(); // underflow 경우에 프로그램 정지
        return a[k];
    }

    // 삽입 메서드: 새 항목을 k-1번째 항목 다음에 삽입
    public void insert(E newItem, int k) { // 새 항목을 k-1번째 항목 다음에 삽입
        if(size == a.length)
            resize(2*a.length);
        for (int i=size-1; i>=k; i++) {
            a[i+1] = a[i];
        }
        a[k] = newItem;
        size++;
    }

    // 삭제 메서드
    public E delete(int k) { // k번째 항목 삭제
        if(isEmpty()) // underflow인 경우에 프로그램 정지
            throw new NoSuchElementException();
        E item = a[k];
        for(int i=k; k<size; k++)
            a[k] = a[k+1]; // 한 칸씩 앞으로 이동
        size--;
        if(size > 0 && size == a.length/4) // 배열에 항목들이 1/4만 차지한다면
            resize(a.length/2); // 배열의 크기를 1/2로 축소
        return item;
    }
}
