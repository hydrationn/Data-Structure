package lecture.ch01DataStructure;

/*
// 무한 호출 Recursion class, StackOverflowError가 발생한다.
public class Recursion {
    public void recurse() {
        System.out.println("*");
        recurse();
    }
    public static void main(String[] args) {
        Recursion r = new Recursion();
        r.recurse();
    }
}
*/

public class Recursion {
    public void recurse(int count) {
        if (count <= 0)
            System.out.println(".");
        else {
            System.out.println(count + " *");
            recurse(count-1);
        }
    }
    public static void main(String[] args) {
        Recursion r = new Recursion();
        r.recurse(5);
    }
}