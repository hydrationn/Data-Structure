package lab.lab20240501;

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
                CQueue lst = new CQueue();
                String[] str = line.split(" ");

                for (int i = 0; i < str.length; i++) {
                    switch (str[i]) {
                        case "i":
                            // Insert
                            i++;
                            while (i<str.length && !str[i].equals("d")) {
                                lst.insert(Integer.parseInt(str[i++]));
                            }
                            i--;
                            break;
                        case "d":
                            // Delete
                            lst.delete();
                            break;
                    }
                }
                System.out.println();
                line = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.print("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
