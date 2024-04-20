package lecture.ch01DataStructure;

// 팩토리얼 계산 자바 프로그램

// 1. Recursion 이용
public class Factorial {
    public static int factorial(int n) {
        if (n <= 1)
            return 1;
        else
            return n*factorial(n-1);
    }
    public static void main(String[] args) {
        int result;
        result = factorial(4);
        System.out.println(result);
    }
}


/*

// 2. 반복문 이용
// 메소드 호출로 인해 시스템 스택을 사용하지 않으므로 순환을 이용한 계산보다 매우 간단하며 메모리도 적게 사용
public class Factorial {
    public static void main(String[] args) {
        int n = 4;
        int result = 1;
        for (int i = 0; i <= n; i ++)
            result = result * i;
        System.out.println(result);
    }
}
*/

