package lab.lab20240326;

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
                StringTokenizer parser = new StringTokenizer(line, " ");

                while (parser.hasMoreElements()) { // StringTokenizer 클래스 객체에서 다음에 읽어들일 token이 있으면 true, 없으면 false를 return
                    String a = parser.nextToken();
                    SinglyLinkedList.insertLast(Integer.parseInt(a));
                }

                SinglyLinkedList.printall();
                SinglyLinkedList.reverse();
                SinglyLinkedList.printall();

                SinglyLinkedList.listReset();

                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
