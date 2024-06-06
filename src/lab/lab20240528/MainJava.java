package lab.lab20240528;

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
        String[] numbers = lines.split(" ");
        Heap<Integer, Integer> maxHeap = new Heap<>(numbers.length, false); // 최대 힙
        Heap<Integer, Integer> minHeap = new Heap<>(numbers.length, true); // 최소 힙
        for (String numberStr : numbers) {
          if (maxHeap.size() <= minHeap.size())
            maxHeap.insert(Integer.valueOf(numberStr), 1);
          else
            minHeap.insert(Integer.valueOf(numberStr), 1);

          if (maxHeap.size() != 0 && minHeap.size() != 0 && (int) maxHeap.peekRoot().getKey() > (int) minHeap.peekRoot().getKey()) {
            int maxHeapRoot = (int) maxHeap.deleteRoot().getKey();
            int minHeapRoot = (int) minHeap.deleteRoot().getKey();
            maxHeap.insert(minHeapRoot, 1);
            minHeap.insert(maxHeapRoot, 1);
          }
        }
        System.out.println(maxHeap.peekRoot().getKey()); // 중간값 출력
        lines = br.readLine();
      }
      br.close();
    } catch (FileNotFoundException e) {
      System.out.print("FileNotFoundException: File not found");
    } catch (IOException e) {
      System.out.println("IOException: Error reading file");
    }
  }
}
