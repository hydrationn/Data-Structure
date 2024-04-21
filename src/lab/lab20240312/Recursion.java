package lab.lab20240312;

import java.io.*;
import java.util.StringTokenizer;

public class Recursion {

    public static void main(String[] args) {
        try {
            File file = new File("/Users/hydrationn/datastructure01/input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                StringTokenizer parser = new StringTokenizer(line, " ");

                while (parser.hasMoreElements()) { // String Tokenizer 클래스 객체에서 다음에 읽어들일 token이 있으면 true, 없으면 false를 return
                    int number = Integer.parseInt(parser.nextToken());

                    // fibonacci function 호출 및 결과 출력
                    System.out.println(fibonacci(number) + " ");
                }
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException");
        } catch (IOException e) {
            throw new RuntimeException("IOException");
        }
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

}
