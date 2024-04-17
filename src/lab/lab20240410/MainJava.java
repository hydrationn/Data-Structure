package lab.lab20240410;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class MainJava {
    public static void main(String[] args) {
        ArrayList<String> Lines = readFile("input.txt");

        for (String Line : Lines) {
            int size = 50;
            String[] str = Line.split(" ");
            ArrayStack<Integer> A = new ArrayStack<Integer>(size);
            ArrayStack<Integer> B = new ArrayStack<Integer>(size);

            // 파일로부터 입력받은 값들을 정수로 변환하여 배열에 저장
            int[] arr = new int[str.length];
            for(int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            B.push(arr[0]);

            // stack A, B 이용하여 내림차순 정렬
            for(int i = 1; i < str.length; i++) {
                int current = arr[i];
                while (!B.isEmpty() && B.peek() > current) {
                    A.push(B.pop());
                }
                B.push(arr[i]);
                while (!A.isEmpty()) {
                    B.push(A.pop());
                }
            }

            // stack B pop하여 출력
            for (int i = 0; i < str.length; i++) {
                System.out.print(B.pop() + " ");
            }

            System.out.println();
        }
    }

    public static ArrayList<String> readFile(String fileName) {
        ArrayList<String> Lines = null;

        try {
            String path = "/Users/hydrationn/datastructure01/";
            FileReader FileReader = new FileReader(path+fileName);
            BufferedReader BufferedReader = new BufferedReader(FileReader);

            String line = "";
            Lines = new ArrayList<String>();
            while ((line = BufferedReader.readLine()) != null) {
                Lines.add(line);
            }

            BufferedReader.close();
            FileReader.close();

        } catch (Exception e) {}

        return Lines;
    }
}
