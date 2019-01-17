public class LinkedListDeque<T> {
	private class Node {
		private T value;
		private Node previous;
		private Node next;

		public Node(T obj) {
			value = obj;
			previous = next = null;
		}
	}

	private Node sentinel;
	private Node current;
	private int size;

	public LinkedListDeque() {
		current = sentinel = new Node(null);
		sentinel.next = sentinel.previous = sentinel;
	}

	public void add(T obj) {
		Node x = new Node(obj);
		x.next = current.next;
		x.previous = current;
		current.next.previous = x;
		current.next = x;
		current = x;
		size++;
	}

    public void addFirst(T obj) {
        current = sentinel;
        add(obj);
    }

    public void addLast(T obj) {
        current = sentinel.previous;
        add(obj);
    }

	public void remove() {
		current.next.previous = current.previous;
		current.previous.next = current.next;
		current = current.next;
		size--;
		if (size < 0) {
		    size = 0;
        }
	}

	public void removeFirst() {
	    current = sentinel.next;
	    remove();
    }

    public void removeLast() {
	    current = sentinel.previous;
	    remove();
    }

	public T get(int index) {
		if (index >= size) {
			return null;
		}
		Node n = sentinel.next;
		for (int i = 0; i < index; i++) {
			n = n.next;
		}
		return n.value;
	}

	public T getRecursive(int index) {
		if (index >= size) {
			return null;
		}
		Node n = getRec(sentinel.next, index);
		return n.value;
	}

	public Node getRec(Node n, int index) {
		if (index == 0) {
			return n;
		}
		return getRec(n.next, index - 1);
	}

	public int size() {
	    return size;
    }

    public boolean isEmpty() {
	    if (size == 0) {
	        return true;
        }
	    return false;
    }


    public void printDeque() {
        String print = "";
        for (int i = 0; i < size; i++) {
            print += get(i) + " ";
        }
        System.out.println(print);
    }

}