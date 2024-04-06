package lecture.ch02List;

import lecture.ch02List.array.ArrList;
import lecture.ch02List.circularLinkedList.CList;
import lecture.ch02List.doublyLinkedList.DList;
import lecture.ch02List.doublyLinkedList.DNode;
import lecture.ch02List.singlyLinkedList.SList;

public class Main {
    public static void main(String[] args) {
        // Array
        ArrList<String> arrList = new ArrList<String>();
        arrList.insert("apple", 0);
        arrList.insert("orange", 1);
        arrList.peek(0);
        arrList.delete(1);

        // Singly Linked List
        SList<String> sList = new SList<String>();
        sList.insertFront("cherry");
        sList.insertFront("pear");
        sList.deleteFront();

        // Doubly Linked List
        DList<String> dList = new DList<String>();
        DNode head = new DNode("carrot", null, null);
        dList.insertAfter(head, "melon");
        dList.insertAfter(head.getNext(), "persimmon");
        dList.delete(head.getNext());

        // Circular Linked List
        CList<String> cList = new CList<String>();
        cList.insert("mandarin");
        cList.insert("peach");
        cList.delete();
    }
}
