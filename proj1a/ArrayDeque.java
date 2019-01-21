public class ArrayDeque<T> {

    private T[] list;
    private int size;

    public ArrayDeque() {
        list = (T[]) new Object[8];
        size = 0;
    }

    public void addLast(T object) {
        if (size == list.length) {
            T[] a = (T[]) new Object[size * 2];
            System.arraycopy(list, 0, a, 0, list.length);
            list = a;
        }
        list[size] = object;
        size++;
    }

    public void addFirst(T object) {
        T[] a;
        if (size == list.length) {
            a = (T[]) new Object[size * 2];
        } else {
            a = (T[]) new Object[list.length];
        }
        System.arraycopy(list, 0, a, 1, size);
        list = a;
        list[0] = object;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public T removeFirst() {
        T obj = list[0];
        size--;
        if (getUsageFactor() <= 0.25) {
            resize(list.length / 2);
        } else {
            resize(list.length);
        }
        return obj;
    }

    public T removeLast() {
        T obj = list[size - 1];
        list[size] = null;
        size--;
        if (getUsageFactor() <= 0.25) {
            resize();
        }
        return obj;
    }

    public void resize() {
        T[] a = (T[]) new Object[list.length / 2];
        System.arraycopy(list, 0, a, 0, size);
        list = a;
    }

    public void resize(int length) {
        T[] a = (T[]) new Object[length];
        System.arraycopy(list, 1, a, 0, size);
        list = a;
    }

    public double getUsageFactor() {
        return (double)size / list.length;
    }

    public T get(int i) {
        return list[i];
    }

    public int size() {
        return size;
    }

    public int getLength() {
        return list.length;
    }

    public void printDeque() {
        String print = "";
        for (int i = 0; i < size; i++) {
            print += list[i] + " ";
        }
        System.out.println(print);
    }
}