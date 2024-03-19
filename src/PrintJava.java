import java.io.*;
import java.util.StringTokenizer;

public class PrintJava {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/hydrationn/datastructure01/input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();

            while (line != null) {
                StringTokenizer parser = new StringTokenizer(line, " ");
                // countTokens() : 꺼내지 않고 남아있는 토큰의 수
                // hasMoreTokens() : 남아있는 토큰이 있는지 여부

                while (parser.hasMoreElements()) { // String Tokenizer 클래스 객체에서 다음에 읽어들일 token이 있으면 true, 없으면 false를 return
                    // String a = parser.nextToken();
                    // System.out.print(a + " ");
                    System.out.println(parser.nextToken() + " "); // 토큰을 하나씩 꺼내옴
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
}
