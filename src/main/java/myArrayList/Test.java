package myArrayList;

public class Test {
    public static void main(String[] args) {
        MyArrayList<Cat> arrayList = new MyArrayList();

        arrayList.add(new Cat("q", 1));
        arrayList.add(new Cat("w", 2));
        arrayList.add(new Cat("e", 3));
        arrayList.add(new Cat("r", 4));
        arrayList.add(new Cat("t", 5));

        arrayList.remove(2);
        System.out.println(arrayList);

        arrayList.remove(1);
        System.out.println(arrayList);
        Object o = arrayList.get(2);
        System.out.println(o);



    }
}