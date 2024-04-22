package lab.lab20240416;

import java.io.*;
import java.util.StringTokenizer;

public class MainJava {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/hydrationn/datastructure01/input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                ListStack<String> SStack = new ListStack<>();
                StringTokenizer parser = new StringTokenizer(line, " ");

                while (parser.hasMoreTokens()) {
                    String token = parser.nextToken();

                    // 토큰이 연산자인 경우
                    if ("+ - * / (".contains(token)) {
                        while (!SStack.isEmpty() && in_priority(SStack.peek()) >= out_priority(token)) {
                            System.out.print(SStack.pop() + " ");
                        }
                        SStack.push(token);
                    } else if (token.equals(")")) {
                        while (!SStack.isEmpty() && !SStack.peek().equals("(")) {
                            System.out.print(SStack.pop() + " ");
                        }
                        SStack.pop(); // 여는 괄호 '(' 제거
                    } else {
                        // 토큰이 피연산자인 경우
                        System.out.print(token + " ");
                    }
                }

                // 스택에 남은 모든 연산자 출력
                while (!SStack.isEmpty()) {
                    System.out.print(SStack.pop() + " ");
                }

                line = br.readLine();
                System.out.println();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.print("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    static int out_priority(String input) {

        // "+, - *, /, (" 중의 하나인 연산자가 스택 밖에 있을 때
        // 우선 순위를 나타내는 메소드

        if (input.equals("+") || input.equals("-")) {
            return 1;
        } else if (input.equals("*") || input.equals("/")) {
            return 2;
        } else if (input.equals("(")) {
            return 3; // 스택 밖에서 '(' 가장 높은 우선순위 부여
        }

        return -1;
    }

    static <E> int in_priority(E input) {

        // "+, - *, /, (" 중의 하나인 연산자가 스택 안에 있을 때
        // 우선 순위를 나타내는 메소드

        if (input.equals("+") || input.equals("-")) {
            return 1;
        } else if (input.equals("*") || input.equals("/")) {
            return 2;
        } else {
            return -1;
        }
    }
}

