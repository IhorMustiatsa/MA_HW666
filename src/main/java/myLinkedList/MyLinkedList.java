package myLinkedList;


import myArrayList.MyList;

public class MyLinkedList<T> implements MyList {
    int currentSize = 0;
    MyNode<T> head;
    MyNode<T> tail;



    @Override
    public boolean add(Object o) {
        linkLast(o);
        return true;
    }
    @Override
    public int size() {
        return currentSize;
    }
    @Override
    public void clear() {
        for (MyNode<T> x = head; x != null; ) {
            MyNode<T> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        head = tail = null;
        currentSize = 0;
    }
    @Override
    public T get(int index) {
        if (index >= 0 && index < currentSize) {
            return node(index).item;
        }
        throw new IndexOutOfBoundsException();
    }
    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (MyNode<T> x = head; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (MyNode<T> x = head; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }


    void linkLast(Object t) {
        MyNode<T> l = tail;
        MyNode<T> newNode = new MyNode(l, t, null);
        tail = newNode;
        if (l == null)
            head = newNode;
        else
            l.next = newNode;
        currentSize++;

    }

    T unlink(MyNode<T> x) {
        // assert x != null;
        final T element = x.item;
        final MyNode<T> next = x.next;
        final MyNode<T> prev = x.prev;

        if (prev == null) {
            head = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            tail = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        currentSize--;
        return element;
    }

    MyNode<T> node(int index) {
        // assert isElementIndex(index);

        if (index < (currentSize >> 1)) {
            MyNode<T> x = head;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            MyNode<T> x = tail;
            for (int i = currentSize - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }


    private static class MyNode<E> {
        E item;
        MyNode<E> next;
        MyNode<E> prev;

        public MyNode(MyNode<E> prev, E item, MyNode<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public String toString() {
        MyNode<T> curr = head;
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList [");
        while (curr != null) {
            sb.append(curr.item);
            if (curr.next != null) {
                sb.append(", ");
            }
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();

    }
}
