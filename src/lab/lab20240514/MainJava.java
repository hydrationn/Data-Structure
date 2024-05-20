package lab.lab20240514;

import java.io.*;

public class MainJava {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/hydrationn/datastructure01/input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();

            while (line != null) {
                String[] keys = line.split(" ");
                BST<Integer, Integer> bst = new BST<>();

                for (String key : keys) {
                    bst.put_mod(Integer.valueOf(key), 1);
                }

                bst.inorder(bst.getRoot());
                System.out.println();

                bst.deleteMax();
                bst.inorder(bst.getRoot());
                System.out.println();

                line = br.readLine();
                String[] deleteKeys = line.split(" ");
                for(String key : deleteKeys) {
                    bst.delete_mod(Integer.valueOf(key));
                }

                bst.inorder(bst.getRoot());
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
