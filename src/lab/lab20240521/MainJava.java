package lab.lab20240521;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MainJava {
  public static void main(String[] args) {
    try {
      File file = new File("/Users/hydrationn/datastructure01/input.txt");
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);
      String lines = br.readLine();

      while (lines != null) {
        AVLTree tree = new AVLTree();
        String[] put_keys = lines.split(" "); // 첫 번째 줄 삽입 key들을 저장
        lines = br.readLine();
        String[] del_keys = lines.split(" "); // 두 번째 줄 삭제 key들을 저장

        /* AVL 트리에 노드 삽입 */
        for (int i = 0; i < put_keys.length; i++) {
          int key = Integer.valueOf(put_keys[i]);
          tree.put(key, 0); //  본 과제에서 value는 사용하지 않으므로 0으로 초기화
        }

        /* 수정된 inorder 메소드로 삽입된 노드들의 정보 출력 */
        tree.inorder_mod(tree.getRoot());
        System.out.println();

        // 알맞게 주석 처리하여 결과 확인

        /* deleteMin 이용, 해당 key 값을 가진 노드를 삭제 */
        for (int i = 0; i < del_keys.length; i++) {
          int key = Integer.valueOf(del_keys[i]);
          tree.delete_min(key);
        }

        /* 삭제 이후 노드들이 정보 출력 */
        tree.inorder_mod(tree.getRoot());
        lines = br.readLine();
        System.out.println();

//        /* deleteMax 이용, 해당 key 값을 가진 노드를 삭제 */
//        for (int i = 0; i < del_keys.length; i++) {
//          int key = Integer.valueOf(del_keys[i]);
//          tree.delete_max(key);
//        }
//
//        /* 삭제 이후 노드들이 정보 출력 */
//        tree.inorder_mod(tree.getRoot());
//        lines = br.readLine();
//        System.out.println();
      }
      br.close();
    } catch (FileNotFoundException e) {
      System.out.print("FileNotFoundException");
    } catch (IOException e) {
      System.out.println("IOException");
    }
  }
}
