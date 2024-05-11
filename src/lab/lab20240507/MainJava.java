package lab.lab20240507;

import java.io.*;

public class MainJava {
    public static void main(String[] args) {
        try {
            File file = new File("/Users/hydrationn/datastructure01/input.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine();
            int digit = Integer.valueOf(line);
            Node[] a = new Node[digit];

            for (int i = 0; i < digit; i++) {
                a[i] = new Node(i, 1);
            }
            UnionFind uf = new UnionFind(a);
            line = br.readLine();

            while (line != null) {
                String[] str = line.split(" ");
                int p = Integer.valueOf(str[0]);
                int q = Integer.valueOf(str[1]);
                uf.union(p, q);

                line = br.readLine();
            }
            System.out.println("[ disjoint sets ]");
            uf.printsets();
            br.close();
        } catch (FileNotFoundException e) {
            System.out.print("FileNotFoundException");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }
}
