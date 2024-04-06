package lab20240402;

import java.io.*;

public class MainJava {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/hydrationn/datastructure01/input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine(); // Example code

            while (line != null) {
                CDList lst = new CDList();
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

                System.out.print("OUTPUT: ");
                lst.printall();
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
