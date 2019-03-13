package myArrayList;

import java.util.Arrays;

public class MyArrayList<T> implements myArrayList.MyList {
    private static Object[] elementData;
    private final int capacity = 10;
    private int currentSize = 0;

    public MyArrayList() {
        elementData = createArray(capacity);
    }

    private <T> T[] createArray(int size) {
        T[] arr = (T[]) new Object[size];
        return arr;
    }


    public boolean add(Object e) {
        if (currentSize + 1 > elementData.length) {
            ensureCapacity(currentSize + 1);
        }
        elementData[currentSize++] = e;
        return true;
    }


    public boolean remove(int index) {
        if (index < 0 || index > currentSize - 1) return false;
        int numMoved = currentSize - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--currentSize] = null;
        return true;
    }


    public boolean remove(Object obj) {
        int index = -1;
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(obj)) {
                index = i;
                break;
            }
        }

        if (index == -1) return false;

        System.arraycopy(elementData, index + 1, elementData, index, elementData.length - index - 1);
        elementData[currentSize--] = null;

        return true;
    }


    public void add(T obj, int index) {
        if (index >= 0 && index <= currentSize) {
            if (currentSize + 1 > elementData.length) {
                ensureCapacity(currentSize + 1);
            } else {
                return;
            }

            System.arraycopy(elementData, index, elementData, index + 1, currentSize - index);
            elementData[index] = obj;
            currentSize++;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }


    public void clear() {
        final Object[] es = elementData;
        int to = currentSize;
        currentSize = 0;
        for (int i = 0; i < to; i++)
            es[i] = null;
    }



    public int size() {
        return currentSize;
    }


    public Object get(int index) {
        if (index < 0 || index >= currentSize)
            throw new IndexOutOfBoundsException();
        else {
            return elementData[index];
        }

    }

    private Object[] ensureCapacity(int newIndex) {
        int newLength = 3 * elementData.length / 2 + 1;
        return elementData = Arrays.copyOf(elementData, newLength);
    }


    public String toString() {
        return "MyArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", capacity=" + capacity +
                ", currentSize=" + currentSize +
                '}';
    }
}