package myLinkedList;

import myArrayList.Cat;

public class Test {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();

        linkedList.add(new Cat("q", 1));
        linkedList.add(new Cat("w", 2));
        linkedList.add(new Cat("e", 3));
        linkedList.add(new Cat("r", 4));
        linkedList.add(new Cat("t", 5));

        linkedList.remove(2);
        System.out.println(linkedList.toString());

        linkedList.remove(1);
        System.out.println(linkedList.toString());
        Object o = linkedList.get(2);
        System.out.println(o);


    }

}
