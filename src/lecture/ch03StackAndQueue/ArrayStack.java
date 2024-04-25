package lecture.ch03StackAndQueue;

import java.util.EmptyStackException; // java.util 라이브러리에 선언된 클래스를 이용하여 underflow 발생 시 프로그램 종료
public class ArrayStack<E> {
    private E s[]; // 스택을 위한 배열
    private int top; // 스택의 top 항목의 배열 원소 인덱스
    public ArrayStack() { // 스택 생성자
        s = (E[]) new Object[1]; // 초기에 크기가 1인 배열 생성
        top = -1;
    }
    public int size() { return top + 1; } // 스택이 있는 항목의 수 반환
    public boolean isEmpty() { return (top == -1); } // 스택이 empty이면 true 반환

    // peek(), push(), pop(), resize() 메소드 선언

    // peek(): 스택의 top에 있는 항목 반환
    public E peek() { // 스택 top 항목의 내용만을 반환
        if (isEmpty())
            throw new EmptyStackException(); // underflow 시 프로그램 정지
        return s[top];
    }

    // push(): 새 항목을 스택에 삽입 -> overflow가 발생하면, resize()를 호출하여 배열을 2배로 확장
    public void push(E newItem) { // push 연산
        if (size() ==  s.length)
            resize(2*s.length); // 스택을 2배의 크기로 확장
        s[++top] = newItem; // 새 항목을 push
    }

    // pop(): 스택 top 항목 삭제 -> 스택 항목 수가 배열 s의 1/4만 차지하면, resize()를 호출하여 배열 s의 크기를 1/2로 축소
    public E pop() { // pop 연산
        if (isEmpty())
            throw new EmptyStackException(); // underflow 시 프로그램 정지
        E item = s[top];
        s[top--] = null;
        if (size() > 0 && size()==s.length/4)
            resize(s.length/2);
        return item;
    }

    // resize(): 배열의 크기를 확대/축소
    public void resize(int newSize) {
        Object[] t = new Object[newSize];
//        System.arraycopy(s, 0, t, 0, s.length); // 아래와 같은 의미
        for(int i=0; i<top; i++)
            t[i] = s[i];
        s = (E[]) t;
    }
}
