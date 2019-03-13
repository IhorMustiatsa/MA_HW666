package myArrayList;

public interface MyList<T> {
    boolean add(T t);
    int size();
    T get(int index);
    boolean remove(Object o);
    void clear();
}
