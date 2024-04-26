package lab.lab20240319;

import java.io.*;
import java.util.StringTokenizer;

public class ArrayAssignment {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/hydrationn/datastructure01/input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            // 한 줄씩 읽어서 가능하도록
            String line = br.readLine(); // 라인 별로 읽어주고

            while (line != null) {
                StringTokenizer parser = new StringTokenizer(line, " "); // 한 라인 안에서 " "을 기준으로 읽어준다.
                int length = parser.countTokens(); // 공백을 기준으로 parser.countTockens으로 배열 길이 정하기

                // 길이 알았으니 배열 세워주고, 채워주기
                int[] arr = new int[length];
                for(int i = 0; i < length; i++) {
                    arr[i] = Integer.parseInt(parser.nextToken());
                }

                System.out.print("INPUT: ");
                for(int i = 0; i < length; i++) {
                    System.out.print(arr[i] + " ");
                }

                System.out.println();

                int temp;
                int evenNum = 0;

                for(int i=0; i<arr.length; i++) {
                    if(arr[i] % 2 == 0) {
                        temp = arr[i];
                        arr[i] = arr[evenNum];
                        arr[evenNum] = temp;
                        evenNum++;
                    }
                }

                /* 방법 2
                int left = 0;
                int right = arr.length - 1;

                while (left < right) {
                    // 왼쪽에서부터 짝수를 찾을 때까지 이동
                    while (left < right && arr[left] % 2 == 0) {
                        left++;
                    }
                    // 오른쪽에서부터 홀수를 찾을 때까지 이동
                    while (left < right && arr[right] % 2 != 0) {
                        right--;
                    }

                    // 짝수와 홀수 위치 교환
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    left++;
                    right--;
                }*/

                System.out.print("OUTPUT: ");
                for(int i = 0; i < length; i++) {
                    System.out.print(arr[i] + " ");
                }

                System.out.println();

                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException");
        } catch (IOException e) {
            throw new RuntimeException("IOException");
        }
    }
}
