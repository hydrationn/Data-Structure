package lab.lab20240410;

public class MainLab {
    public static void main(String[] args) {
        int size = 50;
        String s = "I go to school";
        ArrayStack<Character> A = new ArrayStack<Character>(size);

        // String을 Array로 변환
        char[] arr = new char[s.length()];
        for(int i=0; i<s.length(); i++) {
            arr[i] = s.charAt(i);
        }

        for(int i = 0; i < arr.length; i++) {
            // 공백이 아니면 스택에 문자 추가
            if (arr[i] != ' ') {
                A.push(arr[i]);
            }

            // pop하면서 출력
            if (arr[i] == ' ' || i == arr.length-1) {
                while (!A.isEmpty()) {
                    System.out.print(A.pop());
                }

                // 공백 문자 출력
                System.out.print(" ");
            }
        }
    }
}
