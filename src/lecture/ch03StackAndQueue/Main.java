package lecture.ch03StackAndQueue;

public class Main {
    public static void main(String[] args) {
        ArrayStack<String> arrayStack = new ArrayStack<String>();
        arrayStack.push("apple");
        arrayStack.push("orange");
        arrayStack.push("cherry");
        System.out.println(arrayStack.peek());
        arrayStack.pop();

        ListStack<String> listStack = new ListStack<String>();
        listStack.push("pear");
        listStack.push("grape");
        listStack.push("peach");
        System.out.println(listStack.peek());
        listStack.pop();

        ArrayQueue<String> arrayQueue = new ArrayQueue<String>();
        arrayQueue.add("lemon");
        arrayQueue.add("mango");
        arrayQueue.add("lime");
        arrayQueue.remove();
        arrayQueue.remove();

        ListQueue<String> listQueue = new ListQueue<String>();
        listQueue.add("kiwi");
        listQueue.add("citron");
        listQueue.add("litch");
        listQueue.remove();
        listQueue.remove();
    }
}
