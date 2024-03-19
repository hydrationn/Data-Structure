package lab20240312;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Recursion {
    public static void main(String[] args) {
        System.out.print("print_pathA(0): ");
        print_pathA(0);

        System.out.print("print_pathB(0): ");
        print_pathB(0);
    }

    public static void print_pathA(int start) {
        try {
            File file = new File("/Users/hydrationn/datastructure01/input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine(); // 라인 별로 읽어주고

            StringTokenizer parser = new StringTokenizer(line, " "); // 한 라인 안에서 " "을 기준으로 읽어준다.
            int length = parser.countTokens(); // 공백을 기준으로 parser.countTockens으로 배열 길이 정하기

            // 길이 알았으니 배열 세워주고, 채워주기
            int[] A = new int[length];
            for(int i = 0; i < length; i++) {
                A[i] = Integer.parseInt(parser.nextToken());
            }

            /*
             * 0에서 시작
             * 지점 0에서 A[0] = 2 값을 가지므로 2 출력
             * 지점 2에서 A[2] = 4 값을 가지므로 4 출력
             * 지점 4에서 A[4] = 3 값을 가지므로 3 출력
             * 지점 3에서 A[3] = 1 값을 가지므로 1 출력
             * 지점 1에서 A[1] = 0이므로 마지막 0 출력
             * 하고 끝
             * */

            System.out.print(start + " ");

            int end = A[start];

            if(end == 0) {
                System.out.println(0 + " ");
                return;
            }

            print_pathA(end);

            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException");
        } catch (IOException e) {
            throw new RuntimeException("IOException");
        }

    }

    public static void print_pathB(int start) {
        try {
            File file = new File("/Users/hydrationn/datastructure01/input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            StringTokenizer parser = new StringTokenizer(line, " ");
            int length = parser.countTokens();

            String[] B = new String[length];
            for(int i = 0; i < length; i++) {
                B[i] = parser.nextToken();
            }

            /*
             * 0에서 시작
             * 0 = B[1]. 즉, 1번째 자리에서 이동하여 왔으므로 1 출력
             * 1 = B[3]. 즉, 3번째 자리에서 이동하여 왔으므로 3 출력
             * 3 = B[4]. 즉, 4번째 자리에서 이동하여 왔으므로 4 출력
             * 4 = B[2]. 즉, 2번째 자리에서 이동하여 왔으므로 2 출력
             * 2 = B[0]. 즉, 3번째 자리에서 이동하여 왔으므로 0 출력
             * 하고 끝
             * */

            br.close();

            System.out.print(start + " ");

            int startIndex = Arrays.asList(B).indexOf(Integer.toString(start));

            if(startIndex == 0) {
                System.out.println(0);
                return;
            }

            print_pathB(startIndex);

            /*for (int j = 0; j < B.length; j++) {
                int startIndex = Arrays.asList(B).indexOf(Integer.toString(start));
                System.out.print(startIndex + " ");
                start = startIndex;
            }*/

        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException");
        } catch (IOException e) {
            throw new RuntimeException("IOException");
        }
    }
}