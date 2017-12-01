//for discriptions of methods, see IList

public class ArrayList<T> implements IList<T> {
	T[] ls;
	int size;
	int curr;

	//constructor, list of generic type T
	public ArrayList() {
		ls = (T[]) new Object[0];
		int size = 0;
		int curr = 0;
	}

	public void insert(int idx, T v) {
		T[] templs = (T[]) new Object[size+1];
		for (int i=0; i<size; i++) {
			if (i < idx) {
				templs[i] = ls[i];
			}
			else if (i == idx) {
				templs[i] = v;
			}
			else if (i > idx) {
				templs[i] = ls[i-1];
			}
		}
		ls = templs;
		size += 1;
	}

	public void append(T v) {
		T[] templs = (T[]) new Object[size+1];
		for (int i=0; i<size; i++) {
			templs[i] = ls[i];
		}
		templs[size] = v;
		ls = templs;
		size += 1;
		//move curr to the end
		curr = size-1;
	}

	public void remove() {
		T[] templs = (T[]) new Object[size-1];
		for (int i=0; i<size; i++) {
			if (i < curr) {
				templs[i] = ls[i];
			}
			else if (i == curr) {}
			else if (i > curr) {
				templs[i-1] = ls[i];
			}
		}
		ls = templs;
		size -=1;
		//if possible, move curr to the previous item
		if (curr != 0) {
			curr -= 1;
		}
	}

	public void remove(int idx) {
		T[] templs = (T[]) new Object[size-1];
		for (int i=0; i<size; i++) {
			if (i < idx) {
				templs[i] = ls[i];
			}
			else if (i == idx) {}
			else if (i > idx) {
				templs[i-1] = ls[i];
			}
		}
		ls = templs;
		size -=1;
	}

	public void move(int sidx, int didx) {
		T[] templs = (T[]) new Object[size];
		T sitem = ls[sidx];
		//remove the scourse item
		for (int i = 0; i < size-1; i ++) {
			if (i < sidx) {
				templs[i] = ls[i];
			}
			else if (i >= sidx) {
				templs[i] = ls[i+1];
			}
		}
		ls = templs;
		//add the source item
		templs = (T[]) new Object[size];
		for (int i = 0; i < size; i++) {
			if (i < didx) {
				templs[i] = ls[i];
			}
			else if (i == didx) {
				templs[i] = sitem;
			}
			else if (i > didx) {
				templs[i] = ls[i-1];
			}
		}
		ls = templs;
	}

	public T fetch() {
		return ls[curr];
	}

	public T fetch(int idx) {
		return ls[idx];
	}

	public void next() {
		if (curr < size-1) {
			curr += 1;
		}
	}

	public void prev() {
		if (curr > 0) {
			curr -= 1;
		}
	}

	public void jumpToTail() {
		curr = size - 1;
	}

	public void jumpToHead() {
		curr = 0;
	}

	public int size() {
		return size;
	}
}